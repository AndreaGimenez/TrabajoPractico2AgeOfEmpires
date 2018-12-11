package fiuba.algo3.tp2.vista;

import java.util.Collection;

import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class VistaSeleccionador {
	
	private Mapa mapa;
	private ContenedorMapa contenedorMapa;
	private Pane nodoSeleccionado;

	
	public VistaSeleccionador(Mapa mapa, ContenedorMapa contenedorMapa) {
		this.mapa = mapa;
		this.contenedorMapa = contenedorMapa;
	}
	
	public void seleccionarNodo(Pane nodo) {
		
		Pane nodoAnterior = nodoSeleccionado;
		nodoSeleccionado = nodo;
		
		if(nodoAnterior != null) {
			deseleccionarNodo(nodoAnterior);
		}
		
		int colIndex = contenedorMapa.obtenerColumnIndex(nodoSeleccionado);
		int rowIndex = contenedorMapa.obtenerRowIndex(nodoSeleccionado);
		
		Posicionable posicionable = mapa.obtenerPosicionable(new Posicion(colIndex, rowIndex));
		if(posicionable == null) {
			nodoSeleccionado.setBorder(new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, null, BorderStroke.THICK)));
		}else {
			Collection<Posicion> posicionesPosicionable = posicionable.obtenerPosicionesOcupadasEnMapa();
			for(Posicion posicion: posicionesPosicionable) {
				Pane nodoPosicion = contenedorMapa.obtenerNodo(posicion);
				nodoPosicion.setBorder(new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, null, BorderStroke.THICK)));
			}
		}
	}

	private void deseleccionarNodo(Pane nodo) {
		
		if(nodo != null) {
			int colIndex = contenedorMapa.obtenerColumnIndex(nodo);
			int rowIndex = contenedorMapa.obtenerRowIndex(nodo);
			
			Posicionable posicionable = mapa.obtenerPosicionable(new Posicion(colIndex, rowIndex));
			if(posicionable == null) {
				nodo.setBorder(Border.EMPTY);
			}else {
				Collection<Posicion> posicionesPosicionable = posicionable.obtenerPosicionesOcupadasEnMapa();
				for(Posicion posicion: posicionesPosicionable) {
					Pane nodoPosicion = contenedorMapa.obtenerNodo(posicion);
					nodoPosicion.setBorder(Border.EMPTY);
				}
			}
		}
	}

	public void seleccionarNodo(Posicionable posicionable) {
		seleccionarNodo(contenedorMapa.obtenerNodo(posicionable.obtenerPosicion()));
	}

	public void deseleccionarNodoActual() {
		deseleccionarNodo(nodoSeleccionado);
		nodoSeleccionado = null;
	}
}
