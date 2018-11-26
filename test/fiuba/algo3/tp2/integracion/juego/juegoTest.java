package fiuba.algo3.tp2.integracion.juego;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.juego.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.movimiento.DireccionAbajoIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;
import fiuba.algo3.tp2.movimiento.MovimientoInvalidoException;
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.unidad.Aldeano;

public class juegoTest {
	
	@Test
	public void testSeIniciaUnJuegoYSeRealizanAccionesDeCadaJugadorEnSuTurnoCorrespondiente() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, MovimientoInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		Juego juego = new Juego(mapa);

		juego.iniciar();
		
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
