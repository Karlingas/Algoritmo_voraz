package org.example.Practica2;
import lombok.*;
import org.example.Practica1.Mercancia;

public class Camion {
    @Setter @Getter
    public int capacidad; //capacidad en kilos
    public Mercancia[] mercancias;

    public Camion(){
        this.capacidad=15000;
    }
    public Camion(int capacidad){
        this.capacidad=capacidad;
    }

}