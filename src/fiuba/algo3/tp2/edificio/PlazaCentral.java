package fiuba.algo3.tp2.edificio;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Coordenada;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;


public class PlazaCentral implements Posicionable {
	
	private FormaPlazaCentral forma;
	
	public PlazaCentral() {
		forma = new FormaPlazaCentral();
	}

	@Override
	public void posicionar(Coordenada coordenada, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		Collection<Coordenada> coordenadasAOcuparEnMapa = forma.obtenerCoordenadas(coordenada);
		
		for(Coordenada coordenadaPosicion : coordenadasAOcuparEnMapa){
			mapa.posicionar(this, coordenadaPosicion);
		}
	}
	
}
