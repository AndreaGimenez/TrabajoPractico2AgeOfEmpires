package fiuba.algo3.tp2.edificios;

import fiuba.algo3.tp2.movimiento.Posicionable;
import fiuba.algo3.tp2.posicion.Posicion;

public abstract class Edificio implements Posicionable{

	private Posicion posicion;
	private Integer vida;
	
	public Edificio(Integer vida) {
		this.vida = vida;
	}
	
	public Integer obtenerVida() {
		return vida;
	}

	public void reducirVida(Integer vidaAReducir) {
		vida -= vidaAReducir;
	}

	@Override
	public void posicionar(Posicion posicion) {
		this.posicion = posicion;
	}
}
