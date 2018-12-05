package fiuba.algo3.tp2.reparacion;

import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.unidad.Aldeano;

public class ReparadorEdificioAldeano implements ReparadorEdificio {

	private EdificioConReparadorAsignadoException EdificioConReparadorAsignado;
	private boolean yaRepareEsteTurno;
	private fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException EdificioNoAptoParaReparacionException;

	public ReparadorEdificioAldeano() {

		this.yaRepareEsteTurno = false;

		this.EdificioConReparadorAsignado = new EdificioConReparadorAsignadoException();

		this.EdificioNoAptoParaReparacionException = new EdificioNoAptoParaReparacionException();

	}

	@Override
	public void repararEdificio(Edificio edificio, Aldeano aldeano)
			throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		if(yaRepareEsteTurno) throw EdificioNoAptoParaReparacionException;
		if(!edificio.verificarReparador(aldeano) && !edificio.verificarReparador(null)) throw EdificioConReparadorAsignado;
		edificio.reparar();
		edificio.enReparacionPorAldeano(aldeano);
		this.yaRepareEsteTurno = true;

	}

	@Override
	public void esPosibileVolverAReparar() {

		this.yaRepareEsteTurno = false;

	}
}
