package com.example.createlocation.data;

import com.example.createlocation.pojo.CreateLocationModel;
import com.example.createlocation.pojo.CreateLocationResponse;
import com.example.createlocation.pojo.FacilityModel;
import com.example.createlocation.pojo.GetAllDropDown;
import com.example.createlocation.pojo.LoginRequest;
import com.example.createlocation.pojo.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @POST("api/Users/Login")
    public Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);
    @GET("api/Facilities/GetAllFacilities")
    public Call <List<FacilityModel>> getFacilities();
    @GET("api/Facilities/GetAllFacilitiesDropDown")
    public Call <GetAllDropDown> getDropDown();
    @Headers("Content-Type: application/json")
    @POST("api/Location")
    public Call<CreateLocationResponse> postData(@Body CreateLocationModel createLoctionModel);
    @PUT("api/Location")
    public Call<Boolean> getRequest(@Path("id") int id,@Body CreateLocationResponse createLocationResponse);
}
