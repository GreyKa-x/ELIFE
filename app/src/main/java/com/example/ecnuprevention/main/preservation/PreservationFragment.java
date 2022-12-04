package com.example.ecnuprevention.main.preservation;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecnuprevention.R;
import com.example.ecnuprevention.databinding.FragmentPreservationBinding;

import java.util.ArrayList;
import java.util.List;


public class PreservationFragment extends Fragment {

    private PreservationViewModel preservationViewModel;

    FragmentPreservationBinding binding;

    public static PreservationFragment newInstance() {
        return new PreservationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPreservationBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            preservationViewModel = new PreservationViewModel(this);
        setViews();
    }
    private void setViews() {

    }

}

