package fiuba.algo3.tp2.mapa;

public class Celda {
	
	private Posicionable posicionable;
	
	public Celda() {
		posicionable = null;
	}
	
	private Posicionable getPosicionable() {
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
		
		ocupar(celda.getPosicionable());
	}

	public void liberar() {
		
		posicionable = null;
	}
}