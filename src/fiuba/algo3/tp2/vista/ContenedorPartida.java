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
		
    	this.musica = new Musica("src/fiuba/algo3/tp2/vista/musicaJuego.mp3");
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
    	
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(ContenedorPartida.contenedorMapa);

        ContenedorPartida.vistaMapa = new VistaMapa(juego, contenedorMapa, vistaSeleccionador);
        VistaPosicionableMultitone.init(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, mapa, juego);
        
        ContenedorPartida.vistaMapa.dibujarTerreno();
        ContenedorPartida.vistaMapa.dibujarPosicionables();
        
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
