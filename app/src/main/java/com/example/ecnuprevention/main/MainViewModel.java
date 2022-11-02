package com.example.ecnuprevention.main;

import android.view.MenuItem;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.ecnuprevention.main.comment.CommentFragment;
import com.example.ecnuprevention.main.preservation.PreservationFragment;
import com.example.ecnuprevention.R;
import com.example.ecnuprevention.main.notification.NotificationFragment;

import java.util.ArrayList;

public class MainViewModel {


    private final FragmentActivity activity;
    private ArrayList<Fragment> fragments;
    private Integer fragmentNow = 0;

    MainViewModel(FragmentActivity activity) {
        this.activity = activity;
        fragments = new ArrayList<>();
        addFragments();
    }

    private void addFragments() {
        fragments.add(new NotificationFragment());
        fragments.add(new PreservationFragment());
        fragments.add(new CommentFragment());
        activity.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container_view, fragments.get(0))
                .add(R.id.fragment_container_view, fragments.get(1))
                .add(R.id.fragment_container_view, fragments.get(2))
                .show(fragments.get(0))
                .hide(fragments.get(1))
                .hide(fragments.get(2))
                .commit();
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
                .hide(fragments.get(fragmentNow))
                .show(fragments.get(id))
                .commit();
        fragmentNow = id;

    }


}
