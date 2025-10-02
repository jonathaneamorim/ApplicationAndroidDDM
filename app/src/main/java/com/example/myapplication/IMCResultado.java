package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.fragments.InfoUserFragment;

public class IMCResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcresult);

        InfoUserFragment infoUserFragment = new InfoUserFragment();

        Bundle b = getIntent().getExtras();

        infoUserFragment.setArguments(b);
        infoUserFragment.setBundle(b);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.fragmentContainerView, infoUserFragment);

        ft.commit();


    }
}