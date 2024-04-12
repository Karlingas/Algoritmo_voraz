package org.example.Practica2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){


        Mercancia[] mercancias = new Mercancia[10];


        ArrayList<Mercancia> mercanciasArray = new ArrayList<>();
        for (int i = 0; i<mercancias.length;i++){
            mercanciasArray.add(i,mercancias[i]);
        }
        Camion camion = new Camion();
        mercancias = Algoritmo.algoDinamico(mercanciasArray,camion);
    }
}
