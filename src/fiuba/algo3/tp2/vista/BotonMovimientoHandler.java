package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.MovimientoInvalidoException;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Movible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMovimientoHandler implements EventHandler<ActionEvent>{
	
	private Movible movible;
	private Direccion direccion;
	private VistaPosicionable vistaPosicionable;
	private VistaSeleccionador vistaSeleccionador;
	
	public BotonMovimientoHandler(Movible movible, Direccion direccion, VistaPosicionable vistaPosicionable, VistaSeleccionador vistaSeleccionador) {
		this.movible = movible;
		this.direccion = direccion;
		this.vistaPosicionable = vistaPosicionable;
		this.vistaSeleccionador = vistaSeleccionador;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			Posicion posicionAnterior = movible.obtenerPosicion();
			movible.mover(direccion);
			vistaPosicionable.dibujarPosicionable(movible, posicionAnterior);
			vistaSeleccionador.seleccionarNodo(movible);
			
		} catch (MovimientoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
