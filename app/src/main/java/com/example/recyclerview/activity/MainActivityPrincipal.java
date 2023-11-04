package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerview.R;


public class MainActivityPrincipal extends AppCompatActivity {

    Button Registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_principal);

        Registrar = (Button)findViewById(R.id.btn_registrar);
        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityPrincipal.this,RegistroActivity.class);
                startActivity(i);
            }
        });

    }

}