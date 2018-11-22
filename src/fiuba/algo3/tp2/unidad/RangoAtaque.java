package fiuba.algo3.tp2.unidad;

import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;

public abstract class RangoAtaque {

	protected abstract Collection<Posicion> obtenerPosicionesRango(Posicionable atacante);
	
	public boolean estaEnRango(Posicionable atacante, Posicionable atacado) {
		
		boolean estaEnRango = false;
		
		Collection<Posicion> posicionesOcupadasPorAtacado = atacado.obtenerPosicionesOcupadasEnMapa();
		Collection<Posicion> posicionesRango = obtenerPosicionesRango(atacante);
		
		
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
