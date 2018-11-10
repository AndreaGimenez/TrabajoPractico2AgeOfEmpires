package fiuba.algo3.tp2.mapa;

public class Celda {
	
	private boolean estaOcupada;
	
	public Celda() {
		estaOcupada = false;
	}

	public boolean estaOcupada() {
		return estaOcupada;
	}

	public void ocupar() throws CeldaOcupadaException {
		
		if (estaOcupada()) {
			throw new CeldaOcupadaException();
		}
		
		estaOcupada = true;
	}

	public void liberar() {
		
		estaOcupada = false;
	}
}
