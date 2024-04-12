package org.example.Practica1;

import lombok.*;

public class Mercancia {

    @Setter @Getter
    public String nombre;
    @Setter @Getter
    public int peso;

    public Mercancia(String nombre, int peso){
        this.nombre=nombre;
        this.peso=peso;
    }

    public Mercancia(int peso){
        this.peso=peso;
    }

    public Mercancia(Mercancia copia){
        this.nombre= copia.getNombre();
        this.peso= copia.getPeso();
    }

}
