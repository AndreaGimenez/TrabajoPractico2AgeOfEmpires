package fiuba.algo3.tp2.turno;

import java.util.Collection;

import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignado;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;

public class Turno {
	
	private Collection<Posicionable> posicionablesJugador;

	public Turno(Collection<Posicionable> posicionablesJugador) {
		this.posicionablesJugador = posicionablesJugador;
	}

	public void iniciar() {
		
		for(Posicionable posicionable : posicionablesJugador) {
			posicionable.iniciar();
		}
	}

    public void avanzar() throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignado {

		for(Posicionable posicionable : posicionablesJugador) {
			posicionable.siguienteAccion();
		}

    }
}
