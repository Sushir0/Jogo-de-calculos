package com.example.jogodacalculadora.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Engine {
    public static Integer QtdVariaveis_Calculos = 2;
    public static Integer QtdRespostas = 4;
    public static Integer valorMinimo = 0, valorMaximo = 10; // padrão 0 e 10
    public static boolean negativo = false; // números negativos ativo ou inativo
    public static boolean dark_mode = false; // modo escuro ativo ou inativo
    public static Integer variabilidade = 5; // entre 3 e 15
    public static boolean segundaVariavel_MenorQ10 = true;

    public static Integer getRandom() {

        Random random = new Random();
        int numero = random.nextInt(Engine.variabilidade);

        return numero;
    }

    public static Integer getRandom(Integer Variavel) {

        Random random = new Random();
        int numero = random.nextInt(Variavel);

        return numero;
    }

    public static Integer getRandom(Integer inicio, Integer fim) {
        // gera um número randomico com base nas variáveis começo e fim

        Integer[] dados = Organizador.organizarCrescente(inicio, fim);
        Integer diferenca = dados[1] - dados[0];
        Integer random = Engine.getRandom(diferenca + 1);

        for (int i = 0; i < diferenca + 1; i++) {
            if (i == random) {
                return i + dados[0];
            }
        }

        return null;
    }

    public static Integer[] GerarVariaveis() {

        Integer[] variaveis = new Integer[QtdVariaveis_Calculos];

        for (int i = 0; i < QtdVariaveis_Calculos; i++) {
            if(segundaVariavel_MenorQ10){
                if (i==0){
                    if (Engine.negativo) {
                        int probabilidadeNegativo = Engine.getRandom(2);

                        if (probabilidadeNegativo == 0) {
                            variaveis[i] = Engine.getRandom(Engine.valorMinimo, Engine.valorMaximo);

                        } else {
                            variaveis[i] = Engine.getRandom(Engine.valorMinimo, Engine.valorMaximo) * -1;

                        }
                    } else {
                        variaveis[i] = Engine.getRandom(Engine.valorMinimo, Engine.valorMaximo);

                    }
                }else{


                    if (Engine.negativo) {
                        int probabilidadeNegativo = Engine.getRandom(2);

                        if (probabilidadeNegativo == 0) {
                            variaveis[i] = Engine.getRandom(0, 10);

                        } else {
                            variaveis[i] = Engine.getRandom(0, 10) * -1;

                        }
                    } else {
                        variaveis[i] = Engine.getRandom(0, 10);

                    }
                }


            }else {

                if (Engine.negativo) {
                    int probabilidadeNegativo = Engine.getRandom(2);

                    if (probabilidadeNegativo == 0) {
                        variaveis[i] = Engine.getRandom(Engine.valorMinimo, Engine.valorMaximo);

                    } else {
                        variaveis[i] = Engine.getRandom(Engine.valorMinimo, Engine.valorMaximo) * -1;

                    }
                } else {
                    variaveis[i] = Engine.getRandom(Engine.valorMinimo, Engine.valorMaximo);

                }
            }
        }
        if (!segundaVariavel_MenorQ10) {
            variaveis = Organizador.organizarDecrescente(variaveis);
        }
        return variaveis;
    }

    public static boolean verificarRepeticao(Integer[] Array) {

        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (Array[i] == Array[j]) {

                    return true;
                }
            }
        }

        return false;
    }

    public static Integer getValorFalso(Integer valorReal) {
        //  gera uma resposta diferente da verdadeira

        Integer probabilidades = Engine.getRandom(100);
        Integer ValorFalso = null;
        if (probabilidades < 50) {
            ValorFalso = valorReal - Engine.getRandom(Engine.variabilidade) - 1;

        } else if (probabilidades == 1 && Engine.negativo) {
            if (valorReal == 0) {
                ValorFalso = valorReal - Engine.getRandom(Engine.variabilidade) - 1;

            } else {
                ValorFalso = valorReal + Engine.getRandom(Engine.variabilidade) * -1;

            }

        } else {
            ValorFalso = valorReal + Engine.getRandom(Engine.variabilidade) + 1;

        }
        return ValorFalso;
    }

    public static List<String> setEdicoes(Integer valorVariabilidade, Integer valorMinimo, Integer valorMaximo){
        List<String> erros = new ArrayList<>();

        boolean variabilidadeVerify = false, minimoVerify = false, maximoverify = false;

        if(ValidacaoDeFormulario.validarVariabilidade(valorVariabilidade)){
            variabilidadeVerify = true;
        }else{
            erros.add("Variabilidade inválida");
            variabilidadeVerify = false;
        }

        if(ValidacaoDeFormulario.validarValorMinimo_Maximo(valorMinimo)){
            minimoVerify = true;
        }else{
            erros.add("Valor minimo inválido");
            minimoVerify = false;
        }

        if(ValidacaoDeFormulario.validarValorMinimo_Maximo(valorMaximo)){
            maximoverify = true;
        }else{
            erros.add("Valor máximo inválido");
            maximoverify = false;
        }

        if(variabilidadeVerify && minimoVerify && maximoverify){
            variabilidade = valorVariabilidade;
            Engine.valorMinimo = valorMinimo;
            Engine.valorMaximo = valorMaximo;
        }

        return erros;
    }

    public static String setVariabilidade(Integer valorVariabilidade){
        String erro = null;
        if(ValidacaoDeFormulario.validarVariabilidade(valorVariabilidade)){
            variabilidade = valorVariabilidade;
        }else{
            erro = "A variabilidade tem que ser um valor entre 2 e 10.000";
        }

        return erro;
    }

    public static String setValorMinimo(Integer valorMinimo){
        String erro = null;
        if(ValidacaoDeFormulario.validarValorMinimo_Maximo(valorMinimo)){
            Engine.valorMinimo = valorMinimo;
        }else{
            erro = "O valor mínimo tem que ser um valor entre 0 e 10.000";
        }

        return erro;
    }

    public static String setValorMaximo(Integer valorMaximo){
        String erro = null;
        if(ValidacaoDeFormulario.validarValorMinimo_Maximo(valorMaximo)){
            Engine.valorMaximo = valorMaximo;
        }else{
            erro = "O valor máximo tem que ser um valor entre 0 e 10.000";
        }

        return erro;
    }



}



