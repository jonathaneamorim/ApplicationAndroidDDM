package com.example.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    Sensor sensorLuz;
    TextView tvLuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvLuz = findViewById(R.id.textView);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        sensorLuz = sm.getDefaultSensor(Sensor.TYPE_LIGHT);

        // Looper - Tratar eventos

        sm.registerListener(MainActivity.this, sensorLuz, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float luz = event.values[0];
        tvLuz.setText(luz + "lx");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}