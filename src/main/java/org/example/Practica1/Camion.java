package org.example.Practica1;


import lombok.*;

public class Camion {

    @Setter @Getter
    public int capacidad; //capacidad en kilos
    public Mercancia[] mercancias;

    public Camion(){
        this.capacidad=10000;
    }
    public Camion(int capacidad){
        this.capacidad=capacidad;
    }

}
