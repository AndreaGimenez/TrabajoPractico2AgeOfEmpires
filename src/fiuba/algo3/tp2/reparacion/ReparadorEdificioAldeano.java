package fiuba.algo3.tp2.reparacion;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.mapa.Mapa;

public class ReparadorEdificioAldeano implements ReparadorEdificio {

	public ReparadorEdificioAldeano(Mapa mapa) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void repararEdificio(Edificio edificio) 
			throws EdificioNoAptoParaReparacionException {
		edificio.reparar();
	}
}
