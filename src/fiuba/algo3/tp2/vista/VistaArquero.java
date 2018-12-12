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
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Atacador;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class VistaArquero implements VistaPosicionable, VistaMovible, Observer {

	private ContenedorControles contenedorControles;
	private ContenedorMapa contenedorMapa;
	private VistaSeleccionador vistaSeleccionador;
	private VistaMapa vistaMapa;
	private Juego juego;
	private Button botonAtacar;

	public VistaArquero(ContenedorControles contenedorControles, 
						ContenedorMapa contenedorMapa, 
						VistaSeleccionador vistaSeleccionador,
						VistaMapa vistaMapa,
						Juego juego) {
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.vistaSeleccionador = vistaSeleccionador;
		this.vistaMapa = vistaMapa;
		this.juego = juego;
	}

	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		pane.setBackground(obtenerFondoArquero());
	}
	
	public void dibujarPosicionable(Arquero arquero) {
		Pane nodo = contenedorMapa.obtenerNodo(arquero.obtenerPosicion());
		dibujarPosicionable(arquero, nodo);
	}
	
	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		ContenedorPartida.contenedorControles.clean();
		
		Arquero arquero = (Arquero)posicionable;

		contenedorControles.setNombreUnidad("Arquero");
		contenedorControles.setVida(arquero.obtenerVida(), arquero.obtenerVidaMaxima());

		Collection<Button> acciones = new ArrayList<Button>();
		
		botonAtacar = new CreadorBotonAtaque(juego, vistaMapa, vistaSeleccionador, ContenedorPartida.contenedorMapa).crearBoton((Atacador)posicionable);
		acciones.add(botonAtacar);
		
		//Movimientos
		ContenedorPartida.contenedorControles.getChildren().add((new CreadorBotonesMovimiento(this, vistaSeleccionador, juego.obtenerMapa()).crearBotones((Movible)posicionable)));

		ContenedorPartida.contenedorControles.setAcciones(acciones);
	}
	
	@Override
	public void dibujarPosicionable(Movible movible, Posicion posicionAnterior) {
		ContenedorPartida.contenedorMapa.setBackground(Background.EMPTY, posicionAnterior);
		ContenedorPartida.contenedorMapa.setBackground(obtenerFondoArquero(), movible.obtenerPosicion());
	}

	public Background obtenerFondoArquero() {
		
		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/arquero.jpeg", 
					 VistaMapa.TAMANIO_NODO, 
					 VistaMapa.TAMANIO_NODO, 
					 false, 
					 true);

        BackgroundImage fondoAldeano = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        return new Background(fondoAldeano);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		Arquero arquero = (Arquero)o;
		Posicion posicionAnterior = (Posicion) arg;
		
		dibujarPosicionable(arquero, posicionAnterior);
	}
}
