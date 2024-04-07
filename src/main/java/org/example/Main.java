package org.example;

import java.awt.color.CMMException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bienvenido al sistema de Mudanzas Voraces S.L.");
        System.out.println("Porfavor, introduzca la cantidad de productos a transportar");

        Scanner input = new Scanner(System.in);
        Mercancia[] mercancias = new Mercancia[input.nextInt()];

        System.out.println("Ahora introduzca los objetos 1 a 1");

        for (int i = 0; i < mercancias.length; i++) {
            mercancias[i] = new Mercancia("Objeto "+(i+1),input.nextInt());
        }

        System.out.println("¿El tamaño del camion es el estandar (10 toneladas) o personalizado? Ss/Nn");

        String vacio = input.nextLine();

        String respues = input.nextLine().toLowerCase();


        Camion camion = null;

        switch (respues){
            case "n" :
                System.out.println("Introduce la capacidad del camion en kilos");
                camion = new Camion(input.nextInt());
                break;
            case "s" :
                camion = new Camion();
                break;
        }


        Mercancia[] mercanciasR = Algoritmos.algorVoraz(mercancias,camion);

        System.out.println("Nombre \t\t Peso");
        System.out.println("---------------------");
        int precio = 0;
        for (int i=0; i<mercanciasR.length;i++) {
                System.out.println(mercanciasR[i].getNombre()+"\t"+mercanciasR[i].getPeso());
                precio = precio +40;

        }

        System.out.println(precio+" Euros");


    }
}