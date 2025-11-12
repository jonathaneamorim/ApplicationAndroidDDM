package com.example.myapplication;

import android.content.DialogInterface;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

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
    // Deixar o usuário escolher as formas
    // Pegar a hipotenusa pra saber o raio do circulo
    // Adicionar camadas com multiplos paths e paints (arraylist e foreach)
    // Definir forma de desenho (circulo, quadrado e linha);
    // salvar um bitmap em memoria

    SimplePaint simplePaint;
    private int selectedColor = Color.BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simplePaint = findViewById(R.id.simplePaint);

        Button btnFreeDraw = findViewById(R.id.btnFreeDraw);
        Button btnLine = findViewById(R.id.btnLine);
        Button btnRect = findViewById(R.id.btnRect);
        Button btnCircle = findViewById(R.id.btnCircle);
        Button btnColor = findViewById(R.id.btnColor);
        Button btnClear = findViewById(R.id.btnClear);

        btnFreeDraw.setOnClickListener(v -> {
            simplePaint.setShapeType(SimplePaint.ShapeType.FREE_DRAW);
            Toast.makeText(this, "Modo: Traço Livre", Toast.LENGTH_SHORT).show();
        });

        btnLine.setOnClickListener(v -> {
            simplePaint.setShapeType(SimplePaint.ShapeType.LINE);
            Toast.makeText(this, "Modo: Linha", Toast.LENGTH_SHORT).show();
        });

        btnRect.setOnClickListener(v -> {
            simplePaint.setShapeType(SimplePaint.ShapeType.RECTANGLE);
            Toast.makeText(this, "Modo: Retângulo", Toast.LENGTH_SHORT).show();
        });

        btnCircle.setOnClickListener(v -> {
            simplePaint.setShapeType(SimplePaint.ShapeType.CIRCLE);
            Toast.makeText(this, "Modo: Círculo", Toast.LENGTH_SHORT).show();
        });

        btnColor.setOnClickListener(v -> {
            new ColorPickerDialog.Builder(this)
                    .setTitle("Escolha uma cor")
                    .setPreferenceName("ColorPickerDialog")
                    .setPositiveButton("Selecionar", new ColorEnvelopeListener() {
                        @Override
                        public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                            selectedColor = envelope.getColor();
                            simplePaint.setCurrentColor(selectedColor);
                            Toast.makeText(MainActivity.this, "Cor alterada!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancelar", (dialogInterface, i) -> dialogInterface.dismiss())
                    .attachAlphaSlideBar(true)
                    .attachBrightnessSlideBar(true)
                    .show();
        });

        btnClear.setOnClickListener(v -> simplePaint.clearCanvas());
    }
}