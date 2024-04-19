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

        //System.out.println("Ahora introduzca los objetos 1 a 1");
        log.info("Ahora introduzca los objetos 1 a 1");
        Mercancia[] mercancias = new Mercancia[10];
        for (int i = 0; i < mercancias.length; i++) {
            mercancias[i] = new Mercancia("Objeto "+(i+1),input.nextInt());
        }


        Camion camion = new Camion();
        mercancias = Algoritmo.algoDinamico(mercancias,camion);
    }
}
