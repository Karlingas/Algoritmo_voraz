package org.example.Practica3;

import lombok.Getter;
import lombok.Setter;

public class Mercancia {
    @Setter
    @Getter
    public String nombre;
    @Setter
    @Getter
    public int peso, posibleCamion=0;

    public Mercancia(int peso) {
        this.peso = peso;
    }
    public Mercancia(String nombre, int peso) {
        this.peso=peso;
        this.nombre = nombre;
    }


    public Mercancia(org.example.Practica3.Mercancia copia) {
        this.nombre = copia.getNombre();
        this.peso = copia.getPeso();
        this.posibleCamion= copia.getPosibleCamion();
    }
}
