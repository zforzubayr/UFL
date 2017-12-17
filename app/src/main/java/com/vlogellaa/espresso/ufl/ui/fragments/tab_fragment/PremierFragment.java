package com.vlogellaa.espresso.ufl.ui.fragments.tab_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vlogellaa.espresso.ufl.R;

public class PremierFragment extends Fragment {


    public PremierFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_premier, container, false);
        return view;
    }

}
