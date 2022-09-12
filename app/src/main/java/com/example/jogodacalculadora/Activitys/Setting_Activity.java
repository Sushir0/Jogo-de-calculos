package com.example.jogodacalculadora.Activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jogodacalculadora.Engine.Engine;
import com.example.jogodacalculadora.Engine.Outros;
import com.example.jogodacalculadora.R;

import java.util.ArrayList;
import java.util.List;

public class Setting_Activity extends AppCompatActivity {

    private Toast toast;
    private EditText editTextVariabilidade, editTextMinimo, editTextMaximo;
    private Switch switchNegativo, switchCalculoSimples;


    public void helpVariabilidade(View view){
        AlertDialog.Builder showHelpVariabilidade = new AlertDialog.Builder(this);
        View help = getLayoutInflater().inflate(R.layout.dialogo_customizado, null);

        TextView titulo = help.findViewById(R.id.textViewTitulo);
        TextView conteudo = help.findViewById(R.id.textViewConteudo);

        titulo.setText("Variabilidade");
        conteudo.setText("   A variabilidade define a distância das respostas falsas geradas em relação à verdadeira." +
                "\n   Por exemplo: se a equação for 10+10, e a variabilidade for 5, " +
                "as respostas geradas nos botões estarão entre 15 e 25.");

        showHelpVariabilidade.setView(help);

        showHelpVariabilidade.create().show();
    }

    public void helpValorMinimo(View view){
        AlertDialog.Builder showHelpValorMinimo = new AlertDialog.Builder(this);
        View help = getLayoutInflater().inflate(R.layout.dialogo_customizado, null);

        TextView titulo = help.findViewById(R.id.textViewTitulo);
        TextView conteudo = help.findViewById(R.id.textViewConteudo);

        titulo.setText("Primeiro número base");
        conteudo.setText("   É o valor mínimo que o aplicativo usará para gerar as equações.\n   Por exemplo: " +
                "se o primeiro número base for 0, e o segundo número base for 10, as variáveis da equação que " +
                "aparecerão sempre serão entre 0 e 10.");

        showHelpValorMinimo.setView(help);
        showHelpValorMinimo.create().show();
    }

    public void helpValorMaximo(View view){
        AlertDialog.Builder showHelpValorMaximo = new AlertDialog.Builder(this);
        View help = getLayoutInflater().inflate(R.layout.dialogo_customizado, null);

        TextView titulo = help.findViewById(R.id.textViewTitulo);
        TextView conteudo = help.findViewById(R.id.textViewConteudo);

        titulo.setText("Segundo número base");
        conteudo.setText("   É o valor máximo que o aplicativo usará para gerar as equações.\n   Por exemplo: " +
                "se o primeiro número base for 0, e o segundo número base for 10, as variáveis da equação que " +
                "aparecerão sempre serão entre 0 e 10.");

        showHelpValorMaximo.setView(help);
        showHelpValorMaximo.create().show();
    }

    public void helpValoresNegativos(View view){
        AlertDialog.Builder showHelpValoresNegativos = new AlertDialog.Builder(this);
        View help = getLayoutInflater().inflate(R.layout.dialogo_customizado, null);

        TextView titulo = help.findViewById(R.id.textViewTitulo);
        TextView conteudo = help.findViewById(R.id.textViewConteudo);

        titulo.setText("Valores negativos");
        conteudo.setText("   Quando os valores negativos estiverem ativados, haverão cálculos com valores positivos e negativos." +
                "\n   Por exemplo: Com o valor negativo ativado irão aparecer questões como: -5+2. ");

        showHelpValoresNegativos.setView(help);
        showHelpValoresNegativos.create().show();
    }

    public void helpCalculosSimples(View view){
        AlertDialog.Builder showHelpCalculosSimples = new AlertDialog.Builder(this);
        View help = getLayoutInflater().inflate(R.layout.dialogo_customizado, null);

        TextView titulo = help.findViewById(R.id.textViewTitulo);
        TextView conteudo = help.findViewById(R.id.textViewConteudo);

        titulo.setText("Calculos Simples");
        conteudo.setText("   Quando estiver ativo, os cálculos sempre terão o segundo número da equação menor que 10.\n   Por exemplo: " +
                "Com Calculos Simples ativados, com valores base altos, a equação ficará mais simples como: 150*5; 90+7; 300*2 etc.");

        showHelpCalculosSimples.setView(help);
        showHelpCalculosSimples.create().show();
    }

