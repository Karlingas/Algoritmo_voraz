package org.example.Practica2;

import lombok.extern.java.Log;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Algoritmo {
    static final Logger logger = LogManager.getLogger(Algoritmo.class.getName());

    public static ArrayList<Mercancia> algoDinamico(ArrayList<Mercancia> candidatos, Camion camion){
        Camion camionDi = new Camion(camion.getCapacidad());
        ArrayList<Mercancia> resultado = new ArrayList<>();
        int[][] tabla = tablaDecisones(candidatos);
        try {
            //Esto no funciona todavia, esta a medio hacer
            int columnas = tabla.length, filas = tabla[1].length;
            boolean finish = false;
            while (finish){
                for (int recorreCol = columnas-1; recorreCol>=0; recorreCol-- ){

                }

            }


        } catch (Exception e){
            logger.error("error por alguna razon");
        }


        return resultado;
    }

    //Como el valor por kg es estatico no hace galta que pasemos el valor, solo el peso
    public static int[][] tablaDecisones(ArrayList<Mercancia> candidatos){



        return new int[0][0];
    }

}
