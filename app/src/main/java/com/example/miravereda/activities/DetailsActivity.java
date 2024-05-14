package com.example.miravereda.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import es.ieslavereda.miravereda.R;

public class DetailsActivity extends AppCompatActivity {

    private Button btnRestar;
    private Button btnSumar;
    private TextView valoracion;
    private double auxiliar;
    private FloatingActionButton guardarValoracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        btnRestar = findViewById(R.id.bttnMenos);
        btnSumar = findViewById(R.id.bttnMas);
        valoracion = findViewById(R.id.tvValoracionContenido);
        auxiliar = 5;
        guardarValoracion = findViewById(R.id.fabGuardar);

        btnRestar.setOnClickListener(view -> {
            if (auxiliar > 0) {
                auxiliar -= 0.5;
                valoracion.setText(String.valueOf(auxiliar));
            }
        });

        btnSumar.setOnClickListener(view -> {
            if (auxiliar < 10) {
                auxiliar += 0.5;
                valoracion.setText(String.valueOf(auxiliar));
            }
        });

        guardarValoracion.setOnClickListener(view -> {
            auxiliar = 5;
            valoracion.setText(String.valueOf(auxiliar));
            Toast.makeText(this, "Su valoración ha sido guardada correctamente", Toast.LENGTH_SHORT).show();
        });
    }
}
