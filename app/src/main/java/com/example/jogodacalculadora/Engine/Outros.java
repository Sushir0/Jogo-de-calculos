package com.example.jogodacalculadora.Engine;

import java.util.ArrayList;
import java.util.List;

public class Outros {

    public static Integer getSomaDeArrayInteger(Integer Array[]){
        Integer Contador = 0;

        for(Integer item: Array){
            Contador+=item;
        }

        return Contador;
    }

    public static String getFraseDeErroDeArray(List<String> erros){
        String fraseDeErro = "";

        for(String erro: erros){
            fraseDeErro += erro+"; ";
        }

        return fraseDeErro;
    }

}
