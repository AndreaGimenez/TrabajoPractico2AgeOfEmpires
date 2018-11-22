package fiuba.algo3.tp2.integracion;

import Construccion.EdificioNoSoportadoException;

import fiuba.algo3.tp2.edificio.*;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.unidad.Aldeano;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;


public class ConstruccionTest {
	
	@Rule
	public ExpectedException expectedRule = ExpectedException.none();

    @Test
    public void test01AldeanoConstruyeUnCuartelASuDerechaPorDebajo() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

        posicionador.posicionarALaDerechaPorDebajo(EdificioConstants.TipoEdificio.CUARTEL);

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(1).desplazarVerticalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(2).desplazarVerticalmente(-1)).estaOcupada());

    }

    @Test
    public void test02AldeanoConstruyeUnCuartelASuIzquierdaPorDebajo() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

        posicionador.posicionarALaIzquierdaPorDebajo(EdificioConstants.TipoEdificio.CUARTEL);

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-1).desplazarVerticalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-2).desplazarVerticalmente(-1)).estaOcupada());

    }

    @Test
    public void test03AldeanoConstruyeUnCuartelDebajoPorLaDerecha() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

        posicionador.posicionarDebajoPorLaDerecha(EdificioConstants.TipoEdificio.CUARTEL);

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(1).desplazarVerticalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(1).desplazarVerticalmente(-2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-1)).estaOcupada());

    }

    @Test
    public void test04AldeanoConstruyeUnCuartelArribaPorLaDerecha() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

        posicionador.posicionarArribaPorLaDerecha(EdificioConstants.TipoEdificio.CUARTEL);

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(1).desplazarVerticalmente(1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(1).desplazarVerticalmente(2)).estaOcupada());

    }

    @Test
    public void test05AldeanoConstruyeUnCuartelEnSuAristaSuperiorDerecha() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

        posicionador.posicionarEnAristaSuperiorDerecha(EdificioConstants.TipoEdificio.CUARTEL);

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(2).desplazarHorizontalmente(1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(1).desplazarHorizontalmente(1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(1).desplazarHorizontalmente(2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(2).desplazarHorizontalmente(2)).estaOcupada());

    }

    @Test
    public void test06AldeanoConstruyeUnCuartelEnSuAristaInferiorDerecha() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

        posicionador.posicionarEnAristaInferiorDerecha(EdificioConstants.TipoEdificio.CUARTEL);

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-2).desplazarHorizontalmente(1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-2).desplazarHorizontalmente(2)).estaOcupada());

    }

    @Test
    public void test07AldeanoConstruyeUnCuartelEnSuAristaSuperiorIzquierda() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

        posicionador.posicionarEnAristaSuperiorIzquierda(EdificioConstants.TipoEdificio.CUARTEL);

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(2).desplazarVerticalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(2).desplazarVerticalmente(-2)).estaOcupada());

    }

    @Test
    public void test08AldeanoConstruyeUnCuartelEnSuAristaInferiorIzquierda() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        EdificioConstants.TipoEdificio cuartel = EdificioConstants.TipoEdificio.CUARTEL;

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

        posicionador.posicionarEnAristaInferiorIzquierda(EdificioConstants.TipoEdificio.CUARTEL);

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-2).desplazarHorizontalmente(-2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-1).desplazarVerticalmente(-2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(-2)).estaOcupada());

    }

    @Test
    public void test09AldeanoConstruyeUnCuartelALaDerechaPorEncima() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

        posicionador.posicionarALaDerechaPorEncima(EdificioConstants.TipoEdificio.CUARTEL);

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(1).desplazarHorizontalmente(1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(1).desplazarHorizontalmente(2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(2)).estaOcupada());

    }

    @Test
    public void test10AldeanoConstruyeUnCuartelALaIzquierdaPorEncima() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

        posicionador.posicionarALaIzquierdaPorEncima(EdificioConstants.TipoEdificio.CUARTEL);

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(1).desplazarHorizontalmente(-2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(1).desplazarHorizontalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-2)).estaOcupada());

    }

    @Test
    public void test11AldeanoConstruyeUnCuartelDebajoPorLaIzquierda() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

        posicionador.posicionarDebajoPorLaIzquierda(EdificioConstants.TipoEdificio.CUARTEL);

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-1).desplazarVerticalmente(-2)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-2)).estaOcupada());

    }

    @Test
    public void test12AldeanoConstruyeUnCuartelArribaPorLaIzquierda() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException {

        Mapa mapa = new Mapa(250,250);

        Aldeano aldeano = new Aldeano(new Posicion(5,5), mapa);

        PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

        posicionador.posicionarArribaPorLaIzquierda(EdificioConstants.TipoEdificio.CUARTEL);

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(2).desplazarHorizontalmente(-1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-1).desplazarVerticalmente(1)).estaOcupada());

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(2)).estaOcupada());

    }


}
