package com.example.jogodacalculadora.Engine;

public class GetRespostas {

    public static Integer getRespostaFalsa(Integer RespostaVerdadeira) {

        Integer RespostaFalsa;
        if (Engine.negativo) {
            int RandomNegativo = Engine.getRandom(2);

            if (RandomNegativo == 0) {
                RespostaFalsa = Engine.getValorFalso(RespostaVerdadeira) * -1;
            } else {
                RespostaFalsa = Engine.getValorFalso(RespostaVerdadeira);
            }

        } else {
            do {
                RespostaFalsa = Engine.getValorFalso(RespostaVerdadeira);

            } while (RespostaFalsa < 0);
        }

        return RespostaFalsa;
    }

    public static Integer[] getRespostasFalsasRepetidas(Integer respostaVerdadeira) {

        Integer[] RespostasFalsas = new Integer[Engine.QtdRespostas];
        for (int i = 0; i < Engine.QtdRespostas; i++) {
            RespostasFalsas[i] = GetRespostas.getRespostaFalsa(respostaVerdadeira);

        }

        return RespostasFalsas;
    }

    public static Integer[] getRespostasUnicas(Integer RespostaVerdadeira) {
        Integer[] Respostas = GetRespostas.getRespostasFalsasRepetidas(RespostaVerdadeira);

        do {
            for (int i = 0; i < Engine.QtdRespostas; i++) {
                for (int j = 0; j < i; j++) {
                    if (Respostas[i] == Respostas[j]) {
                        Respostas[i] = GetRespostas.getRespostaFalsa(RespostaVerdadeira);
                    }
                }
            }
        } while (Engine.verificarRepeticao(Respostas));

        return Respostas;
    }

    public static Integer[] colocarRespostaVerdadeiraNasRespostas(Integer[] respostas, Integer respostaVerdadeira) {
        int x = Engine.getRandom(Engine.QtdRespostas);
        for (int i = 0; i < Engine.QtdRespostas; i++) {
            if (x == i) {
                respostas[i] = respostaVerdadeira;
            }
        }
        return respostas;
    }
}
