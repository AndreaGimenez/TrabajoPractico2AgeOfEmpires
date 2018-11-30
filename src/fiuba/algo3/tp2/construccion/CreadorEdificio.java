package fiuba.algo3.tp2.construccion;

import fiuba.algo3.tp2.excepciones.EdificioNoSoportadoException;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioConstants.TipoEdificio;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;

public interface CreadorEdificio {
	
	public Edificio crear(TipoEdificio tipoEdificio) 
			throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException;
}
