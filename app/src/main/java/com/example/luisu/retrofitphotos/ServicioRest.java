package com.example.luisu.retrofitphotos;


import com.example.luisu.retrofitphotos.DTO.Album;
import com.example.luisu.retrofitphotos.DTO.Deserializador;
import com.example.luisu.retrofitphotos.DTO.Peliculas;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by luisu on 28/03/2016.
 */
public class ServicioRest implements IServicio {
    private static RestApi retrofit;

    public ServicioRest() {
        retrofit = ServiceGenerator.createService(RestApi.class);
    }

    @Override
    public ArrayList<Album> getDatos() throws IOException {
        Call<ArrayList<Album>> call = retrofit.getAlbum();
        return call.execute().body();
    }

    @Override
    public ArrayList<Peliculas> getDatosP() throws IOException {
        Call<Deserializador> call = retrofit.getPelicula();
        return  call.execute().body().getResults();
    }
}
