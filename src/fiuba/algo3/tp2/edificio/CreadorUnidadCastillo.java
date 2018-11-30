/*package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class CreadorUnidadCastillo implements CreadorUnidad {

	private Mapa mapa;

	public CreadorUnidadCastillo(Mapa mapa) {
		this.mapa = mapa;
	}

	@Override
	public Unidad crear(TipoUnidad tipoUnidad, Posicion posicion)
			throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		
		if(!tipoUnidad.equals(TipoUnidad.ARMA_ASEDIO)) {
			throw new UnidadNoSoportadaException();
		}
		return new ArmaAsedio(posicion, mapa);
	}

}
*/