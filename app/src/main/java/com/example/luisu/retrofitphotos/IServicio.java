package com.example.luisu.retrofitphotos;

import com.example.luisu.retrofitphotos.DTO.Album;
import com.example.luisu.retrofitphotos.DTO.Deserializador;
import com.example.luisu.retrofitphotos.DTO.Peliculas;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by luisu on 28/03/2016.
 */
public interface IServicio {

    ArrayList<Album> getDatos() throws IOException;

    ArrayList<Peliculas> getDatosP() throws  IOException;
}
