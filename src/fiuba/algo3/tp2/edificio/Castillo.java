package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.formas.FormaCastilloRectangulo;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.excepciones.reparacion.ReparacionDesactivada;

public class Castillo extends Edificio implements /*GeneradorUnidades,*/ AtacadorZona {
	
	private static final int VIDA_MAXIMA = 1000;
	private static final int SALUD_RECUPERADA_POR_TURNO = 15;
	private static final int COSTO_CONSTRUCCION = 0;
	//private CreadorUnidad generadorUnidades;
	private AtaqueZona ataque;
	
	public Castillo(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, new FormaCastilloRectangulo(), new ReparacionDesactivada(), VIDA_MAXIMA, SALUD_RECUPERADA_POR_TURNO, COSTO_CONSTRUCCION, mapa);
		//this.generadorUnidades = new CreadorUnidadCastillo(mapa);
		this.ataque = new AtaqueCastillo(this, mapa);
	}

	@Override
	public void actualizarEstadoParaSiguienteTurno() {

	}

	@Override
	public void atacar() {
		ataque.atacar();
	}
}
