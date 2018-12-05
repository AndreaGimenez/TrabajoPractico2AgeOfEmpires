package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.edificio.PosicionarEdificio;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.unidad.Aldeano;
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
		contenedorControles.setVida(((Aldeano)posicionable).obtenerVida());
		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionConstruir((Aldeano)posicionable));
		acciones.add(crearAccionReparar(/*edificio*/));
		acciones.add(crearAccionMoverse(this, posicionable, contenedorControles, vistaSeleccionador));
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

	private Button crearAccionConstruir(Aldeano aldeanoSeleccionado) {
		
		Button accionConstruir = new Button("Construir");
		BotonConstruirEdificioEventHandler botonConstruirEdificioEventHandler = new BotonConstruirEdificioEventHandler(accionConstruir, new PosicionarEdificio(aldeanoSeleccionado));
		
		return accionConstruir;
	}	
	
	private Button crearAccionMoverse(VistaAldeano vistaAldeano, Posicionable posicionableActual, ContenedorControles contenedorControles, VistaSeleccionador vistaSeleccionador) {
		Button accionMoverse = new Button("Mover");
		BotonMoverseHandler botonMoverseHandler = new BotonMoverseHandler(accionMoverse, posicionableActual, contenedorControles, vistaSeleccionador, vistaAldeano);
		accionMoverse.setOnAction(botonMoverseHandler);
		return accionMoverse;
	}
}
