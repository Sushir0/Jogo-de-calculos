package com.example.jogodacalculadora.Database;

import com.example.jogodacalculadora.Engine.ValidacaoDeFormulario;

import java.util.ArrayList;

public class Player extends ArrayList<Player> {
    private Integer id = 0;
    private String nome;
    private String email;
    private String senha;
    private Integer pontuacao = 0, acertos = 0, erros = 0;
    public ArrayList<Historico> history = new ArrayList<>();


    public Player(Integer id, String nome, String email, String senha, Integer pontuacao, Integer acertos, Integer erros){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.pontuacao = pontuacao;
        this.acertos = acertos;
        this.erros = erros;
    }

    public Player(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;


    }



    public void mudarNome_Email_Senha(String nome, String email, String senha){
            this.nome = nome;
            this.email = email;
            this.senha = senha;
    }

    public Integer getId(){
        return this.id;
    }

    public String getNome(){ return this.nome; }

    public String getEmail(){ return this.email;}

    public String getSenha(){
        if(ValidacaoDeFormulario.PermissaoADM_Login(this.email)){
            return this.senha;
        }else{
            return null;
        }
    }

    public Integer getPontuacao(){ return this.pontuacao;}

    public Integer getAcertos(){ return this.acertos;}

    public Integer getErros(){ return this.erros;}

    public void adicionarErro(){ this.erros++;}

    public void adicionarAcerto(){ this.acertos++;}

    public void adicionarPontuacao(Integer pontosRecebidos){ this.pontuacao+=pontosRecebidos;}

    public void diminuirPontuacao(Integer pontosReduzidos){ this.pontuacao-=pontosReduzidos;}

    public Boolean verificarSenha(String SenhaTentada){
        if (this.senha.equals(SenhaTentada)){
            return true;
        }else{
            return false;
        }
    }

    public Boolean verificarEmail(String emailTentado){
        if (this.email.equals(emailTentado)){
            return true;
        }else{
            return false;
        }
    }

    public static String getFirstName(Player p) {
        String[] nome = p.nome.split(" ");
        return nome[0];
    }


}
