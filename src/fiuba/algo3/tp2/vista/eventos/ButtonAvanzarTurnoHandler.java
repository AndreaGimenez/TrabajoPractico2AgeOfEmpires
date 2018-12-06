package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.vista.ContenedorControles;
import fiuba.algo3.tp2.vista.MensajeDeError;
import fiuba.algo3.tp2.vista.VistaEstadoJugador;
import fiuba.algo3.tp2.vista.VistaMapa;
import fiuba.algo3.tp2.vista.VistaSeleccionador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonAvanzarTurnoHandler implements EventHandler<ActionEvent> {

	private Juego juego;
	private VistaMapa vistaMapa;
	private VistaEstadoJugador vistaEstadoJugador;
	private VistaSeleccionador vistaSeleccionador;
	private ContenedorControles contenedorControles;
	
	public ButtonAvanzarTurnoHandler(VistaEstadoJugador vistaEstadoJugador, 
									 ContenedorControles contenedorControles, 
									 VistaSeleccionador vistaSeleccionador,
									 VistaMapa vistaMapa,
									 Juego juego) {
		this.contenedorControles = contenedorControles;
		this.vistaSeleccionador = vistaSeleccionador;
		this.vistaEstadoJugador = vistaEstadoJugador;
		this.vistaMapa = vistaMapa;
		this.juego = juego;
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		MensajeDeError error = new MensajeDeError();
		try {
			
			juego.avanzarJugador();
			vistaEstadoJugador.actualizar();
			vistaSeleccionador.deseleccionarNodoActual();
			contenedorControles.clean();
			vistaMapa.dibujarPosicionables();
			
		} 
		catch(EdificioNoAptoParaReparacionException e) {
			error.mostrarVentanaError("Edificio No Apto Para Reparación");
		}
		catch(EdificioConReparadorAsignadoException e) {
			error.mostrarVentanaError("Este Edificio Ya Tiene Asignado Un Reparador");
		}
	}
}
