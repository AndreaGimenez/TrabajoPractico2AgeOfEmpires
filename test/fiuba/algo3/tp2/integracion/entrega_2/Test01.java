package fiuba.algo3.tp2.integracion.entrega_2;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.juego.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.mapa.Celda;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

/**
 * Distribucion de jugadores en el mapa
 *
 */
public class Test01 {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void test_alIniciarJuegoCadaJugadorDeberiaTener_100_Oro() 
			throws CantidadDeJugadoresInvalidaException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Juego juego = new Juego(new Mapa(250, 250));
		
		juego.iniciar();
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		assertEquals(100, jugador1.obtenerOro());
		juego.avanzarJugador();
		Jugador jugador2 = juego.obtenerJugadorActual();
		assertEquals(100, jugador2.obtenerOro());
	}
	
	@Test
	public void test_alIniciarJuegoCadaJugadorDeberiaTenerUnCastillo_YEstarPosicionadoUnoEnCadaEsquina()
		throws CantidadDeJugadoresInvalidaException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
			
			Mapa mapa = new Mapa(250, 250);
			
			Juego juego = new Juego(mapa);
			
			juego.iniciar();
			
			Celda celdaCastilloJugador1 = mapa.obtenerCelda(new Posicion(0, 0));
			Celda celdaCastilloJugador2 = mapa.obtenerCelda(new Posicion(244, 244));
			assertEquals(true, celdaCastilloJugador1.estaOcupada());
			assertEquals(true, celdaCastilloJugador2.estaOcupada());

	}
	
	@Test
	public void test_alIniciarElJuegoDebenEstarLosJugadoresUbicadosSimetricamenteOpuestoEnElMapa() 
			throws CantidadDeJugadoresInvalidaException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		Mapa mapa = new Mapa(250, 250);
		Juego juego = new Juego(mapa);
		
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
	public void test_iniciarJuegoConUnMapaNoCuadradadoDeberiaUbicarBienLosCastillos()
		throws CantidadDeJugadoresInvalidaException, TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
			
			Mapa mapa = new Mapa(300, 250);
			
			Juego juego = new Juego(mapa);

			juego.iniciar();
			
			Celda celdaCastilloJugador1 = mapa.obtenerCelda(new Posicion(0, 0));
			Celda celdaCastilloJugador2 = mapa.obtenerCelda(new Posicion(294, 244));
			assertEquals(true, celdaCastilloJugador1.estaOcupada());
			assertEquals(true, celdaCastilloJugador2.estaOcupada());
	}
	
	/*@Test
	public void testUnJugadorCreaUnaPlazaCentralDeberiaTener25UnidadesMenosDeOro() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		Mapa mapa = new Mapa(300, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		
		juego.iniciar();
		
		Jugador primerJugador = juego.obtenerJugador(0);
		
		int oroAntes = primerJugador.obtenerOro();
		
		PlazaCentral plaza = (PlazaCentral) mapa.obtenerCelda(new Posicion(5, 0)).obtenerPosicionable();
		
		primerJugador.agregarUnidad(plaza.crear(TipoUnidad.ALDEANO, new Posicion(10,10)),mapa);
		
		int oroDespues = primerJugador.obtenerOro();
		assertEquals(25, oroAntes-oroDespues);
	}*/
}
