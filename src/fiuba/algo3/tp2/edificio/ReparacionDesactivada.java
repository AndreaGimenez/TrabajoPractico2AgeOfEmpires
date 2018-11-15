package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;

public class ReparacionDesactivada implements Reparacion {
	
	public void reparar(Edificio edificio) throws EdificioNoAptoParaReparacionException {
		throw new EdificioNoAptoParaReparacionException();
	}
}
