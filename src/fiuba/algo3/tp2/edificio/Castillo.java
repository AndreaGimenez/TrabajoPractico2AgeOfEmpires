package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class Castillo extends Edificio implements GeneradorUnidades {
	
	private CreadorUnidad generadorUnidades;

	public Castillo(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, new FormaCastilloRectangulo(), mapa);
		this.generadorUnidades = new CreadorUnidadCastillo(mapa);
	}

	@Override
	public Unidad crear(TipoUnidad tipoUnidad)
			throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		return generadorUnidades.crear(tipoUnidad);
	}
}
