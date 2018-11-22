package fiuba.algo3.tp2.reparacion;

import fiuba.algo3.tp2.edificio.Edificio;

public interface Reparador {
	
	public void repararEdificio(Edificio edificio)
            throws EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException;
}
