package com.example.jogodacalculadora.Ranked;

import com.example.jogodacalculadora.Calculos.Multiplicacao;
import com.example.jogodacalculadora.Calculos.Soma;
import com.example.jogodacalculadora.Calculos.Subtracao;
import com.example.jogodacalculadora.Database.Fragmentos.Database;
import com.example.jogodacalculadora.Database.Historico;
import com.example.jogodacalculadora.Engine.Engine;
import com.example.jogodacalculadora.Engine.Outros;

public class apiRanked {
    public static String Equacao = null;
    public static String Erros = null, Acertos = null, Pontos = null;
    public static String[] botoes = {null, null, null, null};
    public static Integer respostaVerdadeira;
    public static Integer[] respostas = new Integer[4];
    public static Integer[] variaveis = new Integer[2];

    public static Integer saveInicio = 0, saveFim = 10, saveVariabilidade = 10;
    public static boolean saveNegativo = false, saveSegundaVariavel_menorQ10 = false;

    public static final String[] EscolhasModosDeCalculos = {"MULTIPLICAÇÃO", "SOMA", "SUBTRAÇÃO"};
    public static final Integer[] ProbabilidadeDeCalculos = {33, 33, 33};

    public static final String[] EscolhasModosDeJogo = {"COMUM", "ESPECIAL"};
    public static final Integer[] ProbabilidadeModosDeJogo = {99, 2};


    public static void apiRank(){
        String ModoDeJogo = getModosDeJogo();
        switch (ModoDeJogo){
            case "COMUM":
                gameComum();
                break;
            case "ESPECIAL":
                gameEspecial();
                break;
        }


    }

    public static void start(String modo){

        switch (modo){
            case "MULTIPLICAÇÃO":
                Multiplicacao.start();

                respostaVerdadeira = Multiplicacao.respostaVerdadeira;
                respostas = Multiplicacao.respostas;

                variaveis = Multiplicacao.variaveis;
                Equacao = "(" + Multiplicacao.variaveis[0] + ")\n X (" + Multiplicacao.variaveis[1]+")";
                Erros = "" + Database.PlayerLogado.getErros();
                Acertos = "" + Database.PlayerLogado.getAcertos();
                Pontos = "" + Database.PlayerLogado.getPontuacao();
                botoes[0] = "" + Multiplicacao.respostas[0];
                botoes[1] = "" + Multiplicacao.respostas[1];
                botoes[2] = "" + Multiplicacao.respostas[2];
                botoes[3] = "" + Multiplicacao.respostas[3];

                break;
            case "SOMA":
                Soma.start();

                respostaVerdadeira = Soma.respostaVerdadeira;
                respostas = Soma.respostas;

                variaveis = Soma.variaveis;
                Equacao = "(" + Soma.variaveis[0] + ")\n + (" + Soma.variaveis[1]+")";
                Erros = "" + Database.PlayerLogado.getErros();
                Acertos = "" + Database.PlayerLogado.getAcertos();
                Pontos = "" + Database.PlayerLogado.getPontuacao();
                botoes[0] = "" + Soma.respostas[0];
                botoes[1] = "" + Soma.respostas[1];
                botoes[2] = "" + Soma.respostas[2];
                botoes[3] = "" + Soma.respostas[3];

                break;
            case "SUBTRAÇÃO":
                Subtracao.start();

                respostaVerdadeira = Subtracao.respostaVerdadeira;
                respostas = Subtracao.respostas;

                variaveis = Subtracao.variaveis;
                Equacao = "(" + Subtracao.variaveis[0] + ")\n - (" + Subtracao.variaveis[1]+")";
                Erros = "" + Database.PlayerLogado.getErros();
                Acertos = "" + Database.PlayerLogado.getAcertos();
                Pontos = "" + Database.PlayerLogado.getPontuacao();
                botoes[0] = "" + Subtracao.respostas[0];
                botoes[1] = "" + Subtracao.respostas[1];
                botoes[2] = "" + Subtracao.respostas[2];
                botoes[3] = "" + Subtracao.respostas[3];

                break;
        }
    }

    public static void gameComum(){
        ComumRankedConfig();
        String modoDeCalculo = getModosDeCalculos();
        start(modoDeCalculo);
    }

