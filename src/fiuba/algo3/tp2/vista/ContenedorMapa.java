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
	
	private ContenedorCentral contenedorPadre;

	
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

	public PaneMapa obtenerNodo(Posicion posicion) {
		
		PaneMapa nodoADevolver = null;
		for(Node nodo : getChildren()) {
			if(nodoADevolver == null
					&& nodo instanceof PaneMapa
					&& new Posicion(obtenerColumnIndex(nodo), obtenerRowIndex(nodo)).esIgualA(posicion)) {
				
				nodoADevolver = (PaneMapa)nodo;
			}
		}
		return nodoADevolver;
	}

	public void agregarVistaPosicionable(VistaPosicionable vistaPosicionable, Posicion posicion) {
		obtenerNodo(posicion).setVistaPosicionable(vistaPosicionable);
	}
	
	public VistaPosicionable obtenerVistaPosicionable(Posicion posicion) {
		return obtenerNodo(posicion).obtenerVistaPosicionable();
	}

	public void setContenedorPadre(ContenedorCentral contenedorPadre) {
		this.contenedorPadre = contenedorPadre;
	}

	public void setCursorDefault() {
		this.contenedorPadre.setCursorDefault();
	}

	public void setCursorAtaque() {
		this.contenedorPadre.setCursorAtaque();
	}

	public void setCursorReparar() {
		this.contenedorPadre.setCursorReparar();
	}
}
