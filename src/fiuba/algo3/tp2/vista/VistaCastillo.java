package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeArmaDeAsedioEventHandler;
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

public class VistaCastillo implements VistaPosicionable {
	
	private Mapa mapa;
	private ContenedorControles contenedorControles;
	private ContenedorMapa contenedorMapa;

	
	public VistaCastillo(ContenedorMapa contenedorMapa, ContenedorControles contenedorControles, Mapa mapa) {
		this.mapa = mapa;
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
	}
	
	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		pane.setBackground(obtenerFondoCastillo(posicionable, pane));
	}

	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		contenedorControles.clean();
		
		Castillo castillo = (Castillo) posicionable;
		
		contenedorControles.setNombreUnidad("Castillo");

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionConstruirArmaAsedio(castillo));

		contenedorControles.setAcciones(acciones);
	}

	private Button crearAccionConstruirArmaAsedio(Castillo castillo) {

		Button crearArmaAsedio = new Button("Crear Arma de Asedio");
		crearArmaAsedio.setOnAction(new BotonCreadorDeArmaDeAsedioEventHandler(crearArmaAsedio, castillo, mapa));
		return crearArmaAsedio;
	}
	
	private Background obtenerFondoCastillo(Posicionable posicionable, Pane pane) {
		
		
		int colIndex = contenedorMapa.obtenerColumnIndex(pane);
		int rowIndex = contenedorMapa.obtenerRowIndex(pane);
		
		String nombreImagen = new Posicion(colIndex, rowIndex).restar(posicionable.obtenerPosicion()).toString();
		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/castillo/" + nombreImagen + ".jpg", 
			       VistaMapa.TAMANIO_NODO,
			 	   VistaMapa.TAMANIO_NODO,
			       false,
			       true);
		
		BackgroundImage fondoCastillo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		return new Background(fondoCastillo);
	}
}
