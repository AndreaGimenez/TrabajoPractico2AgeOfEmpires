package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.formas.FormaCastilloRectangulo;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.reparacion.ReparacionDesactivada;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class Castillo extends Edificio implements GeneradorUnidades {
	
	private CreadorUnidad generadorUnidades;
	private int puntosDeSaludPorReparacion = 15;

	public Castillo(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, new FormaCastilloRectangulo(), new ReparacionDesactivada(), mapa);
		this.generadorUnidades = new CreadorUnidadCastillo(mapa);
	}

	@Override
	public Unidad crear(TipoUnidad tipoUnidad, Posicion posicion)
			throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		return generadorUnidades.crear(tipoUnidad, posicion);
	}
}
