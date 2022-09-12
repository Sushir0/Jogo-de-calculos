package com.example.jogodacalculadora.Calculos;

import com.example.jogodacalculadora.Engine.Engine;
import com.example.jogodacalculadora.Engine.GetRespostas;

public class Divisao {
    public static Integer[] respostas = new Integer[Engine.QtdRespostas];
    public static Integer[] variaveis = new Integer[Engine.QtdVariaveis_Calculos];
    public static Integer respostaVerdadeira = null;
    public static Integer erros = 0, acertos = 0;
    public static Boolean marcadorRefresh = true;




    public static void colocarRespostaVerdadeiraNasRespostas() {

        int x = Engine.getRandom(Engine.QtdRespostas);
        for (int i = 0; i < Engine.QtdRespostas; i++) {
            if (x == i) {
                respostas[i] = variaveis[1];
            }
        }
    }

    public static Integer[] getRespostas() {

        getRespostaVerdadeira();

        Integer[] respostasFalsas_semRepeticoes = GetRespostas.getRespostasUnicas(variaveis[1]);
        return respostasFalsas_semRepeticoes;
    }

    public static void getRespostaVerdadeira() {

        int x = 1;
        for (Integer variavel : variaveis) {
            x = variavel * x;
        }

        respostaVerdadeira = x;
    }


    public static void start() {
        variaveis = Engine.GerarVariaveis();
        respostas = getRespostas();
        colocarRespostaVerdadeiraNasRespostas();
    }

}
