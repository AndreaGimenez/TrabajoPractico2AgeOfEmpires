package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;

public class ArmaAsedio extends Unidad {

	boolean montada;
	
	public ArmaAsedio(Posicion posicion, Mapa mapa)
			throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion,null, mapa, new MovimientoBasico());
	}

	public void montar() {
		this.movimiento = new MovimientoNulo();
	}

	public void desmontar() {
		this.movimiento = new MovimientoBasico();
	}
}
