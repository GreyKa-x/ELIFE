package com.example.ecnuprevention.main.notification;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.viewpager2.widget.ViewPager2;

import com.example.ecnuprevention.main.notification.collective.CollectiveNotificationFragment;
import com.example.ecnuprevention.main.notification.normal.NormalNotificationFragment;
import com.example.ecnuprevention.main.notification.signup.SignUpNotificationFragment;

import java.util.ArrayList;
import java.util.List;

public class NotificationViewModel {
    private Fragment fragment;
    private List<Fragment> fragments;
    private List<String> tabs;
    NotificationViewModel(Fragment fragment) {
        this.fragment = fragment;
        this.fragments = new ArrayList<>();
        this.tabs = new ArrayList<>();
        addFragments();
    }
    private void addFragments() {
        fragments.add(new NormalNotificationFragment());
        tabs.add("通知");
        fragments.add(new SignUpNotificationFragment());
        tabs.add("签到");
        fragments.add(new CollectiveNotificationFragment());
        tabs.add("收集");
    }
    public List<Fragment> getFragments() {
        return fragments;
    }
    public List<String> getTabs() {
        return tabs;
    }

}