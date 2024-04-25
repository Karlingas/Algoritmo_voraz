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

        Mercancia[] input = new Mercancia[0];
        ArrayList<Mercancia> resultadoEsperado = new ArrayList<>();

        Assert.assertEquals("El ArrayList debe ser vacío", resultadoEsperado, Algoritmo.algoDinamico(input, camion));
    }

    @Test
    public void unaMercancia() {
        Camion camion = new Camion();

        Mercancia[] input = new Mercancia[1];
        input[0] = new Mercancia("Mercancia1", 5000);

        ArrayList<Mercancia> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(new Mercancia("Mercancia1", 5000));

        ArrayList<Mercancia> resultado = Algoritmo.algoDinamico(input,camion);

        while(!resultadoEsperado.isEmpty()) {
            Assert.assertEquals(resultado.get(0).getPeso(), resultadoEsperado.get(0).getPeso());
            Assert.assertEquals(resultado.get(0).getNombre(), resultadoEsperado.get(0).getNombre());
            resultado.remove(0);
            resultadoEsperado.remove(0);
        }

    }

    @Test
    public void variasMercancias() {
        Camion camion = new Camion();

        Mercancia[] input = new Mercancia[3];
        input[0] = new Mercancia("Mercancia1", 6000);
        input[1] = new Mercancia("Mercancia2", 8000);
        input[2] = new Mercancia("Mercancia3", 10000);

        ArrayList<Mercancia> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(new Mercancia("Mercancia3", 10000));

        ArrayList<Mercancia> resultado = Algoritmo.algoDinamico(input,camion);

        while(!resultadoEsperado.isEmpty()) {
            Assert.assertEquals(resultadoEsperado.get(0).getPeso(),resultado.get(0).getPeso());
            Assert.assertEquals(resultadoEsperado.get(0).getNombre(),resultado.get(0).getNombre() );
            resultado.remove(0);
            resultadoEsperado.remove(0);
        }
    }

    @Test
    public void pesoNegativoUnico(){
        Camion camion = new Camion();

        Mercancia[] input = new Mercancia[1];
        input[0] = new Mercancia("Mercancia3", -10000);

        ArrayList<Mercancia> resultadoEsperado = new ArrayList<>();

        ArrayList<Mercancia> resultado = Algoritmo.algoDinamico(input,camion);

        Assert.assertEquals("El ArrayList debe ser vacío", resultadoEsperado, resultado);
    }

    @Test
    public void pesoNegativoVarios(){
        Camion camion = new Camion(5);

        Mercancia[] input = new Mercancia[4];
        input[0] = new Mercancia("Mercancia3", 1);
        input[1] = new Mercancia("Mercancia3", -5);
        input[2] = new Mercancia("Mercancia3", 4);
        input[3] = new Mercancia("Mercancia3", -10000);

        ArrayList<Mercancia> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(new Mercancia("Mercancia3", 1));
        resultadoEsperado.add(new Mercancia("Mercancia3", 4));

        ArrayList<Mercancia> resultado = Algoritmo.algoDinamico(input,camion);

        while(!resultadoEsperado.isEmpty()) {
            Assert.assertEquals(resultado.get(0).getPeso(), resultadoEsperado.get(0).getPeso());
            Assert.assertEquals(resultado.get(0).getNombre(), resultadoEsperado.get(0).getNombre());
            resultado.remove(0);
            resultadoEsperado.remove(0);
        }
    }

    @Test
    public void pesoSuperiorAlMaximo(){
        Camion camion = new Camion();

        Mercancia[] input = new Mercancia[4];
        input[0] = new Mercancia("Mercancia3", 15001);
        input[1] = new Mercancia("Mercancia3", 2345458);
        input[2] = new Mercancia("Mercancia3", 10);
        input[3] = new Mercancia("Mercancia3", 60);

        ArrayList<Mercancia> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(new Mercancia("Mercancia3", 10));
        resultadoEsperado.add(new Mercancia("Mercancia3", 60));

        ArrayList<Mercancia> resultado = Algoritmo.algoDinamico(input,camion);

        while(!resultadoEsperado.isEmpty()) {
            Assert.assertEquals(resultado.get(0).getPeso(), resultadoEsperado.get(0).getPeso());
            Assert.assertEquals(resultado.get(0).getNombre(), resultadoEsperado.get(0).getNombre());
            resultado.remove(0);
            resultadoEsperado.remove(0);
        }
    }
    @Test
    public void pesoNuloUnico(){
        Camion camion = new Camion();

        Mercancia[] input = new Mercancia[1];
        input[0] = new Mercancia("Mercancia3", 0);

        ArrayList<Mercancia> resultadoEsperado = new ArrayList<>();

        ArrayList<Mercancia> resultado = Algoritmo.algoDinamico(input,camion);

        Assert.assertEquals("El ArrayList debe ser vacío", resultadoEsperado, resultado);
    }
    @Test
    public void mezclaDeErrores(){
        Camion camion = new Camion();

        Mercancia[] input = new Mercancia[7];
        input[0] = new Mercancia("Mercancia3", 0);
        input[1] = new Mercancia("Mercancia3", 2345458);
        input[2] = new Mercancia("Mercancia3", 10);
        input[3] = new Mercancia("Mercancia3", 60);
        input[4] = new Mercancia("Mercancia3", 0);
        input[5] = new Mercancia("Mercancia3", -35);
        input[6] = new Mercancia("Mercancia3", -0);


        ArrayList<Mercancia> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(new Mercancia("Mercancia3", 10));
        resultadoEsperado.add(new Mercancia("Mercancia3", 60));

        ArrayList<Mercancia> resultado = Algoritmo.algoDinamico(input,camion);

        while(!resultadoEsperado.isEmpty()) {
            Assert.assertEquals(resultado.get(0).getPeso(), resultadoEsperado.get(0).getPeso());
            Assert.assertEquals(resultado.get(0).getNombre(), resultadoEsperado.get(0).getNombre());
            resultado.remove(0);
            resultadoEsperado.remove(0);
        }
    }
}
