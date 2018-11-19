package fiuba.algo3.tp2.reparacion;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.mapa.Mapa;

public class ReparadorEdificioAldeano implements ReparadorEdificio {

	private boolean yaRepareEsteTurno;
	private EdificioNoAptoParaReparacionException EdificioNoAptoParaReparacionException;

	public ReparadorEdificioAldeano(Mapa mapa) {

		this.yaRepareEsteTurno = false;

		this.EdificioNoAptoParaReparacionException = new EdificioNoAptoParaReparacionException();

	}

	@Override
	public void repararEdificio(Edificio edificio) 
			throws EdificioNoAptoParaReparacionException {
		if(yaRepareEsteTurno) throw EdificioNoAptoParaReparacionException;

		edificio.reparar();

		this.yaRepareEsteTurno = true;

	}

	@Override
	public void esPosibileVolverAReparar() {

		this.yaRepareEsteTurno = false;

	}
}
