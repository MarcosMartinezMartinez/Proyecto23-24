package com.example.proyectocliente2324.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectocliente2324.API.Connector;
import com.example.myweatherbase.R;
import com.example.proyectocliente2324.activities.model.Root;
import com.example.proyectocliente2324.base.BaseActivity;
import com.example.proyectocliente2324.base.CallInterface;
import com.example.proyectocliente2324.base.ImageDownloader;
import com.example.proyectocliente2324.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity2 extends BaseActivity implements CallInterface {

    private TextView txtView ;
    private TextView textViewDay;
    private TextView textViewDayOfWeek;
    private ImageView imageView;
    private Root root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    // Realizamos la llamada y recogemos los datos en un objeto Root
    @Override
    public void doInBackground() {
        root = Connector.getConector().get(Root.class,"&lat=39.5862518&lon=-0.5411163");
    }

    // Una vez ya se ha realizado la llamada, ocultamos la barra de progreso y presentamos los datos
    @Override
    public void doInUI() {
        hideProgress();
        txtView.setText(root.list.get(0).weather.get(0).description);
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(0).weather.get(0).icon + Parameters.ICON_URL_POST, imageView);

        Date date = new Date((long)root.list.get(0).dt*1000);
        SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("E");
        SimpleDateFormat dateDay = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");
        textViewDayOfWeek.setText(dateDayOfWeek.format(date));
        textViewDay.setText(dateDay.format(date));
    }
}