    public static void gameEspecial(){
        EspecialConfig();
        String modoDeCalculo = getModosDeCalculos();
        start(modoDeCalculo);
    }

    public static boolean verificarAcerto(Integer BotaoPressionado, Integer botao1, Integer botao2, Integer botao3, Integer botao4){
        boolean respostaCerta = false;
        if(BotaoPressionado.equals(botao1)){
            if (respostas[0].equals(respostaVerdadeira)) {
                respostaCerta = setAcerto(0);
            } else {
                respostaCerta = setErro(0);
            }

        }else if(BotaoPressionado.equals(botao2)){
            if (respostas[1].equals(respostaVerdadeira)) {
                respostaCerta = setAcerto(1);
            } else {
                respostaCerta = setErro(1);
            }

        }else if(BotaoPressionado.equals(botao3)){
            if (respostas[2].equals(respostaVerdadeira)) {
                respostaCerta = setAcerto(2);
            } else {
                respostaCerta = setErro(2);
            }

        }else if(BotaoPressionado.equals(botao4)){
            if (respostas[3].equals(respostaVerdadeira)) {
                respostaCerta = setAcerto(3);
            } else {
                respostaCerta = setErro(3);
            }

        }
        return respostaCerta;
    }

    public static String getModosDeCalculos(){
        return CalcularProbabilidades(EscolhasModosDeCalculos, ProbabilidadeDeCalculos);
    }

    public static String getModosDeJogo(){
        return CalcularProbabilidades(EscolhasModosDeJogo, ProbabilidadeModosDeJogo);
    }

    public static String CalcularProbabilidades(String[] Escolhas, Integer[] Probabilidade){
        Integer ContadorProbabilistico = 0, contadorEscolhas = 0;
        Integer Escolha = Engine.getRandom(Outros.getSomaDeArrayInteger(Probabilidade));

        for(Integer probabilidade: Probabilidade){
            ContadorProbabilistico += probabilidade;
            if (Escolha<=ContadorProbabilistico){
                return Escolhas[contadorEscolhas];
            }
            contadorEscolhas++;
        }

        return null;
    }

    public static void EspecialConfig(){
        Engine.valorMinimo = 0;
        Engine.valorMaximo = 1000;
        Engine.variabilidade = 7;
        Engine.negativo = true;
        Engine.segundaVariavel_MenorQ10 = false;
    }

    public static void ComumRankedConfig(){
        Engine.valorMinimo = 0;
        Engine.valorMaximo = 12;
        Engine.variabilidade = 5;
        Engine.negativo = true;
        Engine.segundaVariavel_MenorQ10 = false;
    }

    public static void saveConfig(){
        saveInicio = Engine.valorMinimo;
        saveFim = Engine.valorMaximo;
        saveVariabilidade = Engine.variabilidade;
        saveNegativo = Engine.negativo;
        saveSegundaVariavel_menorQ10 = Engine.segundaVariavel_MenorQ10;
    }

    public static void setConfigSalva(){
        Engine.valorMinimo = saveInicio;
        Engine.valorMaximo = saveFim;
        Engine.variabilidade = saveVariabilidade;
        Engine.negativo = saveNegativo;
        Engine.segundaVariavel_MenorQ10 = saveSegundaVariavel_menorQ10;
    }

    public static boolean setAcerto(int botaoPressionado){
        Database.PlayerLogado.adicionarAcerto();
        Integer Pontuacao = PontosRank.ganharPontuacao(variaveis[0], variaveis[1], Database.PlayerLogado.getPontuacao());
        Database.PlayerLogado.adicionarPontuacao(Pontuacao);
        Historico history = new Historico(Equacao, true, respostas[botaoPressionado], respostaVerdadeira, Database.PlayerLogado.getId());
        Database.PlayerLogado.history.add(history);
        return true;
    }

    public static boolean setErro(int botaoRespondido){
        Database.PlayerLogado.adicionarErro();
        Integer Pontuacao = PontosRank.perderPontuacao(variaveis[0], variaveis[1], Database.PlayerLogado.getPontuacao());
        Database.PlayerLogado.diminuirPontuacao(Pontuacao);
        Historico history = new Historico(Equacao, false, respostas[botaoRespondido], respostaVerdadeira, Database.PlayerLogado.getId());
        Database.PlayerLogado.history.add(history);
        return false;
    }
}
