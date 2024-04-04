package org.example;


import lombok.*;

public class Camion {

    @Setter @Getter
    public int capacidad; //capacidad en kilos
    public Mercancia[] mercancias;

    public Camion(){
        this.capacidad=10000;
    }
    public Camion(int capa){
        this.capacidad=capa;
    }

}
