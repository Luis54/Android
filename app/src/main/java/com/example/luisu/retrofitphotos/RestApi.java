package com.example.luisu.retrofitphotos;

import com.example.luisu.retrofitphotos.DTO.Album;
import com.example.luisu.retrofitphotos.DTO.Deserializador;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {

    @GET("photos")
    Call<ArrayList<Album>> getAlbum();

    @GET("movie?sort_by=popularity.desc&api_key=b46be86043bd1e650910333fb3d7c935")
    Call<Deserializador> getPelicula();
}
