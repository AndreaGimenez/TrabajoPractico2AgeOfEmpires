package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.vista.VistaEstadoJugador;
import fiuba.algo3.tp2.vista.VistaPosicionable;
import fiuba.algo3.tp2.vista.VistaSeleccionador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonAvanzarTurnoHandler implements EventHandler<ActionEvent> {

	private Juego juego;
	private VistaEstadoJugador vistaEstadoJugador;
	private VistaSeleccionador vistaSeleccionador;
	private VistaPosicionable vistaPosicionable;
	
	public ButtonAvanzarTurnoHandler(VistaEstadoJugador vistaEstadoJugador, 
									 VistaSeleccionador vistaSeleccionador,
									 VistaPosicionable vistaPosicionable,
									 Juego juego) {
		
		this.vistaPosicionable = vistaPosicionable;
		this.vistaSeleccionador = vistaSeleccionador;
		this.vistaEstadoJugador = vistaEstadoJugador;
		this.juego = juego;
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		try {
			
			juego.avanzarJugador();
			vistaEstadoJugador.actualizar();
			vistaSeleccionador.deseleccionarNodoActual();
			vistaPosicionable.limpiarControles();
			
		} catch (EdificioNoAptoParaReparacionException | EdificioConReparadorAsignadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
