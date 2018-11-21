package fiuba.algo3.tp2.juego;

import java.util.LinkedList;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.unidad.Unidad;

public class Jugador {
	
	private int oro;
	private LinkedList<Posicionable> edificios = new LinkedList<>();
	private LinkedList<Posicionable> unidades = new LinkedList<>();

	public Jugador() {
		
		this.oro = 0;
		this.edificios = new LinkedList<>();
		this.unidades = new LinkedList<>();
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

	}

	public void agregarEdificio(Edificio edificio) {

		this.edificios.add(edificio);

	}

	public void setOro(int oroInicial) {
		
		this.oro = oroInicial;		
	}

}
