package fiuba.algo3.tp2.formas;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.mapa.Posicion;

public class FormaRectangulo extends Forma {
	
	protected Collection<Posicion> forma;
	protected Integer largo;
	protected Integer ancho;
	
	public FormaRectangulo(Integer largo, Integer ancho) {
		this.largo = largo ;
		this.ancho = ancho;
	}
	 
	@Override
	public Collection<Posicion> obtenerPosiciones(Posicion coordenadaOrigen) {
			 
			 Collection<Posicion> posicionesADevolver = new ArrayList<Posicion>();
			 
			 for(Posicion coordenada : forma) {
				 posicionesADevolver.add(coordenada.sumar(coordenadaOrigen));
			 }
			 return posicionesADevolver;
	}

	@Override
	public Collection<Posicion> obtenerPosicionesContorno(Posicion posicion) {
		// TODO Auto-generated method stub
		Integer posicionInicialEnX = posicion.getX();
		Integer posicionInicialEnY = posicion.getY();
		
		Collection<Posicion> contorno = new ArrayList<Posicion>();
		
		//Contorno vertical izquierdo
		for(int i = posicionInicialEnY ; i <= (posicionInicialEnY + ancho) ; i++) {
			contorno.add(new Posicion(posicionInicialEnX-1,i));
		}
		
		//contorno horizontal superior
		for(int i = posicionInicialEnX ; i <= (posicionInicialEnX + largo) ; i ++) {
			contorno.add(new Posicion(i,posicionInicialEnY + ancho));
		}
		
		//contorno vertical derecho
		for(int i = posicionInicialEnY-1 ; i < (posicionInicialEnY + ancho) ; i++) {
			contorno.add(new Posicion(posicionInicialEnX+largo,i));
		}
		
		//contorno horizontal inferior
		for(int i = posicionInicialEnX-1 ; i < (posicionInicialEnX+largo) ; i++) {
			contorno.add(new Posicion(i,posicionInicialEnY-1));
		}
		
		return contorno;
	}
}
