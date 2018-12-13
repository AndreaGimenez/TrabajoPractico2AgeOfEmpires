package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.construccion.EstadoConstruccion;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.generacionDeUnidades.Generable;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.vida.VidaEdificio;
import fiuba.algo3.tp2.vista.contenedores.ContenedorControles;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;
import fiuba.algo3.tp2.vista.handlers.BotonCreadorDeArqueroEventHandler;
import fiuba.algo3.tp2.vista.handlers.BotonCreadorDeEspadachinEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class VistaCuartel implements VistaPosicionable, Observer {

	private ContenedorControles contenedorControles;
	private ContenedorMapa contenedorMapa;
	private Mapa mapa;
	private VistaMapa vistaMapa;
	private Juego juego;
	private VistaSeleccionador vistaSeleccionador;
	private Button botonCrearArquero;
	private Button botonCrearEspadachin;
	private Cuartel cuartel;

	public VistaCuartel(ContenedorMapa contenedorMapa, ContenedorControles contenedorControles, VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador, Juego juego, Cuartel cuartel) {
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.mapa = juego.obtenerMapa();
		this.vistaMapa = vistaMapa;
		this.juego = juego;
		this.vistaSeleccionador = vistaSeleccionador;
		this.cuartel = cuartel;
		this.botonCrearEspadachin = crearAccionCrearEspadachin();
		this.botonCrearArquero = crearAccionCrearArquero();
	}
	
	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		pane.setBackground(obtenerFondoCuartel((Cuartel)posicionable, pane));
	}
	
	public void dibujarPosicionable(Posicionable posicionable) {
		
		Cuartel cuartel = (Cuartel)posicionable;
		for(Posicion posicion : cuartel.obtenerPosicionesOcupadasEnMapa()) {
			
			Pane nodo = contenedorMapa.obtenerNodo(posicion);
			dibujarPosicionable(posicionable, nodo);
		}
	}
	
	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		ContenedorPartida.contenedorControles.clean();
		
		Cuartel cuartel = (Cuartel) posicionable;
		contenedorControles.setNombreUnidad("Cuartel");
		contenedorControles.setVida(cuartel.obtenerVida(), cuartel.obtenerVidaMaxima());

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(botonCrearArquero);
		acciones.add(botonCrearEspadachin);

		ContenedorPartida.contenedorControles.setAcciones(acciones);
	}

	private Button crearAccionCrearEspadachin() {
		Button botonCrearEspadachin = new Button("Crear Espadachin");
		botonCrearEspadachin.setOnAction(new BotonCreadorDeEspadachinEventHandler
				(botonCrearEspadachin, this.cuartel, mapa, vistaMapa, contenedorMapa, juego, vistaSeleccionador));
		return botonCrearEspadachin;
	}

	private Button crearAccionCrearArquero() {
		Button botonCrearArquero = new Button("Crear Arquero");
		botonCrearArquero.setOnAction(new BotonCreadorDeArqueroEventHandler
						(botonCrearArquero, this.cuartel, mapa, vistaMapa, contenedorMapa, juego, vistaSeleccionador));
		return botonCrearArquero;
	}
	
	private Background obtenerFondoCuartel(Cuartel unCuartel, Pane pane) {
		
		int colIndex = contenedorMapa.obtenerColumnIndex(pane);
		int rowIndex = contenedorMapa.obtenerRowIndex(pane);
		
		String imagePath = "";
		String nombreImagen = new Posicion(colIndex, rowIndex).restar(unCuartel.obtenerPosicion()).toString();
		
		if(unCuartel.estaConstruido()) {
			imagePath = "file:src/fiuba/algo3/tp2/vista/imagenes/cuartel" + nombreImagen + ".jpg";
		}
		else {
			imagePath = "file:src/fiuba/algo3/tp2/vista/imagenes/construccion-2x2" + nombreImagen + ".jpg";
		}
		Image imagen = new Image(imagePath, 
			       VistaMapa.TAMANIO_NODO,
			 	   VistaMapa.TAMANIO_NODO,
			       false,
			       true);
		 
//		String imagePath = "";
//		
//		if(aldeano.estaMuerta()) {
//			imagePath = "file:src/fiuba/algo3/tp2/vista/imagenes/unidad-muerta.jpg";
//		}else {
//			imagePath = "file:src/fiuba/algo3/tp2/vista/imagenes/aldeano.jpg";
//		}
//		Image imagen = new Image(imagePath, 
//			       VistaMapa.TAMANIO_NODO,
//			 	   VistaMapa.TAMANIO_NODO,
//			       false,
//			       true); 
//		}
		
		BackgroundImage fondoCastillo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		return new Background(fondoCastillo);
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

	private void actualizarCambiosEnLaGeneracion(Generable objetoQueCambio) {
		if(objetoQueCambio != null) {
			this.botonCrearArquero.setDisable(true);
			this.botonCrearEspadachin.setDisable(true);
			
		}
		else {
			this.botonCrearArquero.setDisable(false);
			this.botonCrearEspadachin.setDisable(false);
		}
	}

	private void actualizarCambiosEnLaConstruccion(EstadoConstruccion objetoQueCambio) {
		if(objetoQueCambio.estaConstruido()) {
			//poner imagen de cuartel construido
		}
		else {
			//poner imagen de cuartel en cimientos
		}
		
	}

	private void actualizarCambiosEnLaVida(int vidaActual, int vidaMaxima) {
		//Si la vida esta entre el 50% y el 100%
		if(vidaActual >= vidaMaxima/2 ) {
			//mostrar foto del cuartel sin ddanios
		}
		else { 
			//mostrar foto del cuartel con danios
		}
	}
}
