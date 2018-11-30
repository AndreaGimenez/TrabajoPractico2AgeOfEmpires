package fiuba.algo3.tp2.turno;

import java.util.Collection;

import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;

public class Turno {
	
	Jugador jugador;
	
	public Turno(Jugador jugador) {
		this.jugador = jugador;
	}

    public void avanzar() throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
    	
    	Collection<Posicionable> posicionablesJugador = jugador.obtenerPosicionables();
		for(Posicionable posicionable : posicionablesJugador) {
			posicionable.actualizarEstadoParaSiguienteTurno();
		}

    }
}
