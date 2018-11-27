package fiuba.algo3.tp2.juego;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Atacador;
import fiuba.algo3.tp2.unidad.Ataque;
import fiuba.algo3.tp2.unidad.AtaqueArquero;
import fiuba.algo3.tp2.unidad.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.unidad.AtaqueInvalidoException;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.unidad.UnidadMuertaException;



public class FinDelJuegoTest{
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_AlEliminarCastilloDeUnJugadorElJuegoDebeFinalizar() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, 
			CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, 
			OroInsuficienteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		AtaqueArquero ataque = mock(AtaqueArquero.class);
		when(ataque.obtenerDanioEdificio()).thenReturn(1000);
		
		juego.iniciar();
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		
		juego.avanzarJugador();
		
		Jugador jugador2 = juego.obtenerJugadorActual();
		Espadachin espadachin = new Espadachin(new Posicion(0, 4), mapa);
		jugador2.agregarUnidad(espadachin, mapa, true);
		
		//juego.obtenerJugadorActual().atacar(juego.obtenerAtacables(jugador1).getFirst(), juego.obtenerJugadorActual().obtenerPosicionables().getLast());
		Castillo castillo = (Castillo) jugador2.obtenerPosicionables().getFirst();
		
		castillo.recibirDanio(ataque);
		
		assertEquals(true, juego.estaTerminado());
		
	}
	/*
	@Test
	public void test_AlNoEliminarCastilloDeUnJugadorElJuegoNoDebeFinalizar() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, 
			CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, 
			OroInsuficienteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		AtaqueArquero ataque = mock(AtaqueArquero.class);
		when(ataque.obtenerDanioEdificio()).thenReturn(500);
		
		juego.iniciar();
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		
		juego.avanzarJugador();
		
		Jugador jugador2 = juego.obtenerJugadorActual();
		Espadachin espadachin = new Espadachin(new Posicion(0, 4), mapa);
		jugador2.agregarUnidad(espadachin, mapa, true);
		
		//juego.obtenerJugadorActual().atacar(juego.obtenerAtacables(jugador1).getFirst(), juego.obtenerJugadorActual().obtenerPosicionables().getLast());
		Castillo castillo = (Castillo) jugador2.obtenerPosicionables().getFirst();
		
		castillo.recibirDanio(ataque);
		
		assertEquals(false, juego.estaTerminado());
		
	}*/
}

