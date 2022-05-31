package com.example.cadastrodecarros;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CarActivity extends AppCompatActivity {
  Car car;
  private EditText textModelo;
  private EditText textMarca;

  @Override
  public void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.car_activity);
    setarListeners();

    car = (Car)this.getIntent().getExtras().getSerializable(MainActivity.ENVIAR);

    textModelo = findViewById(R.id.textModelo);
    textMarca = findViewById(R.id.textMarca);
    TextView textViewID = findViewById(R.id.textViewID);

    textViewID.setText("ID: " + car.getID());
    textModelo.setText(car.getModelo());
    textMarca.setText(car.getMarca());
  }
  void setarListeners() {
    Button btnVoltar = findViewById(R.id.btnVoltar);
    Button btnSalvar = findViewById(R.id.btnSalvar);
    btnVoltar.setOnClickListener(view -> {
      setResult(Activity.RESULT_CANCELED, null);
      finish();
    });
    btnSalvar.setOnClickListener(view -> {
      if (textModelo.getText().equals("") || textMarca.getText().equals("")) {
        Toast.makeText(CarActivity.this, "Te", Toast.LENGTH_SHORT).show();
        return;
      }

      car.setMarca(textMarca.getText().toString());
      car.setModelo(textModelo.getText().toString());

      Intent data = new Intent();
      data.putExtra(MainActivity.RECEBER, car);
      setResult(Activity.RESULT_OK, data);
      finish();
    });
  }
}
