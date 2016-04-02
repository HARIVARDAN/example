package com.example.hari.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Hari on 3/16/2016.
 */
public class about extends Fragment {

    View rootview;

    @Nullable
    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){

        rootview=inflater.inflate(R.layout.about, container,false);

        return rootview;

    }
}

