package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.construccion.Construible;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.movimiento.MovimientoBasico;
import fiuba.algo3.tp2.reparacion.ReparadorEdificio;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.vida.VidaUnidad;
import fiuba.algo3.tp2.vista.botones.CreadorBotonesMovimiento;
import fiuba.algo3.tp2.vista.constantes.Constantes;
import fiuba.algo3.tp2.vista.contenedores.ContenedorControles;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;
import fiuba.algo3.tp2.vista.handlers.BotonAldeanoReparaEdificioEventHandler;
import fiuba.algo3.tp2.vista.handlers.BotonConstruirCuartelHandler;
import fiuba.algo3.tp2.vista.handlers.BotonConstruirPlazaCentralHandler;
import javafx.animation.Animation;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class VistaAldeano implements VistaPosicionable, VistaMovible, Observer {
	
	private ContenedorMapa contenedorMapa;
	private VistaSeleccionador vistaSeleccionador;
	private VistaMapa vistaMapa;
	private Juego juego;
	
	private Button accionReparar;
	private Button accionConstruirPlazaCentral;
	private Button accionConstruirCuartel;
	private GridPane accionesMovimiento;
	
	
	public VistaAldeano(ContenedorControles contenedorControles, 
						ContenedorMapa contenedorMapa, 
						VistaSeleccionador vistaSeleccionador, 
						VistaMapa vistaMapa, 
						Juego juego,
						Aldeano aldeano) {
		
		this.contenedorMapa = contenedorMapa;
		this.vistaSeleccionador = vistaSeleccionador; 
		this.vistaMapa = vistaMapa;
		this.juego = juego;
		
		this.accionReparar = crearAccionReparar(aldeano);
		
		this.accionConstruirPlazaCentral = new Button("Construir Plaza Central");
		BotonConstruirPlazaCentralHandler botonConstruirPlazaCentral = new BotonConstruirPlazaCentralHandler(aldeano, vistaMapa, contenedorMapa, juego, vistaSeleccionador); 
		accionConstruirPlazaCentral.setOnAction(botonConstruirPlazaCentral);
		
		this.accionConstruirCuartel = new Button("Construir Cuartel");
		BotonConstruirCuartelHandler botonConstruirCuartel = new BotonConstruirCuartelHandler(aldeano, vistaMapa, ContenedorPartida.contenedorMapa, juego, vistaSeleccionador);
		accionConstruirCuartel.setOnAction(botonConstruirCuartel);
		
		this.accionesMovimiento = new CreadorBotonesMovimiento(this, vistaSeleccionador, juego.obtenerMapa()).crearBotones(aldeano);
	}

	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		if(this.juego.posicionablePerteneceAPrimerJugador(posicionable)) {
			String rojo = "rojo";
			pane.setBackground(obtenerFondoAldeano((Aldeano) posicionable, rojo));
		}else {
			String azul = "azul";
			pane.setBackground(obtenerFondoAldeano((Aldeano) posicionable, azul));
		}
	}
	
	public void dibujarPosicionable(Posicionable posicionable) {
		Pane nodo = contenedorMapa.obtenerNodo(posicionable.obtenerPosicion());
		dibujarPosicionable(posicionable, nodo);
	}
	
	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		ContenedorPartida.contenedorControles.clean();
		
		Aldeano aldeano = (Aldeano)posicionable; 
		
		ContenedorPartida.contenedorControles.setNombreUnidad("Aldeano");
		ContenedorPartida.contenedorControles.setVida(aldeano.obtenerVida(), aldeano.obtenerVidaMaxima());
		
		Collection<Button> acciones = new ArrayList<>();
		acciones.add(this.accionReparar);
		acciones.add(this.accionConstruirPlazaCentral);
		acciones.add(this.accionConstruirCuartel);
		
		ContenedorPartida.contenedorControles.getChildren().add(this.accionesMovimiento);
		ContenedorPartida.contenedorControles.setAcciones(acciones);
	}

	@Override
	public void dibujarPosicionable(Movible movible, Posicion posicionAnterior) {

		ContenedorPartida.contenedorMapa.setBackground(Background.EMPTY, posicionAnterior);

		if(this.juego.posicionablePerteneceAPrimerJugador(movible)){
			String rojo = "rojo";
			ContenedorPartida.contenedorMapa.setBackground(obtenerFondoAldeano((Aldeano) movible, rojo), movible.obtenerPosicion());
		}else{
			String azul = "azul";
			ContenedorPartida.contenedorMapa.setBackground(obtenerFondoAldeano((Aldeano) movible, azul), movible.obtenerPosicion());
		}
	}

	private Background obtenerFondoAldeano(Aldeano aldeano, String color) {
		String imagePath;

		if(aldeano.estaMuerta()) {
			imagePath = Constantes.UNIDAD_MUERTA;
		}else {
			imagePath = Constantes.ALDEANO + color + ".jpg";
		}
		Image imagen = new Image(imagePath,
				VistaMapa.TAMANIO_NODO,
				VistaMapa.TAMANIO_NODO,
				false,
				true);

		BackgroundImage fondoAldeano = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		return new Background(fondoAldeano);
	}

	private Button crearAccionReparar(Aldeano aldeano) {
		Button accionReparar = new Button("Reparar");
		
		BotonAldeanoReparaEdificioEventHandler botonAldeanoReparaEdificioEventHandler = 
									new BotonAldeanoReparaEdificioEventHandler(aldeano, vistaMapa, contenedorMapa, juego, vistaSeleccionador);
	
		accionReparar.setOnAction(botonAldeanoReparaEdificioEventHandler);
		return accionReparar;
	}
 
	@Override
	public void update(Observable o, Object arg) {
		
		Aldeano aldeano = (Aldeano)o;
		
		if(arg instanceof Posicion) {
			
			Posicion posicionAnterior = (Posicion)arg;
			contenedorMapa.actualizarPosicionVistaPosicionable(this, posicionAnterior, aldeano.obtenerPosicion());
			this.accionesMovimiento.setDisable(true);
			dibujarPosicionable(aldeano, posicionAnterior);
			
		}else if(arg instanceof ReparadorEdificio
				|| arg instanceof Construible) {
			
			this.accionesMovimiento.setDisable(true);
			this.accionConstruirCuartel.setDisable(true);
			this.accionConstruirPlazaCentral.setDisable(true);
			this.accionReparar.setDisable(true);
			
		}else if(arg instanceof MovimientoBasico) {
			
			this.accionesMovimiento.setDisable(false);
		}else if(arg instanceof VidaUnidad) {
			
			dibujarPosicionable(aldeano);
			if(aldeano.estaMuerta()) {
				contenedorMapa.removerVista(aldeano.obtenerPosicion());
			}
			
			Pane nodo = contenedorMapa.obtenerNodo(aldeano.obtenerPosicion());
			Shape nodoShape = new Rectangle(nodo.getWidth(), nodo.getHeight());
			nodo.getChildren().add(nodoShape);
			final Animation animation = new ColorTransition(Color.RED, nodoShape);
	        animation.play();
			
		}else {
			
			this.accionesMovimiento.setDisable(false);
			this.accionConstruirCuartel.setDisable(false);
			this.accionConstruirPlazaCentral.setDisable(false);
			this.accionReparar.setDisable(false);
		}
	}
}
