package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.vista.VistaMapa;
import fiuba.algo3.tp2.vista.VistaSeleccionador;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;
import fiuba.algo3.tp2.vista.strategy.NodoMapaOnMouseClickedConstruirPlazaCentralStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;

public class BotonConstruirPlazaCentralHandler implements EventHandler<ActionEvent> {
	
	private Aldeano aldeano;
	private VistaMapa vistaMapa;
	private ContenedorMapa contenedorMapa;
	private Juego juego;
	private VistaSeleccionador vistaSeleccionador;
	
	public BotonConstruirPlazaCentralHandler(Aldeano aldeano, VistaMapa vistaMapa, ContenedorMapa contenedorMapa, Juego juego, VistaSeleccionador vistaSeleccionador) {
		
		this.aldeano = aldeano;
		this.vistaMapa = vistaMapa;
		this.contenedorMapa = contenedorMapa;
		this.juego = juego;
		this.vistaSeleccionador = vistaSeleccionador;
	}

	@Override
	public void handle(ActionEvent event) {
		
		vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedConstruirPlazaCentralStrategy(ContenedorPartida.contenedorMapa, juego, aldeano, vistaMapa, vistaSeleccionador));
		contenedorMapa.setCursor(Cursor.CROSSHAIR);
	}

}
