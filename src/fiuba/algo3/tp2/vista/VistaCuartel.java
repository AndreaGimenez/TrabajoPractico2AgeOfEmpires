package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeArqueroEventHandler;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeEspadachinEventHandler;
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

public class VistaCuartel implements VistaPosicionable {

	private ContenedorControles contenedorControles;
	private ContenedorMapa contenedorMapa;
	private Mapa mapa;

	public VistaCuartel(ContenedorMapa contenedorMapa, ContenedorControles contenedorControles, Mapa mapa) {
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.mapa = mapa;
	}
	
	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		pane.setBackground(obtenerFondoCuartel(posicionable, pane));
	}
	
	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		contenedorControles.clean();
		
		Cuartel cuartel = (Cuartel) posicionable;
		contenedorControles.setNombreUnidad("Cuartel");
		contenedorControles.setVida(cuartel.obtenerVida());

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionCrearArquero(cuartel));
		acciones.add(crearAccionCrearEspadachin(cuartel));

		contenedorControles.setAcciones(acciones);
	}

	private Button crearAccionCrearEspadachin(Cuartel cuartel) {

		Button botonCrearEspadachin = new Button("Crear Espadachin");

		botonCrearEspadachin.setOnAction(new BotonCreadorDeEspadachinEventHandler(botonCrearEspadachin, cuartel, mapa));

		return botonCrearEspadachin;

	}

	private Button crearAccionCrearArquero(Cuartel cuartel) {

		Button botonCrearArquero = new Button("Crear Arquero");

		botonCrearArquero.setOnAction(new BotonCreadorDeArqueroEventHandler(botonCrearArquero, cuartel, mapa));

		return botonCrearArquero;
	}
	
	private Background obtenerFondoCuartel(Posicionable posicionable, Pane pane) {
		
		
		int colIndex = contenedorMapa.obtenerColumnIndex(pane);
		int rowIndex = contenedorMapa.obtenerRowIndex(pane);
		
		String nombreImagen = new Posicion(colIndex, rowIndex).restar(posicionable.obtenerPosicion()).toString();
		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/cuartel/" + nombreImagen + ".jpg", 
			       VistaMapa.TAMANIO_NODO,
			 	   VistaMapa.TAMANIO_NODO,
			       false,
			       true);
		
		BackgroundImage fondoCastillo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		return new Background(fondoCastillo);
	}
}
