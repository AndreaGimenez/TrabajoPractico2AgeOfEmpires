package fiuba.algo3.tp2.mapa;

import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.vista.VistaPosicionable;

public class Celda {
	
	private Posicionable posicionable;
	private VistaPosicionable vistaPosicionable;
	
	public Celda() {
		posicionable = null;
		vistaPosicionable = null;
	}
	
	public void ocupar(Posicionable posicionable) throws CeldaOcupadaException {
		
		if (estaOcupada()) {
			throw new CeldaOcupadaException();
		}
		
		this.posicionable = posicionable;
	}
	
	public void agregarVistaPosicionable(VistaPosicionable vistaPosicionable){
		
		this.vistaPosicionable = vistaPosicionable;
	}
	
	public Posicionable obtenerPosicionable() {
		return posicionable;
	}

	public boolean estaOcupada() {
		return (posicionable != null);
	}
	
	public void ocupar(Celda celdaOrigen) throws CeldaOcupadaException {
		
		ocupar(celdaOrigen.obtenerPosicionable());
		agregarVistaPosicionable(celdaOrigen.obtenerVistaPosicionable());
	}

	public VistaPosicionable obtenerVistaPosicionable() {
		return vistaPosicionable;
	}

	public void liberar() {
		posicionable = null;
		vistaPosicionable = null;
	}
}
