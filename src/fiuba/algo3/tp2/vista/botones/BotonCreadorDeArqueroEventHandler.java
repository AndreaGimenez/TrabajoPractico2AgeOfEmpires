package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.vista.ContenedorMapa;
import fiuba.algo3.tp2.vista.NodoMapaOnMouseClickedCrearArqueroStrategy;
import fiuba.algo3.tp2.vista.VistaMapa;
import fiuba.algo3.tp2.vista.VistaSeleccionador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;


public class BotonCreadorDeArqueroEventHandler implements EventHandler<ActionEvent> {

    private Cuartel cuartel;
	private VistaMapa vistaMapa;
	private ContenedorMapa contenedorMapa;
	private Juego juego;
	private VistaSeleccionador vistaSeleccionador;

    public BotonCreadorDeArqueroEventHandler
    (Button botonCreadorDeArquero, Cuartel cuartel, Mapa mapa, VistaMapa vistaMapa, ContenedorMapa contenedorMapa, Juego juego, VistaSeleccionador vistaSeleccionador) {

        this.cuartel = cuartel;
        this.vistaMapa = vistaMapa;
        this.contenedorMapa = contenedorMapa;
        this.juego = juego;
        this.vistaSeleccionador = vistaSeleccionador;

    }

    @Override
    public void handle(ActionEvent event) {
    	
    	vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedCrearArqueroStrategy(contenedorMapa, cuartel, juego, vistaMapa, vistaSeleccionador));
		contenedorMapa.setCursor(Cursor.CROSSHAIR);
    }
}
