package fiuba.algo3.tp2.juego;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.Celda;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.mapa.PosicionesInicialesAldeanos;
import fiuba.algo3.tp2.unidad.Aldeano;

public class Juego {

	private static final int ORO_INICIAL = 100;
	private static final Posicion POSICION_INICIAL_CASTILLO_JUG_1 = new Posicion(0, 0);
	private static final Posicion POSICION_INICIAL_PLAZACENTRAL_JUG_1 = new Posicion(5, 0);
	public static final int CANTIDAD_DE_JUGADORES = 2;
	
	private LinkedList<Jugador> jugadores;
	private Mapa mapa;

	public Juego(Mapa mapa) 
			throws CantidadDeJugadoresInvalidaException {

		this.jugadores = new LinkedList<>();
		this.mapa = mapa;
	}

	public void iniciar() 
			throws CeldaOcupadaException, CeldaInexistenteException, CantidadDeJugadoresInvalidaException {
		
		if(jugadores.size()!=CANTIDAD_DE_JUGADORES)
			throw new CantidadDeJugadoresInvalidaException();
		
		cargarCondicionesIniciales(jugadores.get(0));
		cargarCondicionesIniciales(jugadores.get(1));
	}

	public void cargarCondicionesIniciales(Jugador jugador) 
			throws CeldaOcupadaException, CeldaInexistenteException {
		
		jugador.setOro(ORO_INICIAL);
		cargarEdificiosIniciales(jugador);
		cargarUnidadesIniciales(jugador);
	}

	private void cargarUnidadesIniciales(Jugador jugador)
			throws CeldaOcupadaException, CeldaInexistenteException {
		
		Aldeano aldeano1 = new Aldeano(buscarPosicionAldeano(), this.mapa);
		Aldeano aldeano2 = new Aldeano(buscarPosicionAldeano(), this.mapa);
		Aldeano aldeano3 = new Aldeano(buscarPosicionAldeano(), this.mapa);

		jugador.agregarUnidad(aldeano1);
		jugador.agregarUnidad(aldeano2);
		jugador.agregarUnidad(aldeano3);
	
	}

	private Posicion buscarPosicionAldeano() {
		
		PosicionesInicialesAldeanos posiciones = new PosicionesInicialesAldeanos(this.mapa);
		
		Posicion posicion = posiciones.buscarPosicion();
		return posicion;
	}

	private void cargarEdificiosIniciales(Jugador jugador)
			throws CeldaOcupadaException, CeldaInexistenteException {
		
		Castillo castillo = new Castillo(buscarPosicionCastillo(), this.mapa);
		PlazaCentral plazaCentral = new PlazaCentral(buscarPosicionPlazaCentral(), this.mapa);
		jugador.agregarEdificio(castillo); 
		jugador.agregarEdificio(plazaCentral);
		
	}

	/*
	 * La plaza central se colocara dos celdas arriba del castillo contra el costado izquierdo del mapa
	 * y para el otro jugador la posicion inversa: dos casilleros debajo del castillo contra el
	 * costado derecho del mapa
	 */
	private Posicion buscarPosicionPlazaCentral() {
		
		Posicion posicion = new Posicion(POSICION_INICIAL_PLAZACENTRAL_JUG_1.getX(),
				POSICION_INICIAL_PLAZACENTRAL_JUG_1.getY());
		Celda celda = this.mapa.obtenerCelda(posicion);
		
		if(celda.estaOcupada()) {
			posicion.setX(this.mapa.getTamanioX()-7);
			posicion.setY(this.mapa.getTamanioY()-2);
		}
		
		return posicion;
	}

	/*
	 * El castillo del jugador se posicionara en una esquina del mapa
	 * Si la posicion esta ocupada significa que esta el castillo del otro jugador, entonces
	 * Se asignara la otra esquina
	 */
	private Posicion buscarPosicionCastillo() {
		
		Posicion posicion = new Posicion(POSICION_INICIAL_CASTILLO_JUG_1.getX(),
										POSICION_INICIAL_CASTILLO_JUG_1.getY());
		Celda celda = this.mapa.obtenerCelda(posicion);
		
		if(celda.estaOcupada()) {
			posicion.setX(this.mapa.getTamanioX()-4); 
			posicion.setY(this.mapa.getTamanioY()-4);
		}
		
		return posicion;
	}

	public void agregarJugador() throws CantidadDeJugadoresInvalidaException {
		
		if(jugadores.size()==CANTIDAD_DE_JUGADORES)
			throw new CantidadDeJugadoresInvalidaException();
		this.jugadores.add(new Jugador());
		
	}

	public Jugador obtenerJugador(int numeroDeJugador) {
		
		return this.jugadores.get(numeroDeJugador);
	}
}