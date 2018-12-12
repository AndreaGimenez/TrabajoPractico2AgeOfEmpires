package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.unidad.Atacador;
import fiuba.algo3.tp2.vista.VistaMapa;
import fiuba.algo3.tp2.vista.VistaSeleccionador;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;
import fiuba.algo3.tp2.vista.strategy.NodoMapaOnMouseClickedAtacarStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAtacarHandler implements EventHandler<ActionEvent>{

	private Atacador atacador;
	private VistaMapa vistaMapa;
	private VistaSeleccionador vistaSeleccionador;
	private ContenedorMapa contenedorMapa;
	private Juego juego;

	public BotonAtacarHandler(Juego juego, VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador, ContenedorMapa contenedorMapa, Atacador atacador) {
		this.atacador = atacador;
		this.vistaMapa = vistaMapa;
		this.contenedorMapa = contenedorMapa;
		this.juego = juego;
		this.vistaSeleccionador = vistaSeleccionador;
	}

	@Override
	public void handle(ActionEvent event) {
		vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedAtacarStrategy(juego, vistaMapa, vistaSeleccionador, ContenedorPartida.contenedorMapa, atacador));
		contenedorMapa.setCursorAtaque();
	}
}
