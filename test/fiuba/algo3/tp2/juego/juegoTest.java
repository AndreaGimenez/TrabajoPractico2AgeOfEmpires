package fiuba.algo3.tp2.juego;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;

public class juegoTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_crearJuegoConDosJugadoresDeberiaDarBien() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException {
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Collection<Jugador> jugadores = new ArrayList<Jugador>();
		
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		
		Juego juego = new Juego(jugadores, new Mapa(250, 250));
	}
	
	@Test
	public void test_crearJuegoConUnJugador_DeberiaLanzarCantidadDeJugadoresInvalidaException() 
			throws CantidadDeJugadoresInvalidaException, TamanioInvalidoException {
		
		Jugador jugador = new Jugador();
		Collection<Jugador> jugadores = new ArrayList<Jugador>();
		
		jugadores.add(jugador);
		
		exceptionRule.expect(CantidadDeJugadoresInvalidaException.class);
		Juego juego = new Juego(jugadores, new Mapa(250, 250));
	}
	/*
	@Test
	public void test_alIniciarJuegoCadaJugadorDeberiaTener_100_Oro() 
			throws CantidadDeJugadoresInvalidaException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Collection<Jugador> jugadores = new ArrayList<Jugador>();
		
		jugadores.add(jugador1);jugadores.add(jugador2);
		
		Juego juego = new Juego(jugadores, mapa);
		
		juego.iniciar();
		
		assertEquals(100, jugador1.obtenerOro());
		assertEquals(100, jugador2.obtenerOro());
		
	}
	*/
	

}
