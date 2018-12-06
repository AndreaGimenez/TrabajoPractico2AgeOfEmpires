package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeAldeanosEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class VistaPlazaCentral implements VistaPosicionable {

	private ContenedorControles contenedorControles;
	private Mapa mapa;
	private ContenedorMapa contenedorMapa;

	
	public VistaPlazaCentral(ContenedorMapa contenedorMapa, ContenedorControles contenedorControles, Mapa mapa) {
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.mapa = mapa;
	}
	
	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		pane.setBackground(obtenerFondoPlazaCentral(posicionable, pane));
	}

	@Override
	public void dibujarControles(Posicionable posicionable) {

		contenedorControles.clean();
		
		PlazaCentral plazaCentral = (PlazaCentral) posicionable;
		
		contenedorControles.setNombreUnidad("Plaza Central");
		contenedorControles.setVida(plazaCentral.obtenerVida());

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionCrearAldeano(plazaCentral));

		contenedorControles.setAcciones(acciones);
	}

	private Button crearAccionCrearAldeano(PlazaCentral plazaCentral) {
		Button crearAldeano = new Button("Crear Aldeano");
		crearAldeano.setOnAction(new BotonCreadorDeAldeanosEventHandler(crearAldeano, plazaCentral, mapa));
		return crearAldeano;
	}
	
	private Background obtenerFondoPlazaCentral(Posicionable posicionable, Pane pane) {
		
		int colIndex = contenedorMapa.obtenerColumnIndex(pane);
		int rowIndex = contenedorMapa.obtenerRowIndex(pane);
		
		String nombreImagen = new Posicion(colIndex, rowIndex).restar(posicionable.obtenerPosicion()).toString();
		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/plaza-central/" + nombreImagen + ".jpg", 
			       VistaMapa.TAMANIO_NODO,
			 	   VistaMapa.TAMANIO_NODO,
			       false,
			       true);
		
		BackgroundImage fondoCastillo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		return new Background(fondoCastillo);
	}
}
