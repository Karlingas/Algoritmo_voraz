import org.example.Practica1.Algoritmos;
import org.example.Practica1.Camion;
import org.example.Practica1.Mercancia;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class testVoraz {
    @Test
    public void testNoObjeto() {
        Mercancia[] mercancias = new Mercancia[0];
        Camion camion = new Camion();
        Assert.assertEquals( "Debe dar un array vacio",mercancias, Algoritmos.algorVoraz(mercancias,camion));
    }

    @Test
    public void testObjetosOrdenados() {
        Mercancia[] mercancias = new Mercancia[10];
        mercancias[0] = new Mercancia(5000);
        mercancias[1] = new Mercancia(2000);
        mercancias[2] = new Mercancia(2000);
        mercancias[3] = new Mercancia(500);
        mercancias[4] = new Mercancia(500);
        mercancias[5] = new Mercancia(200);
        mercancias[6] = new Mercancia(200);
        mercancias[7] = new Mercancia(200);
        mercancias[8] = new Mercancia(200);
        mercancias[9] = new Mercancia(200);

        Mercancia[] mercanciasR = new Mercancia[9];
        mercanciasR[8] = new Mercancia(2000);
        mercanciasR[7] = new Mercancia(2000);
        mercanciasR[6] = new Mercancia(500);
        mercanciasR[5] = new Mercancia(500);
        mercanciasR[4] = new Mercancia(200);
        mercanciasR[3] = new Mercancia(200);
        mercanciasR[2] = new Mercancia(200);
        mercanciasR[1] = new Mercancia(200);
        mercanciasR[0] = new Mercancia(200);

        Camion camion = new Camion();

        Mercancia[] mercanciasA = Algoritmos.algorVoraz(mercancias, camion);

        for (int i = 0; i < mercanciasR.length; i++) {
            Assert.assertEquals(mercanciasR[i].getPeso(), mercanciasA[i].getPeso());
            Assert.assertEquals(mercanciasR[i].getNombre(), mercanciasA[i].getNombre());
        }
    }

    @Test
    public void testObjetosDesordenados() {
        Mercancia[] mercancias = new Mercancia[10];
        mercancias[3] = new Mercancia(5000);
        mercancias[1] = new Mercancia(2000);
        mercancias[8] = new Mercancia(2000);
        mercancias[0] = new Mercancia(500);
        mercancias[4] = new Mercancia(500);
        mercancias[5] = new Mercancia(200);
        mercancias[9] = new Mercancia(200);
        mercancias[7] = new Mercancia(200);
        mercancias[2] = new Mercancia(200);
        mercancias[6] = new Mercancia(200);

        Mercancia[] mercanciasR = new Mercancia[9];
        mercanciasR[8] = new Mercancia(2000);
        mercanciasR[7] = new Mercancia(2000);
        mercanciasR[6] = new Mercancia(500);
        mercanciasR[5] = new Mercancia(500);
        mercanciasR[4] = new Mercancia(200);
        mercanciasR[3] = new Mercancia(200);
        mercanciasR[2] = new Mercancia(200);
        mercanciasR[1] = new Mercancia(200);
        mercanciasR[0] = new Mercancia(200);

        Camion camion = new Camion();

        Mercancia[] mercanciasA = Algoritmos.algorVoraz(mercancias, camion);

        for (int i = 0; i < mercanciasR.length; i++) {
            Assert.assertEquals(mercanciasR[i].getPeso(), mercanciasA[i].getPeso());
            Assert.assertEquals(mercanciasR[i].getNombre(), mercanciasA[i].getNombre());
        }
    }

    @Test
    public void testPesoNegativo(){
        Mercancia[] mercancias = new Mercancia[10];
        mercancias[3] = new Mercancia(5000);
        mercancias[1] = new Mercancia(-2000);
        mercancias[8] = new Mercancia(2000);
        mercancias[0] = new Mercancia(500);
        mercancias[4] = new Mercancia(500);
        mercancias[5] = new Mercancia(200);
        mercancias[9] = new Mercancia(200);
        mercancias[7] = new Mercancia(200);
        mercancias[2] = new Mercancia(200);
        mercancias[6] = new Mercancia(200);

        Mercancia[] mercanciasR = new Mercancia[8];
        mercanciasR[7] = new Mercancia(2000);
        mercanciasR[6] = new Mercancia(500);
        mercanciasR[5] = new Mercancia(500);
        mercanciasR[4] = new Mercancia(200);
        mercanciasR[3] = new Mercancia(200);
        mercanciasR[2] = new Mercancia(200);
        mercanciasR[1] = new Mercancia(200);
        mercanciasR[0] = new Mercancia(200);

        Camion camion = new Camion();

        Mercancia[] mercanciasA = Algoritmos.algorVoraz(mercancias, camion);

        for (int i = 0; i < mercanciasR.length; i++) {
            Assert.assertEquals(mercanciasR[i].getPeso(), mercanciasA[i].getPeso());
            Assert.assertEquals(mercanciasR[i].getNombre(), mercanciasA[i].getNombre());
        }
    }

    @Test
    public void testPesoNulo(){
        Mercancia[] mercancias = new Mercancia[10];
        mercancias[3] = new Mercancia(5000);
        mercancias[1] = new Mercancia(0);
        mercancias[8] = new Mercancia(2000);
        mercancias[0] = new Mercancia(500);
        mercancias[4] = new Mercancia(500);
        mercancias[5] = new Mercancia(200);
        mercancias[9] = new Mercancia(200);
        mercancias[7] = new Mercancia(200);
        mercancias[2] = new Mercancia(200);
        mercancias[6] = new Mercancia(200);

        Mercancia[] mercanciasR = new Mercancia[8];
        mercanciasR[7] = new Mercancia(2000);
        mercanciasR[6] = new Mercancia(500);
        mercanciasR[5] = new Mercancia(500);
        mercanciasR[4] = new Mercancia(200);
        mercanciasR[3] = new Mercancia(200);
        mercanciasR[2] = new Mercancia(200);
        mercanciasR[1] = new Mercancia(200);
        mercanciasR[0] = new Mercancia(200);

        Camion camion = new Camion();

        Mercancia[] mercanciasA = Algoritmos.algorVoraz(mercancias, camion);

        for (int i = 0; i < mercanciasR.length; i++) {
            Assert.assertEquals(mercanciasR[i].getPeso(), mercanciasA[i].getPeso());
            Assert.assertEquals(mercanciasR[i].getNombre(), mercanciasA[i].getNombre());
        }
    }

}
