package com.example.ecnuprevention;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;

import com.example.ecnuprevention.utilities.uToast;
import com.example.ecnuprevention.webservice.Response;
import com.example.ecnuprevention.webservice.ResponseData.SignInData;
import com.example.ecnuprevention.webservice.WebServiceClient;

public class LoginViewModel extends ViewModel implements Callback<Response<SignInData>>{

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

    @Override
    public void onResponse(Call<Response<SignInData>> call, retrofit2.Response<Response<SignInData>> response) {
        if(response.isSuccessful()) {
            uToast.operationSucceeded();
            navigateToMainActivity();
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
