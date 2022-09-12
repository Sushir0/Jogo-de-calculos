package com.example.jogodacalculadora.Database.Fragmentos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.jogodacalculadora.Database.Player;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public static ArrayList<Player> listaPlayers = new ArrayList<Player>();
    protected static ArrayList<String> listaAdmin = new ArrayList<String>();
    public static Player PlayerLogado;

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public static void cadastroBase(){
        Player adm1 = new Player("ciro roberto", "sushiro", "12345");
        PlayerLogado = adm1;

        Player jogador1 = new Player("astolfo", "astolfo", "123");
        Player adm2 = new Player("Juliana Nogueira", "juju", "12345");

        listaAdmin.add(adm1.getEmail());
        listaAdmin.add(adm2.getEmail());
        listaPlayers.add(adm1);
        listaPlayers.add(adm2);
        listaPlayers.add(jogador1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}