package com.example.retrofit;

import android.util.Log;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static final String API_BASE_URL = "http://www.iwithyou.ir/api/";
    private static Retrofit myRetrofit = null;

    //Instance of OkHttp  , Retrofit use OkHttp to connection with Internet.
    private static OkHttpClient httpClient = new OkHttpClient.Builder().build();


    //Instance of Retrofit.Builder
    private static Retrofit.Builder builder =
            new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());


    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }




}
