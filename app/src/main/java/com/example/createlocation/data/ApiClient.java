package com.example.createlocation.data;

import com.example.createlocation.pojo.LoginRequest;
import com.example.createlocation.pojo.LoginResponse;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Header;

public class ApiClient {
    String token;
    private static final String BASE_URL = "http://95.211.149.197:1050/";
    private ApiInterface apiInterface;
    private ApiClient INSTANCE;
    public LoginRequest loginRequest;

    private static Retrofit getRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiJhZTg2OGY4Ny01OWExLTQyYzUtOTc4Yy01MjA3ZGIzZDI0ZjgiLCJ1bmlxdWVfbmFtZSI6ItmF2K_ZitixIiwibmJmIjoxNjA3NTkyODI3LCJleHAiOjE2MDc2NzkyMjcsImlhdCI6MTYwNzU5MjgyN30.D-rOgLnQQVy0G3nMwzgkoKjefAbhbi3sYU1doffb7TA").build();
                return chain.proceed(request);
            }
        }).addInterceptor(httpLoggingInterceptor);
        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("http://95.211.149.197:1050/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build();
        return retrofit1;
    }

    public static ApiInterface getApiInterface() {
        ApiInterface anInterface = getRetrofit().create(ApiInterface.class);
        return anInterface;
    }
}
