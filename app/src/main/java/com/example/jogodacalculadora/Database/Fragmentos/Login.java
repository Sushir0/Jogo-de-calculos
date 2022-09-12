package com.example.jogodacalculadora.Database.Fragmentos;

import com.example.jogodacalculadora.Database.Player;
import com.example.jogodacalculadora.Engine.ValidacaoDeFormulario;

import java.util.ArrayList;
import java.util.List;

public class Login {
    public static void deslogar(){
        Database.PlayerLogado = null;
    }

    public static boolean logar(String email, String senha){
        for(Player pessoa: Database.listaPlayers){
            if(pessoa != null){
                if( pessoa.verificarEmail(email) && pessoa.verificarSenha(senha)){
                    Database.PlayerLogado = pessoa;
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> cadastrar(String nome, String email, String senha){
        List<String> erros = new ArrayList<>();

        boolean nomeVerify = false, emailVerify = false, senhaverify = false, emailNoBanco = false;

        if(ValidacaoDeFormulario.validarNome(nome)){
            nomeVerify = true;
        }else{
            erros.add("nome inválido");
            nomeVerify = false;
        }

        if(ValidacaoDeFormulario.validarEmail(email)){
            emailVerify = true;
        }else{
            erros.add("email inálido");
            emailVerify = false;
        }

        if(ValidacaoDeFormulario.validarSenha(senha)){
            senhaverify = true;
        }else{
            erros.add("senha inválida");
            senhaverify = false;
        }

        if(!Verificador.verificarEmailNoBanco(email)){
            emailNoBanco = true;
        }else{
            erros.add("email já utilizado");
            emailNoBanco = false;
        }

        if(nomeVerify && emailVerify && senhaverify && emailNoBanco) {
            Player novoPlayer = new Player(nome, email, senha);
            Database.listaPlayers.add(novoPlayer);
            Database.PlayerLogado = novoPlayer;

        }

        return erros;

    }
}
