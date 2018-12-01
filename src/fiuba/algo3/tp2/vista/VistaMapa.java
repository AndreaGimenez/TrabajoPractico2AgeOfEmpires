package fiuba.algo3.tp2.vista;

import java.util.Collection;

import fiuba.algo3.tp2.mapa.Celda;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.Aldeano;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class VistaMapa {
	
	private Mapa mapa;
	private ContenedorMapa contenedorMapa;
	private Pane nodoSeleccionado;

	public VistaMapa(Mapa mapa, ContenedorMapa contenedorMapa) {
		 this.mapa = mapa;
		 this.contenedorMapa = contenedorMapa;
	}

	public void dibujar() {
		
		for (int i = 0; i < mapa.getTamanioX(); i++) {
            RowConstraints row = new RowConstraints(50);
            contenedorMapa.getRowConstraints().add(row);
        }
        for (int i = 0; i < mapa.getTamanioY(); i++) {
            ColumnConstraints col = new ColumnConstraints(50);
            contenedorMapa.getColumnConstraints().add(col);
        }
        
        for (int i = 0 ; i < mapa.getTamanioX() ; i++) {
            for (int j = 0; j < mapa.getTamanioY(); j++) {
            	
            	Celda celda = mapa.obtenerCelda(new Posicion(i, j));
            	Posicionable posicionable = celda.obtenerPosicionable();
            	
            	
            	Pane pane = new Pane();
            	if(posicionable != null) {
            		if(posicionable instanceof Aldeano) {
            			
            	        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/aldeano.jpg", 
       						 50, 
       						 50, 
       						 false, 
       						 true);
       
            	        BackgroundImage fondoAldeano = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
       
            			pane.setBackground(new Background(fondoAldeano));
            		}else {
            			pane.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
            		}
            		
            	}
                pane.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						
						int colIndex = contenedorMapa.obtenerColumnIndex((Pane)event.getSource());
						int rowIndex = contenedorMapa.obtenerRowIndex((Pane)event.getSource());
						
						Posicionable posicionable = mapa.obtenerPosicionable(new Posicion(colIndex, rowIndex));
						if(posicionable == null) {
							Pane nodo = contenedorMapa.obtenerCelda(colIndex, rowIndex);
							nodo.setBorder(new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, null, BorderStroke.THICK)));
						}else {
							Collection<Posicion> posicionesPosicionable = posicionable.obtenerPosicionesOcupadasEnMapa();
							for(Posicion posicion: posicionesPosicionable) {
								Pane nodoPosicion = contenedorMapa.obtenerCelda(posicion.getX(), posicion.getY());
								nodoPosicion.setBorder(new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, null, BorderStroke.THICK)));
							}
						}
						
						Pane nodoSeleccionadoAnterior = nodoSeleccionado;
						nodoSeleccionado = (Pane)event.getSource();
						
						if(nodoSeleccionadoAnterior != null) {
							nodoSeleccionadoAnterior.setBorder(Border.EMPTY);
						}
						nodoSeleccionado.setBorder(new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, null, BorderStroke.THICK)));
					}
				});
                contenedorMapa.add(pane, i, Math.abs(j - (mapa.getTamanioY() - 1)));
            }
        }
	}
}
