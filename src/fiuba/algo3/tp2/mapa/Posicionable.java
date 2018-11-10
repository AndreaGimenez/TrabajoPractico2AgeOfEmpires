package fiuba.algo3.tp2.mapa;

public interface Posicionable {

	public void posicionar(Coordenada coordenada, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException;
}
