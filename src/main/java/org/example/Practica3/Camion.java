package org.example.Practica3;

import lombok.Getter;
import lombok.Setter;
import org.example.Practica1.Mercancia;

public class Camion {
    @Setter @Getter
    public int capacidad; //capacidad en kilos
    public Mercancia[] mercancias;

    public Camion(){
        this.capacidad=20000;
    }
    public Camion(int capacidad){
        this.capacidad=capacidad;
    }

}