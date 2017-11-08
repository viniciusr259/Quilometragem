package br.com.caminhoneiro.app;

import com.orm.SugarRecord;

/**
 * Created by 16254866 on 30/10/2017.
 */

public class Mes extends SugarRecord{
    String nome;

    //Construtores obriatorio pro causa ORM
    public Mes(){}

    public Mes(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
