package Construccion;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioConstants;
import fiuba.algo3.tp2.edificio.EdificioConstants.TipoEdificio;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;

public interface CreadorEdificio {
	
	Edificio crear(TipoEdificio tipoEdificio)
			throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException;
}
