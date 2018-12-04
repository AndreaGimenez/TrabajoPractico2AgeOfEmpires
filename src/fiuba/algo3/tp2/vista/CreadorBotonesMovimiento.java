package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

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

public class CreadorBotonesMovimiento {

	private VistaSeleccionador vistaSeleccionador;
	private VistaPosicionable vistaPosicionable;


	public CreadorBotonesMovimiento(VistaPosicionable vistaPosicionable, VistaSeleccionador vistaSeleccionador) {
		this.vistaSeleccionador = vistaSeleccionador;
		this.vistaPosicionable = vistaPosicionable;
	}


	public Collection<Button> crearBotones(Movible movible) {
		
		Collection<Button> botones = new ArrayList<Button>();
		botones.add(crearAccionMover(movible, "Arriba", new DireccionArriba()));
		botones.add(crearAccionMover(movible, "ArribaDerecha", new DireccionArribaDerecha()));
		botones.add(crearAccionMover(movible, "Derecha", new DireccionDerecha()));
		botones.add(crearAccionMover(movible, "AbajoDerecha", new DireccionAbajoDerecha()));
		botones.add(crearAccionMover(movible, "Abajo", new DireccionAbajo()));
		botones.add(crearAccionMover(movible, "AbajoIzquierda", new DireccionAbajoIzquierda()));
		botones.add(crearAccionMover(movible, "Izquierda", new DireccionIzquierda()));
		botones.add(crearAccionMover(movible, "ArribaIzquierda", new DireccionArribaIzquierda()));
		
		return botones;
	}
	

	private Button crearAccionMover(Movible movible, String textoBoton, Direccion direccion) {

		Button botonMovimiento = new Button(textoBoton);
		
		BotonMovimientoHandler botonMovimientoHandler = new BotonMovimientoHandler(movible, direccion, vistaPosicionable, vistaSeleccionador);
		botonMovimiento.setOnAction(botonMovimientoHandler);
		
		return botonMovimiento;
	}

}
