package fiuba.algo3.tp2.vida;

import fiuba.algo3.tp2.unidad.Ataque;

public abstract class Vida {

	public abstract int obtenerVidaActual();

	public abstract void recibirDanio(Ataque ataque);

	public abstract void curar();



}
