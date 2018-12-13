package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioDestruidoException;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;
import fiuba.algo3.tp2.formas.FormaEspadachinRectangulo;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.MovimientoBasico;

public class Espadachin extends Unidad implements Atacador {
	
	private static final int VIDA_MAXIMA = 100;
	private static final int COSTO_GENERACION = 50;
	
	private Ataque ataque;
	
	public Espadachin(Posicion posicion, Mapa mapa)
			throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, mapa, new MovimientoBasico(), new FormaEspadachinRectangulo(), VIDA_MAXIMA, COSTO_GENERACION);
		ataque = new AtaqueEspadachin();
	}

	@Override
	public void actualizarEstadoParaSiguienteTurno() {
		movimiento = new MovimientoBasico();
		ataque = new AtaqueEspadachin();
		
		setChanged();
		notifyObservers();
	}

	@Override
	public void atacar(Atacable atacable) throws AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException, AtaqueInvalidoException {
		ataque.atacar(this, atacable);
		ataque = new AtaqueNulo();
		
		setChanged();
		notifyObservers(ataque);
	}
}
