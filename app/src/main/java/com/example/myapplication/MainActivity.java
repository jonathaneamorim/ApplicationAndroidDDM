package com.example.myapplication;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText mini, maxi;
    TextView result;
    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mini = findViewById(R.id.min);
        maxi = findViewById(R.id.max);
        result = findViewById(R.id.result);
        botao = findViewById(R.id.button);

        botao.setOnClickListener((v) -> {
            int min = Integer.parseInt(mini.getText().toString());
            int max = Integer.parseInt(maxi.getText().toString());
            Random random = new Random();
            int sorteado = (int) (Math.random() * (max - min) - min);
            result.setText(Integer.toString(sorteado));
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}