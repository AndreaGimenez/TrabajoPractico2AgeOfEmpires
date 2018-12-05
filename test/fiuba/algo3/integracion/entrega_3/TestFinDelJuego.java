package fiuba.algo3.integracion.entrega_3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.excepciones.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.unidad.AtaqueArquero;

import org.junit.experimental.theories.suppliers.TestedOn;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestFinDelJuego {
	
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
		
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		juego.avanzarJugador();
		Jugador jugador2 = juego.obtenerJugadorActual();
		juego.avanzarJugador();
		Jugador jugador1 = juego.obtenerJugadorActual();
		Castillo castilloJ1 = (Castillo) jugador1.obtenerPosicionables().getFirst();
		juego.avanzarJugador();
		
		//en el turno del jugador 2 se ataca el castillo del jugador 1
		castilloJ1.recibirDanio(ataque);

		juego.avanzarJugador();
		
		assertTrue(juego.estaTerminado());
		
	}

	@Test
	public void test_AlNoEliminarCastilloDeUnJugadorElJuegoNoDebeFinalizar() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, 
			CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, 
			OroInsuficienteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {

		Mapa mapa = new Mapa(250, 250);

		Juego juego = new Juego(mapa);

		AtaqueArquero ataque = mock(AtaqueArquero.class);
		when(ataque.obtenerDanioEdificio()).thenReturn(500);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});

		juego.avanzarJugador();
		Jugador jugador2 = juego.obtenerJugadorActual();
		juego.avanzarJugador();
		Jugador jugador1 = juego.obtenerJugadorActual();
		Castillo castilloJ1 = (Castillo) jugador1.obtenerPosicionables().getFirst();
		juego.avanzarJugador();

		//en el turno del jugador 2 se ataca el castillo del jugador 1
		castilloJ1.recibirDanio(ataque);

		juego.avanzarJugador();

		assertFalse(juego.estaTerminado());
	}
}