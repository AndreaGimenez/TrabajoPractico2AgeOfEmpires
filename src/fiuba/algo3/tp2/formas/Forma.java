package fiuba.algo3.tp2.formas;

import java.util.Collection;

import fiuba.algo3.tp2.mapa.Posicion;

public abstract class Forma {

	public abstract Collection<Posicion> obtenerCoordenadas(Posicion coordenada);

	public abstract Collection<Posicion> obtenerPosicionesContorno(Posicion posicion);

	protected Collection<Posicion> obtenerPosicionesContorno() {
		// TODO Auto-generated method stub
		return null;
	}
}
