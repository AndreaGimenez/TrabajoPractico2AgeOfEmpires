package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.formas.FormaAldeanoRectangulo;
import fiuba.algo3.tp2.formas.FormaArmaAsedioRectangulo;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.MovimientoBasico;
import fiuba.algo3.tp2.movimiento.MovimientoNulo;

public class ArmaAsedio extends Unidad {
	
	private static final int VIDA_MAXIMA = 150;
	boolean montada;
	
	public ArmaAsedio(Posicion posicion, Mapa mapa)
			throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, mapa, new MovimientoBasico(), new FormaArmaAsedioRectangulo(), VIDA_MAXIMA);
	}

	public void montar() {
		this.movimiento = new MovimientoNulo();
	}

	public void desmontar() {
		this.movimiento = new MovimientoBasico();
	}

	@Override
	public void siguienteAccion() {

	}
}
