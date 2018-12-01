package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.vista.eventos.ButtonAvanzarTurnoHandler;
import fiuba.algo3.tp2.vista.interfaces.AccionesDeAldeano;
import fiuba.algo3.tp2.vista.interfaces.AccionesDeCuartel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPartida extends BorderPane {

    BarraDeMenu menuBar;
    AccionesDeAldeano accionesDeAldeano;
    AccionesDeCuartel accionesDeCuartel;
    AccionesDeCastillo accionesDeCastillo;

    public ContenedorPartida(Stage stage, Juego juego) throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {
        this.setMenu(stage);
        this.setMapa(juego, stage);
        this.setControles(juego);
        this.setEstadoJugador(juego);
    }

    private void setControles(Juego juego) throws CeldaInexistenteException, TamanioInvalidoException, CeldaOcupadaException {

        /*this.accionesDeAldeano = new AccionesDeAldeano();
        this.accionesDeAldeano.mostrarAcciones(this);

        this.accionesDeCuartel = new AccionesDeCuartel();
        this.accionesDeCuartel.mostrarAcciones(this);

        this.accionesDeCastillo = new AccionesDeCastillo();
        this.accionesDeCastillo.mostrarAcciones(this);*/

    	Label labelNombreUnidad = new Label();
        labelNombreUnidad.setText("Aldeano");
        
        Label labelAcciones = new Label();
        labelAcciones.setText("Acciones");
        
        Button botonConstruir = new Button();
        botonConstruir.setText("Construir");

        BotonEnter botonEnter = new BotonEnter();
        botonEnter.disparar(botonConstruir);

        VBox contenedorVertical = new VBox(labelNombreUnidad, labelAcciones, botonConstruir);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        contenedorVertical.setStyle("-fx-background-color: brown;");
        contenedorVertical.setPrefWidth(200);
        
        this.setLeft(contenedorVertical);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setMapa(Juego juego, Stage stage) throws CeldaOcupadaException, CeldaInexistenteException {
    	
    	ContenedorMapa contenedorMapa = new ContenedorMapa();
    	contenedorMapa.setAlignment(Pos.CENTER);
    	contenedorMapa.setGridLinesVisible(true);
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondo-verde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorMapa.setBackground(new Background(imagenDeFondo));
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(contenedorMapa);

        VistaMapa vistaMapa = new VistaMapa(juego.obtenerMapa(), contenedorMapa);
        vistaMapa.dibujarTerreno();
        vistaMapa.dibujarPosicionables();
        
        this.setCenter(scrollPane);
    }

    private void setEstadoJugador(Juego juego) {
    	
    	ContenedorEstadoJugador contenedorEstadoJugador = new ContenedorEstadoJugador();
        Button botonAvanzarTurno = new Button("Avanzar Turno");
        VistaEstadoJugador vistaEstadoJugador = new VistaEstadoJugador(juego, contenedorEstadoJugador);
        
        ButtonAvanzarTurnoHandler botonAvanzarTurnoHandler = new ButtonAvanzarTurnoHandler(vistaEstadoJugador, juego);
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
