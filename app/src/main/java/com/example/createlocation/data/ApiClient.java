package com.example.createlocation.data;

import com.example.createlocation.pojo.LoginRequest;
import com.example.createlocation.pojo.LoginResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL="http://95.211.149.197:1050/";
    private ApiInterface apiInterface;
    private ApiClient INSTANCE;
    public LoginRequest loginRequest;
    private static Retrofit getRetrofit(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("http://95.211.149.197:1050/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit1;
    }
    public static ApiInterface getApiInterface(){
        ApiInterface anInterface = getRetrofit().create(ApiInterface.class);
        return anInterface;
    }
}
