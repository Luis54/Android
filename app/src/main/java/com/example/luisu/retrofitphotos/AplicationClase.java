package com.example.luisu.retrofitphotos;

import android.app.Application;

/**
 * Created by luisu on 29/03/2016.
 */
public class AplicationClase extends Application{


    private static AplicationClase instance;

    public static AplicationClase getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
