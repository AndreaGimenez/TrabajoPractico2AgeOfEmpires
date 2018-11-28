package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;

public class VistaEstadoJugador {

	private Juego juego;
	private ContenedorEstadoJugador contenedorEstadoJugador;

	public VistaEstadoJugador(Juego juego, ContenedorEstadoJugador contenedorEstadoJugador) {
		this.juego = juego;
		this.contenedorEstadoJugador = contenedorEstadoJugador;
	}

	public void actualizar() {
		
		Jugador jugadorActual = juego.obtenerJugadorActual();
		contenedorEstadoJugador.actualizarOro(jugadorActual.obtenerOro());
		contenedorEstadoJugador.actualizarPoblacion(jugadorActual.obtenerPoblacionActual());
		contenedorEstadoJugador.actualizarNombreJugador(jugadorActual.obtenerNombre());
	}
}