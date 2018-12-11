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

	Musica musica;

    public ContenedorPartida(Stage stage, Juego juego) throws Exception {
    	
    	this.setMusica();
        this.setMenu(stage, this.musica);
        this.setControles(juego);
        this.setMapa(juego, stage);
        this.setEstadoJugador(juego);
    }

    private void setMusica() {
		// TODO Auto-generated method stub
		
    	this.musica = new Musica("src/fiuba/algo3/tp2/vista/musicaJuego.mp3");
        this.musica.iniciarReproduccionMusica();
	}

	private void setControles(Juego juego) throws CeldaInexistenteException, TamanioInvalidoException, CeldaOcupadaException {
    	
        contenedorControles = new ContenedorControles();        
        this.setLeft(contenedorControles);
    }

    private void setMenu(Stage stage, Musica musica) {
        this.menuBar = new BarraDeMenu(stage, musica);
        this.setTop(menuBar);
    }

    private void setMapa(Juego juego, Stage stage) throws Exception {
    	
    	mapa = juego.obtenerMapa();
    	contenedorMapa = new ContenedorMapa(mapa);
    	vistaSeleccionador = new VistaSeleccionador(mapa, contenedorMapa);
    	
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(contenedorMapa);

        vistaMapa = new VistaMapa(juego, contenedorMapa, vistaSeleccionador);
        VistaPosicionableMultitone.init(contenedorControles, contenedorMapa, vistaSeleccionador, vistaMapa, mapa, juego);
        
        vistaMapa.dibujarTerreno();
        vistaMapa.dibujarPosicionables();
        
        this.setCenter(scrollPane);
    }

    private void setEstadoJugador(Juego juego) {
    	
    	contenedorEstadoJugador = new ContenedorEstadoJugador();
        Button botonAvanzarTurno = new Button("Avanzar Turno");
        VistaEstadoJugador vistaEstadoJugador = new VistaEstadoJugador(juego, contenedorEstadoJugador);
        
        ButtonAvanzarTurnoHandler botonAvanzarTurnoHandler = new ButtonAvanzarTurnoHandler(vistaEstadoJugador, contenedorControles, vistaSeleccionador, vistaMapa, juego);
        botonAvanzarTurno.setOnAction(botonAvanzarTurnoHandler);
        contenedorEstadoJugador.getChildren().add(botonAvanzarTurno);
        
        vistaEstadoJugador.actualizar();
        
        this.setBottom(contenedorEstadoJugador);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
}
