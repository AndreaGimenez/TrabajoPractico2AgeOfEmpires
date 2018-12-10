package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Aldeano;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class NodoMapaOnMouseClickedConstruirPlazaCentralStrategy implements NodoMapaOnMouseClickedStrategy {
	
	private ContenedorMapa contenedorMapa;
	private Juego juego;
	private Aldeano aldeano;
	private VistaMapa vistaMapa;
	private VistaSeleccionador vistaSeleccionador;
	
	public NodoMapaOnMouseClickedConstruirPlazaCentralStrategy(ContenedorMapa contenedorMapa, Juego juego, Aldeano aldeano, VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador) {
		
		this.contenedorMapa = contenedorMapa;
		this.juego = juego;
		this.aldeano = aldeano;
		this.vistaMapa = vistaMapa;
		this.vistaSeleccionador = vistaSeleccionador;
	}

	@Override
	public void handle(MouseEvent event) {
		
		Pane nodo = (Pane) event.getSource();
		
		int colIndex = contenedorMapa.obtenerColumnIndex(nodo);
		int rowIndex = contenedorMapa.obtenerRowIndex(nodo);
		
		MensajeDeError error = new MensajeDeError();
		
		try {
			
			aldeano.construir(new PlazaCentral(new Posicion(colIndex, rowIndex), juego.obtenerMapa()));
		
		} 
		catch(CeldaOcupadaException e) {
			error.mostrarVentanaError("La celda en la que intentas contruir esta ocupada");
		}
		catch(CeldaInexistenteException e) {
			error.mostrarVentanaError("La celda en la que intentas contruir no existe");
		}			
		finally {
			vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedSeleccionarStrategy(juego, contenedorMapa, vistaSeleccionador));
			contenedorMapa.setCursor(Cursor.DEFAULT);
		}
	}

}
