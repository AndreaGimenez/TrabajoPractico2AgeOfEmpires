package fiuba.algo3.tp2.excepciones.reparacion;

import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.edificio.Edificio;

public interface Reparador {
	
	public void repararEdificio(Edificio edificio)
            throws EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException;
}
