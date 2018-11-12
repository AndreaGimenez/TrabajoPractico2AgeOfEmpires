package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Direccion;

public interface Movible extends Posicionable{

	public void mover(Direccion direccion) throws MovimientoInvalidoException;
	public void desplazar(Posicion posicion) throws CeldaOcupadaException, CeldaInexistenteException;
}
