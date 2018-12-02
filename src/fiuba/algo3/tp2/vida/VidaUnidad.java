package fiuba.algo3.tp2.vida;

import fiuba.algo3.tp2.excepciones.UnidadMuertaException;
import fiuba.algo3.tp2.unidad.Ataque;

public class VidaUnidad extends Vida {

	private int vidaMaxima;
	private int vidaActual;

	public VidaUnidad(int vidaMaxima2) {
		
		this.vidaMaxima = vidaMaxima2;
		this.vidaActual = vidaMaxima2;
	}
	@Override
	public int obtenerVidaActual() {
		
		return vidaActual;
	}
	@Override
	public void recibirDanio(Ataque ataque) {
		
		if(this.vidaActual==0) {
			throw new UnidadMuertaException();
		}
		
		this.vidaActual -= ataque.obtenerDanioUnidad();
		
		if(this.vidaActual < 0) {
			this.vidaActual = 0;
		}
	}
	@Override
	public void curar() {
		// TODO Auto-generated method stub
		
	}

}
