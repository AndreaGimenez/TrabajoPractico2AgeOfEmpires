package fiuba.algo3.tp2.edificio;

import java.util.Collection;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Coordenada;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;

public abstract class Edificio implements Posicionable {

	private Coordenada posicion;
	private Forma forma;
	
	/*
	 * La coordenada es la celda inferior izquierda del edificio
	 */
	public Edificio(Coordenada posicion, Forma forma, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		this.forma = forma;
		posicionar(posicion, mapa);
	}
	
	@Override
	public void posicionar(Coordenada coordenada, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		Collection<Coordenada> coordenadasAOcuparEnMapa = forma.obtenerCoordenadas(coordenada);
		
		for(Coordenada coordenadaPosicion : coordenadasAOcuparEnMapa) {
			mapa.posicionar(this, coordenadaPosicion);
		}
		this.posicion = coordenada;
	}
	
	@Override
	public Coordenada getPosicion() {
		return posicion;
	}	
}
