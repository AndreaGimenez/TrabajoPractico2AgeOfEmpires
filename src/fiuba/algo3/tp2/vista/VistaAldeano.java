package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.DireccionAbajoDerecha;
import fiuba.algo3.tp2.movimiento.DireccionAbajoIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionArriba;
import fiuba.algo3.tp2.movimiento.DireccionArribaDerecha;
import fiuba.algo3.tp2.movimiento.DireccionArribaIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;
import fiuba.algo3.tp2.movimiento.DireccionIzquierda;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.DireccionAbajo;
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
	private ContenedorMapa contenedorMapa;
	
	private VistaSeleccionador vistaSeleccionador;
	private VistaPosicionable vistaPosicionable;
	
	public VistaAldeano(VistaPosicionable vistaPosicionable) {
		this.vistaPosicionable = vistaPosicionable;
	}
	
	public void dibujar(Aldeano aldeano, Pane pane) {
		
		pane.setBackground(obtenerFondoAldeano());
	}
	
	public void dibujar(Aldeano aldeano, Posicion posicionAnterior) {
		
		contenedorMapa.setBackground(Background.EMPTY, posicionAnterior);
		contenedorMapa.setBackground(obtenerFondoAldeano(), aldeano.obtenerPosicion());
	}

	private Background obtenerFondoAldeano() {
		
		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/aldeano.jpg", 
			       VistaMapa.TAMANIO_NODO,
			 	   VistaMapa.TAMANIO_NODO,
			       false,
			       true);

		BackgroundImage fondoAldeano = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		return new Background(fondoAldeano);
	
	}
	
	public void dibujarControles(Aldeano aldeano) {
		
		aldeano.obtenerVida();
		contenedorControles.setNombreUnidad("Aldeano");
		
		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionConstruir());
		acciones.add(crearAccionReparar(/*edificio*/));
		
		//Movimientos
		acciones.addAll(new CreadorBotonesMovimiento(vistaPosicionable, vistaSeleccionador).crearBotones(aldeano));
		
		contenedorControles.setAcciones(acciones);
	}

	private Button crearAccionReparar(/*Edificio edificio*/) {
		Button accionReparar = new Button("Reparar");
		/*BotonAldeanoReparaEdificioEventHandler botonAldeanoReparaEdificioEventHandler = new BotonAldeanoReparaEdificioEventHandler(edificio);
		botonAldeanoReparaEdificioEventHandler.seleccionarAldeano(aldeano);
		accionReparar.setOnAction(botonAldeanoReparaEdificioEventHandler);*/
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

	public void setContenedorMapa(ContenedorMapa contenedorMapa) {
		this.contenedorMapa = contenedorMapa;
	}
	
	public void setVistaSeleccionador(VistaSeleccionador vistaSeleccionador) {
		this.vistaSeleccionador = vistaSeleccionador;
	}
}
