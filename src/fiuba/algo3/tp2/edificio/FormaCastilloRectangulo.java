package fiuba.algo3.tp2.edificio;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.mapa.Posicion;

public class FormaCastilloRectangulo extends Forma {
	 
	 private static final Integer LARGO = 4;
	 private static final Integer ANCHO = 4;
	 
	 private Collection<Posicion> forma;
	 
	 public FormaCastilloRectangulo(){
		 
		 forma = new ArrayList<Posicion>();
		 
		 for(int i = 0 ; i < LARGO ; i++) {
			 for(int j = 0; j < ANCHO ; j++) {
				 forma.add(new Posicion(i,j));
			 }
		 }
	 }
	 
	 @Override
	 public Collection<Posicion> obtenerCoordenadas(Posicion coordenadaOrigen){
		 
		 Collection<Posicion> posicionesADevolver = new ArrayList<Posicion>();
		 
		 for(Posicion coordenada : forma) {
			 posicionesADevolver.add(coordenada.sumar(coordenadaOrigen));
		 }
		 return posicionesADevolver;
	 }
}
