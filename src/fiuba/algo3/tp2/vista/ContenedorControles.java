package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ContenedorControles extends VBox {
	
	private Label labelNombreUnidad;
	private Label labelAcciones;
	private Collection<Button> acciones;

	public ContenedorControles() {
		
    	labelNombreUnidad = new Label();
        labelNombreUnidad.setText("");
        getChildren().add(labelNombreUnidad);
        
        labelAcciones = new Label();
        labelAcciones.setText("");
        getChildren().add(labelAcciones);
        
        setSpacing(10);
        setPadding(new Insets(15));
        setStyle("-fx-background-color: brown;");
        setPrefWidth(200);
	}

	public void setNombreUnidad(String nombreUnidad) {
		labelNombreUnidad.setText(nombreUnidad);
	}
	
	public void setAcciones(Collection<Button> acciones) {
		
		labelAcciones.setText("Acciones");
		
		if(this.acciones != null) {
			getChildren().removeAll(this.acciones);
		}
		
		this.acciones = new ArrayList<Button>();
		this.acciones.addAll(acciones);
		
		getChildren().addAll(this.acciones);
	}
}
