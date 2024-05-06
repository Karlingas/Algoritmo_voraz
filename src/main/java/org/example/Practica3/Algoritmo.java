
package org.example.Practica3;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Algoritmo {
    static final Logger logger = LogManager.getLogger(Algoritmo.class.getName());

    static final int CAPACIDAD_MAXIMA = 20000; //en kilos 20 toneladas que es el peso maximo de este problema por camion

    public static ArrayList<Mercancia> algoBackTrack(ArrayList<Mercancia> listaCandidatos, Camion[] camiones){
        //aunque recibamos por parametro el array de camiones, simplemente lo representamos como array
        //para no tener que pasar por parametro los tres camiones.

        if(listaCandidatos.isEmpty() || listaCandidatos.get(0).getPeso()>CAPACIDAD_MAXIMA){
            return new ArrayList<Mercancia>();
        }

        Mercancia candidato = listaCandidatos.remove(0);
        ArrayList<Mercancia> resultado = new ArrayList<Mercancia>();

        for (Camion camion : camiones){
            if (candidato.getPeso()>0 && candidato.getPeso()<= camion.getCapacidad()){
                //aqui estamos si el candidato cabe dentro del camion
                candidato.setPosibleCamion(camion.getID());
                camion.setCapacidad(camion.getCapacidad() - candidato.getPeso());

                //si la lista de candidatos que quedan esta vacia es porque era el ultimo
                if (listaCandidatos.isEmpty()){
                    resultado.add(0,candidato);
                    break;
                }

                ArrayList<Mercancia> siguiente = Algoritmo.algoBackTrack(listaCandidatos,camiones);

                //si devuelve la funcion vacio es porque el siguiente candidato no permite una solucion
                if (siguiente.isEmpty()){ return new ArrayList<Mercancia>(); }

                resultado.add(candidato);
                resultado.addAll(siguiente);
                break;
            }
        }



        return resultado;
    }
}
