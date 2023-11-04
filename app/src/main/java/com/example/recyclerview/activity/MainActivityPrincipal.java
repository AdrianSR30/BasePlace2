package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recyclerview.DeveloperuBD;
import com.example.recyclerview.R;


public class MainActivityPrincipal extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private DeveloperuBD db;
    Button Registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_principal);

        //BOTON REGISTRAR
        Registrar = (Button)findViewById(R.id.btn_registrar);
        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityPrincipal.this,RegistroActivity.class);
                startActivity(i);
            }
        });

        //BOTON INICIAR SESIÓN
        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btn_login);
        db = new DeveloperuBD(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // Verificar si el usuario y la contraseña coinciden en la base de datos
                if (db.buscarUsuario(username, password)) {
                    // Iniciar la actividad MainActivityPrincipal
                    Intent intent = new Intent(MainActivityPrincipal.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Cierra la actividad de inicio de sesión para que no se pueda volver atrás
                } else {
                    Toast.makeText(MainActivityPrincipal.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

}