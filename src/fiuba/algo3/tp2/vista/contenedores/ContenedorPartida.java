package fiuba.algo3.tp2.vista.contenedores;

import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.vista.VistaEstadoJugador;
import fiuba.algo3.tp2.vista.VistaMapa;
import fiuba.algo3.tp2.vista.VistaPosicionableMultitone;
import fiuba.algo3.tp2.vista.VistaSeleccionador;
import fiuba.algo3.tp2.vista.constantes.Constantes;
import fiuba.algo3.tp2.vista.handlers.ButtonAvanzarTurnoHandler;
import fiuba.algo3.tp2.vista.musica.Musica;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ContenedorPartida extends BorderPane {
	
	Mapa mapa;
	
	public static ContenedorControles contenedorControles;
	public static ContenedorMapa contenedorMapa;
	public static ContenedorEstadoJugador contenedorEstadoJugador;
	
	public static VistaSeleccionador vistaSeleccionador;
	public static VistaMapa vistaMapa;
	
	public static BarraDeMenu menuBar;

	Musica musica;

    public ContenedorPartida(Stage stage) throws Exception {
    	
    	this.setMusica();
        this.setMenu(stage, this.musica);
//        this.setControles(juego);
//        this.setMapa(juego, stage);
//        this.setEstadoJugador(juego);
    }

    private void setMusica() {
		// TODO Auto-generated method stub
		
    	this.musica = new Musica(Constantes.MUSICA_JUEGO);
        this.musica.iniciarReproduccionMusica();
	}

	public void setControles(Juego juego) throws CeldaInexistenteException, TamanioInvalidoException, CeldaOcupadaException {
    	
        ContenedorPartida.contenedorControles = new ContenedorControles();        
        this.setLeft(ContenedorPartida.contenedorControles);
    }

    public void setMenu(Stage stage, Musica musica) {
        ContenedorPartida.menuBar = new BarraDeMenu(stage, musica);
        this.setTop(menuBar);
    }

    public void setMapa(Juego juego, Stage stage){
    	
    	mapa = juego.obtenerMapa();
    	
    	ContenedorPartida.contenedorMapa = new ContenedorMapa(mapa);
    	ContenedorPartida.vistaSeleccionador = new VistaSeleccionador(mapa, contenedorMapa);
    	ContenedorCentral contenedorCentral = new ContenedorCentral(contenedorMapa);
    	contenedorMapa.setContenedorPadre(contenedorCentral);
    	
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(contenedorCentral);
        ContenedorPartida.vistaMapa = new VistaMapa(juego, contenedorMapa, vistaSeleccionador);
        VistaPosicionableMultitone.init(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, mapa, juego);
        
        ContenedorPartida.vistaMapa.dibujarTerreno();
        //ContenedorPartida.vistaMapa.dibujarPosicionables();
        
        this.setCenter(scrollPane);
    }

    public void setEstadoJugador(Juego juego) {
    	
    	ContenedorPartida.contenedorEstadoJugador = new ContenedorEstadoJugador();
        Button botonAvanzarTurno = new Button("Avanzar Turno");
        VistaEstadoJugador vistaEstadoJugador = new VistaEstadoJugador(juego, ContenedorPartida.contenedorEstadoJugador);
        
        ButtonAvanzarTurnoHandler botonAvanzarTurnoHandler = new ButtonAvanzarTurnoHandler(vistaEstadoJugador, ContenedorPartida.contenedorControles, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego);
        botonAvanzarTurno.setOnAction(botonAvanzarTurnoHandler);
        ContenedorPartida.contenedorEstadoJugador.getChildren().add(botonAvanzarTurno);
        
        vistaEstadoJugador.actualizar();
        
        this.setBottom(ContenedorPartida.contenedorEstadoJugador);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
}
