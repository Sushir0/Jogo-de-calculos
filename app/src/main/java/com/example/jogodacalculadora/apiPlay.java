package com.example.jogodacalculadora;

import com.example.jogodacalculadora.Calculos.Divisao;
import com.example.jogodacalculadora.Calculos.Multiplicacao;
import com.example.jogodacalculadora.Calculos.Soma;
import com.example.jogodacalculadora.Calculos.Subtracao;
import com.example.jogodacalculadora.Conversoes.Binario;
import com.example.jogodacalculadora.Conversoes.Octal;
import com.example.jogodacalculadora.Engine.Engine;

public class apiPlay {
    public static String Equacao = "";
    public static String Erros = "", Acertos = "";
    public static String[] botoes = {"", "", "", ""};
    public static Integer respostaVerdadeira;
    public static Integer[] respostas = new Integer[4];


    public static void playStart(String modo){
        switch (modo){
            case "MULTIPLICAÇÃO":
                if(Multiplicacao.marcadorRefresh) {
                    Multiplicacao.start();
                }
                Multiplicacao.marcadorRefresh = false;

                respostaVerdadeira = Multiplicacao.respostaVerdadeira;
                respostas = Multiplicacao.respostas;

                if(Engine.negativo) {
                    Equacao = "  (" + Multiplicacao.variaveis[0] + ")\n X (" + Multiplicacao.variaveis[1]+")";
                }else{
                    Equacao = "  " + Multiplicacao.variaveis[0] + "\n X " + Multiplicacao.variaveis[1]+"";
                }
                Erros = "" + Multiplicacao.erros;
                Acertos = "" + Multiplicacao.acertos;
                botoes[0] = "" + Multiplicacao.respostas[0];
                botoes[1] = "" + Multiplicacao.respostas[1];
                botoes[2] = "" + Multiplicacao.respostas[2];
                botoes[3] = "" + Multiplicacao.respostas[3];

                break;
            case "SOMA":
                if(Soma.marcadorRefresh) {
                    Soma.start();
                }
                Soma.marcadorRefresh = false;

                respostaVerdadeira = Soma.respostaVerdadeira;
                respostas = Soma.respostas;

                if(Engine.negativo) {
                    Equacao = "  (" + Soma.variaveis[0] + ")\n + (" + Soma.variaveis[1]+")";
                }else{
                    Equacao = "  " + Soma.variaveis[0] + "\n + " + Soma.variaveis[1]+"";
                }
                Erros = "" + Soma.erros;
                Acertos = "" + Soma.acertos;
                botoes[0] = "" + Soma.respostas[0];
                botoes[1] = "" + Soma.respostas[1];
                botoes[2] = "" + Soma.respostas[2];
                botoes[3] = "" + Soma.respostas[3];
                
                break;
            case "SUBTRAÇÃO":
                if(Subtracao.marcadorRefresh) {
                    Subtracao.start();
                }
                Subtracao.marcadorRefresh = false;

                respostaVerdadeira = Subtracao.respostaVerdadeira;
                respostas = Subtracao.respostas;

                if(Engine.negativo) {
                    Equacao = "  (" + Subtracao.variaveis[0] + ")\n - (" + Subtracao.variaveis[1]+")";
                }else{
                    Equacao = "  " + Subtracao.variaveis[0] + "\n - " + Subtracao.variaveis[1]+"";
                }
                Erros = "" + Subtracao.erros;
                Acertos = "" + Subtracao.acertos;
                botoes[0] = "" + Subtracao.respostas[0];
                botoes[1] = "" + Subtracao.respostas[1];
                botoes[2] = "" + Subtracao.respostas[2];
                botoes[3] = "" + Subtracao.respostas[3];

                break;
            case "DIVISÃO":
                if(Divisao.marcadorRefresh) {
                    Divisao.start();
                }
                Divisao.marcadorRefresh = false;

                respostaVerdadeira = Divisao.variaveis[1];
                respostas = Divisao.respostas;

                if(Engine.negativo) {
                    Equacao = "  (" + Divisao.respostaVerdadeira + ") / (" + Divisao.variaveis[0]+")";
                }else{
                    Equacao = "  " + Divisao.respostaVerdadeira + " / " + Divisao.variaveis[0]+"";
                }
                Erros = "" + Divisao.erros;
                Acertos = "" + Divisao.acertos;
                botoes[0] = "" + Divisao.respostas[0];
                botoes[1] = "" + Divisao.respostas[1];
                botoes[2] = "" + Divisao.respostas[2];
                botoes[3] = "" + Divisao.respostas[3];

                break;
            case "BINÁRIO":
                if(Binario.marcadorRefresh) {
                    Binario.start();
                }
                Binario.marcadorRefresh = false;

                respostaVerdadeira = Binario.respostaVerdadeira_Decimal;
                respostas = Binario.respostas_Decimal;

                Equacao = "  " + Binario.variavel +"";
                Erros = "" + Binario.erros;
                Acertos = "" + Binario.acertos;
                botoes[0] = "" + Binario.respostas[0];
                botoes[1] = "" + Binario.respostas[1];
                botoes[2] = "" + Binario.respostas[2];
                botoes[3] = "" + Binario.respostas[3];

                break;
            case "OCTAL":
                if(Octal.marcadorRefresh) {
                    Octal.start();
                }
                Octal.marcadorRefresh = false;

                respostaVerdadeira = Octal.respostaVerdadeira_Decimal;
                respostas = Octal.respostas_Decimal;

                Equacao = "  " + Octal.variavel +"";
                Erros = "" + Octal.erros;
                Acertos = "" + Octal.acertos;
                botoes[0] = "" + Octal.respostas[0];
                botoes[1] = "" + Octal.respostas[1];
                botoes[2] = "" + Octal.respostas[2];
                botoes[3] = "" + Octal.respostas[3];

                break;
        }
    }


