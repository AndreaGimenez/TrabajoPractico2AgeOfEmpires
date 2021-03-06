package fiuba.algo3.tp2.reparacion;

import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.unidad.AldeanoConConstruccionAsignadaException;
import fiuba.algo3.tp2.edificio.Edificio;

public interface Reparador {
	
	public void repararEdificio(Edificio edificio)
            throws EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, AldeanoConConstruccionAsignadaException, YaSeReparoEnESteTurnoException;
}
