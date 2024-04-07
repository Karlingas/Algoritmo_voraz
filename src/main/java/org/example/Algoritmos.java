package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Algoritmos {

    public static Mercancia[] algorVoraz(Mercancia[] mercancias, Camion camion){
        try {
            int tamano = mercancias.length, capacidad = camion.getCapacidad(), i = 0, j = 0;
            Mercancia[] resultado = new Mercancia[tamano];
            boolean siguiente = true;

            Arrays.sort(mercancias, Comparator.comparingInt(Mercancia::getPeso)); //Complejidad linean indicada en la documentacion al utilizar mergeSort --> n log(n)

            while (siguiente){
                if (mercancias[i].getPeso() <= capacidad && mercancias[i].getPeso() > 0) {
                    resultado[j] = new Mercancia(mercancias[i]);
                    j++;
                    capacidad -= mercancias[i].getPeso();
                }

                if (i + 1 >= tamano || mercancias[i + 1].getPeso() > capacidad) {
                    siguiente = false;
                } else {
                    i++;
                }
            }

            return Arrays.copyOf(resultado,j);

        } catch (ArrayIndexOutOfBoundsException e) {

            return new Mercancia[0];
        }
    }


}
