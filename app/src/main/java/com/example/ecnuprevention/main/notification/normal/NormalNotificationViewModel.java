package com.example.ecnuprevention.main.notification.normal;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ecnuprevention.main.notification.NotificationListAdapter;
import com.example.ecnuprevention.utilities.uToast;
import com.example.ecnuprevention.webservice.Response;
import com.example.ecnuprevention.webservice.ResponseData.NotificationData;
import com.example.ecnuprevention.webservice.ResponseData.SignInData;

import retrofit2.Call;
import retrofit2.Callback;

public class NormalNotificationViewModel implements Callback<Response<NotificationData>> {

    private Fragment fragment;

    private Callback callback;

    private NotificationData dataList;

    private NotificationListAdapter notificationListAdapter;

    NormalNotificationViewModel(Fragment fragment, NotificationListAdapter adapter) {
        this.fragment = fragment;
        this.notificationListAdapter = adapter;
    }

    @Override
    public void onResponse(Call<Response<NotificationData>> call, retrofit2.Response<Response<NotificationData>> response) {
        if(response.isSuccessful()) {
            notificationListAdapter.updateData(response.body().data);
        } else {
            uToast.serviceFailed();
        }
    }

    @Override
    public void onFailure(Call<Response<NotificationData>> call, Throwable t) {

    }
}