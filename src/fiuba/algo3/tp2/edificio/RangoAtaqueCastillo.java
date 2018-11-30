package fiuba.algo3.tp2.edificio;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.RangoAtaque;

public class RangoAtaqueCastillo extends RangoAtaque {

	private int rango = 3;
	private int ancho = 4;
	private int largo = 4;
	private Mapa mapa;
	
	public RangoAtaqueCastillo(Mapa mapa) {
		this.mapa = mapa;
	}
	
	@Override
	public Collection<Posicion> obtenerPosicionesRango(Posicionable atacante) {
		
		Collection<Posicion> posicionesInvalidas = new ArrayList<Posicion>();
		Collection<Posicion> posicionesRango = new ArrayList<Posicion>();
		
		for(int i = 1; i <= rango; i++) {
			
			posicionesRango.addAll(obtenerPosicionesADistancia(atacante.obtenerPosicion(), i));
		}
		
		for(Posicion posicion : posicionesRango) {
			try {
				mapa.verificarCelda(posicion);
			}catch(CeldaInexistenteException e) {
				posicionesInvalidas.add(posicion);
			}
		}
		posicionesRango.removeAll(posicionesInvalidas);
		return posicionesRango;
	}
	
	private Collection<Posicion> obtenerPosicionesADistancia(Posicion posicion, int distancia) {
		
		Collection<Posicion> posicionesADistancia = new ArrayList<Posicion>();
		
		Integer posicionInicialEnX = posicion.getX();
		Integer posicionInicialEnY = posicion.getY();
		
		for(int i = posicionInicialEnX - (distancia - 1); i <= posicionInicialEnX + (ancho - 1) + (distancia - 1); i++) {
			posicionesADistancia.add(new Posicion(i, posicionInicialEnY + (largo - 1) + distancia));
			posicionesADistancia.add(new Posicion(i, posicionInicialEnY - distancia));
		}
		
		for(int i = posicionInicialEnY - (distancia - 1); i <= posicionInicialEnX + (largo - 1) + (distancia - 1); i++) {
			posicionesADistancia.add(new Posicion(posicionInicialEnX + (ancho - 1) + distancia, i));
			posicionesADistancia.add(new Posicion(posicionInicialEnX - distancia, i));
		}
		
		posicionesADistancia.add(new Posicion(posicionInicialEnX - distancia, posicionInicialEnY - distancia));
		posicionesADistancia.add(new Posicion(posicionInicialEnX - distancia, posicionInicialEnY + (largo - 1) + distancia));
		posicionesADistancia.add(new Posicion(posicionInicialEnX + (ancho - 1) + distancia, posicionInicialEnY + ( largo - 1) + distancia));
		posicionesADistancia.add(new Posicion(posicionInicialEnX + (ancho - 1) + distancia, posicionInicialEnY - distancia));
		
		return posicionesADistancia;
	}
}
