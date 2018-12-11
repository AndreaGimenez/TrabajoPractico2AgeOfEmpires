package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.vista.ContenedorMapa;
import fiuba.algo3.tp2.vista.NodoMapaOnMouseClickedCrearArmaAsedioStrategy;
import fiuba.algo3.tp2.vista.VistaMapa;
import fiuba.algo3.tp2.vista.VistaSeleccionador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class BotonCreadorDeArmaDeAsedioEventHandler implements EventHandler<ActionEvent> {

    private Castillo castillo;
	private VistaMapa vistaMapa;
	private ContenedorMapa contenedorMapa;
	private Juego juego;
	private VistaSeleccionador vistaSeleccionador;

    public BotonCreadorDeArmaDeAsedioEventHandler
    (Button botonCreadorDeArmaDeAsedio, Castillo castillo, Mapa mapa, VistaMapa vistaMapa, ContenedorMapa contenedorMapa, Juego juego, VistaSeleccionador vistaSeleccionador) {

        this.castillo = castillo;
        this.vistaMapa = vistaMapa;
        this.contenedorMapa = contenedorMapa;
        this.juego = juego;
        this.vistaSeleccionador = vistaSeleccionador;
    }

    @Override
    public void handle(ActionEvent event) {
    	
    	vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedCrearArmaAsedioStrategy(contenedorMapa, castillo, juego, vistaMapa, vistaSeleccionador));
		contenedorMapa.setCursor(Cursor.CROSSHAIR);
    }
}
