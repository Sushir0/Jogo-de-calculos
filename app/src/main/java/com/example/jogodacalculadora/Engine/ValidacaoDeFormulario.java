package com.example.jogodacalculadora.Engine;

import com.example.jogodacalculadora.Database.Fragmentos.Database;
import com.example.jogodacalculadora.Database.Fragmentos.Verificador;

public class ValidacaoDeFormulario {

    public static boolean validarNome(String nome){
        if(nome != null && !nome.isEmpty()) {

            if (nome.length() > 3 && nome.length() < 250) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    public static boolean validarEmail(String email){
        if(email != null && !email.isEmpty()) {
            if (email.length() > 3 && email.length() < 100) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    public static boolean validarSenha(String senha){
        if(senha != null && !senha.isEmpty()) {
            if (senha.length() > 3 && senha.length() < 30) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    public static boolean PermissaoADM_Login(String email){
        if (Database.PlayerLogado.verificarEmail(email) || Verificador.verificaADM()){
            return true;
        }else{
            return false;
        }
    }

    public static boolean validarVariabilidade(Integer variabilidade){
        if(variabilidade > 2 && variabilidade < 10000){
            return true;
        }else{
            return false;
        }
    }

    public static boolean validarValorMinimo_Maximo(Integer valor){
        if(valor >= 0 && valor < 10000){
            return true;
        }else{
            return false;
        }
    }
}
