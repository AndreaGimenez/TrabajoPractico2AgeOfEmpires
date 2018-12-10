package fiuba.algo3.tp2.construccion;

import fiuba.algo3.tp2.unidad.AldeanoConConstruccionAsignadaException;

public interface Constructor {
	
	public void construirConstruible(Construible construible)
			throws EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, AldeanoConConstruccionAsignadaException;
	
}
 