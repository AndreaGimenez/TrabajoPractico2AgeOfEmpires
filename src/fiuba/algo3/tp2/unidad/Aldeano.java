package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Mapa;

public class Aldeano extends Unidad {
	
	public Aldeano(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, mapa, new MovimientoBasico());
	}

	public void construirCuartel(Posicion posicionOrigen) throws CeldaOcupadaException, CeldaInexistenteException {

		Cuartel cuartel = new Cuartel(posicionOrigen, super.obtenerMapa());

	}
}
