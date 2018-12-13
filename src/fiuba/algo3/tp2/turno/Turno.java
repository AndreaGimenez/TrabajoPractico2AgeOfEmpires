package fiuba.algo3.tp2.turno;

import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;
import fiuba.algo3.tp2.unidad.Unidad;

public class Turno {
	
	private Jugador jugador;
	private Mapa mapa;
	
	public Turno(Jugador jugador, Mapa mapa) {
		this.jugador = jugador;
		this.mapa = mapa;
	}

    public void avanzar() throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException, AtaqueInvalidoException {
    	
    	Collection<Posicionable> posicionablesJugador = jugador.obtenerPosicionables();
    	
    	for(Posicionable posicionable : posicionablesJugador) {
    		posicionable.actualizarEstadoParaSiguienteTurno();
    	}
    }
}
