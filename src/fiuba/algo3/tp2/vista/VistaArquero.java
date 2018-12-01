package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.unidad.Arquero;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class VistaArquero {

	private ContenedorControles contenedorControles;

	public void dibujar(Arquero posicionable, Pane pane) {
		
		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/arquero.jpeg", 
					 VistaMapa.TAMANIO_NODO, 
					 VistaMapa.TAMANIO_NODO, 
					 false, 
					 true);

	        BackgroundImage fondoAldeano = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

	        pane.setBackground(new Background(fondoAldeano));
	}
}
