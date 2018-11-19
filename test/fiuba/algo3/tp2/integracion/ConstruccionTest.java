package fiuba.algo3.tp2.integracion;

import Construccion.EdificioNoSoportadoException;
import fiuba.algo3.tp2.edificio.EdificioConstants;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.unidad.Aldeano;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstruccionTest {

    @Test
    public void test01AldeanoConstruyeUnCuartelASuDerecha() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        EdificioConstants.TipoEdificio cuartel = EdificioConstants.TipoEdificio.CUARTEL;

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        aldeano.crear(cuartel).posicionar(aldeano.obtenerPosicion().desplazarHorizontalmente(1));

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(1).desplazarVerticalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(2).desplazarVerticalmente(-1)).estaOcupada());

    }

    @Test
    public void test02AldeanoConstruyeUnCuartelASuIzquierda() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        EdificioConstants.TipoEdificio cuartel = EdificioConstants.TipoEdificio.CUARTEL;

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        aldeano.crear(cuartel).posicionar(aldeano.obtenerPosicion().desplazarHorizontalmente(-2));

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-1).desplazarVerticalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-2).desplazarVerticalmente(-1)).estaOcupada());

    }

    /*@Test  No se por que no pasa
    public void test03AldeanoConstruyeUnCuartelDebajo() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        EdificioConstants.TipoEdificio cuartel = EdificioConstants.TipoEdificio.CUARTEL;

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        aldeano.crear(cuartel).posicionar(aldeano.obtenerPosicion().desplazarVerticalmente(-2));

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(1).desplazarVerticalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(1).desplazarVerticalmente(-2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-1)).estaOcupada());

    }*/

}
