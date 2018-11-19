package fiuba.algo3.tp2.juego;

import java.util.LinkedList;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Unidad;

public class Jugador {

	private static final int ORO_INICIAL = 100;
	private static final Posicion POSICION_INICIAL_CASTILLO_JUG_1 = new Posicion(1, 1);
	private static final Posicion POSICION_INICIAL_PLAZACENTRAL_JUG_1 = new Posicion(1, 6);
	private static final Posicion POSICION_INICIAL_ALDEANO1_JUG_1 = new Posicion(4, 6);
	
	private int oro;
	private LinkedList<Posicionable> edificios = new LinkedList<>();
	private LinkedList<Posicionable> unidades = new LinkedList<>();

	public void cargarCondicionesIniciales(Mapa mapa) 
			throws CeldaOcupadaException, CeldaInexistenteException {
		
		this.oro = ORO_INICIAL;
		this.edificios = cargarEdificiosIniciales(mapa);
		this.unidades = cargarUnidadesIniciales(mapa);
	}

	private LinkedList<Posicionable> cargarUnidadesIniciales(Mapa mapa)
			throws CeldaOcupadaException, CeldaInexistenteException {
		
		Aldeano aldeano1 = new Aldeano(buscarPosicionAldeano(mapa), mapa);
		Aldeano aldeano2 = new Aldeano(buscarPosicionAldeano(mapa), mapa);
		Aldeano aldeano3 = new Aldeano(buscarPosicionAldeano(mapa), mapa);

		unidades.add(aldeano1);
		unidades.add(aldeano2);
		unidades.add(aldeano3);
		
		return unidades;
	}

	private Posicion buscarPosicionAldeano(Mapa mapa) {
		
		Posicion posicion = POSICION_INICIAL_ALDEANO1_JUG_1;
		return posicion;
	}

	private LinkedList<Posicionable> cargarEdificiosIniciales(Mapa mapa)
			throws CeldaOcupadaException, CeldaInexistenteException {
		
		Castillo castillo = new Castillo(buscarPosicionCastillo(mapa), mapa);
		PlazaCentral plazaCentral = new PlazaCentral(buscarPosicionPlazaCentral(mapa), mapa);
		edificios.add(castillo);
		edificios.add(plazaCentral);
		
		return edificios;
	}

	/*
	 * La plaza central se colocara dos celdas arriba del castillo contra el costado izquierdo del mapa
	 * y para el otro jugador la posicion inversa: dos casilleros debajo del castillo contra el
	 * costado derecho del mapa
	 */
	private Posicion buscarPosicionPlazaCentral(Mapa mapa) {
		
		Posicion posicion = POSICION_INICIAL_PLAZACENTRAL_JUG_1;
		Celda celda = mapa.obtenerCelda(posicion);
		
		if(celda.estaOcupada()) {
			posicion.setX(mapa.getTamanioX());
			posicion.setY(mapa.getTamanioY()-6);
		}
		
		return posicion;
	}

	/*
	 * El castillo del jugador se posicionara en una esquina del mapa
	 * Si la posicion esta ocupada significa que esta el castillo del otro jugador, entonces
	 * Se asignara la otra esquina
	 */
	private Posicion buscarPosicionCastillo(Mapa mapa) {
		
		Posicion posicion = POSICION_INICIAL_CASTILLO_JUG_1;
		Celda celda = mapa.obtenerCelda(posicion);
		
		if(celda.estaOcupada()) {
			posicion.sumar(new Posicion(mapa.getTamanioX(), mapa.getTamanioY()));
		}
		
		return posicion;
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
}
