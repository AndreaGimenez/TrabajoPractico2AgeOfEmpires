package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.unidad.Arquero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAtacarHandler implements EventHandler<ActionEvent>{

	private Arquero arquero;
	private VistaMapa vistaMapa;
	private VistaSeleccionador vistaSeleccionador;
	private ContenedorMapa contenedorMapa;
	private Juego juego;

	public BotonAtacarHandler(Juego juego, VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador, ContenedorMapa contenedorMapa, Arquero arquero) {
		this.arquero = arquero;
		this.vistaMapa = vistaMapa;
		this.contenedorMapa = contenedorMapa;
		this.juego = juego;
		this.vistaSeleccionador = vistaSeleccionador;
	}

	@Override
	public void handle(ActionEvent event) {
		vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedAtacarStrategy(juego, vistaMapa, vistaSeleccionador, contenedorMapa, arquero));
	}
}
