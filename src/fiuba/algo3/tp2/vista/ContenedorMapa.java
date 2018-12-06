package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.mapa.Mapa;
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

public class ContenedorMapa extends GridPane {

	public ContenedorMapa(Mapa mapa) {
		
    	setAlignment(Pos.CENTER);
    	setGridLinesVisible(true);
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/terreno.jpg",
        		mapa.getTamanioX()*VistaMapa.TAMANIO_NODO,
        		mapa.getTamanioY()*VistaMapa.TAMANIO_NODO,
        		false,
        		true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
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
