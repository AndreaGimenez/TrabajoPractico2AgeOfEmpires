package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.movimiento.Direccion;

public class MovimientoNulo implements Movimiento {

	@Override
	public void mover(Movible movimiento, Direccion direccion, Mapa mapa)
			throws MovimientoInvalidoException {
		
		throw new MovimientoInvalidoException();
	}
}
