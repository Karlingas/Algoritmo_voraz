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
     public static double[][] tablaDecisones(Mercancia[] candidatos, Camion camion){
        double total= camion.getCapacidad();
        int columnas= camion.getCapacidad()+1;
        int filas=candidatos.length;
        double acum=0;
        double[][] tabla= new double[columnas][filas];
        double[][] vector=new double[columnas+1][2];
        int a =0;
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                if (((candidatos[j].getPeso()+acum)<=i) && (candidatos[j].usado==false)) {
                    tabla[i][j] = (candidatos[j].getPeso() + acum);
                    vector[a][1]=candidatos[j].getPeso();
                    vector[a][0]=j;
                    a++;
                    System.out.println("i: " + i + " a: "+a);
                    acum = acum + candidatos[j].getPeso();
                    candidatos[j].setUsado(true);
                }else {
                    for (int k = a; k >= 0; k--) {
                        if (candidatos[j].getPeso()+(acum-vector[k][1])>acum && (candidatos[j].getPeso()+(acum-vector[k][1])<=i) && (candidatos[j].usado)==false){
                            acum=acum-vector[k][1];
                            tabla[i][j]=candidatos[j].getPeso()+acum;
                            candidatos[(int)(vector[k][0])].setUsado(false);
                            vector[k][1]=candidatos[j].getPeso();
                            vector[k][0]=j;
                            System.out.println("i: "+ i +" Ahora a: "+a);
                            acum=acum+vector[k][1];
                            candidatos[j].setUsado(true);
                            break;
                        }
                    }
                }
                if(tabla[i][j]==0){
                     if (j==0 && i!=0){
                         tabla[i][j]=tabla[i-1][filas-1];
                     }else if(j==0 && i==0){
                         tabla[i][j]=0;
                     }else{
                         tabla[i][j]=tabla[i][j-1];
                     }
                }
            }
            total=total-tabla[i][filas-1];
        }

        //Esta parte es para ver si funciona
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                System.out.println(tabla[i][j]+"  ");
            }
            System.out.println("\n");
        }
        //hasta aqui

        return tabla;
    }
}
