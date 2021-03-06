/*package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
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
	public Unidad crear(TipoUnidad tipoUnidad, Posicion posicion) 
			throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		Unidad unidadADevolver;
		
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
	
}
*/