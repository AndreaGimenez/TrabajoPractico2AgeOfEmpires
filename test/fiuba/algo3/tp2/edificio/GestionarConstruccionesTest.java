package fiuba.algo3.tp2.edificio;

import java.util.Collection;

import fiuba.algo3.tp2.excepciones.EdificioEnConstruccionException;
import fiuba.algo3.tp2.excepciones.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.excepciones.UnidadNoSoportadaException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.excepciones.EdificioNoSoportadoException;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;

public class GestionarConstruccionesTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    @Test
    public void testCrearUnEdificioYPedirleCrearUnaUnidadNoDeberiaSerPosibleYaQueEstaEnConstruccion()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException {

        Mapa mapa = new Mapa(250, 250);
  
        Cuartel cuartel = new Cuartel(new Posicion(17, 17), mapa);
        GestionarConstruccion gestorCuartel = new GestionarConstruccion(cuartel);

        exceptionRule.expect(EdificioEnConstruccionException.class);
        gestorCuartel.crearEspadachin(new Posicion(19, 19), mapa);

    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void testCrearUnEdificioYPedirleCrearUnaUnidadHabiendoPasadoUnTurnoNoDeberiaSerPosibleYaQueEstaEnConstruccion()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {

        Mapa mapa = new Mapa(250, 250);
        
        Cuartel cuartel = new Cuartel(new Posicion(17, 17), mapa);
        GestionarConstruccion gestorCuartel = new GestionarConstruccion(cuartel);
        
        Jugador jugador = new Jugador("Jugador 1", mapa);
        
        Collection<Posicionable> posicionables = jugador.obtenerPosicionables();
        
        posicionables.add(gestorCuartel);
        Turno turno = new Turno(jugador, mapa);
        turno.avanzar();

        gestorCuartel.crearEspadachin(new Posicion(19, 19), mapa);

    }

    @Test(expected = EdificioEnConstruccionException.class)
    public void testCrearUnEdificioYPedirleCrearUnaUnidadHabiendoPasadoDosTurnosNoDeberiaSerPosibleYaQueEstaEnConstruccion()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {

        Mapa mapa = new Mapa(250, 250);
        
        Cuartel cuartel = new Cuartel(new Posicion(17, 17), mapa);
        GestionarConstruccion gestorCuartel = new GestionarConstruccion(cuartel);
        Jugador jugador = new Jugador("Jugador 1", mapa);
        
        Collection<Posicionable> posicionables = jugador.obtenerPosicionables();
        
        posicionables.add(gestorCuartel);
        Turno turno = new Turno(jugador, mapa);
        turno.avanzar();
        turno.avanzar();

        gestorCuartel.crearEspadachin(new Posicion(19, 19), mapa);

    }

    @Test
    public void testCrearUnEdificioYPedirleCrearUnaUnidadHabiendoPasadoTresTurnosDeberiaSerPosible()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, OroInsuficienteException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {

        Mapa mapa = new Mapa(250, 250);
        
        Cuartel cuartel = new Cuartel(new Posicion(17, 17), mapa);
        GestionarConstruccion gestorCuartel = new GestionarConstruccion(cuartel);
         
        Jugador jugador = new Jugador("Jugador 1", mapa);
        Collection<Posicionable> posicionables = jugador.obtenerPosicionables();
        jugador.agregarEdificio(gestorCuartel, false);
        Turno turno = new Turno(jugador, mapa);
        turno.avanzar();
        turno.avanzar();
        turno.avanzar();

        Arquero arquero = gestorCuartel.crearArquero(new Posicion(19, 19), mapa);

    }
    
    @Test
    public void testCrearUnCuartelYPedirleCrearUnaAldeanoHabiendoPasadoTresTurnosDeberiaLanzarUnidadNoSoportadaException()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, OroInsuficienteException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {

        Mapa mapa = new Mapa(250, 250);
        
        Cuartel cuartel = new Cuartel(new Posicion(17, 17), mapa);
        GestionarConstruccion gestorCuartel = new GestionarConstruccion(cuartel);
         
        Jugador jugador = new Jugador("Jugador 1", mapa);
        Collection<Posicionable> posicionables = jugador.obtenerPosicionables();
        jugador.agregarEdificio(gestorCuartel, false);
        Turno turno = new Turno(jugador, mapa);
        turno.avanzar();
        turno.avanzar();
        turno.avanzar();
        
        exceptionRule.expect(UnidadNoSoportadaException.class);
        gestorCuartel.crearAldeano(new Posicion(19, 19), mapa);

    }
    
    @Test
    public void testCrearUnEdificio_AlCrearUnaUnidadEnElMismoLugarDeberiaLanzar_CeldaOcupadaException()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, OroInsuficienteException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {

        Mapa mapa = new Mapa(250, 250);
        
        PlazaCentral plazaCentral = new PlazaCentral(new Posicion(17, 17), mapa);
        GestionarConstruccion gestorPlaza = new GestionarConstruccion(plazaCentral);
         
        Jugador jugador = new Jugador("Jugador 1", mapa);
        Collection<Posicionable> posicionables = jugador.obtenerPosicionables();
        jugador.agregarEdificio(gestorPlaza, false);
        Turno turno = new Turno(jugador, mapa);
        turno.avanzar();
        turno.avanzar();
        turno.avanzar();

        exceptionRule.expect(CeldaOcupadaException.class);
        gestorPlaza.crearAldeano(new Posicion(17, 17), mapa);

    }
    
    @Test
    public void test_UnCastilloDebePoderCrearUnArmaDeAsedioPasadoLos3Turnos()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, OroInsuficienteException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {

        Mapa mapa = new Mapa(250, 250);
        
        Castillo castillo = new Castillo(new Posicion(17, 17), mapa);
        GestionarConstruccion gestorCastillo = new GestionarConstruccion(castillo);
         
        Jugador jugador = new Jugador("Jugador 1", mapa);
        Collection<Posicionable> posicionables = jugador.obtenerPosicionables();
        jugador.agregarEdificio(gestorCastillo, false);
        Turno turno = new Turno(jugador, mapa);
        turno.avanzar();
        turno.avanzar();
        turno.avanzar();

        ArmaAsedio arma = gestorCastillo.crearArmaAsedio(new Posicion(21, 21), mapa);

    }
    
    @Test
    public void test_UnCastilloCuandoQuiereCrearUnAldeano_DeberiaLanzarUnidadNoSoportadaException()
            throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, OroInsuficienteException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {

        Mapa mapa = new Mapa(250, 250);
        
        Castillo castillo = new Castillo(new Posicion(17, 17), mapa);
        GestionarConstruccion gestorCastillo = new GestionarConstruccion(castillo);
         
        Jugador jugador = new Jugador("Jugador 1",mapa);
        Collection<Posicionable> posicionables = jugador.obtenerPosicionables();
        jugador.agregarEdificio(gestorCastillo, false);
        Turno turno = new Turno(jugador, mapa);
        turno.avanzar();
        turno.avanzar();
        turno.avanzar();
        
        exceptionRule.expect(UnidadNoSoportadaException.class);
        gestorCastillo.crearAldeano(new Posicion(21, 21), mapa);

    }
}