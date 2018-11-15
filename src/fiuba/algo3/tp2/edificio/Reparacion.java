package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;

public interface Reparacion {

	void reparar(Edificio edificio) throws EdificioNoAptoParaReparacionException;

}
