package com.example.jogodacalculadora.Ranked;

import com.example.jogodacalculadora.Engine.Engine;

public class PontosRank {

    private static final Double TaxaDeDecaimentoPorParte = 0.5;
    private static final Double TaxaDeDecaimentoPorPontos = 0.021;

    private static final Integer CrescimentoMaximoPorPontuacao = 4000;
    private static final Double TaxaDeCrescimentoPorParte = 1.2;
    private static final Double TaxaDeCrescimentoPorPontos = 0.021;

    public static Integer perderPontuacao(Integer primeiraParteDaEquacao, Integer segundaParteDaEquacao, Integer pontuacaoAtual){
        Integer pontosFinais = PerderPontosPorPartesDaEquacao(primeiraParteDaEquacao);
        pontosFinais += PerderPontosPorPartesDaEquacao(segundaParteDaEquacao);
        pontosFinais += PerderPontosPorPontuacaoAtual(pontuacaoAtual);

        return pontosFinais;
    }

    public static Integer ganharPontuacao(Integer primeiraParteDaEquacao, Integer segundaParteDaEquacao, Integer pontuacaoAtual){
        Integer pontosFinais = GanharPontosPorPartesDaEquacao(primeiraParteDaEquacao);
        pontosFinais += GanharPontosPorPartesDaEquacao(segundaParteDaEquacao);
        pontosFinais += GanharPontosPorPontuacaoAtual(pontuacaoAtual);

        return pontosFinais;
    }

    public static Integer PerderPontosPorPartesDaEquacao(Integer parte){
        if(parte < 0){
            parte = parte * -1;
        }else if(parte == 0){
            parte = 1;
        }

        //Inverte um array imaginário e faz com que números mais altos tenham menor peso na multiplicação\\

        Integer resultadoInvertido = parte * -1;
        Integer resultadoInversor = resultadoInvertido+ (Engine.valorMaximo - Engine.valorMinimo)+1;

        Integer resultadoFinal = (int) Math.round(resultadoInversor* TaxaDeDecaimentoPorParte);

        return resultadoFinal;
    }

    public static Integer PerderPontosPorPontuacaoAtual(Integer PontosAtual){
        if(PontosAtual < 1){
            PontosAtual = 1;
        }
        Integer resultado = (int) Math.round(PontosAtual* TaxaDeDecaimentoPorPontos);

        return resultado;
    }

    public static Integer GanharPontosPorPartesDaEquacao(Integer parte){
        if(parte < 0){
            parte = parte * -1;
        }else if(parte == 0){
            parte = 1;
        }
        Integer resultado = (int) Math.round(parte* TaxaDeCrescimentoPorParte);

        return resultado;
    }

    public static Integer GanharPontosPorPontuacaoAtual(Integer PontosAtual){
        if(PontosAtual < 0){
            PontosAtual = PontosAtual * -1;
        }

        //Inverte um array imaginário e faz com que números mais altos tenham menor peso na multiplicação\\
        Integer resultadoInvertido = PontosAtual * -1;
        Integer PontosEmpurrados = resultadoInvertido + CrescimentoMaximoPorPontuacao;

        if(PontosEmpurrados < 0){
            return 0;
        }else{
            return (int) Math.round(PontosEmpurrados * TaxaDeCrescimentoPorPontos);
        }
    }



}
