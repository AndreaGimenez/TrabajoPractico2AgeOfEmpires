package fiuba.algo3.tp2.posicion;

import java.math.BigDecimal;
import java.util.Collection;

import fiuba.algo3.tp2.espacio.Mapa;
import fiuba.algo3.tp2.espacio.punto.Punto;
import fiuba.algo3.tp2.movimiento.Direccion;

public class PosicionImpl implements Posicion {

	private Collection<Punto> puntos;
	
	
	public PosicionImpl(Collection<Punto> puntos) {
		this.puntos = puntos;
	}
	
	public void desplazar(Direccion direccion, BigDecimal incremento) {
		
		for(Punto punto : puntos) {
			punto = Mapa.getInstance().desplazarContenido(punto, direccion, incremento);
		}
	}
}
