package fiuba.algo3.tp2.vista;


import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.vista.eventos.ButtonAvanzarTurnoHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    VistaMapa vistaMapa;
    Canvas canvasCentral;
    VBox contenedorCentral;

    public ContenedorPrincipal(Stage stage, Juego juego) {
        this.setMenu(stage);
        this.setMapa(juego);
        this.setControles(juego);
        this.setEstadoJugador(juego);
    }

    private void setControles(Juego juego) {

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

    private void setMapa(Juego juego) {

        canvasCentral = new Canvas(460, 220);
        vistaMapa = new VistaMapa(juego, canvasCentral);
        vistaMapa.dibujar();

        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondo-verde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    }

    private void setEstadoJugador(Juego juego) {
    	
    	ContenedorEstadoJugador contenedorEstadoJugador = new ContenedorEstadoJugador();
    	VistaEstadoJugador vistaEstadoJugador = new VistaEstadoJugador(juego, contenedorEstadoJugador);
        
        Button botonAvanzarTurno = new Button("Avanzar Turno");
        ButtonAvanzarTurnoHandler botonAvanzarTurnoHandler = new ButtonAvanzarTurnoHandler(vistaEstadoJugador, juego);
        botonAvanzarTurno.setOnAction(botonAvanzarTurnoHandler);
        
        contenedorEstadoJugador.getChildren().add(botonAvanzarTurno);
        
        this.setBottom(contenedorEstadoJugador);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
}
