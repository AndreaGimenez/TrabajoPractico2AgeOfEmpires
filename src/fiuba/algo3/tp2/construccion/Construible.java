package fiuba.algo3.tp2.construccion;

public interface Construible {
	public abstract void asignarConstructor(Constructor constructor);
	public boolean verificarConstructor(Constructor constructor);
	public boolean estaConstruido();
	public void avanzarConstruccion();

}
