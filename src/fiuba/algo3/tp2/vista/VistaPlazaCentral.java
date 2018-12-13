package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.construccion.EstadoConstruccion;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.generacionDeUnidades.Generable;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.vida.VidaEdificio;
import fiuba.algo3.tp2.vista.contenedores.ContenedorControles;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;
import fiuba.algo3.tp2.vista.handlers.BotonCreadorDeAldeanosEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class VistaPlazaCentral implements VistaPosicionable, Observer {

	private ContenedorControles contenedorControles;
	private Mapa mapa;
	private ContenedorMapa contenedorMapa;
	private VistaMapa vistaMapa;
	private Juego juego;
	private VistaSeleccionador vistaSeleccionador;
	private Button botonCrearAldeano;
	private PlazaCentral plazaCentral;

	
	public VistaPlazaCentral(ContenedorMapa contenedorMapa, ContenedorControles contenedorControles, VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador, Juego juego, PlazaCentral plazaCentral) {
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.mapa = juego.obtenerMapa();
		this.vistaMapa = vistaMapa;
		this.juego = juego;
		this.vistaSeleccionador = vistaSeleccionador;
		this.botonCrearAldeano = crearAccionCrearAldeano(plazaCentral);
		this.plazaCentral = plazaCentral;
	}
	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		if(this.juego.posicionablePerteneceAPrimerJugador(posicionable)) {
			String rojo = "rojo";
			pane.setBackground(obtenerFondoPlazaCentral((PlazaCentral) posicionable, pane, rojo));
		}else {
			String azul = "azul";
			pane.setBackground(obtenerFondoPlazaCentral((PlazaCentral) posicionable, pane, azul));
		}
	}

	private Background obtenerFondoPlazaCentral(PlazaCentral plazaCentral, Pane pane, String color) {

		int colIndex = ContenedorPartida.contenedorMapa.obtenerColumnIndex(pane);
		int rowIndex = ContenedorPartida.contenedorMapa.obtenerRowIndex(pane);

		String nombreImagen = new Posicion(colIndex, rowIndex).restar(plazaCentral.obtenerPosicion()).toString();

		String imagePath = "file:src/fiuba/algo3/tp2/vista/imagenes/plaza-central-" + color + "/" + nombreImagen + ".jpg";

		Image imagen = new Image(imagePath,
				VistaMapa.TAMANIO_NODO,
				VistaMapa.TAMANIO_NODO,
				false,
				true);

		BackgroundImage fondoPlazaCentral = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		return new Background(fondoPlazaCentral);

	}

	public void dibujarPosicionable(PlazaCentral plazaCentral) {

		for(Posicion posicion : plazaCentral.obtenerPosicionesOcupadasEnMapa()) {
			
			Pane nodo = contenedorMapa.obtenerNodo(posicion);
			dibujarPosicionable(plazaCentral, nodo);
		}
	}

	@Override
	public void dibujarControles(Posicionable posicionable) {

		ContenedorPartida.contenedorControles.clean();
		
		PlazaCentral plazaCentral = (PlazaCentral) posicionable;
		
		contenedorControles.setNombreUnidad("Plaza Central");
		contenedorControles.setVida(plazaCentral.obtenerVida(), plazaCentral.obtenerVidaMaxima());

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(botonCrearAldeano);

		ContenedorPartida.contenedorControles.setAcciones(acciones);
	} 

	private Button crearAccionCrearAldeano(PlazaCentral plazaCentral) {
		Button crearAldeano = new Button("Crear Aldeano");
		crearAldeano.setOnAction(new BotonCreadorDeAldeanosEventHandler
				(crearAldeano, plazaCentral, mapa, vistaMapa, ContenedorPartida.contenedorMapa, juego, vistaSeleccionador));
		return crearAldeano;
	}

	@Override
	public void update(Observable observable, Object objetoQueCambio) {
		if(objetoQueCambio instanceof VidaEdificio) {
			//considerar si sufrio danio, se destruyo, se recupero vida,  se termino de reparar(vida full)
			actualizarCambiosEnLaVida(((VidaEdificio) objetoQueCambio).obtenerVida(), ((VidaEdificio) objetoQueCambio).obtenerVidaMaxima());
		}else if(objetoQueCambio instanceof EstadoConstruccion) {
			//considerar si se termino de construir o si se avanzo en la construccion
			actualizarCambiosEnLaConstruccion(((EstadoConstruccion)objetoQueCambio));
		}else if(objetoQueCambio instanceof Generable) {
			//considerar si se muestran o anulan los botones de generar unidad
			actualizarCambiosEnLaGeneracion((Generable) objetoQueCambio);
		}else {
			actualizarCambiosEnLaGeneracion(null);
		}
	}
	

	private void actualizarCambiosEnLaGeneracion(Object objetoQueCambio) {
		if(objetoQueCambio != null) {
			this.botonCrearAldeano.setDisable(true);
		}
		else {
			this.botonCrearAldeano.setDisable(false);
		}
	}

	private void actualizarCambiosEnLaConstruccion(EstadoConstruccion objetoQueCambio) {
		if(objetoQueCambio.estaConstruido()) {
			dibujarPosicionable(plazaCentral);
		}
	}

	private void actualizarCambiosEnLaVida(int vidaActual, int vidaMaxima) {
		//Si la vida esta entre el 50% y el 100%
		if(vidaActual >= vidaMaxima/2 ) {
			//mostrar foto dde la plaza central sin danios
		}
		else {
			//mostrar foto de la plaza central con danios
		}
	}
}
