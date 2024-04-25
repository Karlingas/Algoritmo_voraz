package org.example.Practica2;

import lombok.*;

public class Mercancia {
    @Setter
    @Getter
    public String nombre;
    @Setter
    @Getter
    public int peso;
    @Setter
    @Getter
    public boolean usado = false;

    public Mercancia(String nombre, int peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public Mercancia(int peso) {
        this.peso = peso;
    }

    public Mercancia(org.example.Practica1.Mercancia copia) {
        this.nombre = copia.getNombre();
        this.peso = copia.getPeso();
    }
}
