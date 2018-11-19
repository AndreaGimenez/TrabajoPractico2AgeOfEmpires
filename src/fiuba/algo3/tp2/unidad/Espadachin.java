package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.formas.FormaEspadachinRectangulo;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.MovimientoBasico;

public class Espadachin extends Unidad{
	private static final int VIDA_MAXIMA = 100;
	
	public Espadachin(Posicion posicion, Mapa mapa)
			throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, mapa, new MovimientoBasico(), new FormaEspadachinRectangulo(), VIDA_MAXIMA);
	}

	@Override
	public void siguienteAccion() {

	}

	public void atacar(Aldeano aldeano) {
		
		aldeano.recibirDanio(25);
	}
}
