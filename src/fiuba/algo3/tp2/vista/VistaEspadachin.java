package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Atacador;
import fiuba.algo3.tp2.unidad.Ataque;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.vida.VidaUnidad;
import fiuba.algo3.tp2.vista.botones.CreadorBotonAtaque;
import fiuba.algo3.tp2.vista.botones.CreadorBotonesMovimiento;
import fiuba.algo3.tp2.vista.contenedores.ContenedorControles;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;
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

public class VistaEspadachin implements VistaPosicionable, VistaMovible, Observer {

	private ContenedorControles contenedorControles;
	private ContenedorMapa contenedorMapa;
	private VistaSeleccionador vistaSeleccionador;
	private VistaMapa vistaMapa;
	private Juego juego;
	
	private Button accionAtacar;
	private GridPane accionesMovimiento;

	public VistaEspadachin(ContenedorControles contenedorControles, 
							ContenedorMapa contenedorMapa, 
							VistaSeleccionador vistaSeleccionador,
							VistaMapa vistaMapa,
							Juego juego,
							Espadachin espadachin) {
		
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.vistaSeleccionador = vistaSeleccionador;
		this.vistaMapa = vistaMapa;
		this.juego = juego;
		
		this.accionAtacar = new CreadorBotonAtaque(juego, vistaMapa, vistaSeleccionador, ContenedorPartida.contenedorMapa).crearBoton(espadachin);
		this.accionesMovimiento = new CreadorBotonesMovimiento(this, vistaSeleccionador, juego.obtenerMapa()).crearBotones(espadachin);
	}

	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		if(this.juego.posicionablePerteneceAPrimerJugador(posicionable))
			pane.setBackground(obtenerFondoEspadachinDeJugadorRojo());
		else
			pane.setBackground(obtenerFondoEspadachinDeJugadorAzul());
	}

	private Background obtenerFondoEspadachinDeJugadorAzul() {

		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/espadachin.jpg",
				VistaMapa.TAMANIO_NODO,
				VistaMapa.TAMANIO_NODO,
				false,
				true);

		BackgroundImage fondoAldeano = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		return new Background(fondoAldeano);

	}

	private Background obtenerFondoEspadachinDeJugadorRojo() {

		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/espadachin-rojo.jpg",
				VistaMapa.TAMANIO_NODO,
				VistaMapa.TAMANIO_NODO,
				false,
				true);

		BackgroundImage fondoAldeano = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		return new Background(fondoAldeano);

	}

	public void dibujarPosicionable(Espadachin espadachin) {
		Pane nodo = contenedorMapa.obtenerNodo(espadachin.obtenerPosicion());
		dibujarPosicionable(espadachin, nodo);
	}
	
	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		ContenedorPartida.contenedorControles.clean();
		
		Espadachin espadachin = (Espadachin)posicionable;
		
		contenedorControles.setNombreUnidad("Espadachin");
		contenedorControles.setVida(espadachin.obtenerVida(), espadachin.obtenerVidaMaxima());

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(accionAtacar);

		ContenedorPartida.contenedorControles.getChildren().add(accionesMovimiento);
		ContenedorPartida.contenedorControles.setAcciones(acciones);
	}
	 
	@Override
	public void dibujarPosicionable(Movible movible, Posicion posicionAnterior) {
		ContenedorPartida.contenedorMapa.setBackground(Background.EMPTY, posicionAnterior);

		if(this.juego.posicionablePerteneceAPrimerJugador(movible))
			ContenedorPartida.contenedorMapa.setBackground(obtenerFondoEspadachinDeJugadorRojo(), movible.obtenerPosicion());
		else
			ContenedorPartida.contenedorMapa.setBackground(obtenerFondoEspadachinDeJugadorAzul(), movible.obtenerPosicion());
	}

	@Override
	public void update(Observable o, Object arg) {
		
		Espadachin espadachin = (Espadachin)o;
		
		if(arg instanceof Posicion) {
			
			Posicion posicionAnterior = (Posicion)arg;
			contenedorMapa.actualizarPosicionVistaPosicionable(this, posicionAnterior, espadachin.obtenerPosicion());
			this.accionesMovimiento.setDisable(true);
			dibujarPosicionable(espadachin, posicionAnterior);
			
		}else if(arg instanceof Ataque) {
			
			this.accionAtacar.setDisable(true);
			
		}else if(arg instanceof VidaUnidad) {
			
			dibujarPosicionable(espadachin);
			if(espadachin.estaMuerta()) {
				contenedorMapa.removerVista(espadachin.obtenerPosicion());
			}
			
			Pane nodo = contenedorMapa.obtenerNodo(espadachin.obtenerPosicion());
			Shape nodoShape = new Rectangle(nodo.getWidth(), nodo.getHeight());
			nodo.getChildren().add(nodoShape);
			final Animation animation = new ColorTransition(Color.RED, nodoShape);
	        animation.play();
			
		}else {
			
			this.accionesMovimiento.setDisable(false);
			this.accionAtacar.setDisable(false);
		}
	}
}
