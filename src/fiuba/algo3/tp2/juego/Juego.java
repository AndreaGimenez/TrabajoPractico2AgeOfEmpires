package fiuba.algo3.tp2.juego;

import java.util.LinkedList;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.Celda;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.PosicionesInicialesAldeanos;
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.unidad.Aldeano;

public class Juego {

	private static final Posicion POSICION_INICIAL_CASTILLO_JUG_1 = new Posicion(0, 0);
	private static final Posicion POSICION_INICIAL_PLAZACENTRAL_JUG_1 = new Posicion(5, 0);
	public static final int CANTIDAD_DE_JUGADORES = 2;
	
	public LinkedList<Jugador> jugadores;
	public Mapa mapa;
	private Ronda ronda;

	public Juego(Mapa mapa) 
			throws CantidadDeJugadoresInvalidaException {

		this.jugadores = new LinkedList<Jugador>();
		this.mapa = mapa;
		this.ronda = new Ronda();
	}

	public void iniciar() 
			throws CeldaOcupadaException, CeldaInexistenteException, CantidadDeJugadoresInvalidaException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		for(int i = 0; i < CANTIDAD_DE_JUGADORES; i++) {
			agregarJugador();
		}
		ronda.iniciar();
	}

	public void cargarCondicionesIniciales(Jugador jugador) 
			throws CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		cargarEdificiosIniciales(jugador);
		cargarUnidadesIniciales(jugador);
	}


	private void cargarEdificiosIniciales(Jugador jugador)
			throws CeldaOcupadaException, CeldaInexistenteException, OroInsuficienteException {
		
		Castillo castillo = new Castillo(buscarPosicionCastillo(), this.mapa);
		
		PlazaCentral plazaCentral = new PlazaCentral(buscarPosicionPlazaCentral(), this.mapa);
		
		boolean checkearRecursos = false;
		jugador.agregarEdificio(castillo, checkearRecursos); 
		
		jugador.agregarEdificio(plazaCentral, checkearRecursos);
		
		
	}
	
	private void cargarUnidadesIniciales(Jugador jugador)
			throws CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		boolean checkearRecursos = false;
		
		for(int i = 0 ; i < 3 ; i++) {
			jugador.agregarUnidad(new Aldeano(buscarPosicionAldeano(), this.mapa),this.mapa, checkearRecursos);
		}	
	}

	private Posicion buscarPosicionAldeano() {
		
		PosicionesInicialesAldeanos posiciones = new PosicionesInicialesAldeanos(this.mapa);
		
		Posicion posicion = posiciones.buscarPosicion();
		return posicion;
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

	private void agregarJugador() 
			throws CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		Jugador jugador = new Jugador();
		cargarCondicionesIniciales(jugador);

		this.ronda.agregarJugador(jugador);
	}

	public Jugador obtenerJugador(int numeroDeJugador) {
		
		return this.jugadores.get(numeroDeJugador);
	}
	
	public Jugador obtenerJugadorActual() {
		return ronda.obtenerJugadorActual();
	}

	public void avanzarJugador() throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		obtenerJugadorActual().avanzarTurno();
		ronda.avanzar();
	}
}