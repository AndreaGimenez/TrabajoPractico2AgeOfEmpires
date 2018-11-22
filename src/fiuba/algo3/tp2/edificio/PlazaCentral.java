package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.formas.FormaPlazaCentralRectangulo;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.reparacion.ReparacionDesactivada;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class PlazaCentral extends Edificio implements GeneradorUnidades {
	
	private static final int VIDA_MAXIMA = 450;
	private static final int SALUD_RECUPERADA_POR_TURNO = 25;
	
	private CreadorUnidad creadorUnidades;
	
	public PlazaCentral(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, new FormaPlazaCentralRectangulo(), new ReparacionDesactivada(), VIDA_MAXIMA, SALUD_RECUPERADA_POR_TURNO, mapa);
		this.creadorUnidades = new CreadorUnidadPlazaCentral(mapa);
	}

	@Override
	public Unidad crear(TipoUnidad tipoUnidad, Posicion posicion) 
			throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {

		return this.creadorUnidades.crear(tipoUnidad, posicion);
	}

	@Override
	public void siguienteAccion() {

	}

}
