package fiuba.algo3.tp2.mapa;

import java.util.Collection;

import fiuba.algo3.tp2.edificio.FormaCastillo;

public class Castillo implements Posicionable {
	
	private FormaCastillo forma;
	
	public Castillo() {
		forma = new FormaCastillo();
	}
	/*
	 * La coordenada es la celda inferior izquierda del edificio
	 */
	@Override
	public void posicionar(Coordenada coordenada, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		Collection<Coordenada> coordenadasAOcuparEnMapa = forma.obtenerCoordenadas(coordenada);
		
		for(Coordenada coordenadaPosicion : coordenadasAOcuparEnMapa) {
			mapa.posicionar(this, coordenadaPosicion);
		}
	}
}
