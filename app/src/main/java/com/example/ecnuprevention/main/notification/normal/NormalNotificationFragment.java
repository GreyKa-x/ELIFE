package com.example.ecnuprevention.main.notification.normal;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecnuprevention.R;
import com.example.ecnuprevention.databinding.FragmentNormalNotificationBinding;
import com.example.ecnuprevention.databinding.FragmentNotificationBinding;
import com.example.ecnuprevention.main.notification.NotificationListAdapter;
import com.example.ecnuprevention.main.notification.SpacesItemDecoration;
import com.example.ecnuprevention.utilities.uDensityUtil;
import com.example.ecnuprevention.webservice.ResponseData.NotificationData;

public class NormalNotificationFragment extends Fragment {

    private NormalNotificationViewModel normalNotificationViewModel;
    private FragmentNormalNotificationBinding binding;

    public static NormalNotificationFragment newInstance() {
        return new NormalNotificationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentNormalNotificationBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        NotificationListAdapter adapter = new NotificationListAdapter(this);
        int space = 8;
        binding.normalNotificationList.addItemDecoration(new SpacesItemDecoration(uDensityUtil.dpToPx(7)));
        binding.normalNotificationList.setAdapter(adapter);
        binding.normalNotificationList.setLayoutManager(new LinearLayoutManager(getContext()));
        normalNotificationViewModel =
                new NormalNotificationViewModel(this, adapter);

    }



}