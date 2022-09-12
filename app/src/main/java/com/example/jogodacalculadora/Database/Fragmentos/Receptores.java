package com.example.jogodacalculadora.Database.Fragmentos;

import com.example.jogodacalculadora.Database.Player;

import java.util.ArrayList;
import java.util.List;

public class Receptores {
    public static List<String> getListaUsuarios(){
        List<String> listaUsuario = new ArrayList<>();
        if(Verificador.verificaADM()){
            for(Player pessoa : Database.listaPlayers){
                if(!Verificador.verificaADM(pessoa)) {
                    listaUsuario.add(pessoa.getEmail());
                }
            }
        }else{
            listaUsuario.add(Database.PlayerLogado.getEmail());
        }
        return listaUsuario;
    }

    public static Player getPlayer(String usuario){
        for(Player pessoa: Database.listaPlayers){
            if(pessoa.verificarEmail(usuario)){
                return pessoa;
            }
        }
        return null;
    }
}
