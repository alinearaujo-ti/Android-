package com.example.meuprimeiroprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ListView lista = (ListView) findViewById(R.id.listaCursos);

        ArrayList<String> cursos = preencher();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cursos);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "cursos: "+cursos.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private ArrayList<String> preencher(){
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Sistemas de Informação");
        dados.add("Ciência da Computação");
        dados.add("Engenharia da Computação");
        dados.add("Engenharia de Software");
        dados.add("Redes de Computadores");
        dados.add("Design Digital");
        return dados;
    }
}