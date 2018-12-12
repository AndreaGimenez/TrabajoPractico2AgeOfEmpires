package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.Aldeano;
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
		VistaPosicionable vistaPosicionable = juego.obtenerMapa().obtenerCelda(new Posicion(colIndex, rowIndex)).obtenerVistaPosicionable();
		
		if(juego.obtenerJugadorActual().posicionablePerteneceAJugador(posicionable)) {
			try {
				if(posicionable instanceof Aldeano) {
					
					contenedorMapa.obtenerVistaPosicionable(new Posicion(colIndex, rowIndex)).dibujarControles(posicionable);
				}
				else {
					VistaPosicionableMultitone.getInstance(posicionable).dibujarControles(posicionable);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vistaSeleccionador.seleccionarNodo((Pane)event.getSource());
		}
	}
}
