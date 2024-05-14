package com.example.proyectocliente2324.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myweatherbase.R;
import com.example.proyectocliente2324.activities.preferencias.IdiomSetUp;
import com.example.proyectocliente2324.activities.preferencias.ThemeSetup;

public class MainActivity extends AppCompatActivity {

    private Button crearCuenta;
    private Button recordarContrasenya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ThemeSetup.applyPreferenceTheme(getApplicationContext());
        IdiomSetUp.applyPreferenceIdiom(getApplicationContext());

        crearCuenta= findViewById(R.id.bttnCrearCuenta);
        recordarContrasenya = findViewById(R.id.bttnRecordarContrasenya);

        recordarContrasenya.setOnClickListener(view -> {
            Intent intent = new Intent(this, ContrasenyaActivity.class);
            startActivity(intent);
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.configuracion):
                Intent intentPreferenciasActivity = new Intent(this, PreferenciasActivity.class);
                startActivity(intentPreferenciasActivity);
                return true;
            case (R.id.exit):
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

     */




}