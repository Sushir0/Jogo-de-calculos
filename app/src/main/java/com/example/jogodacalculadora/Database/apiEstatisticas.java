package com.example.jogodacalculadora.Database;

import com.example.jogodacalculadora.Calculos.Divisao;
import com.example.jogodacalculadora.Calculos.Multiplicacao;
import com.example.jogodacalculadora.Calculos.Soma;
import com.example.jogodacalculadora.Calculos.Subtracao;
import com.example.jogodacalculadora.Conversoes.Binario;
import com.example.jogodacalculadora.Conversoes.Octal;

public class apiEstatisticas {
    public static String acertos, erros, taxaDeAcerto, total;
    public static Integer acertosInteger = 0, errosInteger = 0, totalInteger = 0;
    public static Double taxaDouble = 0.0;

    public static void getEstatisticas(String modo){
        switch(modo){
            case "MULTIPLICAÇÃO":
                acertosInteger = Multiplicacao.acertos;
                errosInteger = Multiplicacao.erros;
                totalInteger = acertosInteger+errosInteger;
                taxaDouble = Double.valueOf(acertosInteger*100/totalInteger);


                break;
            case "SOMA":
                acertosInteger = Soma.acertos;
                errosInteger = Soma.erros;
                totalInteger = acertosInteger+errosInteger;
                if(totalInteger == 0) {
                    taxaDouble = Double.valueOf(acertosInteger * 100 / 1);
                }else{
                    taxaDouble = Double.valueOf(acertosInteger * 100 / totalInteger);
                }

                break;
            case "SUBTRAÇÃO":
                acertosInteger = Subtracao.acertos;
                errosInteger = Subtracao.erros;
                totalInteger = acertosInteger+errosInteger;
                if(totalInteger == 0) {
                    taxaDouble = Double.valueOf(acertosInteger * 100 / 1);
                }else{
                    taxaDouble = Double.valueOf(acertosInteger * 100 / totalInteger);
                }

                break;
            case "DIVISÃO":
                acertosInteger = Divisao.acertos;
                errosInteger = Divisao.erros;
                totalInteger = acertosInteger+errosInteger;
                if(totalInteger == 0) {
                    taxaDouble = Double.valueOf(acertosInteger * 100 / 1);
                }else{
                    taxaDouble = Double.valueOf(acertosInteger * 100 / totalInteger);
                }

                break;
            case "BINÁRIO":
                acertosInteger = Binario.acertos;
                errosInteger = Binario.erros;
                totalInteger = acertosInteger+errosInteger;
                if(totalInteger == 0) {
                    taxaDouble = Double.valueOf(acertosInteger * 100 / 1);
                }else{
                    taxaDouble = Double.valueOf(acertosInteger * 100 / totalInteger);
                }

                break;
            case "OCTAL":
                acertosInteger = Octal.acertos;
                errosInteger = Octal.erros;
                totalInteger = acertosInteger+errosInteger;
                if(totalInteger == 0) {
                    taxaDouble = Double.valueOf(acertosInteger * 100 / 1);
                }else{
                    taxaDouble = Double.valueOf(acertosInteger * 100 / totalInteger);
                }

                break;
        }
        acertos = String.valueOf(acertosInteger);
        erros = String.valueOf(errosInteger);
        total = String.valueOf(totalInteger);
        taxaDeAcerto = String.format("%.2f", taxaDouble);


    }


}
