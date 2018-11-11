package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Coordenada;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Direccion;

public interface Movible extends Posicionable{

	public void mover(Direccion direccion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException;
	public void desplazar(Coordenada posicion, Mapa mapa) throws CeldaOcupadaException;
}
