package fiuba.algo3.tp2.vida;

import fiuba.algo3.tp2.excepciones.EdificioDestruidoException;
import fiuba.algo3.tp2.unidad.Ataque;

public class VidaEdificio extends Vida {

	private int vidaMaxima;
	private int vidaActual;
	private int puntosDeRecuperacion;

	public VidaEdificio(int vidaMaxima, int saludRecuperadaPorTurno) {
		
		this.vidaMaxima = vidaMaxima;
		this.vidaActual = vidaMaxima;
		this.puntosDeRecuperacion = saludRecuperadaPorTurno;
	}
	@Override
	public int obtenerVidaActual() {
		
		return vidaActual;
	}
	@Override
	public void recibirDanio(Ataque ataque) {
		
		if(this.vidaActual==0) {
			throw new EdificioDestruidoException();
		}
		
		this.vidaActual -= ataque.obtenerDanioEdificio();
		
		if(this.vidaActual < 0) {
			this.vidaActual = 0;
		}
	}
	
	@Override
	public void curar() {
		
		if(this.vidaActual > this.vidaMaxima - this.puntosDeRecuperacion)
	        this.vidaActual = this.vidaMaxima;
	    else
	        this.vidaActual = this.vidaActual + this.puntosDeRecuperacion;
	}

}
