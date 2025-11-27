package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] alunos = {"Jonathan", "Aline", "Ana", "Jefferson"};

        listView = findViewById(R.id.listView);

        adapter = new ArrayAdapter<>(
                this,
                R.layout.item_1,
                android.R.id.text1,
                alunos
        );

        listView.setAdapter(adapter);
    }
}