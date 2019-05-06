package com.example.retrofit;

import android.util.Log;

import com.example.retrofit.pojo.Register;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface StoreClient {

   // @POST("/MobileAuth/register")
   // Call<Register> regCall(@Body sampleRegister sampleRegister);

   @POST("MobileAuth/register/{Email}/{Password}/{FirstName}/{LastName}/{PhoneNumber}")
    Call<Register> regCall(@Path("Email") String Email, @Path("Password") String Password, @Path("FirstName") String FirstName, @Path("LastName") String LastName, @Path("PhoneNumber") String PhoneNumber);

}
