package fiuba.algo3.tp2.reparacion;

import fiuba.algo3.tp2.edificio.Edificio;

public class ReparacionDesactivada implements Reparacion {
	
	@Override
	public void reparar(Edificio edificio) throws EdificioNoAptoParaReparacionException {
		throw new EdificioNoAptoParaReparacionException();
		
		//new EdificioNoAptoParaReparacionException();
	}
}
