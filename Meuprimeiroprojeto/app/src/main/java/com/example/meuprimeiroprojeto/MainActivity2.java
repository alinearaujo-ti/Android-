package com.example.meuprimeiroprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    /*private static final String[] VERSOES = new String[]{
            "Brigadeiro", "Pirulito", "Chiclete", "Bala", "Trufa"
    };*/

    Button prox_tela2;
    Button inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String[] versoes = getResources().getStringArray(R.array.versoes);

        AutoCompleteTextView editText = findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, versoes);
        editText.setAdapter(adapter);

        prox_tela2 = findViewById(R.id.prox_tela2);
        inicio = findViewById(R.id.inicio);


        prox_tela2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(i);
            }
        });

        inicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}