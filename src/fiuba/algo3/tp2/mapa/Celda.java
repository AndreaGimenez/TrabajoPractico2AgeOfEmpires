package fiuba.algo3.tp2.mapa;

import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;

public class Celda {
	
	private Posicionable posicionable;
	
	public Celda() {
		posicionable = null;
	}
	
	public Posicionable obtenerPosicionable() {
		return posicionable;
	}

	public boolean estaOcupada() {
		return (posicionable != null);
	}

	public void ocupar(Posicionable posicionable) throws CeldaOcupadaException {
		
		if (estaOcupada()) {
			throw new CeldaOcupadaException();
		}
		
		this.posicionable = posicionable;
	}
	
	public void ocupar(Celda celda) throws CeldaOcupadaException {
		
		ocupar(celda.obtenerPosicionable());
	}

	public void liberar() {
		
		posicionable = null;
	}
}
