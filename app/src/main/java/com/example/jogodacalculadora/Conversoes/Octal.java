package com.example.jogodacalculadora.Conversoes;

import com.example.jogodacalculadora.Engine.Conversor;
import com.example.jogodacalculadora.Engine.Engine;
import com.example.jogodacalculadora.Engine.GetRespostas;

public class Octal {

    public static String[] respostas = new String[Engine.QtdRespostas];
    public static Integer[] respostas_Decimal = new Integer[Engine.QtdRespostas];
    public static String variavel;
    public static Integer respostaVerdadeira_Decimal;
    public static Integer probabilidadeTipoDeConversao = 0;//Tipos de conversão:octal p/ decimal ou decimal p/ octal
    public static Integer erros = 0, acertos = 0;
    public static Boolean marcadorRefresh = true;

    public static void getRespostas() {


        Integer respostasInteger[];
        String respostasString[];
        if (probabilidadeTipoDeConversao == 0) {
            respostasInteger = GetRespostas.getRespostasUnicas(respostaVerdadeira_Decimal);
            respostasString = Conversor.arrayInteger_String(respostasInteger);

            respostas = Octal.colocarRespostaVerdadeiraNasRespostas(respostasString);
            respostas_Decimal = Conversor.arrayString_Integer(respostas);
        } else {
            respostas_Decimal = GetRespostas.getRespostasUnicas(respostaVerdadeira_Decimal);
            respostas = Octal.colocarRespostaVerdadeiraNasRespostas(Conversor.ArrayDecimal_Octal(respostas_Decimal));

        }
    }

    public static String[] colocarRespostaVerdadeiraNasRespostas(String Respostas[]) {

        int probabilidade = Engine.getRandom(Engine.QtdRespostas);
        for (int i = 0; i < Engine.QtdRespostas; i++) {
            if (i == probabilidade) {
                if (probabilidadeTipoDeConversao == 0) {
                    Respostas[i] = String.valueOf(respostaVerdadeira_Decimal);

                } else {
                    Respostas[i] = Conversor.Decimal_Octal(respostaVerdadeira_Decimal);
                    respostas_Decimal[i] = respostaVerdadeira_Decimal;

                }

            }
        }

        return Respostas;
    }


    public static void getVariavel() {

        probabilidadeTipoDeConversao = Engine.getRandom(2);
        if (probabilidadeTipoDeConversao == 0) {
            respostaVerdadeira_Decimal = Engine.getRandom(Engine.valorMinimo, Engine.valorMaximo);
            variavel = Conversor.Decimal_Octal(respostaVerdadeira_Decimal);

        } else {
            respostaVerdadeira_Decimal = Engine.getRandom(Engine.valorMinimo, Engine.valorMaximo);
            variavel = String.valueOf(respostaVerdadeira_Decimal);
        }

    }




    public static void start() {
        Octal.getVariavel();
        Octal.getRespostas();
    }
}
