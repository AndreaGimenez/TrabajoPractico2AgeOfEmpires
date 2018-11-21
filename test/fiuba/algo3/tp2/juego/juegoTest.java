package fiuba.algo3.tp2.juego;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.mapa.Celda;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;

public class juegoTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_crearJuegoConDosJugadoresDeberiaDarBien() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException {
		
		Juego juego = new Juego(new Mapa(250, 250));
		juego.agregarJugador();
		juego.agregarJugador();
		
	}
	
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
		
		//Mapa mapa = new Mapa(250, 250);
		
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
			
			Celda celdaCastilloJugador1 = mapa.obtenerCelda(new Posicion(1, 1));
			Celda celdaCastilloJugador2 = mapa.obtenerCelda(new Posicion(244, 244));
			assertEquals(true, celdaCastilloJugador1.estaOcupada());
			assertEquals(true, celdaCastilloJugador2.estaOcupada());

	}
}
