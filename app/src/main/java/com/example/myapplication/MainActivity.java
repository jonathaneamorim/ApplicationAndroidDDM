package com.example.myapplication;

import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // desisti, ver dps pro trabalho

    private static final int REQUEST_LOCATION = 1;
    private static final String TAG = "MainActivity";
    LocationManager locationManager;
    TextView textView;
    Button btnGetLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        btnGetLocation = findViewById(R.id.buttonGetLocation);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        checkAndGetLocation();
        btnGetLocation.setOnClickListener(v -> getLocation());
    }

    public void checkAndGetLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_DENIED
        ) {
            requestAccess();
            return;
        }
        getLocation();
    }

    public void getLocation() {
        try {
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, location1 -> {
                double latitude = location1.getLatitude();
                double longitude = location1.getLongitude();
                textView.setText("Latitude: " + latitude + "\n Longitude: " + longitude);
            });
            if(location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                if(textView != null) {
                    textView.setText("Latitude: " + latitude + "\n Longitude: " + longitude);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void requestAccess() {
        // Solicitar permissão em tempo de execução
        ActivityCompat.requestPermissions(this,
                new String[] {
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION},
                REQUEST_LOCATION);
        }
}