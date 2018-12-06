package fiuba.algo3.tp2.vida;

import fiuba.algo3.tp2.excepciones.UnidadMuertaException;

public class VidaUnidad{
	
	private int vidaActual;
	
	public VidaUnidad(int vidaMaxima) {
		this.vidaActual = vidaMaxima;
	}
	
	public int obtenerVida() {
		return this.vidaActual;
	}
	
	public void restarVida(int danio) {
		
		if(vidaActual == 0) {
			throw new UnidadMuertaException();
		}
		
		vidaActual -= danio;
		
		if(vidaActual <= 0) {
			vidaActual = 0;
		}
	}
	
	public boolean estaMuerta() {
		return vidaActual == 0;
	}
}
