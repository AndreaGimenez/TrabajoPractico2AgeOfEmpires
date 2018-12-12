package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.vista.botones.BotonAldeanoReparaEdificioEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class VistaAldeano implements VistaPosicionable, VistaMovible, Observer {
	
	private ContenedorMapa contenedorMapa;
	private VistaSeleccionador vistaSeleccionador;
	private VistaMapa vistaMapa;
	private Juego juego;
	
	public VistaAldeano(ContenedorControles contenedorControles, ContenedorMapa contenedorMapa, VistaSeleccionador vistaSeleccionador, VistaMapa vistaMapa, Juego juego) {
		this.contenedorMapa = contenedorMapa;
		this.vistaSeleccionador = vistaSeleccionador;
		this.vistaMapa = vistaMapa;
		this.juego = juego;
	}

	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		pane.setBackground(obtenerFondoAldeano((Aldeano)posicionable));
	}
	
	public void dibujarPosicionable(Posicionable posicionable) {
		Pane nodo = contenedorMapa.obtenerNodo(posicionable.obtenerPosicion());
		dibujarPosicionable(posicionable, nodo);
	}
	
	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		ContenedorPartida.contenedorControles.clean();
		
		ContenedorPartida.contenedorControles.setNombreUnidad("Aldeano");
		ContenedorPartida.contenedorControles.setVida(((Aldeano)posicionable).obtenerVida());

		
		Collection<Button> acciones = new ArrayList<>();
		acciones.add(crearAccionReparar((Aldeano) posicionable));
		
		Button construirPlazaCentral = new Button("Construir Plaza Central");
		BotonConstruirPlazaCentralHandler botonConstruirPlazaCentral = new BotonConstruirPlazaCentralHandler((Aldeano) posicionable, vistaMapa, contenedorMapa, juego, vistaSeleccionador); 
		construirPlazaCentral.setOnAction(botonConstruirPlazaCentral);
		acciones.add(construirPlazaCentral);
		
		Button construirCuartel = new Button("Construir Cuartel");
		BotonConstruirCuartelHandler botonConstruirCuartel = new BotonConstruirCuartelHandler((Aldeano) posicionable, vistaMapa, ContenedorPartida.contenedorMapa, juego, vistaSeleccionador);
		construirCuartel.setOnAction(botonConstruirCuartel);
		acciones.add(construirCuartel);
		
		//Movimientos
		GridPane botoneraMovimiento = new CreadorBotonesMovimiento(this, vistaSeleccionador, juego.obtenerMapa()).crearBotones((Movible)posicionable);
		ContenedorPartida.contenedorControles.getChildren().add(botoneraMovimiento);
		
		ContenedorPartida.contenedorControles.setAcciones(acciones);
	}

	@Override
	public void dibujarPosicionable(Movible movible, Posicion posicionAnterior) {
		if(this.juego.obtenerJugadorActual().posicionablePerteneceAJugador(movible)){
			ContenedorPartida.contenedorMapa.setBackground(Background.EMPTY, posicionAnterior);
			ContenedorPartida.contenedorMapa.setBackground(obtenerFondoAldeanoDeJugadorActual((Aldeano) movible), movible.obtenerPosicion());
		}else{
			ContenedorPartida.contenedorMapa.setBackground(Background.EMPTY, posicionAnterior);
			ContenedorPartida.contenedorMapa.setBackground(obtenerFondoAldeano((Aldeano) movible), movible.obtenerPosicion());
		}
	}


	//COPIE Y PEGUE. LO VOY A CAMBIAR
	private Background obtenerFondoAldeanoDeJugadorActual(Aldeano aldeano) {
		String imagePath;

		if(aldeano.estaMuerta()) {
			imagePath = "file:src/fiuba/algo3/tp2/vista/imagenes/unidad-muerta.jpg";
		}else {
			imagePath = "file:src/fiuba/algo3/tp2/vista/imagenes/aldeano_jugador_actual.jpg";
		}
		Image imagen = new Image(imagePath,
				VistaMapa.TAMANIO_NODO,
				VistaMapa.TAMANIO_NODO,
				false,
				true);

		BackgroundImage fondoAldeano = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		return new Background(fondoAldeano);
	}

	private Background obtenerFondoAldeano(Aldeano aldeano) {
		
		String imagePath = "";
		
		if(aldeano.estaMuerta()) {
			imagePath = "file:src/fiuba/algo3/tp2/vista/imagenes/unidad-muerta.jpg";
		}else {
			imagePath = "file:src/fiuba/algo3/tp2/vista/imagenes/aldeano.jpg";
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
		Posicion posicionAnterior = (Posicion) arg;
		
		dibujarPosicionable(aldeano, posicionAnterior);
	}
}
