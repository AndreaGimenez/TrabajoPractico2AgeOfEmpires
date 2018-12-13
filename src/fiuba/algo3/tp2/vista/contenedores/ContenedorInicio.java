package fiuba.algo3.tp2.vista.contenedores;

import fiuba.algo3.tp2.vista.botones.BotonEnter;
import fiuba.algo3.tp2.vista.constantes.Constantes;
import fiuba.algo3.tp2.vista.handlers.BotonComenzarPartidaEventHandler;
import fiuba.algo3.tp2.vista.handlers.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ContenedorInicio extends VBox {

    Stage stage;

    public ContenedorInicio(Stage stage, Scene proximaEscena) {
    	
        super();
        
        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Image imagen = new Image(Constantes.FONDO_INICIO, 
        						 primaryScreenBounds.getWidth(), 
        						 primaryScreenBounds.getHeight(), 
        						 false, 
        						 true);

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
        Button botonComenzarPartida = new Button();
        botonComenzarPartida.setText("COMENZAR PARTIDA");
        botonComenzarPartida.setTextFill(Color.WHITE);
        botonComenzarPartida.setPrefHeight(50);
        botonComenzarPartida.setPrefWidth(250);
        botonComenzarPartida.setStyle(this.obtenerEstiloBoton());
        
        BotonComenzarPartidaEventHandler botonComenzarPartidaEventHandler = new BotonComenzarPartidaEventHandler(stage, proximaEscena);
        botonComenzarPartida.setOnAction(botonComenzarPartidaEventHandler);
        
        BotonEnter botonEnter = new BotonEnter();
        botonEnter.disparar(botonComenzarPartida);
        
        Button botonSalir = new Button();
        botonSalir.setText("SALIR");
        botonSalir.setTextFill(Color.WHITE);
        botonSalir.setPrefHeight(50);
        botonSalir.setPrefWidth(250);
        botonSalir.setStyle(this.obtenerEstiloBoton());
        
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
        botonSalir.setOnAction(botonSalirEventHandler);

        botonEnter.disparar(botonSalir);
        
        this.getChildren().addAll(botonComenzarPartida, botonSalir);
    }

    private String obtenerEstiloBoton() {
    	return "  -fx-border-size: 5px;" +
        		"  -fx-border-style: solid;" +
        		"  -fx-border-radius: 5px;" +
        		"  -fx-font-size: 15px;" + 
        		"  -fx-font-family: Arial, Helvetica, sans-serif;" +
        		"  -fx-font-weight: bold;" + 
        		"  -fx-background-color: #4C1919;" + 
        		"  -fx-background-size: 13px 13px, 29px 29px, 37px 37px, 53px 53px;" +
        		"  -fx-background-radius: 5px;";
    }
}
