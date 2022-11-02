package com.example.ecnuprevention;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.view.MenuItem;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;

import com.example.ecnuprevention.utilities.uToast;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {


    private final FragmentActivity activity;
    private ArrayList<Fragment> fragments;

    MainViewModel(FragmentActivity activity) {
        this.activity = activity;
        fragments = new ArrayList<>();
        addFragments();
    }

    private void addFragments() {
        fragments.add(new NotificationFragment());
        fragments.add(new PreservationFragment());
        fragments.add(new CommentFragment());
    }

    public Boolean setMenuItemChecked(MenuItem item) {
        item.setCheckable(true);
        switch (item.getItemId()) {
            case R.id.notification:
                switchFragmentById(0);
                return true;
            case R.id.preservation:
                switchFragmentById(1);
                return true;
            case R.id.comment:
                switchFragmentById(2);
                return true;
            default:
                return false;
        }
    }

    public void switchFragmentById(Integer id) {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, fragments.get(id))
                .commit();
    }


}
