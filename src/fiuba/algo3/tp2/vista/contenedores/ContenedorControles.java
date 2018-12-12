package fiuba.algo3.tp2.vista.contenedores;

import java.util.ArrayList;
import java.util.Collection;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ContenedorControles extends VBox {
	
	private Label labelNombreUnidad;
	private Collection<Button> accionesMovimiento;
	private ComboBox<String> construccionesCuartel;
	private Button confirmarConstruccionCuartel;
	private ComboBox<String> construccionesPlazaCentral;
	private Button confirmarConstruccionPlazaCentral;

	public ContenedorControles() {
		
    	labelNombreUnidad = new Label();
        labelNombreUnidad.setText("");
        labelNombreUnidad.setFont(Font.font(15));
        getChildren().add(labelNombreUnidad);

        
        setSpacing(10);
        setPadding(new Insets(15));
        setStyle("-fx-background-color: #BDB76B;");
        setPrefWidth(200);
        
        this.accionesMovimiento = new ArrayList<>();
        this.construccionesCuartel = new ComboBox<>();
        this.construccionesPlazaCentral = new ComboBox<>();
	}

	public void setNombreUnidad(String nombreUnidad) {
		labelNombreUnidad.setText(nombreUnidad);
	}
	
	public void setVida(int vida, int vidaMaxima) {
		
        StackPane barraVida = new StackPane();
        barraVida.setAlignment(Pos.CENTER_LEFT);
        barraVida.setBackground(new Background(new BackgroundFill(Color.WHITE.deriveColor(0, 1, 1, 0.5), new CornerRadii(5), null)));
        barraVida.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        barraVida.setPrefWidth(150);
        barraVida.setMaxWidth(150);
        barraVida.setPrefHeight(15);
        getChildren().add(barraVida);
        
        Pane vidaActual = new Pane();
        
        vidaActual.setMaxWidth((vida * 1.0 / vidaMaxima * 1.0) * 150.0);
        vidaActual.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), null)));
        
        Label vidaActualTexto = new Label(vida + "/" + vidaMaxima);
        vidaActualTexto.setMaxWidth(150);
        vidaActualTexto.setAlignment(Pos.CENTER);
        
        barraVida.getChildren().add(vidaActual);
        barraVida.getChildren().add(vidaActualTexto);
	}
	
	public void setAcciones(Collection<Button> acciones) {
		
		//labelAccionesMovimiento.setText("Acciones");
		this.accionesMovimiento.addAll(acciones);
		getChildren().addAll(this.accionesMovimiento);
	}

	public void setAccionesCuartel(ComboBox<String> acciones, Button botonRealizarConstruccion){
		this.construccionesCuartel = acciones;
		getChildren().addAll(this.construccionesCuartel);
		this.confirmarConstruccionCuartel = botonRealizarConstruccion;
		getChildren().addAll(this.confirmarConstruccionCuartel);
	}

	public void setAccionesPlazaCentral(ComboBox<String> acciones, Button botonRealizarConstruccion){
		this.construccionesPlazaCentral = acciones;
		getChildren().addAll(this.construccionesPlazaCentral);
		this.confirmarConstruccionPlazaCentral = botonRealizarConstruccion;
		getChildren().addAll(this.confirmarConstruccionPlazaCentral);
	}

	public void clean() {
		
		labelNombreUnidad.setText("");
		
		getChildren().removeIf(children -> !(children instanceof Label));
		this.accionesMovimiento = new ArrayList<>();
		this.construccionesCuartel = new ComboBox<>();
		this.construccionesPlazaCentral = new ComboBox<>();
	}
}
