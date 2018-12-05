package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.vista.eventos.ButtonAvanzarTurnoHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPartida extends BorderPane {
	
	Mapa mapa;
	
	ContenedorControles contenedorControles;
	ContenedorMapa contenedorMapa;
	ContenedorEstadoJugador contenedorEstadoJugador;
	
	VistaSeleccionador vistaSeleccionador;
	VistaMapa vistaMapa;
	
    BarraDeMenu menuBar;

    public ContenedorPartida(Stage stage, Juego juego) throws Exception {
    	
        this.setMenu(stage);
        this.setControles(juego);
        this.setEstadoJugador(juego);
        this.setMapa(juego, stage);
    }

    private void setControles(Juego juego) throws CeldaInexistenteException, TamanioInvalidoException, CeldaOcupadaException {
    	
        contenedorControles = new ContenedorControles();        
        this.setLeft(contenedorControles);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setMapa(Juego juego, Stage stage) throws Exception {
    	
    	mapa = juego.obtenerMapa();
    	contenedorMapa = new ContenedorMapa();
    	vistaSeleccionador = new VistaSeleccionador(mapa, contenedorMapa);

    	VistaPosicionableMultitone.init(contenedorControles, contenedorMapa, vistaSeleccionador, mapa);
    	
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(contenedorMapa);

        vistaMapa = new VistaMapa(juego, contenedorMapa, vistaSeleccionador);
        vistaMapa.dibujarTerreno();
        vistaMapa.dibujarPosicionables();
        
        this.setCenter(scrollPane);
    }

    private void setEstadoJugador(Juego juego) {
    	
    	contenedorEstadoJugador = new ContenedorEstadoJugador();
        Button botonAvanzarTurno = new Button("Avanzar Turno");
        VistaEstadoJugador vistaEstadoJugador = new VistaEstadoJugador(juego, contenedorEstadoJugador);
        
        ButtonAvanzarTurnoHandler botonAvanzarTurnoHandler = new ButtonAvanzarTurnoHandler(vistaEstadoJugador, contenedorControles, vistaSeleccionador, juego);
        botonAvanzarTurno.setOnAction(botonAvanzarTurnoHandler);
        contenedorEstadoJugador.getChildren().add(botonAvanzarTurno);
        
        vistaEstadoJugador.actualizar();
        
        this.setBottom(contenedorEstadoJugador);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
}
