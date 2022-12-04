package com.example.ecnuprevention.webservice;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import com.example.ecnuprevention.webservice.ResponseData.NotificationData;
import com.example.ecnuprevention.webservice.ResponseData.SignInData;

public interface WebServiceAPIs {
    @POST("user/login")
    @FormUrlEncoded
    Call<Response<SignInData>> SignInWithUsernameAndPassword(@Field("username") String username, @Field("password") String password);

    @GET("notification/normal")
    Call<Response<NotificationData>> GetNormalNotificationList();

}
