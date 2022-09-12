package com.example.jogodacalculadora.Calculos;

import com.example.jogodacalculadora.Engine.Engine;
import com.example.jogodacalculadora.Engine.GetRespostas;

public class Subtracao {
    public static Integer[] respostas = new Integer[Engine.QtdRespostas];
    public static Integer[] variaveis = new Integer[Engine.QtdVariaveis_Calculos];
    public static Integer respostaVerdadeira = null;
    public static Integer erros = 0, acertos = 0;
    public static Boolean marcadorRefresh = true;



    public static Integer[] getRespostas() {

        getRespostaVerdadeira();
        Integer respostasFalsas_semRepeticoes[] = GetRespostas.getRespostasUnicas(respostaVerdadeira);

        return GetRespostas.colocarRespostaVerdadeiraNasRespostas(respostasFalsas_semRepeticoes, respostaVerdadeira);
    }

    public static void getRespostaVerdadeira() {

        int x = 0;
        for (int i = 0; i < Engine.QtdVariaveis_Calculos; i++) {
            x = variaveis[i] - x;
        }
        if (x < 0) {
            x = x * -1;
        }

        respostaVerdadeira = x;
    }

    public static void start() {
        variaveis = Engine.GerarVariaveis();
        respostas = getRespostas();
    }
}
