package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.control.NotaController;
import com.example.myapplication.model.Nota;
import com.example.myapplication.view.InputNotaView;
import com.example.myapplication.view.ListNotasAdapter;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    // https://developer.android.com/develop/background-work/background-tasks/asynchronous/java-threads?hl=pt-br
    private final Executor executor = Executors.newSingleThreadExecutor();
    ListNotasAdapter adapter;
    NotaController notaController;
    ListView listView;
    Button botaoNovaNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notaController = new NotaController(this);
        botaoNovaNota = findViewById(R.id.botaoNovaNota);

        listView = findViewById(R.id.listViewNotas);
        adapter = new ListNotasAdapter(this, R.layout.list_notas, notaController.getListaNotas());

        listView.setAdapter(adapter);

        botaoNovaNota.setOnClickListener(v -> {
            v.setEnabled(false);
            Intent intent = new Intent(MainActivity.this, InputNotaView.class);
            intent.putExtra("edicao", false);
            startActivity(intent);
            v.setEnabled(true);
        });

    }

    // Ao voltar pra activity principal,
        // atualiza a lista de notas
        // atualiza o adapter
        // e reinicia a view com notifyDataSetChanged()
    // https://pt.stackoverflow.com/questions/115564/atualizar-listview-usando-notifydatasetchanged
    @Override
    protected void onResume() {
        super.onResume();

        // Realizando processos em segundo plano, fazendo direto dava erro direto
        executor.execute(() -> {
            List<Nota> lista = notaController.getListaNotas();

            // Função disponível no contexto do AppCompatActivity
            // Sem necessidade de instanciar um objeto mainHandler
            // Limpa o adapter e adiciona a nova lista, após isso atualiza a tela
            runOnUiThread(() -> {
                adapter.clear();
                adapter.addAll(lista);
                adapter.notifyDataSetChanged();
            });
        });
    }
}