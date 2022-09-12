package com.example.jogodacalculadora.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.jogodacalculadora.Database.Fragmentos.Database;
import com.example.jogodacalculadora.Database.Fragmentos.Verificador;
import com.example.jogodacalculadora.Engine.Engine;
import com.example.jogodacalculadora.R;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerOperacao;
    private ArrayAdapter<String> adapter;


    private TextView Nome, Erros, Acertos, Pontuacao, Partidas, Taxa;
    private Button Nivel;


    public void playGame(String str){
        Intent i = new Intent(this, PlayActivity.class);
        i.putExtra("modo", str);
        startActivity(i);
    }

    public void playRank(){
        Intent intent = new Intent(this, RankeadaActivity.class);
        startActivity(intent);
    }

    public void openSetting(View view) { // abre o xml das confingurações
        Intent intent = new Intent(this, ChoseSettingActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) { // não faz nada
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database.cadastroBase();
        Nome = findViewById(R.id.TextViewNome);
        Pontuacao = findViewById(R.id.TextViewPontuacao);
        Acertos = findViewById(R.id.TextViewAcertos);
        Erros = findViewById(R.id.TextViewErros);
        Partidas = findViewById(R.id.TextViewPartidas);
        Taxa = findViewById(R.id.TextViewTaxa);
        Nivel = findViewById(R.id.buttonNivel);




        if(!Verificador.verificarLogado()){
            Intent i = new Intent( this, LoginActivity.class);
            startActivity(i);
        }else{
            Double porcento = Double.valueOf(0);
            String Porcento;
            Double Total = Database.PlayerLogado.getErros()+ Database.PlayerLogado.getAcertos()+0.0;
            if(Total!=0){
                porcento = Database.PlayerLogado.getAcertos()*100/Total;
            }
            Porcento = String.format("%.2f", porcento);
            Nome.setText(""+ Database.PlayerLogado.getNome());
            Pontuacao.setText(""+ Database.PlayerLogado.getPontuacao());
            Acertos.setText(""+ Database.PlayerLogado.getAcertos());
            Erros.setText(""+ Database.PlayerLogado.getErros());
            Partidas.setText(""+(Database.PlayerLogado.getErros()+ Database.PlayerLogado.getAcertos()));
            Taxa.setText(Porcento+"%");
            Integer nivel = Database.PlayerLogado.getPontuacao()/400+1;
            Nivel.setText(""+nivel);
        }



        spinnerOperacao = findViewById(R.id.spinnerModo);
        adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1);

        //vincular adaptador no spinner
        spinnerOperacao.setAdapter(adapter);

        //adicionar o valor no spinner
        if(Verificador.verificarLogado()) {
            adapter.add("RANKEADA");
        }
        adapter.add("SOMA");
        adapter.add("SUBTRAÇÃO");
        adapter.add("MULTIPLICAÇÃO");
        adapter.add("DIVISÃO");
        adapter.add("BINÁRIO");
        adapter.add("OCTAL");


        double tamanhoInicial = 1, tamanhoFinal = 1.5;
        double crescimento = tamanhoFinal-tamanhoInicial, duracaoTotal = 2000;
        double velocidade = crescimento/duracaoTotal;
        double tempoDaAnimacao = Engine.getRandom(500, 2000);
        double tamanhoDaAnimacao = tamanhoInicial+(tempoDaAnimacao*velocidade);



        Nivel.animate().scaleX((float) tamanhoDaAnimacao).scaleY((float) tamanhoDaAnimacao).alpha(1f).setDuration((long) tempoDaAnimacao).withEndAction(new Runnable(){

            @Override
            public void run() {

                Nivel.animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration((long) tempoDaAnimacao);
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();
        if(Verificador.verificarLogado()) {
            adapter.add("RANKEADA");
        }
        adapter.add("SOMA");
        adapter.add("SUBTRAÇÃO");
        adapter.add("MULTIPLICAÇÃO");
        adapter.add("DIVISÃO");
        adapter.add("BINÁRIO");
        adapter.add("OCTAL");



        Nome = findViewById(R.id.TextViewNome);
        Pontuacao = findViewById(R.id.TextViewPontuacao);
        Acertos = findViewById(R.id.TextViewAcertos);
        Erros = findViewById(R.id.TextViewErros);
        Partidas = findViewById(R.id.TextViewPartidas);
        Taxa = findViewById(R.id.TextViewTaxa);
        Nivel = findViewById(R.id.buttonNivel);

        if(!Verificador.verificarLogado()){
            Nome.setText("Usuario não logado");
            Pontuacao.setText("0000");
            Acertos.setText("0000");
            Erros.setText("0000");
            Partidas.setText("0000");
            Taxa.setText("0000");
            Nivel.setText("0");
        }else{
            Double porcento = Double.valueOf(0);
            String Porcento;
            Double Total = Database.PlayerLogado.getErros()+ Database.PlayerLogado.getAcertos()+0.0;
            if(Total!=0){
                porcento = Database.PlayerLogado.getAcertos()*100/Total;
            }
            Porcento = String.format("%.2f", porcento);
            Nome.setText(""+ Database.PlayerLogado.getNome());
            Pontuacao.setText(""+ Database.PlayerLogado.getPontuacao());
            Acertos.setText(""+ Database.PlayerLogado.getAcertos());
            Erros.setText(""+ Database.PlayerLogado.getErros());
            Partidas.setText(""+(Database.PlayerLogado.getErros()+ Database.PlayerLogado.getAcertos()));
            Taxa.setText(Porcento+"%");
            Integer nivel = Database.PlayerLogado.getPontuacao()/400+1;
            Nivel.setText(""+nivel);
        }
    }

    public void play(View v){
        Integer posicao = spinnerOperacao.getSelectedItemPosition();
        String acao = (String) adapter.getItem(posicao);

        switch(acao){
            case "RANKEADA":
                playRank();
                break;
            case "MULTIPLICAÇÃO":
                playGame("MULTIPLICAÇÃO");
                break;
            case "SOMA":
                playGame("SOMA");
                break;
            case "SUBTRAÇÃO":
                playGame("SUBTRAÇÃO");
                break;
            case "DIVISÃO":
                playGame("DIVISÃO");
                break;
            case "BINÁRIO":
                playGame("BINÁRIO");
                break;
            case "OCTAL":
                playGame("OCTAL");
                break;
        }

    }

    public void fechar(View V){
        finish();
    }

    public void trocarTema(View V){
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

    }




}