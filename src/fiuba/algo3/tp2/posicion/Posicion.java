package fiuba.algo3.tp2.posicion;

import java.math.BigDecimal;

import fiuba.algo3.tp2.movimiento.Direccion;

public interface Posicion {

	public void desplazar(Direccion direccion, BigDecimal incremento);
}
