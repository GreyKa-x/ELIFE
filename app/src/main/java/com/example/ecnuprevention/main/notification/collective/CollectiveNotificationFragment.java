package com.example.ecnuprevention.main.notification.collective;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecnuprevention.R;

public class CollectiveNotificationFragment extends Fragment {

    private CollectiveNotificationViewModel collectiveNotificationViewModel;

    public static CollectiveNotificationFragment newInstance() {
        return new CollectiveNotificationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_normal_notification, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        collectiveNotificationViewModel = new CollectiveNotificationViewModel(this);

    }

}