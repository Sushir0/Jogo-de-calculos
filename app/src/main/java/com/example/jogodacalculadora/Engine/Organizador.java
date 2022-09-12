package com.example.jogodacalculadora.Engine;

import java.util.Arrays;

public class Organizador {
    public static Integer[] organizarCrescente(Integer number1, Integer numeber2) {
        // organiza dois números em um array crescente

        Integer[] dados = {number1, numeber2};
        Arrays.sort(dados);

        return dados;
    }

    public static Integer[] organizarDecrescente(Integer[] Request) {
        // organiza números decimais de forma decressente

        Arrays.sort(Request);

        for (int i = 1; i < Request.length; i++) {
            for (int j = 0; j < i; j++) {

                if (Request[i] > Request[j]) {
                    int temp = Request[i];
                    Request[i] = Request[j];
                    Request[j] = temp;
                }
            }
        }

        return Request;
    }

}
