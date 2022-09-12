package com.example.jogodacalculadora.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jogodacalculadora.Database.Fragmentos.Database;
import com.example.jogodacalculadora.Database.Fragmentos.Login;
import com.example.jogodacalculadora.Database.Fragmentos.Modificadores;
import com.example.jogodacalculadora.Database.Fragmentos.Verificador;
import com.example.jogodacalculadora.Database.Player;
import com.example.jogodacalculadora.Engine.Outros;
import com.example.jogodacalculadora.R;

import java.util.ArrayList;
import java.util.List;

public class Cadastro_Activity extends AppCompatActivity {

    private EditText nome, email, senha;
    Editable Nome, Idade, Email, Senha;
    String StringNome = "nulo", StringEmail = "nulo", StringSenha = "nulo", erro = "";
    private Toast toast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);



    }


    public void cadastrar(View view){
        List<String> erros = new ArrayList<>();
        boolean erroDoFormulario = false;

        EditText EditTextNome = findViewById(R.id.editTextNome);
        EditText EditTextEmail = findViewById(R.id.editTextEmail);
        EditText EditTextSenha = findViewById(R.id.editTextSenha);

        String nome = null, email = null, senha = null;

        try {
            nome = String.valueOf(EditTextNome.getText());
            email = String.valueOf(EditTextEmail.getText());
            senha = String.valueOf(EditTextSenha.getText());

        }catch(Error error){
            erroDoFormulario = true;
            erros.add("Erro ao pegar os itens do formulário");
        }finally {
            if (nome!=null && email!=null && senha!=null){

                if(!erroDoFormulario){
                    erros = Login.cadastrar(nome, email, senha);
                }

                if(erros.isEmpty()){
                    toast.makeText(Cadastro_Activity.this, "Cadastrado com sucesso", Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    String fraseDeErro = Outros.getFraseDeErroDeArray(erros);
                    toast.makeText(Cadastro_Activity.this, fraseDeErro, Toast.LENGTH_LONG).show();
                }


            }
        }

    }




    public void fechar(View V){
        finish();
    }
}