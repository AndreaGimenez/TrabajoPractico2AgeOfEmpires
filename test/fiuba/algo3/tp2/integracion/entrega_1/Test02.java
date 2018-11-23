package fiuba.algo3.tp2.integracion.entrega_1;

import Construccion.EdificioNoSoportadoException;
import fiuba.algo3.tp2.edificio.*;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.LinkedList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Test02 {

    /*verificar construcción de cuartel y plaza central
    verificar que se haga en los turnos propios al jugador
    verificar que no suma oro
    */

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    @Test
    public void testVerificarConstruccionDePlazaCentral() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException {

        Mapa mapa = new Mapa(250, 250);
        Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
        PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

        posicionador.posicionarALaIzquierdaPorEncima(EdificioConstants.TipoEdificio.PLAZA_CENTRAL);

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(1).desplazarHorizontalmente(-1)).estaOcupada());
        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(1).desplazarHorizontalmente(-2)).estaOcupada());
        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-2)).estaOcupada());
        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-1)).estaOcupada());


        LinkedList<Posicionable> posicionables = new LinkedList<>();
        GestionarConstruccion gestorPlazaCentral = new GestionarConstruccion((Edificio) mapa.obtenerPosicionable(new Posicion(4,5)));
        posicionables.add(gestorPlazaCentral);

        Turno turno = new Turno(posicionables);

        // Turno 0/3

        try{

            gestorPlazaCentral.crear(UnidadConstants.TipoUnidad.ALDEANO, new Posicion(6, 5));

            fail();

        } catch (EdificioEnConstruccionException e) {

        }

        turno.avanzar();

        // Turno 1/3

        try{

            gestorPlazaCentral.crear(UnidadConstants.TipoUnidad.ALDEANO, new Posicion(6, 5));

            fail();

        } catch (EdificioEnConstruccionException e) {

        }

        turno.avanzar();

        // Turno 2/3

        try{

            gestorPlazaCentral.crear(UnidadConstants.TipoUnidad.ALDEANO, new Posicion(6, 5));

            fail();

        } catch (EdificioEnConstruccionException e) {

        }

        turno.avanzar();

        //Turno 3/3

        try{

            gestorPlazaCentral.crear(UnidadConstants.TipoUnidad.ALDEANO, new Posicion(6, 5));


        } catch (EdificioEnConstruccionException e) {

            fail();

        }


    }

    @Test
    public void testVerificarConstruccionDeCuartel()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException {

        Mapa mapa = new Mapa(250, 250);
        Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
        PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

        posicionador.posicionarEnAristaInferiorDerecha(EdificioConstants.TipoEdificio.CUARTEL);

        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(1)).estaOcupada());
        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-2).desplazarHorizontalmente(2)).estaOcupada());
        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(2).desplazarVerticalmente(-1)).estaOcupada());
        assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(1).desplazarVerticalmente(-2)).estaOcupada());


        LinkedList<Posicionable> posicionables = new LinkedList<>();
        GestionarConstruccion gestorCuartel = new GestionarConstruccion((Edificio) mapa.obtenerPosicionable(new Posicion(6,6)));
        posicionables.add(gestorCuartel);
        Turno turno = new Turno(posicionables);


       // Turno 0/3

        try{

            gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(5, 4));

            fail();

        } catch (EdificioEnConstruccionException e){

        }

        try{

            gestorCuartel.crear(UnidadConstants.TipoUnidad.ARQUERO, new Posicion(5, 4));

            fail();

        } catch (EdificioEnConstruccionException e) {

        }

        turno.avanzar();

        // Turno 1/3

        try{

            gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(5, 4));

            fail();

        } catch (EdificioEnConstruccionException e){

        }

        try{

            gestorCuartel.crear(UnidadConstants.TipoUnidad.ARQUERO, new Posicion(5, 4));

            fail();

        } catch (EdificioEnConstruccionException e) {

        }


        turno.avanzar();

        // Turno 2/3

        try{

            gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(5, 4));

            fail();

        } catch (EdificioEnConstruccionException e){

        }

        try{

            gestorCuartel.crear(UnidadConstants.TipoUnidad.ARQUERO, new Posicion(5, 4));

            fail();

        } catch (EdificioEnConstruccionException e) {

        }

        turno.avanzar();

        // Turno 3/3

        try{

            Unidad espadachin = gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(6, 5));

            Unidad arquero = gestorCuartel.crear(UnidadConstants.TipoUnidad.ARQUERO, new Posicion(7, 5));


        } catch (EdificioEnConstruccionException e){

            fail();

        }

    }


}
