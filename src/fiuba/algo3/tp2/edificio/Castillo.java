package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.formas.FormaCastilloRectangulo;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.reparacion.ReparacionDesactivada;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class Castillo extends Edificio implements GeneradorUnidades, AtacadorZona {
	
	private static final int VIDA_MAXIMA = 1000;
	private static final int SALUD_RECUPERADA_POR_TURNO = 15;
	private CreadorUnidad generadorUnidades;
	private AtaqueZona ataque;

	public Castillo(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, new FormaCastilloRectangulo(), new ReparacionDesactivada(), VIDA_MAXIMA, SALUD_RECUPERADA_POR_TURNO, mapa);
		this.generadorUnidades = new CreadorUnidadCastillo(mapa);
		ataque = new AtaqueCastillo(this, mapa);
	}

	@Override
	public Unidad crear(TipoUnidad tipoUnidad, Posicion posicion)
			throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {

		return this.generadorUnidades.crear(tipoUnidad, posicion);
	}

	@Override
	public int costo() {

		return 0;
	}

	@Override
	public boolean estaReparado() {
		return this.VIDA_MAXIMA == super.obtenerVida();
	}

	@Override
	public void actualizarEstadoParaNuevoTurno() {

	}

	@Override
	public void atacar() {
		ataque.atacar();
	}
}
