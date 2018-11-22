package fiuba.algo3.tp2.juego;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.Unidad;

public class Jugador {
	
	private int oro;
	private Collection<Posicionable> edificios = new LinkedList<>();
	private Collection<Posicionable> unidades = new LinkedList<>();
	private int poblacion;

	public Jugador() {
		
		this.edificios = new LinkedList<>();
		this.unidades = new LinkedList<>();
		this.poblacion = 0;
	}

	public int obtenerOro() {
		return this.oro;		
	}

	public LinkedList<Posicionable> obtenerPosicionables() {

		LinkedList<Posicionable> posicionables = new LinkedList<>();

		posicionables.addAll(this.edificios);

		posicionables.addAll(this.unidades);

		return posicionables;

	}

	public void agregarUnidad(Unidad unidad) {

		this.unidades.add(unidad);
		poblacion += 1;

	}

	public void agregarEdificio(Edificio edificio) {

		this.edificios.add(edificio);

	}

	public void setOro(int oroInicial) {
		
		this.oro = oroInicial;		
	}

	public int obtenerPoblacionActual() {
		return poblacion;
	}

	public void removerUnidad(Unidad unidadARemover, Mapa mapa) {
		unidades.remove(unidadARemover);
		mapa.obtenerCelda(unidadARemover.obtenerPosicion()).liberar();
		poblacion -=1;
	} 

}
