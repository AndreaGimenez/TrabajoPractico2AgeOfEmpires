package fiuba.algo3.tp2.reparacion;

import fiuba.algo3.tp2.edificio.Edificio;

public interface ReparadorEdificio {
	
	public void repararEdificio(Edificio edificio) throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignado;

	void esPosibileVolverAReparar();
}
