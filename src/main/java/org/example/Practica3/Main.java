package org.example.Practica3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getLogger("Logger de Control");

        log.info("Bienvenido al sistema de Mudanzas BackTrack S.L.");

        Scanner input = new Scanner(System.in);
        ArrayList<Mercancia> mercancias = new ArrayList<>();

        log.info("Por favor, introduzca los pesos de los productos uno por uno.");
        log.info("Presione 'Enter' sin ingresar ningún número para finalizar.");

        int i = 1;
        while (true) {
            log.info("Introduzca el peso del producto " + i + " (o presione 'Enter' para finalizar):");
            String inputLine = input.nextLine().trim();
            if (inputLine.isEmpty()) {
                break;
            }
            try {
                int peso = Integer.parseInt(inputLine);
                mercancias.add(new Mercancia(peso));
                i++;
            } catch (NumberFormatException e) {
                log.info("Entrada no válida. Por favor, ingrese un número válido o presione 'Enter' para finalizar.");
            }
        }

        Camion[] camiones = new Camion[3];
        for (i = 0; i < 3; i++) {
            camiones[i] = new Camion(i + 1);
        }

        ArrayList<Mercancia> result = Algoritmo.algoBackTrack(mercancias, camiones);

        if (result.isEmpty()) {
            log.info("No se ha encontrado una solución para transportar las mercancías.");
        } else {
            log.info("Lista de mercancías a transportar:");
            for (Mercancia mercancia : result) {
                log.info("Peso: " + mercancia.getPeso() + "\t Posible camion: " + mercancia.getPosibleCamion());
            }
        }
    }
}
