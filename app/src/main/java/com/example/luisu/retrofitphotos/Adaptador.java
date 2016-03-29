package com.example.luisu.retrofitphotos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luisu.retrofitphotos.DTO.Album;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class Adaptador extends RecyclerView.Adapter<Adaptador.AdaptadorViewHolder> {

    private final ArrayList<Album> datos;


    public static class AdaptadorViewHolder extends RecyclerView.ViewHolder {

        private TextView titulo;
        private ImageView imagen;
        private Context contexto;


        public AdaptadorViewHolder(View itemView, Context context) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            contexto = context;
        }

        public void bindAdaptador(Album e) {
            Picasso.with(contexto).load("http://placeholdit.imgix.net/~text?txtsize=56&bg=92c952&txt=600%C3%97600&w=600&h=600")
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.nodisponible).into(imagen);
            //imagen.setText(e.getTitle());
            titulo.setText(e.getTitle());

        }
    }

    public Adaptador(ArrayList<Album> datos) {
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
        Album exam = datos.get(position);
        holder.bindAdaptador(exam);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

}
