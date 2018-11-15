package fiuba.algo3.tp2.movimiento;

import fiuba.algo3.tp2.mapa.Mapa;

public class MovimientoNulo implements Movimiento {

	@Override
	public void mover(Movible movimiento, Direccion direccion, Mapa mapa)
			throws MovimientoInvalidoException {
		
		throw new MovimientoInvalidoException();
	}
}
