package fiuba.algo3.tp2.vista;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ContenedorMapa extends GridPane {
	
	public ContenedorMapa() {
		
    	setAlignment(Pos.CENTER);
    	setGridLinesVisible(true);
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondo-verde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        setBackground(new Background(imagenDeFondo));
	}

	public Pane obtenerNodo(int colIndex, int rowIndex) {
		
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
