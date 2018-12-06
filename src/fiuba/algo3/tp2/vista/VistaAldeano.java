package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

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
import javafx.scene.layout.Pane;

public class VistaAldeano implements VistaPosicionable, VistaMovible {
	
	private ContenedorControles contenedorControles;
	private ContenedorMapa contenedorMapa;
	private VistaSeleccionador vistaSeleccionador;
	private VistaMapa vistaMapa;
	private Juego juego;
	
	public VistaAldeano(ContenedorControles contenedorControles, ContenedorMapa contenedorMapa, VistaSeleccionador vistaSeleccionador, VistaMapa vistaMapa, Juego juego) {
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.vistaSeleccionador = vistaSeleccionador;
		this.vistaMapa = vistaMapa;
		this.juego = juego;
	}
	
	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		pane.setBackground(obtenerFondoAldeano((Aldeano)posicionable));
	}

	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		contenedorControles.clean();
		
		contenedorControles.setNombreUnidad("Aldeano");
		contenedorControles.setVida(((Aldeano)posicionable).obtenerVida());
		
		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionConstruir());
		acciones.add(crearAccionReparar((Aldeano)posicionable));
		
		//Movimientos
		acciones.addAll(new CreadorBotonesMovimiento(this, vistaSeleccionador).crearBotones((Movible)posicionable));
		
		contenedorControles.setAcciones(acciones);
	}
	
	@Override
	public void dibujarPosicionable(Movible movible, Posicion posicionAnterior) {
		contenedorMapa.setBackground(Background.EMPTY, posicionAnterior);
		contenedorMapa.setBackground(obtenerFondoAldeano((Aldeano)movible), movible.obtenerPosicion());
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

	private Button crearAccionReparar(Aldeano aldeano/*Edificio edificio*/) {
		Button accionReparar = new Button("Reparar");
		
		BotonAldeanoReparaEdificioEventHandler botonAldeanoReparaEdificioEventHandler = 
									new BotonAldeanoReparaEdificioEventHandler(aldeano, vistaMapa, contenedorMapa, juego, vistaSeleccionador);
	
		accionReparar.setOnAction(botonAldeanoReparaEdificioEventHandler);
		return accionReparar;
	}

	private Button crearAccionConstruir() {
		
		Button accionConstruir = new Button("Construir");
		//TODO Agregar el handler
		return accionConstruir;
	}
}
