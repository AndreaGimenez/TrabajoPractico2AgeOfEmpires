package fiuba.algo3.tp2.movimiento;

import java.math.BigDecimal;

import fiuba.algo3.tp2.posicion.Posicion;

public class MovimientoImpl implements Movimiento {
	
	protected BigDecimal velocidadMovimiento;
	
	@Override
	public void mover(Posicion posicionInicial, Direccion direccion) {
		
		posicionInicial.desplazar(direccion, velocidadMovimiento);
	}
}
