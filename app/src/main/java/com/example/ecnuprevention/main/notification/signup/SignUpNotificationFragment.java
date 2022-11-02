package com.example.ecnuprevention.main.notification.signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecnuprevention.R;
import com.example.ecnuprevention.main.notification.normal.NormalNotificationViewModel;

public class SignUpNotificationFragment extends Fragment {

    private SignUpNotificationViewModel signUpNotificationViewModel;

    public static com.example.ecnuprevention.main.notification.normal.NormalNotificationFragment newInstance() {
        return new com.example.ecnuprevention.main.notification.normal.NormalNotificationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_normal_notification, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        signUpNotificationViewModel = new SignUpNotificationViewModel(this);
        // TODO: Use the ViewModel
    }

}
