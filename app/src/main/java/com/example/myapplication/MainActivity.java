package com.example.myapplication;

import android.content.DialogInterface;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    SimplePaint simplePaint;

    // Deixar o usuário escolher as formas
    // Pegar a hipotenusa pra saber o raio do circulo
    // Adicionar camadas com multiplos paths e paints (arraylist e foreach)
    // Definir forma de desenho (circulo, quadrado e linha);
    // salvar um bitmap em memoria

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        simplePaint = findViewById(R.id.simplePaint);

        findViewById(R.id.colorPickerButton).setOnClickListener(v -> {
            new ColorPickerDialog.Builder(this)
                    .setTitle("ColorPicker Dialog")
                    .setPreferenceName("MyColorPickerDialog")
                    .setPositiveButton("Confirmar",
                            new ColorEnvelopeListener() {
                                @Override
                                public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                    setColor(envelope);
                                }
                            })
                    .setNegativeButton("Cancelar",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                    .attachAlphaSlideBar(true) // the default value is true.
                    .attachBrightnessSlideBar(true)  // the default value is true.
                    .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                    .show();
        });
    }

    public void setColor(ColorEnvelope envelope) {
        simplePaint.setColor(envelope.getColor());
    }
}