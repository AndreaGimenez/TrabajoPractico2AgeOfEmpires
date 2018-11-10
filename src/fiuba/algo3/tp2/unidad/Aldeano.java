package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Coordenada;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;

public class Aldeano implements Posicionable{

	@Override
	public void posicionar(Coordenada coordenada, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		mapa.posicionar(this, coordenada);
	}
}
