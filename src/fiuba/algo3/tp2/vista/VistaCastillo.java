package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.construccion.EstadoConstruccion;
import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.generacionDeUnidades.Generable;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.vida.VidaEdificio;
import fiuba.algo3.tp2.vista.contenedores.ContenedorControles;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;
import fiuba.algo3.tp2.vista.handlers.BotonCreadorDeArmaDeAsedioEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class VistaCastillo implements VistaPosicionable, Observer {
	
	private Mapa mapa;
	private ContenedorControles contenedorControles;
	private ContenedorMapa contenedorMapa;
	private VistaMapa vistaMapa;
	private Juego juego;
	private VistaSeleccionador vistaSeleccionador;

	
	public VistaCastillo(ContenedorMapa contenedorMapa, ContenedorControles contenedorControles, VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador, Juego juego) {
		this.mapa = juego.obtenerMapa();
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.vistaMapa = vistaMapa;
		this.juego = juego;
		this.vistaSeleccionador = vistaSeleccionador;
	}
	
	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {

		if (this.juego.posicionablePerteneceAPrimerJugador(posicionable)) {
			String rojo = "rojo";
			pane.setBackground(obtenerFondoCastillo((Castillo) posicionable, pane, rojo));
		} else {
			String azul = "azul";
			pane.setBackground(obtenerFondoCastillo((Castillo) posicionable, pane, azul));
		}

	}

	private Background obtenerFondoCastillo(Castillo castillo, Pane pane, String color) {

		int colIndex = ContenedorPartida.contenedorMapa.obtenerColumnIndex(pane);
		int rowIndex = ContenedorPartida.contenedorMapa.obtenerRowIndex(pane);

		String nombreImagen = new Posicion(colIndex, rowIndex).restar(castillo.obtenerPosicion()).toString();
		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/castillo-" + color + "/" + nombreImagen + ".jpg",
				VistaMapa.TAMANIO_NODO,
				VistaMapa.TAMANIO_NODO,
				false,
				true);

		BackgroundImage fondoCastillo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		return new Background(fondoCastillo);

	}

	public void dibujarPosicionable(Castillo castillo) {
		
		for(Posicion posicion : castillo.obtenerPosicionesOcupadasEnMapa()) {
			
			Pane nodo = contenedorMapa.obtenerNodo(posicion);
			dibujarPosicionable(castillo, nodo);
		}
	}

	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		ContenedorPartida.contenedorControles.clean();
		
		Castillo castillo = (Castillo) posicionable;
		
		contenedorControles.setNombreUnidad("Castillo");
		contenedorControles.setVida(castillo.obtenerVida(), castillo.obtenerVidaMaxima());

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

	@Override
	public void update(Observable observable, Object objetoQueCambio) {
		if(objetoQueCambio instanceof VidaEdificio) {
			//considerar si sufrio danio, se destruyo, se recupero vida,  se termino de reparar(vida full)
			actualizarCambiosEnLaVida(((VidaEdificio) objetoQueCambio).obtenerVida(), ((VidaEdificio) objetoQueCambio).obtenerVidaMaxima());
		}
		
		if(objetoQueCambio instanceof Generable) {
			//considerar si se muestran o anulan los botones de generar unidad
			actualizarCambiosEnLaGeneracion(objetoQueCambio);

		}	
	}

	private void actualizarCambiosEnLaGeneracion(Object objetoQueCambio) {
		if(objetoQueCambio == null) {
			//activar botoon de generar unidades
		}
		else {
			//desactivar boton de generar unidades
		}
	}

	private void actualizarCambiosEnLaVida(int vidaActual, int vidaMaxima) {
		//Si la vida esta entre el 50% y el 100%
		if(vidaActual >= vidaMaxima/2 ) {
			//mostrar foto del cuartel sin danios
		}
		else {
			//mostrar foto del cuartel con danios
		}
	}
}
