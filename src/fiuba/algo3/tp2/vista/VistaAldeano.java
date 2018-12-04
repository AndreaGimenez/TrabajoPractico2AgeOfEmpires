package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Movible;
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
	
	public VistaAldeano(ContenedorControles contenedorControles, ContenedorMapa contenedorMapa, VistaSeleccionador vistaSeleccionador) {
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.vistaSeleccionador = vistaSeleccionador;
	}
	
	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		pane.setBackground(obtenerFondoAldeano());
	}

	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		contenedorControles.clean();
		
		contenedorControles.setNombreUnidad("Aldeano");
		
		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionConstruir());
		acciones.add(crearAccionReparar(/*edificio*/));
		
		//Movimientos
		acciones.addAll(new CreadorBotonesMovimiento(this, vistaSeleccionador).crearBotones((Movible)posicionable));
		
		contenedorControles.setAcciones(acciones);
	}
	
	@Override
	public void dibujarPosicionable(Movible movible, Posicion posicionAnterior) {
		contenedorMapa.setBackground(Background.EMPTY, posicionAnterior);
		contenedorMapa.setBackground(obtenerFondoAldeano(), movible.obtenerPosicion());
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
}
