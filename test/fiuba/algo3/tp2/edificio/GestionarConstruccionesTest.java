package fiuba.algo3.tp2.edificio;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.construccion.EdificioNoSoportadoException;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.UnidadConstants;

public class GestionarConstruccionesTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    @Test
    public void testCrearUnEdificioYPedirleCrearUnaUnidadNoDeberiaSerPosibleYaQueEstaEnConstruccion()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException {

        Mapa mapa = new Mapa(250, 250);
        Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
        Edificio cuartel = aldeano.crear(EdificioConstants.TipoEdificio.CUARTEL);
        GestionarConstruccion gestorCuartel = new GestionarConstruccion(cuartel);

        exceptionRule.expect(EdificioEnConstruccionException.class);
        gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(5, 5));

    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void testCrearUnEdificioYPedirleCrearUnaUnidadHabiendoPasadoUnTurnoNoDeberiaSerPosibleYaQueEstaEnConstruccion()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException {

        Mapa mapa = new Mapa(250, 250);
        Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
        Cuartel cuartel = (Cuartel) aldeano.crear(EdificioConstants.TipoEdificio.CUARTEL);
        GestionarConstruccion gestorCuartel = new GestionarConstruccion(cuartel);
        
        Jugador jugador = new Jugador();
        
        Collection<Posicionable> posicionables = jugador.obtenerPosicionables();
        
        posicionables.add(gestorCuartel);
        Turno turno = new Turno(jugador);
        turno.avanzar();

        gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(5, 5));

    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void testCrearUnEdificioYPedirleCrearUnaUnidadHabiendoPasadoDosTurnosNoDeberiaSerPosibleYaQueEstaEnConstruccion()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException {

        Mapa mapa = new Mapa(250, 250);
        Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
        Cuartel cuartel = (Cuartel) aldeano.crear(EdificioConstants.TipoEdificio.CUARTEL);
        GestionarConstruccion gestorCuartel = new GestionarConstruccion(cuartel);
        Jugador jugador = new Jugador();
        
        Collection<Posicionable> posicionables = jugador.obtenerPosicionables();
        
        posicionables.add(gestorCuartel);
        Turno turno = new Turno(jugador);
        turno.avanzar();
        turno.avanzar();

        gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(5, 5));

    }

    @Test
    public void testCrearUnEdificioYPedirleCrearUnaUnidadHabiendoPasadoTresTurnosDeberiaSerPosible()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException {

        Mapa mapa = new Mapa(250, 250);
        Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
        Cuartel cuartel = (Cuartel) aldeano.crear(EdificioConstants.TipoEdificio.CUARTEL);
        GestionarConstruccion gestorCuartel = new GestionarConstruccion(cuartel);
         
        Jugador jugador = new Jugador();
        Collection<Posicionable> posicionables = jugador.obtenerPosicionables();
        jugador.agregarEdificio(gestorCuartel);
        Turno turno = new Turno(jugador);
        turno.avanzar();
        turno.avanzar();
        turno.avanzar();

        gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(6, 6));

    }
}