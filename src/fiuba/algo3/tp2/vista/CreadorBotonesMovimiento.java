package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.DireccionAbajoDerecha;
import fiuba.algo3.tp2.movimiento.DireccionAbajoIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionArriba;
import fiuba.algo3.tp2.movimiento.DireccionArribaDerecha;
import fiuba.algo3.tp2.movimiento.DireccionArribaIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;
import fiuba.algo3.tp2.movimiento.DireccionIzquierda;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.DireccionAbajo;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class CreadorBotonesMovimiento {

	private VistaSeleccionador vistaSeleccionador;
	private VistaPosicionable vistaPosicionable;
	private ContenedorControles contenedorControles;

	public CreadorBotonesMovimiento(VistaPosicionable vistaPosicionable, VistaSeleccionador vistaSeleccionador, ContenedorControles contenedorControles) {
		this.vistaSeleccionador = vistaSeleccionador;
		this.vistaPosicionable = vistaPosicionable;
		this.contenedorControles = contenedorControles;
	}


	public Collection<Button> crearBotones(Movible movible) {
		
		Collection<Button> botones = new ArrayList<Button>();
		
		Button boton1 = crearAccionMover(movible, "Arriba", new DireccionArriba());
		botones.add(boton1);
		Button boton2 = crearAccionMover(movible, "ArribaDerecha", new DireccionArribaDerecha());
		botones.add(boton2);
		Button boton3 = crearAccionMover(movible, "Derecha", new DireccionDerecha());
		botones.add(boton3);
		Button boton4 = crearAccionMover(movible, "AbajoDerecha", new DireccionAbajoDerecha());
		botones.add(boton4);
		Button boton5 = crearAccionMover(movible, "Abajo", new DireccionAbajo());
		botones.add(boton5);
		Button boton6 = crearAccionMover(movible, "AbajoIzquierda", new DireccionAbajoIzquierda());
		botones.add(boton6);
		Button boton7 = crearAccionMover(movible, "Izquierda", new DireccionIzquierda());
		botones.add(boton7);
		Button boton8 = crearAccionMover(movible, "ArribaIzquierda", new DireccionArribaIzquierda());
		botones.add(boton8);
		
		/*botones.add(crearAccionMover(movible, "Arriba", new DireccionArriba()));
		botones.add(crearAccionMover(movible, "ArribaDerecha", new DireccionArribaDerecha()));
		botones.add(crearAccionMover(movible, "Derecha", new DireccionDerecha()));
		botones.add(crearAccionMover(movible, "AbajoDerecha", new DireccionAbajoDerecha()));
		botones.add(crearAccionMover(movible, "Abajo", new DireccionAbajo()));
		botones.add(crearAccionMover(movible, "AbajoIzquierda", new DireccionAbajoIzquierda()));
		botones.add(crearAccionMover(movible, "Izquierda", new DireccionIzquierda()));
		botones.add(crearAccionMover(movible, "ArribaIzquierda", new DireccionArribaIzquierda()));*/
		
		crearBotoneraMovimiento(botones, contenedorControles);
		return botones;
	}
	

	private void crearBotoneraMovimiento(Collection<Button> botonesMovimiento,ContenedorControles contenedorControles) {
		
		GridPane botonera = new GridPane();
		
		Posicion posicionesBotones[] = cargarPosicionesBotones();
		
		int i = 0;
		
		for(Button botonActual : botonesMovimiento) {
			Posicion posicion = posicionesBotones[i];
			botonera.add(botonActual, posicion.getY(), posicion.getX(),1,1);
			i++;
		}
		
		contenedorControles.getChildren().add(botonera);
	}

	private Posicion[] cargarPosicionesBotones() {
		Posicion posicionesBotones[] = new Posicion[8];
		
		posicionesBotones[0] = new Posicion(1,0);
		posicionesBotones[1] = new Posicion(2,0);
		posicionesBotones[2] = new Posicion(2,1);
		posicionesBotones[3] = new Posicion(2,2);
		posicionesBotones[4] = new Posicion(1,0);
		posicionesBotones[5] = new Posicion(1,2);
		posicionesBotones[6] = new Posicion(0,1);
		posicionesBotones[7] = new Posicion(0,0);
	
		return posicionesBotones;
	}
	
	private Button crearAccionMover(Movible movible, String textoBoton, Direccion direccion) {

		Button botonMovimiento = new Button(textoBoton);
		BotonMovimientoHandler botonMovimientoHandler = new BotonMovimientoHandler(movible, direccion, vistaPosicionable, vistaSeleccionador);
		botonMovimiento.setOnAction(botonMovimientoHandler);
		
		return botonMovimiento;
	}

}
