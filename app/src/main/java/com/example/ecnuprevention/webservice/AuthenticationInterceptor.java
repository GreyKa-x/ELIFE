package com.example.ecnuprevention.webservice;


import android.content.Intent;

import com.example.ecnuprevention.login.LoginActivity;
import com.example.ecnuprevention.MyApplication;
import com.example.ecnuprevention.constants.HttpCode;
import com.example.ecnuprevention.utilities.uToast;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request updateRequest = originalRequest
                .newBuilder()
                .header("app-token", "$2a$10$Kay47GNs8/uaH26e8A01x.ogi9GkBuAVEQ1uNiPv/03ogLTIccRy")
                .build();
        Response response = chain.proceed(updateRequest);
        if(response.code() == HttpCode.Unauthorized) {
            uToast.unauthorized();
            navigateToLoginActivity();
        }
        return response;
    }
    private void navigateToLoginActivity() {
        Intent intent = new Intent(MyApplication.getGlobalContext(), LoginActivity.class);
        MyApplication.getGlobalContext().startActivity(intent);
    }
}


