package fiuba.algo3.tp2.vista.strategy;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.vista.VistaSeleccionador;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class NodoMapaOnMouseClickedSeleccionarStrategy implements NodoMapaOnMouseClickedStrategy {

	private ContenedorMapa contenedorMapa;
	private Juego juego;
	
	private VistaSeleccionador vistaSeleccionador;

	public NodoMapaOnMouseClickedSeleccionarStrategy(Juego juego, ContenedorMapa contenedorMapa, VistaSeleccionador vistaSeleccionador) {
		this.contenedorMapa = contenedorMapa;
		this.juego = juego;
		this.vistaSeleccionador = vistaSeleccionador;
	}

	@Override
	public void handle(MouseEvent event) {
		
		Pane nodo = (Pane)event.getSource();
		int colIndex = ContenedorPartida.contenedorMapa.obtenerColumnIndex(nodo);
		int rowIndex = ContenedorPartida.contenedorMapa.obtenerRowIndex(nodo);
		
		Posicionable posicionable = juego.obtenerMapa().obtenerPosicionable(new Posicion(colIndex, rowIndex));
		
		if(juego.obtenerJugadorActual().posicionablePerteneceAJugador(posicionable)) {
			try {
				contenedorMapa.obtenerVistaPosicionable(new Posicion(colIndex, rowIndex)).dibujarControles(posicionable);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vistaSeleccionador.seleccionarNodo((Pane)event.getSource());
		}
	}
}
