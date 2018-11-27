package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.vista.interfaces.AccionesDeAldeano;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    VistaMapa vistaMapa;
    Canvas canvasCentral;
    VBox contenedorCentral;

    AccionesDeAldeano accionesDeAldeano;


    public ContenedorPrincipal(Stage stage, Juego juego) throws CeldaInexistenteException, TamanioInvalidoException, CeldaOcupadaException {
        this.setMenu(stage);
        this.setMapa(juego);
        this.setControles();
        this.setEstadoJugador(juego);
    }

    private void setEstadoJugador(Juego juego) throws CeldaInexistenteException, TamanioInvalidoException, CeldaOcupadaException {

        /*this.accionesDeAldeano = new AccionesDeAldeano();

        this.accionesDeAldeano.mostrarAcciones(this);*/

        


    	Label labelNombreUnidad = new Label();
        labelNombreUnidad.setText("Aldeano");
        
        Label labelAcciones = new Label();
        labelAcciones.setText("Acciones");
        
        Button botonConstruir = new Button();
        botonConstruir.setText("Construir");

        /*Agregar handler
        BotonConstruirHandler botonConstruirHandler = new BotonConstruirHandler();
        botonConstruir.setOnAction(botonConstruirHandler);
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

    private void setControles() {
    	
        Label labelNombreJugador = new Label();
        labelNombreJugador.setText("Jugador 1");
        
        VBox contenedorHorizontal = new VBox(labelNombreJugador);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(15));
        contenedorHorizontal.setStyle("-fx-background-color: black;");
        contenedorHorizontal.setPrefHeight(200);

        this.setBottom(contenedorHorizontal);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
}
