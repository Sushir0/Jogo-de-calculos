package com.example.jogodacalculadora.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jogodacalculadora.Database.AdapterHistorico;
import com.example.jogodacalculadora.Database.Fragmentos.Database;
import com.example.jogodacalculadora.Database.Historico;
import com.example.jogodacalculadora.R;

import java.util.ArrayList;

public class HistoricoActivity extends AppCompatActivity {

    ArrayList<Historico> history;
    TextView nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        // ...
        // Lookup the recyclerview in activity layout
        RecyclerView rvhistory = (RecyclerView) findViewById(R.id.RecyclerViewHistorico);
        nome = findViewById(R.id.textView24);

        nome.setText(""+ Database.PlayerLogado.getNome());
        // Initialize contacts
        history = Database.PlayerLogado.history;

        // Create adapter passing in the sample user data
        AdapterHistorico adapter = new AdapterHistorico(history);

        // Attach the adapter to the recyclerview to populate items
        rvhistory.setAdapter(adapter);

        // Set layout manager to position the items
        rvhistory.setLayoutManager(new LinearLayoutManager(this));

        // That's all!
    }


    public void fechar(View View){ finish();}
}


