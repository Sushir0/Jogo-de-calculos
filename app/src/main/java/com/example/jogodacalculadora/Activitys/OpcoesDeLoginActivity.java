package com.example.jogodacalculadora.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jogodacalculadora.Database.Fragmentos.Database;
import com.example.jogodacalculadora.Database.Fragmentos.Login;
import com.example.jogodacalculadora.Database.Fragmentos.Verificador;
import com.example.jogodacalculadora.Database.Player;
import com.example.jogodacalculadora.R;

public class OpcoesDeLoginActivity extends AppCompatActivity {
    TextView texto;
    Button botao1, botao2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes_de_login);

        texto = findViewById(R.id.textView6);
        botao1 = findViewById(R.id.button5);
        botao2 = findViewById(R.id.button11);

        if(Verificador.verificarLogado()){
            if(Verificador.verificaADM()){
                texto.setText("ADM || Bem vindo "+ Player.getFirstName(Database.PlayerLogado));
                botao1.setText("Mudar informações");
                botao1.setOnClickListener(this::openInformacoes);
                botao2.setText("Deslogar");
                botao2.setOnClickListener(this::deslogar);
            }else {
                texto.setText("Seja bem vindo(a) " + Player.getFirstName(Database.PlayerLogado));
                botao1.setText("Mudar informações");
                botao1.setOnClickListener(this::openInformacoes);
                botao2.setText("Deslogar");
                botao2.setOnClickListener(this::deslogar);
            }
        }else{
            texto.setText("Você não está logado");
            botao1.setText("Login");
            botao1.setOnClickListener(this::openLogin);
            botao2.setText("cadastrar");
            botao2.setOnClickListener(this::openCadastro);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        texto = findViewById(R.id.textView6);
        botao1 = findViewById(R.id.button5);
        botao2 = findViewById(R.id.button11);

        if(Verificador.verificarLogado()){
            if(Verificador.verificaADM()){
                texto.setText("ADM || Bem vindo "+Player.getFirstName(Database.PlayerLogado));
                botao1.setText("Mudar informações");
                botao1.setOnClickListener(this::openInformacoes);
                botao2.setText("Deslogar");
                botao2.setOnClickListener(this::deslogar);
            }else {
                texto.setText("Seja bem vindo(a) " + Player.getFirstName(Database.PlayerLogado));
                botao1.setText("Mudar informações");
                botao1.setOnClickListener(this::openInformacoes);
                botao2.setText("Deslogar");
                botao2.setOnClickListener(this::deslogar);
            }
        }else{
            texto.setText("Você não está logado");
            botao1.setText("Login");
            botao1.setOnClickListener(this::openLogin);
            botao2.setText("cadastrar");
            botao2.setOnClickListener(this::openCadastro);
        }
    }

    public void deslogar(View View){
        Login.deslogar();
        Intent refresh = new Intent(this, OpcoesDeLoginActivity.class);
        startActivity(refresh);
        this.finish();
    }

    public void openLogin(View View){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    public void openInformacoes(View View){
        Intent i = new Intent(this, MudaInformacoesActivity.class);
        startActivity(i);
    }


    public void openCadastro(View View){
        Intent i = new Intent(this, Cadastro_Activity.class);
        startActivity(i);
    }

    public void fechar(View V){
        finish();
    }
}