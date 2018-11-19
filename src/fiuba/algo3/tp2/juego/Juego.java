package fiuba.algo3.tp2.juego;

import java.util.Collection;

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

	public void iniciar() {
		// TODO Auto-generated method stub
		
	}

}
