package com.example.jogodacalculadora.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jogodacalculadora.apiPlay;
import com.example.jogodacalculadora.R;

public class PlayActivity extends AppCompatActivity {



    TextView Equacao, Erros, Acertos;

    Button Botao1, Botao2, Botao3, Botao4;


    Toast toast;


    public void showAcerto(){
        toast.makeText(PlayActivity.this, "Acertou!", Toast.LENGTH_LONG).show();
    }
    public void showErro(){
        toast.makeText(PlayActivity.this, "Errou!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        

        Intent i = getIntent();


        Equacao = (TextView) findViewById(R.id.showX);
        Erros = (TextView) findViewById(R.id.erradas);
        Acertos = (TextView) findViewById(R.id.acertadas);


        Botao1 = (Button) findViewById(R.id.button1);
        Botao2 = (Button) findViewById(R.id.button2);
        Botao3 = (Button) findViewById(R.id.button3);
        Botao4 = (Button) findViewById(R.id.button4);


        //-----------------------------------------------------------------------\\


        String modo = i.getStringExtra("modo");
        apiPlay.playStart(modo);

        Equacao.setText(apiPlay.Equacao);
        Erros.setText(apiPlay.Erros);
        Acertos.setText(apiPlay.Acertos);
        Botao1.setText(apiPlay.botoes[0]);
        Botao2.setText(apiPlay.botoes[1]);
        Botao3.setText(apiPlay.botoes[2]);
        Botao4.setText(apiPlay.botoes[3]);
    }

    public void onClick(View V){
        Intent i = getIntent();
        String modo = i.getStringExtra("modo");

        // vincula todos os textos que serão utilizados

        Equacao = (TextView) findViewById(R.id.showX);
        Erros = (TextView) findViewById(R.id.erradas);
        Acertos = (TextView) findViewById(R.id.acertadas);


        // vincula todos os botões que serão utilizados

        Botao1 = (Button) findViewById(R.id.button1);
        Botao2 = (Button) findViewById(R.id.button2);
        Botao3 = (Button) findViewById(R.id.button3);
        Botao4 = (Button) findViewById(R.id.button4);

        boolean verificarAcerto = apiPlay.verificarAcerto(modo, V.getId(), R.id.button1, R.id.button2, R.id.button3, R.id.button4); // usar o R.id.button

        if(verificarAcerto){
            showAcerto();
        }else{
            showErro();
        }

        apiPlay.playStart(modo);

        Equacao.setText(apiPlay.Equacao);
        Erros.setText(apiPlay.Erros);
        Acertos.setText(apiPlay.Acertos);
        Botao1.setText(apiPlay.botoes[0]);
        Botao2.setText(apiPlay.botoes[1]);
        Botao3.setText(apiPlay.botoes[2]);
        Botao4.setText(apiPlay.botoes[3]);


    }
    public void abrirInfo(View V){
        Intent i = getIntent();
        String modo = i.getStringExtra("modo");

        Intent intent = new Intent(this, EstatisticasActivity.class);
        intent.putExtra("modo", modo);
        startActivity(intent);
    }
    public void fechar(View V){
        finish();
    }
}