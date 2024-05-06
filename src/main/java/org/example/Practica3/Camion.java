package org.example.Practica3;

import lombok.Getter;
import lombok.Setter;
import org.example.Practica1.Mercancia;

public class Camion {
    @Setter @Getter
    public int capacidad, ID; //capacidad en kilos
    public Mercancia[] mercancias;

    public Camion(){
        this.capacidad=20000;
    }
    public Camion(int ID){
        this.capacidad=20000;
        this.ID=ID;
    }
    public Camion(int capacidad, int ID){
        this.capacidad=capacidad;
        this.ID=ID;
    }

}