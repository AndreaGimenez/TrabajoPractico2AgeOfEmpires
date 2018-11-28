package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.vista.eventos.ButtonAvanzarTurnoHandler;
import fiuba.algo3.tp2.vista.interfaces.AccionesDeAldeano;
import fiuba.algo3.tp2.vista.interfaces.AccionesDeCuartel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPartida extends BorderPane {

    BarraDeMenu menuBar;
    VistaMapa vistaMapa;
    Canvas canvasCentral;
    GridPane contenedorCentral;
    AccionesDeAldeano accionesDeAldeano;
    AccionesDeCuartel accionesDeCuartel;

    public ContenedorPartida(Stage stage, Juego juego) throws CeldaOcupadaException, CeldaInexistenteException {
        this.setMenu(stage);
        this.setMapa(juego, stage);
        this.setControles(juego);
        this.setEstadoJugador(juego);
    }

    private void setControles(Juego juego) {

        //this.accionesDeAldeano = new AccionesDeAldeano();
        //this.accionesDeAldeano.mostrarAcciones(this);

        //this.accionesDeCuartel = new AccionesDeCuartel();
        //this.accionesDeCuartel.mostrarAcciones(this);

    	Label labelNombreUnidad = new Label();
        labelNombreUnidad.setText("Aldeano");
        
        Label labelAcciones = new Label();
        labelAcciones.setText("Acciones");
        
        Button botonConstruir = new Button();
        botonConstruir.setText("Construir");
        /*
         * Agregar handler
         * BotonConstruirHandler botonConstruirHandler = new BotonConstruirHandler();
         * botonConstruir.setOnAction(botonConstruirHandler);
         */
        

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
    	
        canvasCentral = new Canvas();
        vistaMapa = new VistaMapa(juego, canvasCentral);
        vistaMapa.dibujar();
        
        contenedorCentral = new GridPane();
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setGridLinesVisible(true);
        
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        Button button6 = new Button("Button 6");
        
        contenedorCentral.add(button1, 0, 0, 1, 1);
        contenedorCentral.add(button2, 1, 0, 1, 1);
        contenedorCentral.add(button3, 2, 0, 1, 1);
        contenedorCentral.add(button4, 0, 1, 1, 1);
        contenedorCentral.add(button5, 1, 1, 1, 1);
        contenedorCentral.add(button6, 2, 1, 1, 1);

        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondo-verde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    }

    private void setEstadoJugador(Juego juego) {
    	
    	ContenedorEstadoJugador contenedorEstadoJugador = new ContenedorEstadoJugador();
        Button botonAvanzarTurno = new Button("Avanzar Turno");
        VistaEstadoJugador vistaEstadoJugador = new VistaEstadoJugador(juego, contenedorEstadoJugador);
        
        ButtonAvanzarTurnoHandler botonAvanzarTurnoHandler = new ButtonAvanzarTurnoHandler(vistaEstadoJugador, juego);
        botonAvanzarTurno.setOnAction(botonAvanzarTurnoHandler);
        contenedorEstadoJugador.getChildren().add(botonAvanzarTurno);
        
        vistaEstadoJugador.actualizar();
        
        this.setBottom(contenedorEstadoJugador);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
}
