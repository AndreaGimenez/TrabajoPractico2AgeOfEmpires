package fiuba.algo3.tp2.movimiento;

import fiuba.algo3.tp2.mapa.Mapa;

public interface Movimiento {

	public void mover(Movible movimiento, Direccion direccion, Mapa mapa) throws MovimientoInvalidoException;

}
