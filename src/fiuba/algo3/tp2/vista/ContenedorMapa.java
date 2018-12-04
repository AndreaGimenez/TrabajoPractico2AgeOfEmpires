package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.mapa.Posicion;
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
import javafx.scene.layout.Region;

public class ContenedorMapa extends GridPane {
	
	public ContenedorMapa() {
		
    	setAlignment(Pos.CENTER);
    	setGridLinesVisible(true);
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondo-verde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        setBackground(new Background(imagenDeFondo));
	}

	public int obtenerColumnIndex(Node nodo) {
		
		return GridPane.getColumnIndex(nodo);
	}

	public int obtenerRowIndex(Node nodo) {
		return Math.abs(GridPane.getRowIndex(nodo) - (getRowConstraints().size() - 1));
	}

	public void setBackground(Background fondo, Posicion posicion) {
		
		obtenerNodo(posicion).setBackground(fondo);
	}

	public Pane obtenerNodo(Posicion posicion) {
		
		Pane nodoADevolver = null;
		for(Node nodo : getChildren()) {
			if(nodoADevolver == null
					&& nodo instanceof Pane
					&& new Posicion(obtenerColumnIndex(nodo), obtenerRowIndex(nodo)).esIgualA(posicion)) {
				
				nodoADevolver = (Pane)nodo;
			}
		}
		return nodoADevolver;
	}
}
