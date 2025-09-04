package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText pesoi, alturai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        b=findViewById(R.id.edBotao);
        pesoi = findViewById(R.id.tvPeso);
        alturai = findViewById(R.id.edAltura);

        b.setOnClickListener(v -> {
            Intent intent = new Intent(this, IMCResultado.class);

            float peso = Float.parseFloat(pesoi.getText().toString());
            float altura = Float.parseFloat(alturai.getText().toString());

            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            startActivity(intent);
        });
    }
}