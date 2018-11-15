package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class CreadorUnidadCuartel implements CreadorUnidad {

	private Mapa mapa;
	
	public CreadorUnidadCuartel(Mapa mapa) {
		this.mapa = mapa;
	}
	
	@Override
	public Unidad crear(TipoUnidad tipoUnidad) 
			throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		Unidad unidadADevolver = null;
		Posicion posicion = determinarPosicionCreacion();
		
		switch(tipoUnidad) {
		case ESPADACHIN:
			unidadADevolver = new Espadachin(posicion, mapa);
			break;
		case ARQUERO:
			unidadADevolver = new Arquero(posicion, mapa);
			break;
		default:
			throw new UnidadNoSoportadaException();
		}
		
		return unidadADevolver;
	}
	
	private Posicion determinarPosicionCreacion() {
		return new Posicion(3,1);
	}
}
