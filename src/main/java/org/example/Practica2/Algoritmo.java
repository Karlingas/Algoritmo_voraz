package org.example.Practica2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Algoritmo {

    public static Mercancia[] algoDinamico(Mercancia[] candidatos, Camion camion){
        Camion camionDi = new Camion(camion.getCapacidad());
        Mercancia[][] tabla = tablaDecisones(candidatos);



        return new Mercancia[0];
    }

    //Como el valor por kg es estatico no hace galta que pasemos el valor, solo el peso
    public static Mercancia[][] tablaDecisones(Mercancia[] candidatos){



        return new Mercancia[0][0];
    }

}
