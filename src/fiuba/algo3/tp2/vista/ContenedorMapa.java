package fiuba.algo3.tp2.vista;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ContenedorMapa extends GridPane {

	public Pane obtenerCelda(int colIndex, int rowIndex) {
		
		Pane nodoADevolver = null;
		for(Node nodo : getChildren()) {
			if(nodoADevolver == null
					&& nodo instanceof Pane
					&& obtenerColumnIndex(nodo) == colIndex
					&& obtenerRowIndex(nodo) == rowIndex) {
				
				nodoADevolver = (Pane)nodo;
			}
		}
		return nodoADevolver;
	}

	public int obtenerColumnIndex(Node nodo) {
		
		return GridPane.getColumnIndex(nodo);
	}

	public int obtenerRowIndex(Node nodo) {
		return Math.abs(GridPane.getRowIndex(nodo) - (getRowConstraints().size() - 1));
	}
}
