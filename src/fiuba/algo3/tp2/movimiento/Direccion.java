package fiuba.algo3.tp2.movimiento;

import fiuba.algo3.tp2.espacio.punto.Coordenada;
import fiuba.algo3.tp2.posicion.Posicion;

public interface Direccion extends Coordenada {

	public abstract Posicion mover(Posicion posicion, Integer velocidadMovimiento);
}
