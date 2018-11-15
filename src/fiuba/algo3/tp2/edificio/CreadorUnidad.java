package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public interface CreadorUnidad {

	public Unidad crear(TipoUnidad tipoUnidad) 
			throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException;
}
