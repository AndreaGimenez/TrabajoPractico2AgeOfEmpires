package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.excepciones.*;
import fiuba.algo3.tp2.formas.FormaArqueroRectangulo;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.MovimientoBasico;

public class Arquero extends Unidad implements Atacador {
	
	private static final int DANIO_UNIDAD = 15;
	private static final int VIDA_MAXIMA = 75;
	private static final int COSTO_GENERACION = 75;
	
	private Ataque ataque;
	
	public Arquero(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		super(posicion, mapa, new MovimientoBasico(), new FormaArqueroRectangulo(), VIDA_MAXIMA, COSTO_GENERACION);
		ataque = new AtaqueArquero();
	}

	@Override
	public void actualizarEstadoParaSiguienteTurno() {
		movimiento = new MovimientoBasico();
		ataque = new AtaqueArquero();
	}

	@Override
	public void atacar(Atacable atacable) throws AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException, AtaqueInvalidoException {
		ataque.atacar(this, atacable);
		ataque = new AtaqueNulo();
	}

}
