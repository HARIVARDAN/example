package com.example.hari.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.*;
import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;


/**
 * Created by Hari on 3/16/2016.
 */
public class login extends Fragment {

    View rootview;

    @Nullable
    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){

        rootview=inflater.inflate(R.layout.login, container,false);
        return rootview;

    }




}
