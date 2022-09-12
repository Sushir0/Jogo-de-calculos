package com.example.jogodacalculadora.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jogodacalculadora.Database.Fragmentos.Database;
import com.example.jogodacalculadora.Database.Fragmentos.Modificadores;
import com.example.jogodacalculadora.Database.Fragmentos.Receptores;
import com.example.jogodacalculadora.Database.Fragmentos.Verificador;
import com.example.jogodacalculadora.Database.Player;
import com.example.jogodacalculadora.Engine.Outros;
import com.example.jogodacalculadora.R;

import java.util.ArrayList;
import java.util.List;

public class MudaInformacoesActivity extends AppCompatActivity {

    Spinner spinnerOpcao;
    private ArrayAdapter<String> adapter;



    private EditText nome, email, senha;
    Player Opcao = null;
    private Toast toast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mudar_informacoes);



        spinnerOpcao = findViewById(R.id.spinnerOpcao);
        adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1);


        nome = findViewById(R.id.editTextNome);
        email = findViewById(R.id.editTextEmail);
        senha = findViewById(R.id.editTextSenha);


        if(Verificador.verificarLogado()){
            List<String> ListaDeEmails = Receptores.getListaUsuarios();

            if(ListaDeEmails.isEmpty()){

                nome.setText("Não há players no banco.");
                nome.setEnabled(false);
                email.setText("");
                email.setEnabled(false);
                senha.setText("");
                senha.setEnabled(false);
                Button botaoSalvar = findViewById(R.id.button15);
                botaoSalvar.setEnabled(false);
                Button botaoDelete = findViewById(R.id.button13);
                botaoDelete.setEnabled(false);


            }else {
                for (String email : ListaDeEmails) {
                    adapter.add(email);
                }
            }
        }else{
            finish();
        }

        //vincular adaptador no spinner
        spinnerOpcao.setAdapter(adapter);


            nome.setText(Database.PlayerLogado.getNome());
            email.setText(Database.PlayerLogado.getEmail());
            senha.setText(Database.PlayerLogado.getSenha());



        spinnerOpcao.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Integer posicao = spinnerOpcao.getSelectedItemPosition();
                String opcao = (String) adapter.getItem(posicao);


                Opcao = Receptores.getPlayer(opcao);

                nome.setText(Opcao.getNome());
                email.setText(Opcao.getEmail());
                senha.setText(Opcao.getSenha());


            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }));
    }



    public void editar(View view){
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
                Integer posicao = spinnerOpcao.getSelectedItemPosition();
                String emailQueSeraAtualizado = (String) adapter.getItem(posicao);

                if(!erroDoFormulario){
                    erros = Modificadores.mudarInformacoes(emailQueSeraAtualizado, nome, email, senha);
                }

                if(erros.isEmpty()){
                    toast.makeText(MudaInformacoesActivity.this, "mudado com sucesso", Toast.LENGTH_LONG).show();
                }else{
                    String fraseDeErro = Outros.getFraseDeErroDeArray(erros);
                    toast.makeText(MudaInformacoesActivity.this, fraseDeErro, Toast.LENGTH_LONG).show();
                }


            }
        }
    }



    public void deleteInfo(View View){
        Integer posicao = spinnerOpcao.getSelectedItemPosition();
        String emailQueSeraAtualizado = (String) adapter.getItem(posicao);

        Player ver = Modificadores.deletarPessoa(emailQueSeraAtualizado);

            toast.makeText(MudaInformacoesActivity.this, ver.getNome(), Toast.LENGTH_LONG).show();

        finish();

    }





    public void fechar(View V){
        finish();
    }
}