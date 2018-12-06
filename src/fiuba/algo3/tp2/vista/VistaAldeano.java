package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ListIterator;

import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.unidad.Aldeano;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	private LinkedList<AccionPosicionarEdificio> construcciones;
	
	public VistaAldeano(ContenedorControles contenedorControles, ContenedorMapa contenedorMapa, VistaSeleccionador vistaSeleccionador) {
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.vistaSeleccionador = vistaSeleccionador;
		this.construcciones = new LinkedList<>();
	}

	private LinkedList<AccionPosicionarEdificio> crearConstrucciones(Aldeano aldeano) {
		LinkedList<AccionPosicionarEdificio> acciones = new LinkedList<>();

		acciones.add(new ConstruirCuartelArribaALaDerecha(aldeano));
		acciones.add(new ConstruirCuartelAbajoALaDerecha(aldeano));
		acciones.add(new ConstruirCuartelAbajoALaIzquierda(aldeano));
		acciones.add(new ConstruirCuartelALaDerechaPorDebajo(aldeano));
		acciones.add(new ConstruirCuartelALaDerechaPorEncima(aldeano));


		return acciones;
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

		this.construcciones.addAll(crearConstrucciones((Aldeano) posicionable));

		ComboBox<String> construirCuartel = new ComboBox<>();
		construirCuartel.getItems().addAll("Construir arriba a la derecha", "Construir arriba a la izquierda",
				"Construir abajo a la izquierda", "Construir abajo a la derecha", "Construir a la derecha por encima",
				"Construir a la derecha por debajo", "Construir a la izquierda por encima", "Construir a la izquierda por debajo",
				"Construir en arista superior izquierda", "Construir en arista superior derecha", "Construir en arista inferior izquierda",
				"Construir en arista inferior derecha");
		Button botonRealizarConstruccion = new Button("Aceptar");
		botonRealizarConstruccion.setOnAction(e -> buscarEvento(construirCuartel.getEditor().getText()).realizarConstruccion());

		Collection<Button> acciones = new ArrayList<>();
		acciones.add(crearAccionReparar(/*edificio*/));
		
		//Movimientos
		acciones.addAll(new CreadorBotonesMovimiento(this, vistaSeleccionador).crearBotones((Movible)posicionable));
		
		contenedorControles.setAcciones(acciones);
		contenedorControles.setAcciones(construirCuartel, botonRealizarConstruccion);
	}

	private AccionPosicionarEdificio buscarEvento(String accion) {
		AccionPosicionarEdificio buscado = null;

		ListIterator<AccionPosicionarEdificio> iterador = this.construcciones.listIterator();

		while(iterador.hasNext() && (buscado == null)){
			buscado = iterador.next().coincideAccion(accion);
		}

		return buscado;

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
}
