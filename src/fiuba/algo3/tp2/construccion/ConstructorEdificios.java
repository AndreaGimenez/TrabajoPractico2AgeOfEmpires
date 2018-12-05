package fiuba.algo3.tp2.construccion;

import fiuba.algo3.tp2.excepciones.EdificioNoSoportadoException;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioConstants.TipoEdificio;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;

public interface ConstructorEdificios {
	
	public void crear(Edificio edificio) 
			throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException;
}
