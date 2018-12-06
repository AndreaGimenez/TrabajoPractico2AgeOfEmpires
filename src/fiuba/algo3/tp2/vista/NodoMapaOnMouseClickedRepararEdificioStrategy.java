package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.Aldeano;
import javafx.animation.Animation;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class NodoMapaOnMouseClickedRepararEdificioStrategy implements NodoMapaOnMouseClickedStrategy {
	
	private ContenedorMapa contenedorMapa;
	private Juego juego;
	private Aldeano reparador;
	private VistaMapa vistaMapa;
	private VistaSeleccionador vistaSeleccionador;
	
	public NodoMapaOnMouseClickedRepararEdificioStrategy(ContenedorMapa contenedorMapa, Juego juego, Aldeano reparador, VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador){
		this.contenedorMapa = contenedorMapa;
		this.juego = juego;
		this.reparador = reparador;
		this.vistaMapa = vistaMapa;
		this.vistaSeleccionador = vistaSeleccionador;
	}
	
	@Override
	public void handle(MouseEvent event) {
		Pane nodo = (Pane)event.getSource();
		int colIndex = contenedorMapa.obtenerColumnIndex(nodo);
		int rowIndex = contenedorMapa.obtenerRowIndex(nodo);
		Posicionable posicionable = juego.obtenerMapa().obtenerPosicionable(new Posicion(colIndex, rowIndex));
		
		MensajeDeError error = new MensajeDeError();
		
		if(juego.obtenerJugadorActual().posicionablePerteneceAJugador(posicionable) &&
				posicionable instanceof Edificio) {
			try {
				reparador.repararEdificio((Edificio)posicionable);
				
				Shape nodoShape = new Rectangle(nodo.getWidth(), nodo.getHeight());
				nodo.getChildren().add(nodoShape);
				
		        final Animation animation = new ColorTransition(Color.GREEN, nodoShape);
		        animation.play();
		        
			}
			catch(EdificioFueraDeRangoException e) {
				error.mostrarVentanaError("Edificio Fuera De Rango de Reparación");
			}
			catch(EdificioNoAptoParaReparacionException e) {
				error.mostrarVentanaError("Edificio No Apto Para Reparación");
			}
			catch(EdificioConReparadorAsignadoException e) {
				error.mostrarVentanaError("Este Edificio Ya Tiene Asignado Un Reparador");
			}
			finally {
				vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedSeleccionarStrategy(juego, contenedorMapa, vistaSeleccionador));
				contenedorMapa.setCursor(Cursor.DEFAULT);
			}
			
		}
	}

}
