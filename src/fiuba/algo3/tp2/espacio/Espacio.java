package fiuba.algo3.tp2.espacio;

import java.math.BigDecimal;

import fiuba.algo3.tp2.espacio.punto.Punto;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicionable;
import fiuba.algo3.tp2.posicion.Posicion;

public interface Espacio {
	
	public void posicionar(Posicionable posicionable, Posicion nuevaPosicion);
	public Punto desplazarContenido(Punto punto, Direccion direccion, BigDecimal incremento);
}
