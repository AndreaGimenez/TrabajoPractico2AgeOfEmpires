package fiuba.algo3.tp2.integracion.entrega_1;

import fiuba.algo3.tp2.edificio.*;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.unidad.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Pruebas de edificios - Creacion de unidades
 *
 */ 
public class Test03 {

    @Test
    public void testCuartelCreaArqueroYEspadachin() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, UnidadNoSoportadaException {

        Mapa mapa = new Mapa(250,250);

        Posicion posicion = new Posicion(5,5);

        Posicion nacimiento = new Posicion(7,5);

        Posicion otroNacimiento = new Posicion(7,6);

        Cuartel cuartel = new Cuartel(posicion, mapa);

        assertTrue(cuartel.crear(UnidadConstants.TipoUnidad.ARQUERO, nacimiento) instanceof Arquero);

        assertTrue(cuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, otroNacimiento) instanceof Espadachin);

    }

    @Test
    public void testPlazaCentralCreaAldeano() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {

        Mapa mapa = new Mapa(250,250);

        Posicion posicion = new Posicion(5,5);

        Posicion nacimiento = new Posicion(7,5);

        PlazaCentral plazaCentral = new PlazaCentral(posicion, mapa);

        assertTrue(plazaCentral.crear(UnidadConstants.TipoUnidad.ALDEANO, nacimiento) instanceof Aldeano);

    }

    @Test
    public void testCastilloCreaArmaDeAsedio() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {

        Mapa mapa = new Mapa(250,250);

        Posicion posicion = new Posicion(5,5);

        Posicion nacimiento = new Posicion(10,5);

        Castillo castillo = new Castillo(posicion, mapa);

        assertTrue(castillo.crear(UnidadConstants.TipoUnidad.ARMA_ASEDIO, nacimiento) instanceof ArmaAsedio);

    }

}
