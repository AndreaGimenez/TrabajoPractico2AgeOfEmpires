package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Celda;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;
import fiuba.algo3.tp2.vista.handlers.NodoMapaOnMouseClickedEventHandler;
import fiuba.algo3.tp2.vista.strategy.NodoMapaOnMouseClickedSeleccionarStrategy;
import fiuba.algo3.tp2.vista.strategy.NodoMapaOnMouseClickedStrategy;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class VistaMapa {
	
	public static int TAMANIO_NODO = 50;
	
	private Juego juego;
	private ContenedorMapa contenedorMapa;
	 
	private VistaSeleccionador vistaSeleccionador;
	

	public VistaMapa(Juego juego, ContenedorMapa contenedorMapa, VistaSeleccionador vistaSeleccionador) {
		 this.juego = juego;
		 this.contenedorMapa = contenedorMapa;
		 this.vistaSeleccionador = vistaSeleccionador;
	}

	public void dibujarTerreno() {
		
		Mapa mapa = juego.obtenerMapa();
		
		for (int i = 0; i < mapa.getTamanioY(); i++) {
            RowConstraints row = new RowConstraints(TAMANIO_NODO);
            ContenedorPartida.contenedorMapa.getRowConstraints().add(row);
        }
        for (int i = 0; i < mapa.getTamanioX(); i++) {
            ColumnConstraints col = new ColumnConstraints(TAMANIO_NODO);
            ContenedorPartida.contenedorMapa.getColumnConstraints().add(col);
        }
        
        for (int i = 0 ; i < mapa.getTamanioX() ; i++) {
            for (int j = 0; j < mapa.getTamanioY(); j++) {
            	
            	Pane pane = new PaneMapa();
            	
            	NodoMapaOnMouseClickedStrategy strategy = new NodoMapaOnMouseClickedSeleccionarStrategy(juego, contenedorMapa, vistaSeleccionador);
            	NodoMapaOnMouseClickedEventHandler nodoMapaOnMouseClickedEventHandler = new NodoMapaOnMouseClickedEventHandler(strategy);
            	pane.setOnMouseClicked(nodoMapaOnMouseClickedEventHandler);
            	
            	ContenedorPartida.contenedorMapa.add(pane, i, Math.abs(j - (mapa.getTamanioY() - 1)));
            }
        }
	}
	
	public void setNodoMapaOnMouseClickedStrategy(NodoMapaOnMouseClickedStrategy strategy){
		
		for(Node nodo : ContenedorPartida.contenedorMapa.getChildren()) {
			if(nodo instanceof Pane) {
				((NodoMapaOnMouseClickedEventHandler)nodo.getOnMouseClicked()).setStrategy(strategy);
			} 
		}
	}
	 
public void dibujarPosicionables() {
		 
		Mapa mapa = juego.obtenerMapa();
		
        for(Node nodo : ContenedorPartida.contenedorMapa.getChildren()) {
			if(nodo instanceof PaneMapa) {
				
				PaneMapa pane = (PaneMapa) nodo;
				int colIndex = ContenedorPartida.contenedorMapa.obtenerColumnIndex(pane);
				int rowIndex = ContenedorPartida.contenedorMapa.obtenerRowIndex(pane);
				Celda celda = mapa.obtenerCelda(new Posicion(colIndex, rowIndex));
				Posicionable posicionable = celda.obtenerPosicionable();
				
				if(posicionable != null) {
					pane.obtenerVistaPosicionable().dibujarPosicionable(posicionable, pane);
				}else {
					pane.setBackground(null);
				}
			}
        }
	}
}
