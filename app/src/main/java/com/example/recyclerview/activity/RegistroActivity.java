package com.example.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerview.DeveloperuBD;
import com.example.recyclerview.R;

public class RegistroActivity extends AppCompatActivity {

    private RadioButton btnUser;
    private RadioButton btnChofer;
    private RadioButton lastSelected;

    //CAMPOS DE LA TABLA

    EditText campousername,campoemail,campopassword,campotelefono,campounidad;
    Button btn_registro,Regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnUser = findViewById(R.id.btn_user);
        btnChofer = findViewById(R.id.btn_chofer);
        lastSelected = null;
        //CAMPOS DE LA TABLA
        campousername= findViewById(R.id.username);
        campoemail = findViewById(R.id.email);
        campopassword= findViewById(R.id.password);
        campotelefono = findViewById(R.id.telefono);
        campounidad = findViewById(R.id.unidad);
        //BOTON REGISTRO
        btn_registro = findViewById(R.id.btn_registro);


        //REGRESAR A LOGIN
        Regresar = (Button)findViewById(R.id.btn_regresar);
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistroActivity.this,MainActivityPrincipal.class);
                startActivity(i);
            }
        });

        final DeveloperuBD developeruBD=new DeveloperuBD(getApplicationContext());

        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                developeruBD.agregarUsuarios(campousername.getText().toString(),campoemail.getText().toString(),campopassword.getText().toString(),campotelefono.getText().toString(),campounidad.getText().toString());
                Toast.makeText(getApplicationContext(),"SE AGREGÓ CORRECTAMENTE EL USUARIO",Toast.LENGTH_SHORT).show();
            }
        });


        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastSelected != null) {
                    lastSelected.setChecked(false); // Desmarcar el RadioButton previamente seleccionado
                }
                lastSelected = btnUser;
                campounidad.setVisibility(View.GONE);
            }
        });

        btnChofer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastSelected != null) {
                    lastSelected.setChecked(false); // Desmarcar el RadioButton previamente seleccionado
                }
                lastSelected = btnChofer;
                campounidad.setVisibility(View.VISIBLE);
            }
        });
    }
}
