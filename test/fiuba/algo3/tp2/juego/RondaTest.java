package fiuba.algo3.tp2.juego;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;

public class RondaTest {
	
	@Test
	public void testAlCrearseUnaRondaDeberiaEstarVacia() {
		
		Ronda ronda = new Ronda();
		
		assertTrue(ronda.estaVacia());
	}
	
	@Test
	public void testSeAgreganDosJugadoresAUnaRondaVaciaAhoraDeberiaTenerDosJugadores() {
		
		Ronda ronda = new Ronda();
		Jugador jugadorUno = new Jugador("Jugador 1");
		Jugador jugadorDos = new Jugador("Jugador 1");
		
		ronda.agregarJugador(jugadorUno);
		ronda.agregarJugador(jugadorDos);
		
		Collection<Jugador> jugadores = ronda.obtenerJugadores();
		
		assertEquals(2, jugadores.size());
	}
	
	@Test
	public void testAlIniciarElRecorridoDeUnaRondaDeberiaApuntarAlPrimerJugador() {
		
		Ronda ronda = new Ronda();
		Jugador jugador = new Jugador("Jugador 1");
		
		ronda.agregarJugador(jugador);
		
		ronda.iniciar();
		
		assertEquals(jugador, ronda.obtenerJugadorActual());
	}
	
	@Test
	public void testAlRecorrerUnaRondaDeUnJugadorSiempreDevuelveElMismoJugador() throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Ronda ronda = new Ronda();
		Jugador jugador = new Jugador("Jugador 1");
		
		ronda.agregarJugador(jugador);
		
		ronda.iniciar();
		
		assertEquals(jugador, ronda.obtenerJugadorActual());
		
		ronda.avanzar();
		
		assertEquals(jugador, ronda.obtenerJugadorActual());
		
		ronda.avanzar();
		
		assertEquals(jugador, ronda.obtenerJugadorActual());
	}
	
	@Test
	public void testAlRecorrerUnaRondaDeDosJugadoresDeberiaDevolverAlternadamenteUnoYOtro() throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Ronda ronda = new Ronda();
		Jugador jugadorUno = new Jugador("Jugador 1");
		Jugador jugadorDos = new Jugador("Jugador 1");
		
		ronda.agregarJugador(jugadorUno);
		ronda.agregarJugador(jugadorDos);
		
		ronda.iniciar();
		
		assertEquals(jugadorUno, ronda.obtenerJugadorActual());
		
		ronda.avanzar();
		
		assertEquals(jugadorDos, ronda.obtenerJugadorActual());
		
		ronda.avanzar();
		
		assertEquals(jugadorUno, ronda.obtenerJugadorActual());
		
		ronda.avanzar();
		
		assertEquals(jugadorDos, ronda.obtenerJugadorActual());
	}	
}
