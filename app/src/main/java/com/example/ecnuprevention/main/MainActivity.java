package com.example.ecnuprevention.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.ecnuprevention.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends FragmentActivity {

    private MainViewModel mainViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initiate();
    }
    private void initiate() {
        mainViewModel = new MainViewModel(this);
        setBinding();
        setListeners();
    }

    private void setListeners() {
        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return mainViewModel.setMenuItemChecked(item);
            }
        });
    }

    private void setBinding() {
         binding = ActivityMainBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());
    }

}