    public void aplicarVariabilidade(View View) {
        boolean erroDoFormulario = false;

        editTextVariabilidade = (EditText) findViewById(R.id.editVaria);
        Integer variabilidade = null;
        String erro = null;

        try {
            variabilidade = Integer.valueOf(String.valueOf(editTextVariabilidade.getText()));

        } catch (Error error) {
            erroDoFormulario = true;
            erro = ("Erro ao pegar o item do formulário");
        } finally {
            if (variabilidade != null) {

                if (!erroDoFormulario) {
                    erro = Engine.setVariabilidade(variabilidade);
                }

                if (erro == null) {
                    toast.makeText(Setting_Activity.this, "mudado com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    toast.makeText(Setting_Activity.this, erro, Toast.LENGTH_LONG).show();
                }

            }
        }
    }

    public void aplicarValorMinimo(View View) {
        boolean erroDoFormulario = false;

        editTextMinimo = (EditText) findViewById(R.id.editMinimo);
        Integer valorMinimo = null;
        String erro = null;

        try {
            valorMinimo = Integer.valueOf(String.valueOf(editTextMinimo.getText()));

        } catch (Error error) {
            erroDoFormulario = true;
            erro = ("Erro ao pegar o item do formulário");
        } finally {
            if (valorMinimo != null) {

                if (!erroDoFormulario) {
                    erro = Engine.setValorMinimo(valorMinimo);
                }

                if (erro == null) {
                    toast.makeText(Setting_Activity.this, "mudado com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    toast.makeText(Setting_Activity.this, erro, Toast.LENGTH_LONG).show();
                }

            }
        }
    }

    public void aplicarValorMaximo(View View) {
        boolean erroDoFormulario = false;

        editTextMaximo = (EditText) findViewById(R.id.editMaximo);
        Integer valorMaximo = null;
        String erro = null;

        try {
            valorMaximo = Integer.valueOf(String.valueOf(editTextMaximo.getText()));

        } catch (Error error) {
            erroDoFormulario = true;
            erro = ("Erro ao pegar o item do formulário");
        } finally {
            if (valorMaximo != null) {

                if (!erroDoFormulario) {
                    erro = Engine.setValorMaximo(valorMaximo);
                }

                if (erro == null) {
                    toast.makeText(Setting_Activity.this, "mudado com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    toast.makeText(Setting_Activity.this, erro, Toast.LENGTH_LONG).show();
                }

            }
        }
    }





    public void Salvar(View View) {

        List<String> erros = new ArrayList<>();
        boolean erroDoFormulario = false;

        editTextVariabilidade = (EditText) findViewById(R.id.editVaria);
        editTextMinimo = (EditText) findViewById(R.id.editMinimo);
        editTextMaximo = (EditText) findViewById(R.id.editMaximo);

        Integer variabilidade = null, valorMinimo = null, valorMaximo = null;

        try {
            variabilidade = Integer.valueOf(String.valueOf(editTextVariabilidade.getText()));
            valorMinimo = Integer.valueOf(String.valueOf(editTextMinimo.getText()));
            valorMaximo = Integer.valueOf(String.valueOf(editTextMaximo.getText()));

        } catch (Error error) {
            erroDoFormulario = true;
            erros.add("Erro ao pegar os itens do formulário");
        } finally {
            if (variabilidade != null && valorMinimo != null && valorMaximo != null) {

                if (!erroDoFormulario) {
                    erros = Engine.setEdicoes(variabilidade, valorMinimo, valorMaximo);
                }

                if (erros.isEmpty()) {
                    toast.makeText(Setting_Activity.this, "mudado com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    String fraseDeErro = Outros.getFraseDeErroDeArray(erros);
                    toast.makeText(Setting_Activity.this, fraseDeErro, Toast.LENGTH_LONG).show();
                }


            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        editTextVariabilidade = (EditText) findViewById(R.id.editVaria);
        editTextMinimo = (EditText) findViewById(R.id.editMinimo);
        editTextMaximo = (EditText) findViewById(R.id.editMaximo);

        editTextVariabilidade.setText(Engine.variabilidade+"");
        editTextMinimo.setText(Engine.valorMinimo+"");
        editTextMaximo.setText(Engine.valorMaximo+"");


        switchNegativo = findViewById(R.id.switchNegativos);
        switchNegativo.setChecked(Engine.negativo);


        switchNegativo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean switchNegativo) {
                if(switchNegativo){
                    Engine.negativo = true;

                }else{
                    Engine.negativo = false;

                }
            }
        });

        switchCalculoSimples = findViewById(R.id.switchCalculoSimples);
        switchCalculoSimples.setChecked(Engine.segundaVariavel_MenorQ10);

        switchCalculoSimples.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean switchCalculoSimples) {
                if(switchCalculoSimples){
                    Engine.segundaVariavel_MenorQ10 = true;
                }else{
                    Engine.segundaVariavel_MenorQ10 = false;
                }
            }
        });



    }


    public void fechar(View V){
        finish();
    }
}