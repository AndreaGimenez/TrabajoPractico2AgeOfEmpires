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

	public VistaCuartel(ContenedorMapa contenedorMapa, ContenedorControles contenedorControles, VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador, Juego juego) {
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.mapa = juego.obtenerMapa();
		this.vistaMapa = vistaMapa;
		this.juego = juego;
		this.vistaSeleccionador = vistaSeleccionador;
	}
	
	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		pane.setBackground(obtenerFondoCuartel(posicionable, pane));
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
		acciones.add(crearAccionCrearArquero(cuartel));
		acciones.add(crearAccionCrearEspadachin(cuartel));

		ContenedorPartida.contenedorControles.setAcciones(acciones);
	}

	private Button crearAccionCrearEspadachin(Cuartel cuartel) {

		Button botonCrearEspadachin = new Button("Crear Espadachin");

		botonCrearEspadachin.setOnAction(new BotonCreadorDeEspadachinEventHandler(botonCrearEspadachin, cuartel, mapa, vistaMapa, contenedorMapa, juego, vistaSeleccionador));

		return botonCrearEspadachin;

	}

	private Button crearAccionCrearArquero(Cuartel cuartel) {

		Button botonCrearArquero = new Button("Crear Arquero");

		botonCrearArquero.setOnAction(new BotonCreadorDeArqueroEventHandler
						(botonCrearArquero, cuartel, mapa, vistaMapa, contenedorMapa, juego, vistaSeleccionador));

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

	@Override
	public void update(Observable observable, Object objetoQueCambio) {
		if(objetoQueCambio instanceof VidaEdificio) {
			//considerar si sufrio danio, se destruyo, se recupero vida,  se termino de reparar(vida full)
			actualizarCambiosEnLaVida(((VidaEdificio) objetoQueCambio).obtenerVida(), ((VidaEdificio) objetoQueCambio).obtenerVidaMaxima());
		}
		
		if(objetoQueCambio instanceof EstadoConstruccion) {
			//considerar si se termino de construir o si se avanzo en la construccion
			if(((EstadoConstruccion)objetoQueCambio).estaConstruido()) {
			actualizarCambiosEnLaConstruccion();
			}
		}
		
		if(objetoQueCambio instanceof Generable) {
			//considerar si se muestran o anulan los botones de generar unidad
			actualizarCambiosEnLaGeneracion(objetoQueCambio);

		}
	}

	private void actualizarCambiosEnLaGeneracion(Object objetoQueCambio) {
		// TODO Auto-generated method stub
		
	}

	private void actualizarCambiosEnLaConstruccion() {
			//poner imagen de cuartel construido
	}

	private void actualizarCambiosEnLaVida(int vidaActual, int vidaMaxima) {
		//Si la vida esta entre el 50% y el 100%
		if(vidaActual >= vidaMaxima/2 ) {
			//mostrar foto del cuartel sin daños
		}
		else {
			//mostrar foto del cuartel con daños
		}
	}
}
