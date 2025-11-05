package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    EditText editText;
    Button saveButton;
    ListView listView;
    ArrayList<String> notasList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.field);
        saveButton = findViewById(R.id.button);
        listView = findViewById(R.id.l_view);
        notasList = new ArrayList<>();

        // ADB - Aplicação que realiza a comunicação de arquivos entre o Desktop e o Mobile
        // path

        database = openOrCreateDatabase("app_database", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS notas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR, " +
                "texto VARCHAR)"
        );
        saveButton.setOnClickListener(v -> {
            String texto = editText.getText().toString();
            if(!texto.isEmpty()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", texto);
                contentValues.put("texto", texto);
                database.insert("notas", null, contentValues);
            }
            carregarNotas();
        });

        carregarNotas();
    }

    public void carregarNotas() {
        // database.rawQuery("SELECT * FROM notas WHERE id=? AND ?", new String[]{"1", "2"})
        notasList.clear();
        Cursor cursor = database.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            int columnIndex = cursor.getColumnIndex("texto");
            String s = cursor.getString(columnIndex);
            notasList.add(s);
            cursor.moveToNext();
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notasList);
        listView.setAdapter(adapter);
    }
}