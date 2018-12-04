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
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPartida extends BorderPane {
	
	VistaPosicionable vistaPosicionable;
	VistaSeleccionador vistaSeleccionador;
	VistaMapa vistaMapa;
	
    BarraDeMenu menuBar;

    public ContenedorPartida(Stage stage, Juego juego) throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {
    	
    	vistaPosicionable = new VistaPosicionable();
        this.setMenu(stage);
        this.setMapa(juego, stage);
        this.setControles(juego);
        this.setEstadoJugador(juego);
    }

    private void setControles(Juego juego) throws CeldaInexistenteException, TamanioInvalidoException, CeldaOcupadaException {
    	
        ContenedorControles contenedorControles = new ContenedorControles();
        
        vistaPosicionable.setContenedorControles(contenedorControles);
        
        this.setLeft(contenedorControles);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setMapa(Juego juego, Stage stage) throws CeldaOcupadaException, CeldaInexistenteException {
    	
    	Mapa mapa = juego.obtenerMapa();
    	ContenedorMapa contenedorMapa = new ContenedorMapa();
    	vistaSeleccionador = new VistaSeleccionador(mapa, contenedorMapa);
    	vistaPosicionable.setVistaSeleccionador(vistaSeleccionador);
    	
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(contenedorMapa);

        vistaMapa = new VistaMapa(juego, contenedorMapa, vistaSeleccionador, vistaPosicionable);
        vistaMapa.dibujarTerreno();
        
        vistaPosicionable.setMapa(mapa);
        vistaPosicionable.setContenedorMapa(contenedorMapa);
        vistaPosicionable.dibujarPosicionables();
        
        this.setCenter(scrollPane);
    }

    private void setEstadoJugador(Juego juego) {
    	
    	ContenedorEstadoJugador contenedorEstadoJugador = new ContenedorEstadoJugador();
        Button botonAvanzarTurno = new Button("Avanzar Turno");
        VistaEstadoJugador vistaEstadoJugador = new VistaEstadoJugador(juego, contenedorEstadoJugador);
        
        ButtonAvanzarTurnoHandler botonAvanzarTurnoHandler = new ButtonAvanzarTurnoHandler(vistaEstadoJugador, vistaSeleccionador, vistaPosicionable, juego);
        botonAvanzarTurno.setOnAction(botonAvanzarTurnoHandler);
        contenedorEstadoJugador.getChildren().add(botonAvanzarTurno);
        
        botonAvanzarTurno.setOnKeyPressed(evento -> {if(evento.getCode() == KeyCode.ENTER) {
        	botonAvanzarTurno.fire();
	    	evento.consume();
	    	}
	    });
        
        vistaEstadoJugador.actualizar();
        
        this.setBottom(contenedorEstadoJugador);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
}
