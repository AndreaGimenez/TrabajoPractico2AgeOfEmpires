package fiuba.algo3.tp2.reparacion;

import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.unidad.Aldeano;

public interface ReparadorEdificio {
	
	public void repararEdificio(Edificio edificio) throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, YaSeReparoEnESteTurnoException;

	void habilitarReparacionEsteTurno();

}
