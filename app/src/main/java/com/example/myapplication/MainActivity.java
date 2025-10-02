package com.example.myapplication;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText pesoi, alturai, nomei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.edBotao);
        pesoi = findViewById(R.id.tvPeso);
        alturai = findViewById(R.id.edAltura);
        nomei = findViewById(R.id.nome);

        b.setOnClickListener(v -> {
            Intent intent = new Intent(this, IMCResultado.class);

            float peso = Float.parseFloat(pesoi.getText().toString());
            float altura = Float.parseFloat(alturai.getText().toString());
            String nome = nomei.getText().toString();

            float imc = peso / (altura * altura);

            intent.putExtra("nome", nome);
            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            intent.putExtra("imc", imc);

            startActivity(intent);
        });
    }
}