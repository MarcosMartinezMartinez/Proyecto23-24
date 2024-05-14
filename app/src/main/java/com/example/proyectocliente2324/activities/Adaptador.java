package com.example.proyectocliente2324.activities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.R;
import com.example.proyectocliente2324.activities.model.Root;
import com.example.proyectocliente2324.base.ImageDownloader;
import com.example.proyectocliente2324.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private Root root;

    public Adaptador(@NonNull Context context, Root root) {
        this.context = context;
        this.root = root;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.itemView.setOnClickListener(view -> {

        });
    }

    @Override
    public int getItemCount() {
        return root.list.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iContenido;
        private TextView tvNombreContenido;
        private TextView tvValoracion;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iContenido = itemView.findViewById(R.id.iContenido);
            tvNombreContenido = itemView.findViewById(R.id.tvNombreContenido);
            tvValoracion = itemView.findViewById(R.id.tvValoracion);
        }
    }

}


