package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.MovimientoInvalidoException;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Movible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMovimientoHandler implements EventHandler<ActionEvent>{
	
	private Movible movible;
	private Direccion direccion;
	private VistaSeleccionador vistaSeleccionador;
	private Musica musica;
	
	public BotonMovimientoHandler(Movible movible, Direccion direccion, VistaPosicionable vistaPosicionable, VistaSeleccionador vistaSeleccionador) {
		this.movible = movible;
		this.direccion = direccion;
		this.vistaSeleccionador = vistaSeleccionador;
		this.musica = new Musica("src/fiuba/algo3/tp2/vista/aldeanoCaminando.mp3");
	}

	@Override
	public void handle(ActionEvent event) {
		MensajeDeError error = new MensajeDeError();
		try {
			Posicion posicionAnterior = movible.obtenerPosicion();
			movible.mover(direccion);
			((VistaMovible)VistaPosicionableMultitone.getInstance(movible)).dibujarPosicionable(movible, posicionAnterior);
			vistaSeleccionador.seleccionarNodo(movible);
			musica.iniciarReproduccionMusica();
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
