package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.vista.eventos.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ContenedorIngresoJugadores extends VBox {

	private Stage stage;
	private Collection<String> nombresJugadores;
	
	public ContenedorIngresoJugadores(Stage stage) {
	
	    super();
	
	    this.stage = stage;
	    this.nombresJugadores = new ArrayList<String>();
	    
	    this.setAlignment(Pos.CENTER);
	    this.setSpacing(20);
	    this.setPadding(new Insets(25));
	    
	    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	    Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/fondo-inicio.jpg", 
	    						 primaryScreenBounds.getWidth(), 
	    						 primaryScreenBounds.getHeight(), 
	    						 false, 
	    						 true);
	    
	    BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	    this.setBackground(new Background(imagenDeFondo));
	    
	    Label labelNombreJugador = new Label("Ingrese nombre del jugador 1");
	    labelNombreJugador.setTextFill(Color.WHITE);
	    labelNombreJugador.setFont(Font.font("Arial, Helvetica, sans-serif", FontWeight.BOLD, 20));
	    
	    Label labelAdvertencia = new Label("");
	    labelAdvertencia.setTextFill(Color.RED);
	    labelAdvertencia.setFont(Font.font("Arial, Helvetica, sans-serif", FontWeight.BOLD, 12));
	    
	    Button botonAceptarIngresoJugador = new Button();
	    botonAceptarIngresoJugador.setText("ACEPTAR");
	    botonAceptarIngresoJugador.setTextFill(Color.WHITE);
	    botonAceptarIngresoJugador.setPrefHeight(50);
	    botonAceptarIngresoJugador.setPrefWidth(250);
	    botonAceptarIngresoJugador.setStyle(this.obtenerEstiloBoton());
	    
	    TextField tfNombreJugador = new TextField();
	    tfNombreJugador.setPrefWidth(250);
	    tfNombreJugador.setMaxWidth(250);
	    
	    BotonAceptarIngresoJugadorHandler botonAceptarIngresoJugadorHandler = new BotonAceptarIngresoJugadorHandler(stage, labelAdvertencia, labelNombreJugador, tfNombreJugador, nombresJugadores);
	    botonAceptarIngresoJugador.setOnAction(botonAceptarIngresoJugadorHandler);
	    
	    TextBoxNombreJugadorHandler tfNombreJugadorHandler = new TextBoxNombreJugadorHandler(botonAceptarIngresoJugador);
	    tfNombreJugador.setOnKeyPressed(tfNombreJugadorHandler);
	    
	    Button botonSalir = new Button();
	    botonSalir.setText("SALIR");
	    botonSalir.setTextFill(Color.WHITE);
	    botonSalir.setPrefHeight(50);
	    botonSalir.setPrefWidth(250);
	    botonSalir.setStyle(this.obtenerEstiloBoton());
	    
	    BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
	    botonSalir.setOnAction(botonSalirEventHandler);
	    
	    this.getChildren().addAll(labelNombreJugador, tfNombreJugador, labelAdvertencia, botonAceptarIngresoJugador, botonSalir);
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
