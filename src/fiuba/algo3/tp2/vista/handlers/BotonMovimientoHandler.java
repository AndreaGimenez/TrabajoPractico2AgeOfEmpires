package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.MovimientoInvalidoException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.vista.MensajeDeError;
import fiuba.algo3.tp2.vista.VistaPosicionable;
import fiuba.algo3.tp2.vista.VistaSeleccionador;
import fiuba.algo3.tp2.vista.musica.Musica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMovimientoHandler implements EventHandler<ActionEvent>{
	
	private Movible movible;
	private Direccion direccion;
	private VistaSeleccionador vistaSeleccionador;
	private Musica musica;
	private Mapa mapa;
	
	public BotonMovimientoHandler(Movible movible, Direccion direccion, VistaPosicionable vistaPosicionable, VistaSeleccionador vistaSeleccionador, Mapa mapa) {
		this.movible = movible;
		this.direccion = direccion;
		this.vistaSeleccionador = vistaSeleccionador;
		this.mapa = mapa;
	}

	@Override
	public void handle(ActionEvent event) {
		MensajeDeError error = new MensajeDeError();
		try {
			movible.mover(direccion);
			vistaSeleccionador.seleccionarNodo(movible);
		} catch (MovimientoInvalidoException e) {
			error.mostrarVentanaError("Movimiento Invalido", "Intente nuevamente");
		} catch (CeldaOcupadaException e) {
			error.mostrarVentanaError("Celda Ocupada", "No puede moverse hacia una celda ocupada");
		}
		catch (CeldaInexistenteException e) {
			error.mostrarVentanaError("Movimiento fuera del mapa", "Intente nuevamente en direccion adentro del mapa");
		}
	}
}
