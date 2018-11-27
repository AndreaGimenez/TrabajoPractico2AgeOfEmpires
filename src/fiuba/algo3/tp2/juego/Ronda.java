package fiuba.algo3.tp2.juego;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;

public class Ronda {
	Collection<Jugador> jugadores;
	Iterator<Jugador> iteradorJugadores;
	Jugador jugadorActual;
	
	public Ronda() {
		this.jugadores = new LinkedList<Jugador>();
	}

	public boolean estaVacia() {
		
		return jugadores.isEmpty();
	}

	public void agregarJugador(Jugador jugador) {
		this.jugadores.add(jugador);
	}

	public Collection<Jugador> obtenerJugadores() {
		
		return this.jugadores;
	}
	
	/* Va al primer elemento de la ronda*/
	
	public void iniciar() {
		iteradorJugadores = jugadores.iterator();
		jugadorActual = iteradorJugadores.next();
	}

	public Jugador obtenerJugadorActual() {
		return jugadorActual;
	}

	public void avanzar() throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		if(iteradorJugadores.hasNext()) {
			jugadorActual = iteradorJugadores.next();
		}
		else {
			iniciar();
		}
		
		jugadorActual.sumarOroDelTurno();
		
	}
}
