package fiuba.algo3.tp2.construccion;

import fiuba.algo3.tp2.edificio.Edificio;

public class EstadoConstruccion {
	
	private Edificio edificio;
	private int turnosQueTardaEnCrearse;
	private int turnosDesdeQueSePosiciono;


	public EstadoConstruccion(Edificio edificio, int turnosQueTardaEnCrearse) {
		this.edificio = edificio;
		this.turnosQueTardaEnCrearse = turnosQueTardaEnCrearse;
		this.turnosDesdeQueSePosiciono = 0;
	}

	public boolean estaConstruido() {
		return turnosDesdeQueSePosiciono >= turnosQueTardaEnCrearse ;
	}

	public void avanzarConstruccion() {
		if(!estaConstruido()) {
			turnosDesdeQueSePosiciono += 1 ;
		}

	}

}
