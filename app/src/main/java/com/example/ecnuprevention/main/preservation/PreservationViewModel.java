package com.example.ecnuprevention.main.preservation;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class PreservationViewModel {

    private Fragment fragment;

    private List<String> titles = new ArrayList<>();
    {
        titles.add("123");
        titles.add("123");
        titles.add("123");
        titles.add("123");
        titles.add("123");
        titles.add("123");
    }

    public List<String> getTitles() {
        return titles;
    }

    PreservationViewModel(Fragment fragment) {
        this.fragment = fragment;
    }

}