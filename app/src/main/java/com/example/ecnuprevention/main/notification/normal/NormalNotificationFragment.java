package com.example.ecnuprevention.main.notification.normal;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecnuprevention.R;
import com.example.ecnuprevention.databinding.FragmentNotificationBinding;
import com.example.ecnuprevention.main.notification.NotificationListAdapter;

public class NormalNotificationFragment extends Fragment {

    private NormalNotificationViewModel notificationViewModel;
    private FragmentNotificationBinding binding;

    public static NormalNotificationFragment newInstance() {
        return new NormalNotificationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentNotificationBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        notificationViewModel =
                new NormalNotificationViewModel(this, new NotificationListAdapter(this));

    }



}