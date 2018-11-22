package fiuba.algo3.tp2.edificio;

import Construccion.EdificioNoSoportadoException;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.UnidadConstants;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.LinkedList;

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
        LinkedList<Posicionable> posicionables = new LinkedList<>();

        posicionables.add(gestorCuartel);
        Turno turno = new Turno(posicionables);
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
        LinkedList<Posicionable> posicionables = new LinkedList<>();

        posicionables.add(gestorCuartel);
        Turno turno = new Turno(posicionables);
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
        LinkedList<Posicionable> posicionables = new LinkedList<>();

        posicionables.add(gestorCuartel);
        Turno turno = new Turno(posicionables);
        turno.avanzar();
        turno.avanzar();
        turno.avanzar();

        gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(6, 6));

    }




}