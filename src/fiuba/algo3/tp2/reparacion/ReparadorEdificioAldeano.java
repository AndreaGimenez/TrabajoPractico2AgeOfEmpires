package fiuba.algo3.tp2.reparacion;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.mapa.Mapa;

public class ReparadorEdificioAldeano implements ReparadorEdificio {

	private EdificioConReparadorAsignado EdificioConReparadorAsignado;
	private boolean yaRepareEsteTurno;
	private EdificioNoAptoParaReparacionException EdificioNoAptoParaReparacionException;

	public ReparadorEdificioAldeano(Mapa mapa) {

		this.yaRepareEsteTurno = false;

		this.EdificioNoAptoParaReparacionException = new EdificioNoAptoParaReparacionException();

		this.EdificioConReparadorAsignado = new EdificioConReparadorAsignado();

	}

	@Override
	public void repararEdificio(Edificio edificio)
			throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignado {
		if(yaRepareEsteTurno) throw EdificioNoAptoParaReparacionException;
		if(edificio.yaEstaEnReparacion()) throw EdificioConReparadorAsignado;
		edificio.reparar();
		edificio.enReparacion();
		this.yaRepareEsteTurno = true;

	}

	@Override
	public void esPosibileVolverAReparar() {

		this.yaRepareEsteTurno = false;

	}
}
