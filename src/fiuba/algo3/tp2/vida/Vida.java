package fiuba.algo3.tp2.vida;

import fiuba.algo3.tp2.unidad.Ataque;
import fiuba.algo3.tp2.unidad.UnidadMuertaException;

public abstract class Vida {
	
	private int vida;
	private int vidaMaxima;

	public Vida(int vidaMaxima) {
		
		this.vida = vidaMaxima;
		this.vidaMaxima = vidaMaxima;
		
	}

	public void recibirDanio(Ataque ataque) {
		
		if(vida == 0) {
			throw new UnidadMuertaException();
		}
		vida -= ataque.obtenerDanioUnidad();
		
		if(vida < 0) {
			vida = 0;
		}
	}

}
