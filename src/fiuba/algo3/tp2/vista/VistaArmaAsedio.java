package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Atacador;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.vista.botones.CreadorBotonAtaque;
import fiuba.algo3.tp2.vista.botones.CreadorBotonesMovimiento;
import fiuba.algo3.tp2.vista.contenedores.ContenedorControles;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;
import fiuba.algo3.tp2.vista.handlers.BotonMontarHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class VistaArmaAsedio implements VistaPosicionable, VistaMovible, Observer {

	private ContenedorControles contenedorControles;
	private ContenedorMapa contenedorMapa;
	private VistaSeleccionador vistaSeleccionador;
	private VistaMapa vistaMapa;
	private Juego juego;

	public VistaArmaAsedio(ContenedorControles contenedorControles, 
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
		pane.setBackground(obtenerFondoArmaAsedio((ArmaAsedio)posicionable));
	}
	
	public void dibujarPosicionable(ArmaAsedio armaAsedio) {
		Pane nodo = contenedorMapa.obtenerNodo(armaAsedio.obtenerPosicion());
		dibujarPosicionable(armaAsedio, nodo);
	}

	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		ContenedorPartida.contenedorControles.clean();
		
		ArmaAsedio armaAsedio = (ArmaAsedio)posicionable;
		
		contenedorControles.setNombreUnidad("Arma de Asedio");
		contenedorControles.setVida(armaAsedio.obtenerVida(), armaAsedio.obtenerVidaMaxima());
		
		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionMontar((ArmaAsedio)posicionable));
		acciones.add(new CreadorBotonAtaque(juego, vistaMapa, vistaSeleccionador, contenedorMapa).crearBoton((Atacador)posicionable));
		
		//Movimientos
		ContenedorPartida.contenedorControles.getChildren().add((new CreadorBotonesMovimiento(this, vistaSeleccionador, juego.obtenerMapa()).crearBotones((Movible)posicionable)));
		
		ContenedorPartida.contenedorControles.setAcciones(acciones);
	}
	
	private Button crearAccionMontar(ArmaAsedio armaAsedio) {
		
		String textoBoton = (armaAsedio.estaMontada()) ? "Desmontar" : "Montar";
		Button botonMontar = new Button(textoBoton);
		BotonMontarHandler botonMontarHandler = new BotonMontarHandler(botonMontar, armaAsedio, ContenedorPartida.contenedorMapa);
		botonMontar.setOnAction(botonMontarHandler);
		
		
		return botonMontar;
	}
	
	@Override
	public void dibujarPosicionable(Movible movible, Posicion posicionAnterior) {
		ContenedorPartida.contenedorMapa.setBackground(Background.EMPTY, posicionAnterior);
		ContenedorPartida.contenedorMapa.setBackground(obtenerFondoArmaAsedio((ArmaAsedio)movible), movible.obtenerPosicion());
	}

	private Background obtenerFondoArmaAsedio(ArmaAsedio armaAsedio) {
		
		Image imagen = null;
		if(armaAsedio.estaMontada()) {
			imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/arma-asedio-montada.jpg", 
					 50, 
					 50, 
					 false, 
					 true);
		}else {
			imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/arma-asedio-desmontada.png", 
					 50, 
					 50, 
					 false, 
					 true);
		}
		

       BackgroundImage fondoAldeano = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

       return new Background(fondoAldeano);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		ArmaAsedio armaAsedio = (ArmaAsedio)o;
		Posicion posicionAnterior = (Posicion) arg;
		
		dibujarPosicionable(armaAsedio, posicionAnterior);
	}
}
