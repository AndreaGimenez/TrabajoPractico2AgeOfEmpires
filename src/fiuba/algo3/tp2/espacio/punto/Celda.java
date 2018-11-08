package fiuba.algo3.tp2.espacio.punto;

import fiuba.algo3.tp2.movimiento.Posicionable;

public class Celda implements Punto {

	private Coordenada coordenada;
	private Posicionable posicionable;
	
	public Celda(Coordenada coordenada) {
		this.coordenada = coordenada;
		this.posicionable = null;
	}
}
