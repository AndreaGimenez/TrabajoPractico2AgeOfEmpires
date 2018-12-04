package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Espadachin;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collection;

public class VistaEspadachin {

	private ContenedorControles contenedorControles;

	public void dibujar(Espadachin posicionable, Pane pane) {
		
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/espadachin.jpg", 
        		 VistaMapa.TAMANIO_NODO, 
				 VistaMapa.TAMANIO_NODO,
				 false, 
				 true);

        BackgroundImage fondoAldeano = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        pane.setBackground(new Background(fondoAldeano));
	}

    public void setContenedorControles(ContenedorControles contenedorControles) {

		this.contenedorControles = contenedorControles;
    }

	public void dibujarControles(Espadachin posicionable) {
		contenedorControles.setNombreUnidad("Espadachin");

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionAtacar());

		contenedorControles.setAcciones(acciones);
	}

	private Button crearAccionAtacar() {
		Button botonAtacar = new Button("Atacar");
		//TODO agregar event handler.
		return botonAtacar;
	}

	public void dibujar(Espadachin posicionable, Posicion posicionAnterior) {
		// TODO Auto-generated method stub
		
	}
}