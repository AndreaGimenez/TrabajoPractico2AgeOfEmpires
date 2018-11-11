package fiuba.algo3.tp2.mapa;

public interface Posicionable {

	public void posicionar(Posicion coordenada, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException;
	public Posicion obtenerPosicion();
}
