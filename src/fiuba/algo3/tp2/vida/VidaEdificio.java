package fiuba.algo3.tp2.vida;

import fiuba.algo3.tp2.excepciones.EdificioDestruidoException;

public class VidaEdificio {
	private int vidaActual;
	private int vidaMaxima;
	private int puntosDeRecuperacionPorTurno;
	
	public VidaEdificio(int vidaMaxima, int puntosDeRecuperacionPorTurno) {
		this.vidaActual = vidaMaxima;
		this.vidaMaxima = vidaMaxima;
		this.puntosDeRecuperacionPorTurno = puntosDeRecuperacionPorTurno;
	}
	
	public int obtenerVida() {
		return this.vidaActual;
	}

	public void restarVida(int danio) {
        if(vidaActual == 0) {
        	throw new EdificioDestruidoException();
        }
        
		if(vidaActual > danio) {
			vidaActual -= danio;
		}
		else {
			vidaActual = 0;
		}
	}

	public void recuperarVida() {
		
		if((vidaActual + puntosDeRecuperacionPorTurno) < vidaMaxima) {
			vidaActual += puntosDeRecuperacionPorTurno;
		}
		else {
			vidaActual = vidaMaxima;
		}
	}
	
	public boolean estaReparado() {
		return vidaActual == vidaMaxima;
	}
	
	public boolean estaDestruido() {
		return vidaActual == 0;
	}

	public int obtenerVidaMaxima() {
		return vidaMaxima;
	}
}

