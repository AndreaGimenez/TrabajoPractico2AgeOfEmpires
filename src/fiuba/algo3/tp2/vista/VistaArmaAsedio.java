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
import fiuba.algo3.tp2.unidad.Ataque;
import fiuba.algo3.tp2.unidad.GestionadorMontajeArmaAsedio;
import fiuba.algo3.tp2.vida.VidaUnidad;
import fiuba.algo3.tp2.vista.botones.CreadorBotonAtaque;
import fiuba.algo3.tp2.vista.botones.CreadorBotonesMovimiento;
import fiuba.algo3.tp2.vista.constantes.Constantes;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class VistaArmaAsedio implements VistaPosicionable, VistaMovible, Observer {
	
	private ContenedorControles contenedorControles;
	private ContenedorMapa contenedorMapa;
	private VistaSeleccionador vistaSeleccionador;
	private VistaMapa vistaMapa;
	private Juego juego;
	
	private Button accionAtacar;
	private GridPane accionesMovimiento;
	private Button accionMontar;


	public VistaArmaAsedio(ContenedorControles contenedorControles, 
							ContenedorMapa contenedorMapa, 
							VistaSeleccionador vistaSeleccionador, 
							VistaMapa vistaMapa, 
							Juego juego,
							ArmaAsedio armaAsedio) {
		
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.vistaSeleccionador = vistaSeleccionador;
		this.vistaMapa = vistaMapa;
		this.juego = juego;
		
		this.accionMontar = crearAccionMontar(armaAsedio);
		this.accionAtacar = new CreadorBotonAtaque(juego, vistaMapa, vistaSeleccionador, ContenedorPartida.contenedorMapa).crearBoton(armaAsedio);
		this.accionesMovimiento = new CreadorBotonesMovimiento(this, vistaSeleccionador, juego.obtenerMapa()).crearBotones(armaAsedio);
	}

	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		if(this.juego.posicionablePerteneceAPrimerJugador(posicionable))
			pane.setBackground(obtenerFondoArmaAsedioDeJugadorRojo((ArmaAsedio) posicionable));
		else
			pane.setBackground(obtenerFondoArmaAsedioDeJugadorAzul((ArmaAsedio) posicionable));
	}

	private Background obtenerFondoArmaAsedioDeJugadorAzul(ArmaAsedio armaAsedio) {

		String imagePath = "";

		if(armaAsedio.estaMontada()) {
			imagePath = Constantes.ARMA_ASEDIO_MONTADA;
		}else {
			imagePath = Constantes.ARMA_ASEDIO_DESMONTADA;
		}

		if(armaAsedio.estaMuerta())
			imagePath = Constantes.UNIDAD_MUERTA;

		Image imagen = new Image(imagePath,
				VistaMapa.TAMANIO_NODO,
				VistaMapa.TAMANIO_NODO,
				false,
				true);

		BackgroundImage fondoArmaAsedio = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		return new Background(fondoArmaAsedio);
	}

	private Background obtenerFondoArmaAsedioDeJugadorRojo(ArmaAsedio armaAsedio) {

		String imagePath;

		if(armaAsedio.estaMontada())
			imagePath = Constantes.ARMA_ASEDIO_MONTADA_ROJA;
		else
			imagePath = Constantes.ARMA_ASEDIO_DESMONTADA_ROJA;

		if(armaAsedio.estaMuerta())
			imagePath = Constantes.UNIDAD_MUERTA;

		Image imagen = new Image(imagePath,
				VistaMapa.TAMANIO_NODO,
				VistaMapa.TAMANIO_NODO,
				false,
				true);

		BackgroundImage fondoArmaAsedio = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		return new Background(fondoArmaAsedio);

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
		acciones.add(accionMontar);
		acciones.add(accionAtacar);
		
		//Movimientos
		ContenedorPartida.contenedorControles.getChildren().add(accionesMovimiento);
		
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

		if (this.juego.posicionablePerteneceAPrimerJugador(movible)) {
			ContenedorPartida.contenedorMapa.setBackground(obtenerFondoArmaAsedioDeJugadorRojo((ArmaAsedio) movible), movible.obtenerPosicion());
		} else {
			ContenedorPartida.contenedorMapa.setBackground(obtenerFondoArmaAsedioDeJugadorAzul((ArmaAsedio) movible), movible.obtenerPosicion());
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
		ArmaAsedio armaAsedio = (ArmaAsedio)o;
		
		if(arg instanceof Posicion) {
			
			Posicion posicionAnterior = (Posicion)arg;
			contenedorMapa.actualizarPosicionVistaPosicionable(this, posicionAnterior, armaAsedio.obtenerPosicion());
			this.accionesMovimiento.setDisable(true);
			dibujarPosicionable(armaAsedio, posicionAnterior);
			
		}else if(arg instanceof Ataque) {
			
			this.accionAtacar.setDisable(true);
			
		}else if(arg instanceof VidaUnidad) {
			
			dibujarPosicionable(armaAsedio);
			if(armaAsedio.estaMuerta()) {
				contenedorMapa.removerVista(armaAsedio.obtenerPosicion());
			}
			
		}else if(arg instanceof GestionadorMontajeArmaAsedio) {
			
			GestionadorMontajeArmaAsedio gestionadorMontajeArmaAsedio = (GestionadorMontajeArmaAsedio)arg;
			
			if(gestionadorMontajeArmaAsedio.montajeEnCurso()) {
				this.accionMontar.setText("Montando...");
				this.accionMontar.setDisable(true);
				this.accionesMovimiento.setDisable(true);
				this.accionAtacar.setDisable(true);
			}else if(gestionadorMontajeArmaAsedio.desmontajeEnCurso()) {
				this.accionMontar.setText("Desmontando...");
				this.accionMontar.setDisable(true);
				this.accionesMovimiento.setDisable(true);
				this.accionAtacar.setDisable(true);
			}else if(gestionadorMontajeArmaAsedio.estaMontada()) {
				this.accionMontar.setText("Desmontar");
				this.accionMontar.setDisable(false);
				this.accionesMovimiento.setDisable(true);
				this.accionAtacar.setDisable(false);
			}else if(!gestionadorMontajeArmaAsedio.estaMontada()) {
				this.accionMontar.setText("Montar");
				this.accionMontar.setDisable(false);
				this.accionesMovimiento.setDisable(false);
				this.accionAtacar.setDisable(true);
			}
			
		}else {
			
			this.accionesMovimiento.setDisable(false);
			this.accionAtacar.setDisable(false);
		}
	}
}
