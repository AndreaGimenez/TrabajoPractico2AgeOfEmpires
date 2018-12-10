package fiuba.algo3.tp2.integracion.juego;

import org.junit.Test;

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
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.movimiento.DireccionAbajoIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;
import fiuba.algo3.tp2.excepciones.MovimientoInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.unidad.Aldeano;

public class juegoTest {
	
	@Test
	public void testSeIniciaUnJuegoYSeRealizanAccionesDeCadaJugadorEnSuTurnoCorrespondiente() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, MovimientoInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {
		
		Mapa mapa = new Mapa(250,250);
		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador primerJugador = juego.obtenerJugadorActual();
		
		Aldeano aldeanoPrimerJugador = (Aldeano) mapa.obtenerPosicionable(new Posicion(5,3));
		
		aldeanoPrimerJugador.mover(new DireccionDerecha());
		
		juego.avanzarJugador();
		
		Jugador segundoJugador = juego.obtenerJugadorActual();
		
		Aldeano aldeanoSegundoJugador = (Aldeano) mapa.obtenerPosicionable(new Posicion(246,244));
		
		aldeanoSegundoJugador.mover(new DireccionAbajoIzquierda());
		
		juego.avanzarJugador();
		
		aldeanoPrimerJugador.mover(new DireccionDerecha());
	}
}
