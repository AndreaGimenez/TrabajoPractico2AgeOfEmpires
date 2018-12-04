package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class NodoMapaOnMouseClickedEventHandler implements EventHandler<MouseEvent>{
	
	private ContenedorMapa contenedorMapa;
	private Juego juego;
	
	private VistaSeleccionador vistaSeleccionador;
	private VistaPosicionable vistaPosicionable;

	public NodoMapaOnMouseClickedEventHandler(Juego juego, ContenedorMapa contenedorMapa, VistaSeleccionador vistaSeleccionador, VistaPosicionable vistaPosicionable) {
		this.contenedorMapa = contenedorMapa;
		this.juego = juego;
		this.vistaSeleccionador = vistaSeleccionador;
		this.vistaPosicionable = vistaPosicionable;
	}

	@Override
	public void handle(MouseEvent event) {
		
		Pane nodo = (Pane)event.getSource();
		int colIndex = contenedorMapa.obtenerColumnIndex(nodo);
		int rowIndex = contenedorMapa.obtenerRowIndex(nodo);
		Posicionable posicionable = juego.obtenerMapa().obtenerPosicionable(new Posicion(colIndex, rowIndex));
		
		if(juego.obtenerJugadorActual().posicionablePerteneceAJugador(posicionable)) {
			vistaPosicionable.dibujarControles((Pane)event.getSource());
			vistaSeleccionador.seleccionarNodo((Pane)event.getSource());
		}
	}
}
