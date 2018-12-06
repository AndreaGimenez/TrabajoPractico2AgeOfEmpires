package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ContenedorControles extends VBox {
	
	private Label labelNombreUnidad;
	private Label labelVida;
	private Label labelAcciones;
	private Label labelConstrucciones;
	private Collection<Button> acciones;
	private ComboBox<String> construcciones;
	private Button confirmarConstruccion;

	public ContenedorControles() {
		
    	labelNombreUnidad = new Label();
        labelNombreUnidad.setText("");
        getChildren().add(labelNombreUnidad);
        
        labelVida = new Label();
        labelVida.setText("");
        getChildren().add(labelVida);
        
        labelAcciones = new Label();
        labelAcciones.setText("");
        getChildren().add(labelAcciones);

        labelConstrucciones = new Label("");
        getChildren().add(labelConstrucciones);
        
        setSpacing(10);
        setPadding(new Insets(15));
        setStyle("-fx-background-color: brown;");
        setPrefWidth(200);
        
        this.acciones = new ArrayList<>();
        this.construcciones = new ComboBox<>();
	}

	public void setNombreUnidad(String nombreUnidad) {
		labelNombreUnidad.setText(nombreUnidad);
	}
	
	public void setVida(int vida) {
		labelVida.setText(String.valueOf(vida));
	}
	
	public void setAcciones(Collection<Button> acciones) {
		
		labelAcciones.setText("Acciones");
		this.acciones.addAll(acciones);
		getChildren().addAll(this.acciones);
	}

	public void setAcciones(ComboBox<String> acciones, Button botonRealizarConstruccion){
		this.labelConstrucciones.setText("Construir cuartel");
		this.construcciones.getEditor().setText("Seleccionar posicion");
		this.construcciones.getItems().addAll(acciones.getItems());
		getChildren().add(this.construcciones);
		this.confirmarConstruccion = botonRealizarConstruccion;
		getChildren().add(this.confirmarConstruccion);
	}

	public void clean() {
		
		labelNombreUnidad.setText("");
		labelVida.setText("");
		labelAcciones.setText("");
		labelConstrucciones.setText("");

		if(this.acciones != null) {
			getChildren().removeAll(this.acciones);
		}

		if(this.construcciones != null) {
			getChildren().removeAll(this.construcciones);
		}

		if(this.confirmarConstruccion != null)
			getChildren().remove(this.confirmarConstruccion);

		this.acciones = new ArrayList<>();
		this.construcciones = new ComboBox<>();
	}
}
