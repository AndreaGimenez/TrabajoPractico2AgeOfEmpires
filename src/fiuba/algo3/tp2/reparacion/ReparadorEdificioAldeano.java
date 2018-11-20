package fiuba.algo3.tp2.reparacion;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.unidad.Aldeano;

public class ReparadorEdificioAldeano implements ReparadorEdificio {

	private EdificioConReparadorAsignado EdificioConReparadorAsignado;
	private boolean yaRepareEsteTurno;
	private EdificioNoAptoParaReparacionException EdificioNoAptoParaReparacionException;

	public ReparadorEdificioAldeano() {

		this.yaRepareEsteTurno = false;

		this.EdificioNoAptoParaReparacionException = new EdificioNoAptoParaReparacionException();

		this.EdificioConReparadorAsignado = new EdificioConReparadorAsignado();

	}

	@Override
	public void repararEdificio(Edificio edificio, Aldeano aldeano)
			throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignado {
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
