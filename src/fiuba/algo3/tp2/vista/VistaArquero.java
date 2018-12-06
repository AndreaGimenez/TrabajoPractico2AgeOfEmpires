package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Movible;
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

public class VistaArquero implements VistaPosicionable, VistaMovible {

	private ContenedorControles contenedorControles;
	private ContenedorMapa contenedorMapa;
	private VistaSeleccionador vistaSeleccionador;
	private VistaMapa vistaMapa;
	private Juego juego;

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
	
	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		contenedorControles.clean();
		
		Arquero arquero = (Arquero)posicionable;

		contenedorControles.setNombreUnidad("Arquero");
		contenedorControles.setVida(arquero.obtenerVida());

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(new CreadorBotonAtaque(juego, vistaMapa, vistaSeleccionador, contenedorMapa).crearBoton((Atacador)posicionable));
		
		//Movimientos
		acciones.addAll(new CreadorBotonesMovimiento(this, vistaSeleccionador).crearBotones((Movible)posicionable));

		contenedorControles.setAcciones(acciones);
	}
	
	@Override
	public void dibujarPosicionable(Movible movible, Posicion posicionAnterior) {
		contenedorMapa.setBackground(Background.EMPTY, posicionAnterior);
		contenedorMapa.setBackground(obtenerFondoArquero(), movible.obtenerPosicion());
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
}
