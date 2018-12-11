package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.unidad.Aldeano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;

public class BotonConstruirCuartelHandler implements EventHandler<ActionEvent> {
	
	private Aldeano aldeano;
	private VistaMapa vistaMapa;
	private ContenedorMapa contenedorMapa;
	private Juego juego;
	private VistaSeleccionador vistaSeleccionador;
	
	public BotonConstruirCuartelHandler(Aldeano aldeano, VistaMapa vistaMapa, ContenedorMapa contenedorMapa,
			Juego juego, VistaSeleccionador vistaSeleccionador) {
		
		this.aldeano = aldeano;
		this.vistaMapa = vistaMapa;
		this.contenedorMapa = contenedorMapa;
		this.juego = juego;
		this.vistaSeleccionador = vistaSeleccionador;
	}

	@Override
	public void handle(ActionEvent event) {
		
		vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedConstruirCuartelStrategy(ContenedorPartida.contenedorMapa, juego, aldeano, vistaMapa, vistaSeleccionador));
		contenedorMapa.setCursor(Cursor.CROSSHAIR);

	}

}
