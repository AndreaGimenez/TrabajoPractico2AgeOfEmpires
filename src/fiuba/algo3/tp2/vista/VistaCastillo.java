package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeArmaDeAsedioEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class VistaCastillo implements VistaPosicionable {
	
	private Mapa mapa;
	private ContenedorControles contenedorControles;
	private ContenedorMapa contenedorMapa;
	private VistaMapa vistaMapa;
	private Juego juego;
	private VistaSeleccionador vistaSeleccionador;

	
	public VistaCastillo(ContenedorMapa contenedorMapa, ContenedorControles contenedorControles, Mapa mapa, VistaMapa vistaMapa, Juego juego, VistaSeleccionador vistaSeleccionador) {
		this.mapa = mapa;
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.vistaMapa = vistaMapa;
		this.juego = juego;
		this.vistaSeleccionador = vistaSeleccionador;
	}
	
	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		pane.setBackground(obtenerFondoCastillo(posicionable, pane));
	}

	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		ContenedorPartida.contenedorControles.clean();
		
		Castillo castillo = (Castillo) posicionable;
		
		ContenedorPartida.contenedorControles.setNombreUnidad("Castillo");
		ContenedorPartida.contenedorControles.setVida(castillo.obtenerVida());

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionConstruirArmaAsedio(castillo));

		ContenedorPartida.contenedorControles.setAcciones(acciones);
	}

	private Button crearAccionConstruirArmaAsedio(Castillo castillo) {

		Button crearArmaAsedio = new Button("Crear Arma de Asedio");
		
		crearArmaAsedio.setOnAction(new BotonCreadorDeArmaDeAsedioEventHandler
									(crearArmaAsedio, castillo, mapa, vistaMapa, ContenedorPartida.contenedorMapa, juego, vistaSeleccionador));
		return crearArmaAsedio;
	}
	
	private Background obtenerFondoCastillo(Posicionable posicionable, Pane pane) {
		
		
		int colIndex = ContenedorPartida.contenedorMapa.obtenerColumnIndex(pane);
		int rowIndex = ContenedorPartida.contenedorMapa.obtenerRowIndex(pane);
		
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
