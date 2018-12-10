package fiuba.algo3.tp2.jugador;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.excepciones.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;


public class jugadorTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	//ORO
	@Test
	public void testAlIniciarUnNuevoJuegoElOroDeCadaJugadorDeberiaSer100() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});

		assertEquals(100, juego.obtenerJugadorActual().obtenerOro());
		
		juego.avanzarJugador();
		
		assertEquals(100, juego.obtenerJugadorActual().obtenerOro());

	}
	
	@Test
	public void  testUnJugadorCon3AldeanosQueNoEstanReparandoNiConstruyendoGenera60UnidadesDeOro()
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {

		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador = juego.obtenerJugadorActual();
        
        int oroAntes = jugador.obtenerOro();
  
        juego.avanzarJugador();
        juego.avanzarJugador();
        
        int oroDespues = jugador.obtenerOro();

        assertEquals(60, oroDespues-oroAntes);
	}
}
