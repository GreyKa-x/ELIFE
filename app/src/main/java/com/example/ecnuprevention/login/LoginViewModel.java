package com.example.ecnuprevention.login;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;

import com.example.ecnuprevention.main.MainActivity;
import com.example.ecnuprevention.utilities.uDataStore;
import com.example.ecnuprevention.utilities.uToast;
import com.example.ecnuprevention.webservice.Response;
import com.example.ecnuprevention.webservice.ResponseData.SignInData;
import com.example.ecnuprevention.webservice.WebServiceClient;

public class LoginViewModel implements Callback<Response<SignInData>>{

    private Activity activity;
    private MutableLiveData<String> username;
    private MutableLiveData<String> password;

    LoginViewModel(Activity activity) {
        username = new MutableLiveData<>("");
        password = new MutableLiveData<>("");
        this.activity = activity;

    }
    public void setPassword(String str) {
        password.setValue(str);
    }
    public void setUsername(String str) {
        username.setValue(str);
    }

    public void login() {
        WebServiceClient
                .SignInWithUsernameAndPassword(username.getValue(), password.getValue())
                .enqueue(this);
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
    private void saveToken(retrofit2.Response<Response<SignInData>> response) {
        String token = response.body().data.token;
        uDataStore.putString("token", token);
    }

    @Override
    public void onResponse(Call<Response<SignInData>> call, retrofit2.Response<Response<SignInData>> response) {
        if(response.isSuccessful()) {
            if(response.body().code == 200) {
                saveToken(response);
                uToast.operationSucceeded();
                navigateToMainActivity();
            } else {
                uToast.show(response.body().message);
            }

        } else {
            uToast.show(response.code() + "");
            uToast.serviceFailed();
        }
    }

    @Override
    public void onFailure(Call<Response<SignInData>> call, Throwable t) {
        uToast.networkError();
    }
}
