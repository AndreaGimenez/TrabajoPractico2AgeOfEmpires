package fiuba.algo3.tp2.vista.contenedores;

import java.util.ArrayList;
import java.util.Collection;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class ContenedorEstadoJugador extends HBox {

	private Label labelCantidadOro;
	private Label labelCantidadPoblacion;
	private Label labelNombreJugador;
	
	public ContenedorEstadoJugador() {
		
		super();
		
		Collection<Node> elementos = new ArrayList<Node>();
		
		labelNombreJugador = new Label("");
		labelNombreJugador.setFont(Font.font("Sans-Serif", 25));
		elementos.add(labelNombreJugador);
		
		Label labelOro = new Label("Oro");
		labelOro.setFont(Font.font("Sans-Serif", 15));
		elementos.add(labelOro);
		
		labelCantidadOro = new Label("0");
		labelCantidadOro.setFont(Font.font("Sans-Serif", 15));
		elementos.add(labelCantidadOro);
		
		Label labelPoblacion = new Label("Poblacion");
		labelPoblacion.setFont(Font.font("Sans-Serif", 15));
		elementos.add(labelPoblacion);
		
		labelCantidadPoblacion = new Label("0");
		labelCantidadPoblacion.setFont(Font.font("Sans-Serif", 15));
		elementos.add(labelCantidadPoblacion);
		
        this.setSpacing(10);
        this.setPadding(new Insets(15));
        this.setPrefHeight(60);
        
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/estado-jugador-background.jpg", 
        						 primaryScreenBounds.getWidth(), 
        						 this.getPrefHeight(), 
        						 false, 
        						 true);
        
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
		
		this.getChildren().addAll(elementos);
	}
	
	public void actualizarOro(int cantidadOro) {
		
		labelCantidadOro.setText(String.valueOf(cantidadOro));
	}
	public void actualizarPoblacion(int poblacion) {
		
		labelCantidadPoblacion.setText(String.valueOf(poblacion));
	}
	public void actualizarNombreJugador(String nombreJugador) {
		
		labelNombreJugador.setText(nombreJugador);
	}
}
