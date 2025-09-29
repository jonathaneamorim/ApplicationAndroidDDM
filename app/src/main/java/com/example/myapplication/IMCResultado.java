package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IMCResultado extends AppCompatActivity {

    TextView tvPeso, tvAltura, tvIMC;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcresultado);

        tvPeso = findViewById(R.id.tvPeso);
        tvAltura = findViewById(R.id.tvAltura);
        tvIMC = findViewById(R.id.tvIMC);
        imageView = findViewById(R.id.tvPerfil);

        Bundle b = getIntent().getExtras();

        float peso = b.getFloat("peso");
        float altura = b.getFloat("altura");

        float imc = peso / (altura * altura);

        // Peso (kg) / (Altura (m) x Altura (m))

        Log.d("PESO", Float.toString(peso));
        Log.d("ALTURA", Float.toString(altura));
        Log.d("IMC", Float.toString(imc));

        tvPeso.setText("Peso: " + Float.toString(peso));
        tvAltura.setText("Altura: " + Float.toString(altura));
        tvIMC.setText("IMC: " + Float.toString(imc));


        if(imc < 18.5) {
            imageView.setImageResource(R.drawable.abaixopeso);
        } else if(imc < 24.9) {
            imageView.setImageResource(R.drawable.normal);
        } else if(imc < 29.9) {
            imageView.setImageResource(R.drawable.sobrepeso);
        } else if (imc < 34.9) {
            imageView.setImageResource(R.drawable.obesidade1);
        } else if (imc < 39.9) {
            imageView.setImageResource(R.drawable.obesidade2);
        } else {
            imageView.setImageResource(R.drawable.obesidade3);
        }

    }
}