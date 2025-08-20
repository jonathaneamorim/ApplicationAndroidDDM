package com.example.myapplication;

import android.location.LocationManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.d("Ciclo de vida", "onCreate ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ciclo de vida", "onStart ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ciclo de vida", "onStop ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Ciclo de vida", "onRestart ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ciclo de vida", "onDestroy ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}