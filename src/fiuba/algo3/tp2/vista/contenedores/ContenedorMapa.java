package fiuba.algo3.tp2.vista.contenedores;

import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.vista.PaneMapa;
import fiuba.algo3.tp2.vista.VistaMapa;
import fiuba.algo3.tp2.vista.VistaPosicionable;
import fiuba.algo3.tp2.vista.constantes.Constantes;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;

public class ContenedorMapa extends GridPane {
	
	private ContenedorCentral contenedorPadre;
	private Mapa mapa;
	
	public ContenedorMapa(Mapa mapa) {
		
		this.mapa = mapa;
    	setAlignment(Pos.CENTER);
    	setGridLinesVisible(true);
        Image imagen = new Image(Constantes.TERRENO,
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
		
		for(Posicion posicionActual : mapa.obtenerPosicionable(posicion).obtenerPosicionesOcupadasEnMapa()) {
			obtenerNodo(posicionActual).setVistaPosicionable(vistaPosicionable);
		}
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

	public void actualizarPosicionVistaPosicionable(VistaPosicionable vista, Posicion posicionActual, Posicion nuevaPosicion) {
		obtenerNodo(posicionActual).setVistaPosicionable(null);
		obtenerNodo(nuevaPosicion).setVistaPosicionable(vista);
	}

	public void removerVista(Posicion posicion) {
		obtenerNodo(posicion).setVistaPosicionable(null);
	}
}
