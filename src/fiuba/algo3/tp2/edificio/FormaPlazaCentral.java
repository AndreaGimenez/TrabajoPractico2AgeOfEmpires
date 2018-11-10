package fiuba.algo3.tp2.edificio;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.mapa.Coordenada;

public class FormaPlazaCentral {

	 private static final Integer LARGO = 2;
	 private static final Integer ANCHO = 2;
	 
	 private Collection<Coordenada> forma;
	 
	 public FormaPlazaCentral() {
		 
		 forma = new ArrayList<Coordenada>();
		 
		 for(int i = 0 ; i < LARGO ; i++) {
			 for(int j = 0; j < ANCHO ; j++) {
				 forma.add(new Coordenada(i,j));
			 }
		 }
	 }
	 
	 public Collection<Coordenada> obtenerCoordenadas(Coordenada coordenadaOrigen){
		 
		 Collection<Coordenada> posicionesADevolver = new ArrayList<Coordenada>();
		 
		 for(Coordenada coordenada : forma) {
			 posicionesADevolver.add(coordenada.sumar(coordenadaOrigen));
		 }
		 return posicionesADevolver;
	 }

}
