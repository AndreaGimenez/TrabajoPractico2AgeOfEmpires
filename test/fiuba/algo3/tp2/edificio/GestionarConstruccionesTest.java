package fiuba.algo3.tp2.edificio;

import Construccion.EdificioNoSoportadoException;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.UnidadConstants;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class GestionarConstruccionesTest {


    @Test(expected = EdificioEnConstruccionException.class)
    public void testCrearUnCuartelYPedirleCrearUnaUnidadNoDeberiaSerPosibleYaQueEstaEnConstruccion()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException {

        Mapa mapa = new Mapa(250, 250);
        Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
        Cuartel cuartel = (Cuartel) aldeano.crear(EdificioConstants.TipoEdificio.CUARTEL);
        GestionarConstrucciones gestorCuartel = new GestionarConstrucciones(cuartel);

        gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(5, 5));


    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void testCrearUnCuartelYPedirleCrearUnaUnidadHabiendoPasadoUnTurnoNoDeberiaSerPosibleYaQueEstaEnConstruccion()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException {

        Mapa mapa = new Mapa(250, 250);
        Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
        Cuartel cuartel = (Cuartel) aldeano.crear(EdificioConstants.TipoEdificio.CUARTEL);
        GestionarConstrucciones gestorCuartel = new GestionarConstrucciones(cuartel);
        LinkedList<Posicionable> posicionables = new LinkedList<>();

        posicionables.add(gestorCuartel);
        Turno turno = new Turno(posicionables);
        turno.avanzar();

        gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(5, 5));

    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void testCrearUnCuartelYPedirleCrearUnaUnidadHabiendoPasadoDosTurnosNoDeberiaSerPosibleYaQueEstaEnConstruccion()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException {

        Mapa mapa = new Mapa(250, 250);
        Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
        Cuartel cuartel = (Cuartel) aldeano.crear(EdificioConstants.TipoEdificio.CUARTEL);
        GestionarConstrucciones gestorCuartel = new GestionarConstrucciones(cuartel);
        LinkedList<Posicionable> posicionables = new LinkedList<>();

        posicionables.add(gestorCuartel);
        Turno turno = new Turno(posicionables);
        turno.avanzar();
        turno.avanzar();

        gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(5, 5));

    }

    @Test
    public void testCrearUnCuartelYPedirleCrearUnaUnidadHabiendoPasadoTresTurnosDeberiaSerPosible()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException {

        Mapa mapa = new Mapa(250, 250);
        Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
        Cuartel cuartel = (Cuartel) aldeano.crear(EdificioConstants.TipoEdificio.CUARTEL);
        GestionarConstrucciones gestorCuartel = new GestionarConstrucciones(cuartel);
        LinkedList<Posicionable> posicionables = new LinkedList<>();

        posicionables.add(gestorCuartel);
        Turno turno = new Turno(posicionables);
        turno.avanzar();
        turno.avanzar();
        turno.avanzar();

        gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(6, 6));

    }





}