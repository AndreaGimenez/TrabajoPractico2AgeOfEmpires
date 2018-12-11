package fiuba.algo3.tp2.construccion;

import fiuba.algo3.tp2.mapa.Mapa;

public interface Construible {
	public abstract void asignarConstructor(Constructor constructor);
	public boolean verificarConstructor(Constructor constructor);
	public boolean estaConstruido();
	public void avanzarConstruccion();
	public boolean estaEnElContornoDe(Constructor constructor);
	public void liberarCeldas(Mapa mapa);
}