    public static boolean verificarAcerto(String modo, Integer BotaoPressionado, Integer botao1, Integer botao2, Integer botao3, Integer botao4){

        boolean respostaCerta = false;

        if(BotaoPressionado.equals(botao1)){
            if (respostas[0].equals(respostaVerdadeira)) {
                respostaCerta = setAcerto(modo);
            } else {
                respostaCerta = setErro(modo);
            }

        }else if(BotaoPressionado.equals(botao2)){
            if (respostas[1].equals(respostaVerdadeira)) {
                respostaCerta = setAcerto(modo);
            } else {
                respostaCerta = setErro(modo);
            }

        }else if(BotaoPressionado.equals(botao3)){
            if (respostas[2].equals(respostaVerdadeira)) {
                respostaCerta = setAcerto(modo);
            } else {
                respostaCerta = setErro(modo);
            }

        }else if(BotaoPressionado.equals(botao4)){
            if (respostas[3].equals(respostaVerdadeira)) {
                respostaCerta = setAcerto(modo);
            } else {
                respostaCerta = setErro(modo);
            }

        }

        return respostaCerta;
    }

    public static boolean setAcerto(String modo){
        switch (modo){
            case "MULTIPLICAÇÃO":
                Multiplicacao.acertos++;
                Multiplicacao.marcadorRefresh = true;
                break;
            case "SOMA":
                Soma.acertos++;
                Soma.marcadorRefresh = true;
                break;
            case "SUBTRAÇÃO":
                Subtracao.acertos++;
                Subtracao.marcadorRefresh = true;
                break;
            case "DIVISÃO":
                Divisao.acertos++;
                Divisao.marcadorRefresh = true;
                break;
            case "BINÁRIO":
                Binario.acertos++;
                Binario.marcadorRefresh = true;
                break;
            case "OCTAL":
                Octal.acertos++;
                Octal.marcadorRefresh = true;
                break;
        }
        return true;
    }

    public static boolean setErro(String modo){
        switch (modo){
            case "MULTIPLICAÇÃO":
                Multiplicacao.erros++;
                Multiplicacao.marcadorRefresh = true;
                break;
            case "SOMA":
                Soma.erros++;
                Soma.marcadorRefresh = true;
                break;
            case "SUBTRAÇÃO":
                Subtracao.erros++;
                Subtracao.marcadorRefresh = true;
                break;
            case "DIVISÃO":
                Divisao.erros++;
                Divisao.marcadorRefresh = true;
                break;
            case "BINÁRIO":
                Binario.erros++;
                Binario.marcadorRefresh = true;
                break;
            case "OCTAL":
                Octal.erros++;
                Octal.marcadorRefresh = true;
                break;
        }
        return false;
    }
}