package fiuba.algo3.tp2.unidades;

import fiuba.algo3.tp2.movimiento.Posicionable;
import fiuba.algo3.tp2.posicion.Posicion;

public abstract class Unidad implements Posicionable{

	protected Posicion posicion;
	
	@Override
	public void posicionar(Posicion posicion) {
		this.posicion = posicion;
	}
}
