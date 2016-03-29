package com.example.luisu.retrofitphotos;




import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    // public static String API_BASE_URL = "http://jsonplaceholder.typicode.com/";
    public static String API_BASE_URL = "http://api.themoviedb.org/3/discover/";
    //  public static final String API_BASE_URL = "http://your.api-base.url";

    private static OkHttpClient httpClient;

    private static void okhttpclient() {
        Cache cache = null;
        cache = new Cache(new File(AplicationClase.getInstance().getCacheDir(), "retrofitpeliculas-cache"), 1024 * 1024 * 10);
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient = new OkHttpClient.Builder().addInterceptor(logging).cache(cache).build();

       // httpClient.networkInterceptors().add(REWRITE_CACHE_CONTROL_INTERCEPTOR);
    }

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        // HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        //logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        //httpClient.addInterceptor(logging);
        okhttpclient();
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }

    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            return originalResponse.newBuilder()
                    .build();
        }
    };
}
