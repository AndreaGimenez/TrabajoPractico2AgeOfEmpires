package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Coordenada;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Direccion;

public class Aldeano implements Posicionable{
	
	Coordenada posicion;
	
	
	@Override
	public void posicionar(Coordenada coordenada, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		mapa.posicionar(this, coordenada);
		this.posicion = coordenada;
	}

	public void mover(Direccion direccion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {

		this.posicionar(this.posicion.sumar(direccion), mapa);
	}
}
