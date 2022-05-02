package com.example.meuprimeiroprojeto;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    private Switch botaoSwitch;
    private ToggleButton botaoToggle;
    Button prox_tela1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoSwitch = findViewById(R.id.btnSwitch);
        botaoToggle = findViewById(R.id.btnToogle);

        btnListner();

        prox_tela1 = findViewById(R.id.prox_tela1);


        prox_tela1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });

    }


    public void btnListner(){

        botaoSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(botaoSwitch.isChecked()){
                Toast.makeText(getApplicationContext(), "Switch ligado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Switch desligado", Toast.LENGTH_SHORT).show();
            }
        });

        botaoToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(botaoToggle.isChecked()){
                Toast.makeText(getApplicationContext(), "Toggle ligado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Toogle desligado", Toast.LENGTH_SHORT).show();
            }
        });
    }

}