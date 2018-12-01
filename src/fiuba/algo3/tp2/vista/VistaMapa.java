package fiuba.algo3.tp2.vista;

import java.util.Collection;

import fiuba.algo3.tp2.mapa.Celda;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import javafx.scene.Node;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class VistaMapa {
	
	public static int TAMANIO_NODO = 50;
	
	private Mapa mapa;
	private ContenedorMapa contenedorMapa;
	private Pane nodoSeleccionado;
	
	private VistaPosicionable vistaPosicionable;
	

	public VistaMapa(Mapa mapa, ContenedorMapa contenedorMapa) {
		 this.mapa = mapa;
		 this.contenedorMapa = contenedorMapa;
		 this.vistaPosicionable = new VistaPosicionable();
	}

	public void dibujarTerreno() {
		
		for (int i = 0; i < mapa.getTamanioX(); i++) {
            RowConstraints row = new RowConstraints(TAMANIO_NODO);
            contenedorMapa.getRowConstraints().add(row);
        }
        for (int i = 0; i < mapa.getTamanioY(); i++) {
            ColumnConstraints col = new ColumnConstraints(TAMANIO_NODO);
            contenedorMapa.getColumnConstraints().add(col);
        }
        
        for (int i = 0 ; i < mapa.getTamanioX() ; i++) {
            for (int j = 0; j < mapa.getTamanioY(); j++) {
            	
            	Pane pane = new Pane();
            	
            	NodoMapaOnMouseClickedEventHandler nodoMapaOnMouseClickedEventHandler = new NodoMapaOnMouseClickedEventHandler(this);
            	pane.setOnMouseClicked(nodoMapaOnMouseClickedEventHandler);
            	
            	contenedorMapa.add(pane, i, Math.abs(j - (mapa.getTamanioY() - 1)));
            }
        }
	}
	
	public void dibujarPosicionables() {
		
        for(Node nodo : contenedorMapa.getChildren()) {
			if(nodo instanceof Pane) {
				
				Pane pane = (Pane) nodo;
				int colIndex = contenedorMapa.obtenerColumnIndex(pane);
				int rowIndex = contenedorMapa.obtenerRowIndex(pane);
				Celda celda = mapa.obtenerCelda(new Posicion(colIndex, rowIndex));
				Posicionable posicionable = celda.obtenerPosicionable();
				
				vistaPosicionable.dibujarPosicionable(posicionable, pane);
			}
        }
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
				Pane nodoPosicion = contenedorMapa.obtenerNodo(posicion.getX(), posicion.getY());
				nodoPosicion.setBorder(new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, null, BorderStroke.THICK)));
			}
		}
	}

	private void deseleccionarNodo(Pane nodo) {
		
		int colIndex = contenedorMapa.obtenerColumnIndex(nodo);
		int rowIndex = contenedorMapa.obtenerRowIndex(nodo);
		
		Posicionable posicionable = mapa.obtenerPosicionable(new Posicion(colIndex, rowIndex));
		if(posicionable == null) {
			nodo.setBorder(Border.EMPTY);
		}else {
			Collection<Posicion> posicionesPosicionable = posicionable.obtenerPosicionesOcupadasEnMapa();
			for(Posicion posicion: posicionesPosicionable) {
				Pane nodoPosicion = contenedorMapa.obtenerNodo(posicion.getX(), posicion.getY());
				nodoPosicion.setBorder(Border.EMPTY);
			}
		}
	}
}
