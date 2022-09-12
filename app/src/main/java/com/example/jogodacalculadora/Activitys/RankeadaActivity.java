package com.example.jogodacalculadora.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jogodacalculadora.Database.Fragmentos.Database;
import com.example.jogodacalculadora.Database.Fragmentos.Verificador;
import com.example.jogodacalculadora.R;
import com.example.jogodacalculadora.Ranked.apiRanked;

public class RankeadaActivity extends AppCompatActivity {


    TextView Equacao, Erros, Acertos, pontuacao;


    Button Botao1, Botao2, Botao3, Botao4;


    Toast toast;


    public void showAcerto(){
        toast.makeText(RankeadaActivity.this, "Acertou!", Toast.LENGTH_LONG).show();
    }
    public void showErro(){
        toast.makeText(RankeadaActivity.this, "Errou!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankeada);


        if(!Verificador.verificarLogado()){
            finish();
        }


        Equacao = findViewById(R.id.showX);
        Erros = findViewById(R.id.erradas);
        Acertos = findViewById(R.id.acertadas);
        pontuacao = findViewById(R.id.pontuacao);


        Botao1 = findViewById(R.id.button1);
        Botao2 = findViewById(R.id.button2);
        Botao3 = findViewById(R.id.button3);
        Botao4 = findViewById(R.id.button4);


        Erros.setText("" + Database.PlayerLogado.getErros());
        Acertos.setText("" + Database.PlayerLogado.getAcertos());
        pontuacao.setText(""+ Database.PlayerLogado.getPontuacao());


        //-----------------------------------------------------------------------\\


        apiRanked.saveConfig();
        apiRanked.apiRank();


        pontuacao.setText(apiRanked.Pontos);
        Equacao.setText(apiRanked.Equacao);
        Erros.setText(apiRanked.Erros);
        Acertos.setText(apiRanked.Acertos);
        Botao1.setText(apiRanked.botoes[0]);
        Botao2.setText(apiRanked.botoes[1]);
        Botao3.setText(apiRanked.botoes[2]);
        Botao4.setText(apiRanked.botoes[3]);
    }

    public void onClick(View V){
        // vincula todos os textos que serão utilizados

        Equacao = (TextView) findViewById(R.id.showX);
        Erros = (TextView) findViewById(R.id.erradas);
        Acertos = (TextView) findViewById(R.id.acertadas);
        pontuacao = findViewById(R.id.pontuacao);


        // vincula todos os botões que serão utilizados

        Botao1 = (Button) findViewById(R.id.button1);
        Botao2 = (Button) findViewById(R.id.button2);
        Botao3 = (Button) findViewById(R.id.button3);
        Botao4 = (Button) findViewById(R.id.button4);

        boolean verificarAcerto = apiRanked.verificarAcerto(V.getId(), R.id.button1, R.id.button2, R.id.button3, R.id.button4);
        if(verificarAcerto){
            showAcerto();
        }else{
            showErro();
        }

        apiRanked.apiRank();



        pontuacao.setText(apiRanked.Pontos);
        Equacao.setText(apiRanked.Equacao);
        Erros.setText(apiRanked.Erros);
        Acertos.setText(apiRanked.Acertos);
        Botao1.setText(apiRanked.botoes[0]);
        Botao2.setText(apiRanked.botoes[1]);
        Botao3.setText(apiRanked.botoes[2]);
        Botao4.setText(apiRanked.botoes[3]);


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        apiRanked.setConfigSalva();
    }

    public void abrirHistorico(View View){
        Intent i = new Intent(this, HistoricoActivity.class);
        startActivity(i);

    }

    public void fechar(View V){
        finish();
    }
}