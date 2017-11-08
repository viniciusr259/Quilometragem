package br.com.caminhoneiro.app;

import com.orm.SugarRecord;

/**
 * Created by 16254866 on 30/10/2017.
 */

public class Quilometragem extends SugarRecord{
    float km;
    String mes;

    //Construtores obriatorio pro causa ORM
    public Quilometragem(){}

    public Quilometragem(float km,String mes){
        this.km = km;
        this.mes = mes;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }


}
