package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class UserResponseFragment extends Fragment {

    TextView userResponse;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_user_response, container, false);

        userResponse = view.findViewById(R.id.userResponse);

        Bundle args = getArguments();

        float imc = args.getFloat("imc");
        float peso = args.getFloat("peso");
        float altura = args.getFloat("altura");

        String text;
        float limite = 24.9F;

        if(imc < 20) {
            float x = imc * (altura * altura)  - peso;
            text = "Você precisa ganhar " + x + "Kg";
        } else if(imc > limite) {
            float x = peso - limite * (altura * altura);
            text = "Você precisa perder " + x + "Kg";
        } else {
            text = "Erro nos dados";
        }

        userResponse.setText(text);

        return view;
    }

}