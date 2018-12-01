package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.unidad.Aldeano;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class VistaAldeano {
	
	private ContenedorControles contenedorControles;

	public void dibujar(Aldeano posicionable, Pane pane) {
		
		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/aldeano.jpg", 
				 VistaMapa.TAMANIO_NODO, 
				 VistaMapa.TAMANIO_NODO, 
				 false, 
				 true);

      BackgroundImage fondoAldeano = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

      pane.setBackground(new Background(fondoAldeano));
	}

	public void dibujarControles(Aldeano aldeano) {
		
		aldeano.obtenerVida();
		contenedorControles.setNombreUnidad("Aldeano");
		
		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionConstruir());
		acciones.add(crearAccionReparar());
		
		contenedorControles.setAcciones(acciones);
	}

	private Button crearAccionReparar() {
		
		Button accionReparar = new Button("Reparar");
		//TODO Agregar el handler
		return accionReparar;
	}

	private Button crearAccionConstruir() {
		
		Button accionConstruir = new Button("Construir");
		//TODO Agregar el handler
		return accionConstruir;
	}

	public void setContenedorControles(ContenedorControles contenedorControles) {
		this.contenedorControles = contenedorControles;
	}
}
