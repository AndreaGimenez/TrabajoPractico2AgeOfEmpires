package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Movible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonMoverseHandler implements EventHandler<ActionEvent>{
	
	Button boton;
	Posicionable posicionable;
	ContenedorControles contenedorControles;
	VistaSeleccionador vistaSeleccionador;
	VistaPosicionable vistaPosicionable;
	
	public BotonMoverseHandler(Button accionMoverse, Posicionable posicionableActual, ContenedorControles contenedorControles, VistaSeleccionador vistaSeleccionador, VistaPosicionable vistaPosicionable) {
		this.boton = accionMoverse;
		this.posicionable = posicionableActual;
		this.contenedorControles = contenedorControles;
		this.vistaSeleccionador = vistaSeleccionador;
		this.vistaPosicionable = vistaPosicionable;
	}

	@Override
	public void handle(ActionEvent event) {
		contenedorControles.clean();
		
		Collection<Button> direccionMovimientos = new ArrayList<Button>();

		direccionMovimientos.addAll(new CreadorBotonesMovimiento(vistaPosicionable, vistaSeleccionador).crearBotones((Movible)posicionable));
				
		contenedorControles.setAcciones(direccionMovimientos);
	}
	
}
