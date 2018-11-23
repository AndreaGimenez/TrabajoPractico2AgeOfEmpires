package Entrega_1.PruebasDelMapa.Tamanio;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import org.junit.Test;

public class PruebasDeTamanio {

    @Test(expected = TamanioInvalidoException.class)
    public void test_CuandoSeCreaUnMapaConDimensionesTamanioXIgual0YTamanioYIgual1_DeberiaLanzarTamanioInvalidoException()
            throws TamanioInvalidoException {

        Mapa mapa = new Mapa(0, 1);
    }

    @Test(expected = TamanioInvalidoException.class)
    public void test_CuandoSeCreaUnMapaConDimensionesX1Y0_DeberiaLanzarTamanioInvalidoException()
            throws TamanioInvalidoException {

        Mapa mapa = new Mapa(1, 0);
    }
}
