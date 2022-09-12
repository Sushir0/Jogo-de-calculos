package com.example.jogodacalculadora.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jogodacalculadora.Database.Fragmentos.Database;
import com.example.jogodacalculadora.Database.Fragmentos.Login;
import com.example.jogodacalculadora.R;

public class LoginActivity extends AppCompatActivity {

    EditText Email, Senha;
    private Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(Database.PlayerLogado != null){
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Database.PlayerLogado != null){
            finish();
        }
    }

    public void fazerLogin(View View){
        Email = findViewById(R.id.editTextEmail);
        Senha = findViewById(R.id.editTextSenha);
        try {
            Editable eEmail = Email.getText(), eSenha = Senha.getText();
            String email = String.valueOf(eEmail), senha = String.valueOf(eSenha);
            boolean LoginVerificado = Login.logar(email, senha);

            if(LoginVerificado){
                toast.makeText(LoginActivity.this, "login bem sucedido", Toast.LENGTH_LONG).show();
                finish();
            }else{
                toast.makeText(LoginActivity.this, "email ou senha incorretos", Toast.LENGTH_LONG).show();
            }
        }catch (Error Error){
            toast.makeText(LoginActivity.this, "email ou senha incorretos", Toast.LENGTH_LONG).show();
        }

    }


    public void openCadastro(View View){
        Intent i = new Intent(this, Cadastro_Activity.class);
        startActivity(i);
    }

    public void fechar(View V){
        finish();

    }
}