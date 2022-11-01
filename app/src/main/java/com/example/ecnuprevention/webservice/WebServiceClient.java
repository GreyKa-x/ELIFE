package com.example.ecnuprevention.webservice;

import retrofit2.Call;

import com.example.ecnuprevention.webservice.ResponseData.SignInData;

public class WebServiceClient {
    private static final WebServiceAPIs api = RetrofitManager.getRetrofit().create(WebServiceAPIs.class);

    public static Call<Response<SignInData>> SignInWithUsernameAndPassword(String username, String password) {
        return api.SignInWithUsernameAndPassword(username, password);
    }

}
