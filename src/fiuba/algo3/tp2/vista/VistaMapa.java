package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Mapa;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class VistaMapa {
	
	public static int TAMANIO_NODO = 50;
	
	private Juego juego;
	private ContenedorMapa contenedorMapa;
	
	private VistaPosicionable vistaPosicionable;
	private VistaSeleccionador vistaSeleccionador;
	

	public VistaMapa(Juego juego, ContenedorMapa contenedorMapa, VistaSeleccionador vistaSeleccionador, VistaPosicionable vistaPosicionable) {
		 this.juego = juego;
		 this.contenedorMapa = contenedorMapa;
		 this.vistaPosicionable = vistaPosicionable;
		 this.vistaSeleccionador = vistaSeleccionador;
	}

	public void dibujarTerreno() {
		
		Mapa mapa = juego.obtenerMapa();
		
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
            	
            	NodoMapaOnMouseClickedEventHandler nodoMapaOnMouseClickedEventHandler = new NodoMapaOnMouseClickedEventHandler(juego, contenedorMapa, vistaSeleccionador, vistaPosicionable);
            	pane.setOnMouseClicked(nodoMapaOnMouseClickedEventHandler);
            	
            	contenedorMapa.add(pane, i, Math.abs(j - (mapa.getTamanioY() - 1)));
            }
        }
	}
}
