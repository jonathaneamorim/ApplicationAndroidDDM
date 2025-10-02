package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class InfoUserFragment extends Fragment {

    TextView fragPeso, fragAltura, fragImc, fragNome;
    ImageView fragImage;

    Button abrirResultado;

    Bundle b;

    public  InfoUserFragment(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setBundle(Bundle bundle) {
        this.b = bundle;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_info_user, container, false);

        fragPeso = view.findViewById(R.id.fragPeso);
        fragAltura = view.findViewById(R.id.fragAltura);
        fragImc = view.findViewById(R.id.fragImc);
        fragNome = view.findViewById(R.id.fragNome);
        fragImage = view.findViewById(R.id.fragImage);

        Bundle args = b;

        String nome = args.getString("nome");
        float peso = args.getFloat("peso");
        float altura = args.getFloat("altura");
        float imc = args.getFloat("imc");

        fragPeso.setText("Peso: " + Float.toString(peso));
        fragAltura.setText("Altura: " + Float.toString(altura));
        fragImc.setText("IMC: " + Float.toString(imc));
        fragNome.setText("Nome: " + nome);

        if(imc < 18.5) {
            fragImage.setImageResource(R.drawable.abaixopeso);
        } else if(imc < 24.9) {
            fragImage.setImageResource(R.drawable.normal);
        } else if(imc < 29.9) {
            fragImage.setImageResource(R.drawable.sobrepeso);
        } else if (imc < 34.9) {
            fragImage.setImageResource(R.drawable.obesidade1);
        } else if (imc < 39.9) {
            fragImage.setImageResource(R.drawable.obesidade2);
        } else {
            fragImage.setImageResource(R.drawable.obesidade3);
        }

        abrirResultado.setOnClickListener(v -> {
            UserResponseFragment userResponseFragment = new UserResponseFragment();
            userResponseFragment.setArguments(b);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentContainerView, userResponseFragment);
            ft.commit();
        });

        return view;
    }
}