package com.example.proyectocliente2324.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.example.proyectocliente2324.API.Connector;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class BaseActivity extends AppCompatActivity {

    protected Connector connector;
    protected ExecutorService executor = Executors.newSingleThreadExecutor();
    protected Handler handler = new Handler(Looper.getMainLooper());
    protected MyProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connector = Connector.getConector();
        progressBar = new MyProgressBar(this);
    }

    protected void executeCall(CallInterface callInterface){
        executor.execute(() -> {
            callInterface.doInBackground();
            handler.post(() -> {
                callInterface.doInUI();
            });
        });
    }

    public void showProgress(){
        progressBar.show();
    }

    public void hideProgress(){
        progressBar.hide();
    }


    // Sobreescribimos el metodo para asociar a la barra de progreso al ContraintLayout o RelativeLayout
    // y asi poder centrarla y manipular la visibilidad del resto de componentes del ViewGroup
    @Override
    public void setContentView(int layout){
        super.setContentView(layout);
        ViewGroup rootView = (ViewGroup) ((ViewGroup) this .findViewById(android.R.id.content)).getChildAt(0);
        progressBar.initControl(rootView);
        hideProgress();
    }

}
