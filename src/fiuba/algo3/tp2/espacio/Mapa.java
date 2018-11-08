package fiuba.algo3.tp2.espacio;

import java.math.BigDecimal;

import fiuba.algo3.tp2.espacio.punto.Punto;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicionable;
import fiuba.algo3.tp2.posicion.Posicion;

public class Mapa implements Espacio {
	
	private static Mapa INSTANCE = null;
	
	public Mapa(){}
	 
	private static void createInstance() {
		if (INSTANCE == null) { 
			INSTANCE = new Mapa();
		}
	}
	
	public static Mapa getInstance() {
		if (INSTANCE == null) createInstance();
			return INSTANCE;
	}

	@Override
	public void posicionar(Posicionable posicionable, Posicion nuevaPosicion) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Punto desplazarContenido(Punto punto, Direccion direccion, BigDecimal incremento) {
		return null;
	}
}
