package com.example.jogodacalculadora.Database;

public class Historico {
    public Integer codigoPlayer;
    public Integer Codigo;
    public String equacao;
    public boolean acertou_Errou;
    public Integer respostaUtilizada, respostaCorreta;




    public Integer getCodigo(){
        return this.Codigo;
    }

    public Historico(String equacao, boolean acertou_Errou, Integer respostaUtilizada, Integer respostaCorreta, Integer codePlayer){
        this.codigoPlayer = codePlayer;
        this.equacao = equacao;
        this.acertou_Errou = acertou_Errou;
        this.respostaUtilizada = respostaUtilizada;
        this.respostaCorreta = respostaCorreta;

    }


}
