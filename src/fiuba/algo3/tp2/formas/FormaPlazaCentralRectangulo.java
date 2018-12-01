package fiuba.algo3.tp2.formas;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.mapa.Posicion;

public class FormaPlazaCentralRectangulo extends Forma {

	 private static final Integer LARGO = 2;
	 private static final Integer ANCHO = 2;
	 
	 private Collection<Posicion> forma;
	 
	 public FormaPlazaCentralRectangulo() {
		 
		 forma = new ArrayList<Posicion>();
		 
		 for(int i = 0 ; i < LARGO ; i++) {
			 for(int j = 0; j < ANCHO ; j++) {
				 forma.add(new Posicion(i,j));
			 }
		 }
	 }
	 
	 @Override
	 public Collection<Posicion> obtenerPosiciones(Posicion coordenadaOrigen){
		 
		 Collection<Posicion> posicionesADevolver = new ArrayList<Posicion>();
		 
		 for(Posicion coordenada : forma) {
			 posicionesADevolver.add(coordenada.sumar(coordenadaOrigen));
		 }
		 return posicionesADevolver;
	 }

	@Override
	public Collection<Posicion> obtenerPosicionesContorno(Posicion posicion) {
		// TODO Auto-generated method stub
		return null;
	}

}
