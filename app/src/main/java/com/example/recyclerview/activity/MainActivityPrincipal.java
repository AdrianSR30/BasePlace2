package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerview.R;


public class MainActivityPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_principal);

        Button button1 = findViewById(R.id.btnis);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewActivity();
            }
        });

    }

    public void openNewActivity() {
        Intent intent = new Intent(this, Login.class); // Reemplaza SecondActivity con el nombre de tu siguiente Activity
        startActivity(intent);
    }
}