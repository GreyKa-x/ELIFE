package com.example.ecnuprevention.main.notification.collective;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

public class CollectiveNotificationViewModel extends ViewModel {

    private Fragment fragment;

    CollectiveNotificationViewModel(Fragment fragment) {
        this.fragment = fragment;
    }
}