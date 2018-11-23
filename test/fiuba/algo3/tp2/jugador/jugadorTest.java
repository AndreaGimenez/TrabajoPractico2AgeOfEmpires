package fiuba.algo3.tp2.jugador;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.juego.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;


public class jugadorTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	//ORO
	@Test
	public void testAlIniciarUnNuevoJuegoElOroDeCadaJugadorDeberiaSer100() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();

		assertEquals(100, juego.obtenerJugador(0).obtenerOro());
		assertEquals(100, juego.obtenerJugador(1).obtenerOro());

	}
	
	@Test
	public void  testUnJugadorCon3AldeanosQueNoEstanReparandoNiConstruyendoGenera60UnidadesDeOro()
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, PoblacionMaximaAlcanzadaException {

		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();
		
		Jugador jugador = juego.obtenerJugador(0);
        Turno turno = new Turno(jugador.obtenerPosicionables());
        
        int oroAntes = jugador.obtenerOro();
      
        turno.avanzar();
        
        int oroDespues = jugador.obtenerOro();

        
	}
}
