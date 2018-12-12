package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.vista.ContenedorMapa;
import fiuba.algo3.tp2.vista.ContenedorPartida;
import fiuba.algo3.tp2.vista.NodoMapaOnMouseClickedCrearAldeanoStrategy;
import fiuba.algo3.tp2.vista.VistaMapa;
import fiuba.algo3.tp2.vista.VistaSeleccionador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;


public class BotonCreadorDeAldeanosEventHandler implements EventHandler<ActionEvent> {

    private PlazaCentral plazaCentral;
	private VistaMapa vistaMapa;
	private ContenedorMapa contenedorMapa;
	private Juego juego;
	private VistaSeleccionador vistaSeleccionador;

    public BotonCreadorDeAldeanosEventHandler
    (Button botonCreadorDeAldeanos, PlazaCentral plazaCentral, Mapa mapa, VistaMapa vistaMapa, ContenedorMapa contenedorMapa, Juego juego, VistaSeleccionador vistaSeleccionador) {

        this.plazaCentral = plazaCentral;
        this.vistaMapa = vistaMapa;
        this.contenedorMapa = contenedorMapa;
        this.juego = juego;
        this.vistaSeleccionador = vistaSeleccionador;

    }

    @Override
    public void handle(ActionEvent event) {
    	
    	vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedCrearAldeanoStrategy(ContenedorPartida.contenedorMapa, plazaCentral, juego, vistaMapa, vistaSeleccionador));
    	ContenedorPartida.contenedorMapa.setCursor(Cursor.CROSSHAIR);
    }
}
