package com.example.jogodacalculadora.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.jogodacalculadora.Calculos.Divisao;
import com.example.jogodacalculadora.Calculos.Multiplicacao;
import com.example.jogodacalculadora.Calculos.Soma;
import com.example.jogodacalculadora.Calculos.Subtracao;
import com.example.jogodacalculadora.Conversoes.Binario;
import com.example.jogodacalculadora.Conversoes.Octal;
import com.example.jogodacalculadora.Database.apiEstatisticas;
import com.example.jogodacalculadora.R;

public class EstatisticasActivity extends AppCompatActivity {

    TextView acertos, erros, taxa, total;

    private Spinner spinnerModo;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatisticas);

        Intent i = getIntent();
        String modo = i.getStringExtra("modo");

        acertos = (TextView) findViewById(R.id.Acertos);
        erros = (TextView) findViewById(R.id.Erros);
        taxa = (TextView) findViewById(R.id.Taxa);
        total = (TextView) findViewById(R.id.Total);

        spinnerModo = findViewById(R.id.spinnerModo);
        adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1);

        //vincular adaptador no spinner
        spinnerModo.setAdapter(adapter);



        //adicionar o valor no spinner
        adapter.add("SOMA");
        adapter.add("SUBTRAÇÃO");
        adapter.add("MULTIPLICAÇÃO");
        adapter.add("DIVISÃO");
        adapter.add("BINÁRIO");
        adapter.add("OCTAL");

        Double porcento = Double.valueOf(0);
        Integer Total = 0;

        switch(modo){
            case "SOMA":
                spinnerModo.setSelection(0);
                break;
            case "SUBTRAÇÃO":
                spinnerModo.setSelection(1);
                break;
            case "MULTIPLICAÇÃO":
                spinnerModo.setSelection(2);
                break;
            case "DIVISÃO":
                spinnerModo.setSelection(3);
                break;
            case "BINÁRIO":
                spinnerModo.setSelection(4);
                break;
            case "OCTAL":
                spinnerModo.setSelection(5);
                break;
        }

        spinnerModo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Integer posicao = spinnerModo.getSelectedItemPosition();
                String modo = (String) adapter.getItem(posicao);

                apiEstatisticas.getEstatisticas(modo);

                acertos.setText(apiEstatisticas.acertos);
                erros.setText(apiEstatisticas.erros);
                taxa.setText(apiEstatisticas.taxaDeAcerto);
                total.setText(apiEstatisticas.total);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    public void fechar(View V){
        finish();
    }
}