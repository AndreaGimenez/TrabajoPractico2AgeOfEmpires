package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;
import fiuba.algo3.tp2.formas.FormaEspadachinRectangulo;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
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
	public void siguienteAccion() {
		movimiento = new MovimientoBasico();
	}

	@Override
	public void atacar(Atacable atacable) throws AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException {
		ataque.atacar(this, atacable);
	}
}
