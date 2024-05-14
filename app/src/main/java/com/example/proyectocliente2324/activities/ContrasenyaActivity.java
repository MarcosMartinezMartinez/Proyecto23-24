package com.example.proyectocliente2324.activities;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myweatherbase.R;

public class ContrasenyaActivity extends AppCompatActivity {

    private Button actualizarContrasenya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrasenya);

        actualizarContrasenya = findViewById(R.id.bttnActualizarContrasenya);

        actualizarContrasenya.setOnClickListener(view -> {
            finish();
        });
    }

}
