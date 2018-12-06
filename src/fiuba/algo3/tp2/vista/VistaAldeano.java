package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ListIterator;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.vista.botones.BotonAldeanoReparaEdificioEventHandler;
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
	private VistaMapa vistaMapa;
	private Juego juego;
	
	public VistaAldeano(ContenedorControles contenedorControles, ContenedorMapa contenedorMapa, VistaSeleccionador vistaSeleccionador, VistaMapa vistaMapa, Juego juego) {
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.vistaSeleccionador = vistaSeleccionador;
		this.construcciones = new LinkedList<>();
		this.vistaMapa = vistaMapa;
		this.juego = juego;
	}

	private LinkedList<AccionPosicionarEdificio> crearConstrucciones(Aldeano aldeano) {
		LinkedList<AccionPosicionarEdificio> acciones = new LinkedList<>();
		
		acciones.add(new ConstruirCuartelAristaSuperiorDerecha(aldeano));
		acciones.add(new ConstruirCuartelAristaSuperiorIzquierda(aldeano));
		
		acciones.add(new ConstruirCuartelArribaALaDerecha(aldeano));
		acciones.add(new ConstruirCuartelArribaALaIzquierda(aldeano));
		
		acciones.add(new ConstruirCuartelAbajoALaDerecha(aldeano));
		acciones.add(new ConstruirCuartelAbajoALaIzquierda(aldeano));
		
		acciones.add(new ConstruirCuartelALaDerechaPorDebajo(aldeano));
		acciones.add(new ConstruirCuartelALaDerechaPorEncima(aldeano));
		
		acciones.add(new ConstruirCuartelAristaInferiorDerecha(aldeano));
		acciones.add(new ConstruirCuartelAristaInferiorIzquierda(aldeano));
		
		acciones.add(new ConstruirCuartelALaIzquierdaPorDebajo(aldeano));
		acciones.add(new ConstruirCuartelALaIzquierdaPorEncima(aldeano));

		return acciones;
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
		acciones.add(crearAccionReparar((Aldeano) posicionable));
		
		//Movimientos
		contenedorControles.getChildren().add((new CreadorBotonesMovimiento(this, vistaSeleccionador).crearBotones((Movible)posicionable)));
		
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

	private Button crearAccionReparar(Aldeano aldeano) {
		Button accionReparar = new Button("Reparar");
		
		BotonAldeanoReparaEdificioEventHandler botonAldeanoReparaEdificioEventHandler = 
									new BotonAldeanoReparaEdificioEventHandler(aldeano, vistaMapa, contenedorMapa, juego, vistaSeleccionador);
	
		accionReparar.setOnAction(botonAldeanoReparaEdificioEventHandler);
		return accionReparar;
	}
}
