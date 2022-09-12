package com.example.jogodacalculadora.Database.Fragmentos;

import com.example.jogodacalculadora.Database.Player;
import com.example.jogodacalculadora.Engine.ValidacaoDeFormulario;

import java.util.ArrayList;
import java.util.List;

public class Modificadores {

    public static Player deletarPessoa(String emailQueSeraExcluido){
        if(ValidacaoDeFormulario.PermissaoADM_Login(emailQueSeraExcluido)){
            int i = 0;
            for(Player pessoa: Database.listaPlayers){

                if(pessoa.verificarEmail(emailQueSeraExcluido)){
                 Database.listaPlayers.remove(i);
                 if (Database.PlayerLogado.verificarEmail(emailQueSeraExcluido)){
                     Login.deslogar();

                 }
                 return pessoa;
                }
                i++;
            }
        }
        return null;
    }

    public static List<String> mudarInformacoes(String EmailQueSeraAtualizado, String novoNome, String novoEmail, String novaSenha){
        List<String> erros = new ArrayList<>();

        boolean nomeVerify = false, emailVerify = false, senhaverify = false;

        if(ValidacaoDeFormulario.validarNome(novoNome)){
            nomeVerify = true;
        }else{
            erros.add("nome inválido");
            nomeVerify = false;
        }

        if(ValidacaoDeFormulario.validarEmail(novoEmail)){
            emailVerify = true;
        }else{
            erros.add("email inválido");
            emailVerify = false;
        }

        if(ValidacaoDeFormulario.validarSenha(novaSenha)){
            senhaverify = true;
        }else{
            erros.add("senha inválida");
            senhaverify = false;
        }

        for (Player pessoa : Database.listaPlayers){
            if (pessoa.verificarEmail(EmailQueSeraAtualizado)){

                //Campo de validação
                if(pessoa.verificarEmail(novoEmail) || !Verificador.verificarEmailNoBanco(novoEmail)){
                    if(nomeVerify && emailVerify && senhaverify) {
                        //Modificar item
                        pessoa.mudarNome_Email_Senha(novoNome, novoEmail, novaSenha);

                        //Campo de detecção de erros
                    }
                }else{
                    erros.add("email já está sendo utilizado");
                }
            }
        }

        return erros;
    }


}
