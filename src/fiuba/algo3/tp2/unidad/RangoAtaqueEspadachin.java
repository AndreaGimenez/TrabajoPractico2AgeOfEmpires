package fiuba.algo3.tp2.unidad;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;

public class RangoAtaqueEspadachin extends RangoAtaque {

	private int ancho = 1;
	private int largo = 1;
	
	@Override
	public Collection<Posicion> obtenerPosicionesRango(Posicionable atacante) {
		
		Integer posicionInicialEnX = atacante.obtenerPosicion().getX();
		Integer posicionInicialEnY = atacante.obtenerPosicion().getY();
		
		Collection<Posicion> posicionesRango = new ArrayList<Posicion>();
		
		//Contorno vertical izquierdo
		for(int i = posicionInicialEnY ; i <= (posicionInicialEnY + ancho) ; i++) {
			posicionesRango.add(new Posicion(posicionInicialEnX-1,i));
		}
		
		//contorno horizontal superior
		for(int i = posicionInicialEnX ; i <= (posicionInicialEnX + largo) ; i ++) {
			posicionesRango.add(new Posicion(i,posicionInicialEnY + ancho));
		}
		
		//contorno vertical derecho
		for(int i = posicionInicialEnY-1 ; i < (posicionInicialEnY + ancho) ; i++) {
			posicionesRango.add(new Posicion(posicionInicialEnX+largo,i));
		}
		
		//contorno horizontal inferior
		for(int i = posicionInicialEnX-1 ; i < (posicionInicialEnX+largo) ; i++) {
			posicionesRango.add(new Posicion(i,posicionInicialEnY-1));
		}
		
		return posicionesRango;
	}
}
