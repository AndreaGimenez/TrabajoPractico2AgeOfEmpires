package fiuba.algo3.tp2.reparacion;

import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.edificio.Edificio;

public interface Reparacion {

	void reparar(Edificio edificio) throws EdificioNoAptoParaReparacionException;

}
