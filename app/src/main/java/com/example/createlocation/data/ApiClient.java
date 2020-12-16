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

    private static final String BASE_URL = "http://95.211.149.197:1050/";
    private ApiInterface apiInterface;
    private ApiClient INSTANCE;
    public LoginRequest loginRequest;

    private static Retrofit getRetrofit(String token) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer "+token).build();
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

    public static ApiInterface getApiInterface(String token) {
        ApiInterface anInterface = getRetrofit(token).create(ApiInterface.class);
        return anInterface;
    }
}
