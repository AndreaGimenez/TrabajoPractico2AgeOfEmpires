package fiuba.algo3.tp2.unidad;

import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;

public abstract class Rango {
	
	public abstract Collection<Posicion> obtenerPosicionesRango(Posicionable atacante);
	
	public boolean estaEnRango(Posicionable posicionableOrigen, Posicionable posicionableDestino) {
		
		boolean estaEnRango = false;
		
		Collection<Posicion> posicionesOcupadasPorAtacado = posicionableDestino.obtenerPosicionesOcupadasEnMapa();
		Collection<Posicion> posicionesRango = obtenerPosicionesRango(posicionableOrigen);
		
		
		Iterator<Posicion> posicionesRangoIterator = posicionesRango.iterator();
		
		while(posicionesRangoIterator.hasNext() && !estaEnRango) {
			
			Posicion posicionRango = posicionesRangoIterator.next();
			Iterator<Posicion> posicionesOcupadasPorAtacadoIterator = posicionesOcupadasPorAtacado.iterator();
			while(posicionesOcupadasPorAtacadoIterator.hasNext() && !estaEnRango) {
				
				Posicion posicionOcupadaPorAtacado = posicionesOcupadasPorAtacadoIterator.next();
				estaEnRango = (posicionRango.esIgualA(posicionOcupadaPorAtacado));
			}
		}
		
		return estaEnRango;
	}
}
