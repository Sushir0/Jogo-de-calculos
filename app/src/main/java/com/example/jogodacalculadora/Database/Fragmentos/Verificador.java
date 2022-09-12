package com.example.jogodacalculadora.Database.Fragmentos;

import com.example.jogodacalculadora.Database.Player;

public class Verificador {

    public static boolean verificarEmailNoBanco(String email){
        for (Player player : Database.listaPlayers) {
            if (player != null) {
                if (player.getEmail().equals(email)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean verificarLogado(){
        if(Database.PlayerLogado!=null){
            for(Player player : Database.listaPlayers){
                if(player.verificarEmail(Database.PlayerLogado.getEmail()) && player.verificarSenha(Database.PlayerLogado.getSenha())){
                    return true;
                }
            }
        }return false;
    }

    public static boolean verificaADM(){
        for(String admin : Database.listaAdmin){
            if (Database.PlayerLogado.verificarEmail(admin)){
                return true;
            }
        }
        return false;
    }

    public static boolean verificaADM(Player p){
        for(String admin : Database.listaAdmin){
            if (p.verificarEmail(admin)){
                return true;
            }
        }
        return false;
    }
}
