package com.example.luisu.retrofitphotos;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.luisu.retrofitphotos.DTO.Peliculas;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recy;
    private AdaptadorP adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recy = (RecyclerView) findViewById(R.id.recycle);
        recy.setScrollbarFadingEnabled(true);


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recy.setLayoutManager(llm);
        recy.setAdapter(adaptador);
        new AsyncTask<Void, Void, ArrayList<Peliculas>>() {
            @Override
            protected ArrayList<Peliculas> doInBackground(Void... params) {
                ServicioRest service = new ServicioRest();
                try {
                    return service.getDatosP();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(ArrayList<Peliculas> albums) {
                super.onPostExecute(albums);
                if (albums != null) {
                    adaptador = new AdaptadorP(albums);
                    recy.setAdapter(adaptador);
                } else
                    Snackbar.make(recy, "No encontrados datos", Snackbar.LENGTH_SHORT).show();

            }
        }.execute();
    }
}
