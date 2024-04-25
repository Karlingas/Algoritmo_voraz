package org.example.Practica2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args){
        Logger log = Logger.getLogger("Logger de Control");

        //System.out.println("Bienvenido al sistema de Mudanzas Dinamicas S.L.");
        log.info("Bienvenido al sistema de Mudanzas Dinamicas S.L.");

        //System.out.println("Porfavor, introduzca la cantidad de productos a transportar");
        log.info("Porfavor, introduzca la cantidad de productos a transportar");

        Scanner input = new Scanner(System.in);
        Mercancia[] mercancias = new Mercancia[input.nextInt()];

        //System.out.println("Ahora introduzca los objetos 1 a 1");
        log.info("Ahora introduzca los objetos 1 a 1");


        for (int i = 0; i < mercancias.length; i++) {
            mercancias[i] = new Mercancia("Objeto "+(i+1),input.nextInt());
        }

        ArrayList<Mercancia> result = new ArrayList<>();
        Camion camion = new Camion();
        result = Algoritmo.algoDinamico(mercancias,camion);

        int totalP = 0;
        while (!result.isEmpty()){
            log.info(result.get(0).getNombre()+"\t\t"+result.get(0).getPeso());
            totalP+= result.get(0).getPeso();
            result.remove(0);
        }

        log.info("Y el importe Total es = "+totalP*3+"€");
    }
}
