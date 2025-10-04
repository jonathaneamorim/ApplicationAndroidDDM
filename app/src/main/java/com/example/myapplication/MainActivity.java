package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonFragmentA,buttonFragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        buttonFragmentA=findViewById(R.id.buttonFa);
        buttonFragmentB=findViewById(R.id.buttonFb);

        buttonFragmentA.setOnClickListener(this);
        buttonFragmentB.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        switch (v.getId()){
            case (R.id.buttonFa):
                fragment = new FragmentA();
                break;

            case (R.id.buttonFb):
                fragment = new FragmentB();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frameConteudo, fragment);
        fragmentTransaction.commit();
    }
}