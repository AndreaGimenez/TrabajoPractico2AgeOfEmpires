package fiuba.algo3.tp2.reparacion;

import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.edificio.Edificio;

public class ReparacionActivada implements Reparacion {

	@Override
	public void reparar(Edificio edificio) throws EdificioNoAptoParaReparacionException {
		edificio.curar();
	}

}
