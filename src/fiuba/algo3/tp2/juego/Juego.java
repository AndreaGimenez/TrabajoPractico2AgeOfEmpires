package fiuba.algo3.tp2.juego;

import java.util.Collection;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;

public class Juego {

	private Collection<Jugador> jugadores;
	private Mapa mapa;

	public Juego(Collection<Jugador> jugadores, Mapa mapa) 
			throws CantidadDeJugadoresInvalidaException {
				
		if(jugadores.isEmpty() || jugadores.size()!=2) {
			throw new CantidadDeJugadoresInvalidaException();
		}
		
		this.jugadores = jugadores;
		this.mapa = mapa;
	}

	public void iniciar() 
			throws CeldaOcupadaException, CeldaInexistenteException {

		Jugador jugador1 = jugadores.iterator().next();
		Jugador jugador2 = jugadores.iterator().next();
		
		jugador1.cargarCondicionesIniciales(this.mapa);
		jugador2.cargarCondicionesIniciales(this.mapa);
	}

}
