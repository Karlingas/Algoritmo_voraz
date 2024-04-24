import org.example.Practica2.Algoritmo;
import org.example.Practica2.Camion;
import org.example.Practica2.Mercancia;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testDinamico {
    @Test
    public void noObjetos() {
        Camion camion = new Camion();

        ArrayList<Mercancia> input = new ArrayList<>();
        ArrayList<Mercancia> output = new ArrayList<>();

        Assert.assertEquals("El ArrayList debe ser vacío", output, Algoritmo.algoDinamico(input, camion));
    }

    @Test
    public void unaMercancia() {
        Camion camion = new Camion();

        ArrayList<Mercancia> input = new ArrayList<>();
        input.add(new Mercancia("Mercancia1", 5000));

        ArrayList<Mercancia> output = new ArrayList<>();
        output.add(new Mercancia("Mercancia1", 5000));

        Assert.assertEquals("Debería transportarse solo la mercancía de 5000 kg", output, Algoritmo.algoDinamico(input, camion));
    }

    @Test
    public void variasMercancias() {
        Camion camion = new Camion();

        ArrayList<Mercancia> input = new ArrayList<>();
        input.add(new Mercancia("Mercancia1", 5000));
        input.add(new Mercancia("Mercancia2", 8000));
        input.add(new Mercancia("Mercancia3", 10000));

        ArrayList<Mercancia> output = new ArrayList<>();
        output.add(new Mercancia("Mercancia3", 10000));

        Assert.assertEquals("Deberían transportarse las mercancía de 10000 kg", output, Algoritmo.algoDinamico(input, camion));
    }
}
