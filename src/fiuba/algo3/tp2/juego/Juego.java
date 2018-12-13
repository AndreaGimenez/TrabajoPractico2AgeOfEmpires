package fiuba.algo3.tp2.juego;

import java.util.Iterator;
import java.util.LinkedList;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.excepciones.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.mapa.Celda;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.mapa.PosicionesIniciales;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Unidad;

public class Juego {

	private static final Posicion POSICION_INICIAL_CASTILLO_JUG_1 = new Posicion(0, 0);
	private static final Posicion POSICION_INICIAL_PLAZACENTRAL_JUG_1 = new Posicion(5, 0);
	public static final int CANTIDAD_DE_JUGADORES = 2;
	
	public LinkedList<Jugador> jugadores;
	public Mapa mapa;
	private Ronda ronda;
	private boolean estaTerminado;

	public Juego(Mapa mapa) 
			throws CantidadDeJugadoresInvalidaException {

		this.jugadores = new LinkedList<Jugador>();
		this.mapa = mapa;
		this.ronda = new Ronda();
		this.estaTerminado = false;
	}

	public void iniciar(String[] nombreJugadores) 
			throws CeldaOcupadaException, CeldaInexistenteException, CantidadDeJugadoresInvalidaException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		for(int i = 0; i < CANTIDAD_DE_JUGADORES; i++) {
			agregarJugador(nombreJugadores[i]);
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
		
		PosicionesIniciales posiciones = new PosicionesIniciales(this.mapa);
		
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

	private void agregarJugador(String nombreJugador) 
			throws CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		Jugador jugador = new Jugador(nombreJugador, mapa);
		cargarCondicionesIniciales(jugador);

		this.ronda.agregarJugador(jugador);
	}

	public Jugador obtenerJugadorActual() {
		return ronda.obtenerJugadorActual();
	}

	public void avanzarJugador() throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {
		obtenerJugadorActual().avanzarTurno();
		ronda.avanzar();
		
		Jugador jugadorActual = obtenerJugadorActual();
		LinkedList<Posicionable> posicionablesJugador = jugadorActual.obtenerPosicionables();
    	Iterator<Posicionable> posicionablesIterator = posicionablesJugador.iterator();
    	
    	while(posicionablesIterator.hasNext()) {
    		Posicionable posicionable = posicionablesIterator.next();
    		if(posicionable instanceof Unidad) {
    			Unidad unidad = (Unidad)posicionable;
    			if(unidad.estaMuerta()) {
    				jugadorActual.removerUnidad((Unidad)posicionable, mapa);
    			}
    		}else if(posicionable instanceof Edificio
    				&& !(posicionable instanceof Castillo)) {
    			Edificio edificio = (Edificio)posicionable;
    			if(edificio.estaDestruido()) {
    				jugadorActual.removerEdificio((Edificio)posicionable, mapa);
    			}
    		}
    	}
		if(obtenerJugadorActual().castilloDestruido()) {
			this.estaTerminado = true ;
		}
	}

	public boolean estaTerminado() {
		
		return ( this.estaTerminado );
	}

	public Mapa obtenerMapa() {
		return mapa;
	}

	public boolean posicionablePerteneceAPrimerJugador(Posicionable posicionable){
		return this.ronda.posicionablePerteneceAPrimerJugador(posicionable);
	}
}