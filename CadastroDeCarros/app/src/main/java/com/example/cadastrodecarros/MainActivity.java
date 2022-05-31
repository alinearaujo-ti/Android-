package com.example.cadastrodecarros;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
  public static final String ENVIAR = "0";
  public static final String RECEBER = "1";

  ArrayAdapter<String> carsAdapter;
  ListView carsListView;
  List<String> cars;

  Integer proximoID = 5;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);

    setarListView();
    setarListeners();
  }

  void setarListView() {
    carsListView = findViewById(R.id.carsListView);

    cars = new ArrayList();

    cars.add("0 | CORSA | CHEVROLET");
    cars.add("1 | PUNTO | FIAT");
    cars.add("2 | GOL | VOLKSWAGEN");
    cars.add("3 | FOCUS | FORD");
    cars.add("4 | SANDERO | RENAULT");

    carsAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, cars);

    carsListView.setAdapter(carsAdapter);
    carsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, "Clicou em " + cars.get(position), Toast.LENGTH_SHORT).show();
      }
    });
  }

  void setarListeners() {
    Button btnEditar = findViewById(R.id.btnEditar);
    Button btnAdicionar = findViewById(R.id.btnAdicionar);
    EditText textViewIDCarro = findViewById(R.id.textViewIDCarro);

    btnEditar.setOnClickListener(view -> {
      String IDCarro = textViewIDCarro.getText().toString();
      int ID = 0;
      try {
        ID = Integer.parseInt(IDCarro);
      } catch(NumberFormatException ex) {
        Toast.makeText(MainActivity.this, "Campo ID não pode estar vazio!", Toast.LENGTH_SHORT).show();
        return;
      }
      if (ID >= proximoID) {
        Toast.makeText(MainActivity.this, "ID não cadastrado!", Toast.LENGTH_SHORT).show();
        return;
      } else {
        textViewIDCarro.setText("");
        String[] aux = cars.get(ID).split("\\|");
        Car car = new Car(ID, aux[2].trim(), aux[1].trim());
        mGetContent.launch(car);
      }
    });

    btnAdicionar.setOnClickListener(view -> {
      mGetContent.launch(new Car(proximoID, "", ""));
    });
  }

  ActivityResultLauncher<Car> mGetContent = registerForActivityResult(new DadosCarro(), car -> {
    if (car == null) return;

    String parse = car.getID() + " | " + car.getModelo() + " | " + car.getMarca();
    if (car.getID().intValue() == proximoID.intValue()) {
      proximoID += 1;
      cars.add(parse);
    } else {
      cars.set(car.getID(), parse);
    }
    carsAdapter.notifyDataSetChanged();
  });
}

class DadosCarro extends ActivityResultContract<Car, Car> {
  @NonNull
  @Override
  public Intent createIntent(@NonNull Context context, @NonNull Car car) {
    Intent intent = new Intent(context, CarActivity.class);
    intent.putExtra(MainActivity.ENVIAR, car);
    return intent;
  }

  @Override
  public Car parseResult(int resultCode, @Nullable Intent result) {
    if (resultCode != Activity.RESULT_OK || result == null) {
      return null;
    }
    return (Car)result.getExtras().getSerializable(MainActivity.RECEBER);
  }
}