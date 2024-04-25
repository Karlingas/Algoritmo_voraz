package org.example.Practica2;

import lombok.extern.java.Log;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Algoritmo {
    static final Logger logger = LogManager.getLogger(Algoritmo.class.getName());

    public static ArrayList<Mercancia> algoDinamico(Mercancia[] candidatos, Camion camion){
        ArrayList<Mercancia> resultado = new ArrayList<>();
        //Como lo hemos pensado, es mas facil a la hora de programar aprovechar el tener que hacer la tabla, indicar los candidatos que se cogen
        //para ello tenemos un atributo dentro de Mercancias que nos dice si ha sido usado en la tabla
        //sin embargo dejamos la tabla como muestra
        try {
            double[][] tabla = tablaDecisones(candidatos, camion);
            for (int i = 0; i < candidatos.length; i++) {
                if(candidatos[i].isUsado()){
                    resultado.add(candidatos[i]);
                }
            }
            return resultado;
        } catch (Exception e){
            logger.fatal("Error gracias a nuestro Clean-Code");
        }
        return resultado;
    }

    //Como el valor por kg es estatico no hace galta que pasemos el valor, solo el peso
     public static double[][] tablaDecisones(Mercancia[] candidatos, Camion camion){
        //declaramos variables
        int columnas= camion.getCapacidad()+1;
        int filas=candidatos.length;

        double acum=0; //contiene el valor de cada celda
        double[][] tabla = new double[columnas][filas];
        double[][] enJuego = new double[columnas+1][2]; //esto es una matriz que nos dice que candidatos estan siendo usados

        int posicion = -1; //inicializado a -1 para que actualicemos al usarlo, y nunca lo tengamos apuntando a una direccion vacia
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                if((candidatos[j].getPeso()>0)) {
                    if (((candidatos[j].getPeso() + acum) <= i) && (candidatos[j].isUsado() == false)) {
                        //entramos en el if si no esta usado y si su peso mas el acumulado es menor o igual al peso de la columna en la que estamos
                        tabla[i][j] = (candidatos[j].getPeso() + acum);
                        posicion++;
                        enJuego[posicion][1] = candidatos[j].getPeso();
                        enJuego[posicion][0] = j;
                        //acutializamos enJuego con el candidato que estamos usando

                        acum = acum + candidatos[j].getPeso();

                        candidatos[j].setUsado(true);
                    } else {
                        for (int k = posicion; k >= 0; k--) {
                            if (candidatos[j].getPeso() + (acum - enJuego[k][1]) > acum && (candidatos[j].getPeso() + (acum - enJuego[k][1]) <= i) && (candidatos[j].isUsado()) == false) {
                                //entramos en el if si no se pasa del peso de la columna y su peso junto a algun peso anterior cogido es mayor que el acumulado actual
                                //en el acumulado quitamos el peso del candidato que vamos a dejar de usar
                                acum = acum - enJuego[k][1];
                                //actualizamos la tabla
                                tabla[i][j] = candidatos[j].getPeso() + acum;
                                //seteamos a false el que dejamos de usar
                                candidatos[(int) (enJuego[k][0])].setUsado(false);
                                //modificamos enJuego para poner el nuevo candidato
                                enJuego[k][1] = candidatos[j].getPeso();
                                enJuego[k][0] = j;
                                acum = acum + enJuego[k][1];
                                candidatos[j].setUsado(true);

                            }
                        }
                    }

                }
                if (tabla[i][j] == 0) {
                    if (j == 0 && i != 0) {
                        tabla[i][j] = tabla[i - 1][filas - 1];
                    } else if (j == 0 && i == 0) {
                        tabla[i][j] = 0;
                    } else {
                        tabla[i][j] = tabla[i][j - 1];
                    }
                }
            }
        }

        return tabla;
    }
}
