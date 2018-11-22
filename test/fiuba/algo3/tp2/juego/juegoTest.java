package fiuba.algo3.tp2.juego;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.mapa.Celda;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;

public class juegoTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_crearJuegoConMasDeDosJugadores_DeberiaLanzarCantidadDeJugadoresInvalidaException() 
			throws CantidadDeJugadoresInvalidaException, TamanioInvalidoException {
		
		Juego juego = new Juego(new Mapa(250, 250));
		juego.agregarJugador();
		juego.agregarJugador();
		
		exceptionRule.expect(CantidadDeJugadoresInvalidaException.class);
		juego.agregarJugador();
	}

	@Test
	public void test_alIniciarJuegoCadaJugadorDeberiaTener_100_Oro() 
			throws CantidadDeJugadoresInvalidaException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Juego juego = new Juego(new Mapa(250, 250));
		
		juego.agregarJugador();
		juego.agregarJugador();
		
		juego.iniciar();
		
		Jugador jugador1 = juego.obtenerJugador(0);
		Jugador jugador2 = juego.obtenerJugador(1);
		
		assertEquals(100, jugador1.obtenerOro());
		assertEquals(100, jugador2.obtenerOro());
		
	}
	
	@Test
	public void test_alIniciarJuegoCadaJugadorDeberiaTenerUnCastillo_YEstarPosicionadoUnoEnCadaEsquina()
		throws CantidadDeJugadoresInvalidaException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
			
			Mapa mapa = new Mapa(250, 250);
			
			Juego juego = new Juego(mapa);
			
			juego.agregarJugador();
			juego.agregarJugador();
			
			juego.iniciar();
			
			Celda celdaCastilloJugador1 = mapa.obtenerCelda(new Posicion(0, 0));
			Celda celdaCastilloJugador2 = mapa.obtenerCelda(new Posicion(244, 244));
			assertEquals(true, celdaCastilloJugador1.estaOcupada());
			assertEquals(true, celdaCastilloJugador2.estaOcupada());

	}
	
	@Test
	public void test_alIniciarElJuegoDebenEstarLosJugadoresUbicadosSimetricamenteOpuestoEnElMapa() 
			throws CantidadDeJugadoresInvalidaException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		
		juego.iniciar();
		
		Celda celdaCastilloJugador1 = mapa.obtenerCelda(new Posicion(1, 1));	
		Celda celdaCastilloJugador2 = mapa.obtenerCelda(new Posicion(244, 244));
		Celda celdaAldeano1Jugador1 = mapa.obtenerCelda(new Posicion(5, 3));	
		Celda celdaAldeano2Jugador1 = mapa.obtenerCelda(new Posicion(5, 5));
		Celda celdaAldeano3Jugador1 = mapa.obtenerCelda(new Posicion(3, 5));
		Celda celdaPlazaCentralJugador1 = mapa.obtenerCelda(new Posicion(5, 0));
		Celda celdaAldeano1Jugador2 = mapa.obtenerCelda(new Posicion(246, 244));	
		Celda celdaAldeano2Jugador2 = mapa.obtenerCelda(new Posicion(244, 244));
		Celda celdaAldeano3Jugador2 = mapa.obtenerCelda(new Posicion(246, 244));
		Celda celdaPlazaCentralJugador2 = mapa.obtenerCelda(new Posicion(243, 248));
		
		assertEquals(true, celdaCastilloJugador1.estaOcupada());
		assertEquals(true, celdaCastilloJugador2.estaOcupada());
		assertEquals(true, celdaAldeano1Jugador1.estaOcupada());
		assertEquals(true, celdaAldeano2Jugador1.estaOcupada());
		assertEquals(true, celdaAldeano3Jugador1.estaOcupada());
		assertEquals(true, celdaPlazaCentralJugador1.estaOcupada());
		assertEquals(true, celdaAldeano1Jugador2.estaOcupada());
		assertEquals(true, celdaAldeano2Jugador2.estaOcupada());
		assertEquals(true, celdaAldeano3Jugador2.estaOcupada());
		assertEquals(true, celdaPlazaCentralJugador2.estaOcupada());
	}
	
	@Test
	public void test_AlIniciarJuegoConUnJugadorDeberDarError() 
			throws CantidadDeJugadoresInvalidaException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Juego juego = new Juego(new Mapa(250, 250));
		
		juego.agregarJugador();
		
		exceptionRule.expect(CantidadDeJugadoresInvalidaException.class);
		juego.iniciar();
	}
	
	@Test
	public void test_iniciarJuegoConUnMapaNoCuadradadoDeberiaUbicarBienLosCastillos()
		throws CantidadDeJugadoresInvalidaException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
			
			Mapa mapa = new Mapa(300, 250);
			
			Juego juego = new Juego(mapa);
			
			juego.agregarJugador();
			juego.agregarJugador();
			
			juego.iniciar();
			
			Celda celdaCastilloJugador1 = mapa.obtenerCelda(new Posicion(0, 0));
			Celda celdaCastilloJugador2 = mapa.obtenerCelda(new Posicion(294, 244));
			assertEquals(true, celdaCastilloJugador1.estaOcupada());
			assertEquals(true, celdaCastilloJugador2.estaOcupada());
	}
}
