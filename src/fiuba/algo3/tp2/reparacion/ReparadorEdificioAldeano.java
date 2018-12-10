package fiuba.algo3.tp2.reparacion;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;

public class ReparadorEdificioAldeano implements ReparadorEdificio {

	private boolean repareEsteTurno;
	private Reparador reparador;
	
	public ReparadorEdificioAldeano(Reparador reparador) {
		
		this.reparador = reparador;
		this.repareEsteTurno = false;
	}

	@Override
	public void repararEdificio(Edificio edificio)
			throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, YaSeReparoEnESteTurnoException {
		if(repareEsteTurno) throw new YaSeReparoEnESteTurnoException();
		if(!edificio.verificarReparador(reparador) && !edificio.verificarReparador(null)) throw new EdificioConReparadorAsignadoException();
		edificio.reparar();
		edificio.asignarReparador(reparador);
		this.repareEsteTurno = true;
	}

	@Override
	public void habilitarReparacionEsteTurno() {

		this.repareEsteTurno = false;
	}
}
