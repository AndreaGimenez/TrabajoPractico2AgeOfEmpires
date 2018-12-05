package fiuba.algo3.tp2.unidad;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;

public class RangoAtaqueArquero extends RangoAtaque {

	private int rango = 3;
	
	@Override
	public Collection<Posicion> obtenerPosicionesRango(Posicionable atacante) {
		
		Collection<Posicion> posicionesRango = new ArrayList<Posicion>();
		
		for(int i = 1; i <= rango; i++) {
			posicionesRango.addAll(obtenerPosicionesADistancia(atacante.obtenerPosicion(), i));
		}
		
		return posicionesRango;
	}
	
	private Collection<Posicion> obtenerPosicionesADistancia(Posicion posicion, int distancia) {
		
		Collection<Posicion> posicionesADistancia = new ArrayList<Posicion>();
		
		Integer posicionInicialEnX = posicion.getX();
		Integer posicionInicialEnY = posicion.getY();
		
		for(int i = posicionInicialEnX - (distancia - 1); i <= posicionInicialEnX + (distancia - 1); i++) {
			posicionesADistancia.add(new Posicion(i, posicionInicialEnY + distancia));
			posicionesADistancia.add(new Posicion(i, posicionInicialEnY - distancia));
		}
		
		for(int i = posicionInicialEnY - (distancia - 1); i <= posicionInicialEnX + (distancia - 1); i++) {
			posicionesADistancia.add(new Posicion(posicionInicialEnX + distancia, i));
			posicionesADistancia.add(new Posicion(posicionInicialEnX - distancia, i));
		}
		
		posicionesADistancia.add(new Posicion(posicionInicialEnX - distancia, posicionInicialEnY - distancia));
		posicionesADistancia.add(new Posicion(posicionInicialEnX - distancia, posicionInicialEnY + distancia));
		posicionesADistancia.add(new Posicion(posicionInicialEnX + distancia, posicionInicialEnY + distancia));
		posicionesADistancia.add(new Posicion(posicionInicialEnX + distancia, posicionInicialEnY - distancia));
		
		return posicionesADistancia;
	}
}
