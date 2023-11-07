package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerview.R;
import com.example.recyclerview.adaptador.RecyclerAdapter;
import com.example.recyclerview.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {
    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<ItemList> items;

    Button CerrarSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initValues();
        initListener();

        //BOTON CERRAR SESIÓN
        CerrarSesion = (Button)findViewById(R.id.btnsalir);
        CerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MainActivityPrincipal.class);
                startActivity(i);
            }
        });

    }

    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
        svSearch = findViewById(R.id.svSearch);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items, this);
        rvLista.setAdapter(adapter);
    }

    private void initListener() {
        svSearch.setOnQueryTextListener(this);
    }

    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("Autobus Azul Blanco", "Ruta: Horario: Costo: ", R.drawable.azulblanco));
        itemLists.add(new ItemList("Calafia Crema Rojo", "Ruta:  Horario: Costo: ", R.drawable.creamarojo));
        itemLists.add(new ItemList("Camion Azul Blanco", "Ruta: Horario: Costo: ", R.drawable.azulblanco2camion));
        itemLists.add(new ItemList("Transporte", "Ruta: Horario: Costo: ", R.drawable.blancocafe1));
        itemLists.add(new ItemList("Autobus Naranja Negro", "Ruta: Horario: Costo: ", R.drawable.naranjanegro));
        itemLists.add(new ItemList("Autobus Rojo Crema", "Ruta:  Horario: Costo: ", R.drawable.rojocrema1));
        itemLists.add(new ItemList("Taxi Rojo", "Ruta: Horario: Costo: ", R.drawable.rojotaxi));
        itemLists.add(new ItemList("Calafia Rojo Crema", "Ruta: Horario: Costo: ", R.drawable.rojocrema2));
        itemLists.add(new ItemList("Calafia Verde Crema", "Ruta: Horario: Costo: ", R.drawable.verdecrema1));
        //itemLists.add(new ItemList("Autobus", "Ruta: || Horario:.", R.drawable.v));
        //itemLists.add(new ItemList("Taxi", "Ruta: || Horario:.", R.drawable.super_vegeta));
        //itemLists.add(new ItemList("Autobus", "Ruta: || Horario:.", R.drawable.vegeta_blue));

        return itemLists;
    }

    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }
}
