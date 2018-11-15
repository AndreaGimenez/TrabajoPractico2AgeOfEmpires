package fiuba.algo3.tp2.formas;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.mapa.Posicion;

public class FormaCastilloRectangulo extends FormaRectangulo {
	 
	 private static final Integer LARGO = 4;
	 private static final Integer ANCHO = 4;
	 
	 public FormaCastilloRectangulo(){
		 
		 super(LARGO, ANCHO);
		 
		 forma = new ArrayList<Posicion>();
		 
		 for(int i = 0 ; i < LARGO ; i++) {
			 for(int j = 0; j < ANCHO ; j++) {
				 forma.add(new Posicion(i,j));
			 }
		 }
	 }
}
