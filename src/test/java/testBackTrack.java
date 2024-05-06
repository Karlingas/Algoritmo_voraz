import org.example.Practica3.Algoritmo;
import org.example.Practica3.Camion;
import org.example.Practica3.Mercancia;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class testBackTrack {
    @Test
    public void testNoObjetos(){
        Camion[] camiones = new Camion[3];
        int j=0;
        for (int i=1;i<4;i++){
            camiones[j] = new Camion(i);
            j++;
        }

        ArrayList<Mercancia> resultado = Algoritmo.algoBackTrack(new ArrayList<Mercancia>(),camiones);

        Assert.assertEquals("Tiene que dar un ArrayList Vacio", new ArrayList<Mercancia>(), resultado);
    }
    @Test
    public void testUnObjeto(){
        Camion[] camiones = new Camion[3];
        int j=0;
        for (int i=1;i<4;i++){
            camiones[j] = new Camion(i);
            j++;
        }

        ArrayList<Mercancia> mercancias = new ArrayList<Mercancia>();
        mercancias.add(new Mercancia(100));

        ArrayList<Mercancia> esperado = new ArrayList<Mercancia>();

        esperado.add(new Mercancia(100));

        ArrayList<Mercancia> resultado = Algoritmo.algoBackTrack(mercancias,camiones);

        while (!resultado.isEmpty()){
            Mercancia singleEsperado = esperado.remove(0), singleResultado = resultado.remove(0);
            Assert.assertEquals("Tiene que dar un ArrayList con la misma mecancia", singleEsperado.getPeso(), singleResultado.getPeso());
        }

    }
    @Test
    public void testVariosObjetos(){
        Camion[] camiones = new Camion[3];
        int j=0;
        for (int i=1;i<4;i++){
            camiones[j] = new Camion(i);
            j++;
        }

        ArrayList<Mercancia> mercancias = new ArrayList<Mercancia>();
        mercancias.add(new Mercancia(200));
        mercancias.add(new Mercancia(500));
        mercancias.add(new Mercancia(800));
        mercancias.add(new Mercancia(900));
        mercancias.add(new Mercancia(100));

        ArrayList<Mercancia> esperado = new ArrayList<Mercancia>(), resultado = Algoritmo.algoBackTrack(mercancias,camiones);

        esperado.add(new Mercancia(200));
        esperado.add(new Mercancia(500));
        esperado.add(new Mercancia(800));
        esperado.add(new Mercancia(900));
        esperado.add(new Mercancia(100));

        while (!resultado.isEmpty()){
            Mercancia singleEsperado = esperado.remove(0), singleResultado = resultado.remove(0);
            Assert.assertEquals("Tiene que dar un ArrayList con la misma mercancia", singleEsperado.getPeso(), singleResultado.getPeso());
        }
    }
    @Test
    public void testNulos(){
        Camion[] camiones = new Camion[3];
        int j=0;
        for (int i=1;i<4;i++){
            camiones[j] = new Camion(i);
            j++;
        }

        ArrayList<Mercancia> mercancias = new ArrayList<Mercancia>();
        mercancias.add(new Mercancia(1));
        mercancias.add(new Mercancia(5));
        mercancias.add(new Mercancia(8));
        mercancias.add(new Mercancia(9));
        mercancias.add(new Mercancia(0));

        ArrayList<Mercancia> esperado = new ArrayList<Mercancia>(), resultado = Algoritmo.algoBackTrack(mercancias,camiones);

        Assert.assertEquals("Tiene que dar un ArrayList con la misma mercancia", esperado, resultado);
    }
    @Test
    public void testNegativos(){
        Camion[] camiones = new Camion[3];
        int j=0;
        for (int i=1;i<4;i++){
            camiones[j] = new Camion(i);
            j++;
        }

        ArrayList<Mercancia> mercancias = new ArrayList<Mercancia>();
        mercancias.add(new Mercancia(1));
        mercancias.add(new Mercancia(5));
        mercancias.add(new Mercancia(8));
        mercancias.add(new Mercancia(9));
        mercancias.add(new Mercancia(-100));

        ArrayList<Mercancia> esperado = new ArrayList<Mercancia>(), resultado = Algoritmo.algoBackTrack(mercancias,camiones);

        Assert.assertEquals("Tiene que dar un ArrayList con la misma mercancia", esperado, resultado);

    }
    @Test
    public void testMasGrandeQueElPeso(){
        Camion[] camiones = new Camion[3];
        int j=0;
        for (int i=1;i<4;i++){
            camiones[j] = new Camion(i);
            j++;
        }

        ArrayList<Mercancia> mercancias = new ArrayList<Mercancia>();
        mercancias.add(new Mercancia(1));
        mercancias.add(new Mercancia(5));
        mercancias.add(new Mercancia(8));
        mercancias.add(new Mercancia(9));
        mercancias.add(new Mercancia(100000));

        ArrayList<Mercancia> esperado = new ArrayList<Mercancia>(), resultado = Algoritmo.algoBackTrack(mercancias,camiones);

        Assert.assertEquals("Tiene que dar un ArrayList con la misma mercancia", esperado, resultado);

    }

}
