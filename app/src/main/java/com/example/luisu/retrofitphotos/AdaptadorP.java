package com.example.luisu.retrofitphotos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luisu.retrofitphotos.DTO.Peliculas;
import com.example.luisu.retrofitphotos.DTO.Peliculas;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class AdaptadorP extends RecyclerView.Adapter<AdaptadorP.AdaptadorViewHolder> {

    private final ArrayList<Peliculas> datos;


    public static class AdaptadorViewHolder extends RecyclerView.ViewHolder {

        private TextView titulo;
        private ImageView imagen;
        private Context contexto;
        private CheckBox adult;


        public AdaptadorViewHolder(View itemView, Context context) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            adult = (CheckBox) itemView.findViewById(R.id.adulto);
            contexto = context;
        }

        public void bindAdaptador(Peliculas e) {
            Picasso.with(contexto).load("http://image.tmdb.org/t/p/w500"+e.getPoster_path())
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.nodisponible).into(imagen);
            titulo.setText(e.getOriginal_title());
            adult.setChecked(e.isAdult());
        }
    }

    public AdaptadorP(ArrayList<Peliculas> datos) {
        this.datos = datos;
    }

    @Override
    public AdaptadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        AdaptadorViewHolder t = new AdaptadorViewHolder(itemView, parent.getContext());
        return t;
    }

    @Override
    public void onBindViewHolder(AdaptadorViewHolder holder, int position) {
        Peliculas exam = datos.get(position);
        holder.bindAdaptador(exam);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

}
