package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators.ChildrenIterator;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ContenedorControles extends VBox {
	
	private Label labelNombreUnidad;
	private Label labelVida;
	private Label labelAccionesMovimiento;
	private Collection<Button> accionesMovimiento;
	private ComboBox<String> construccionesCuartel;
	private Button confirmarConstruccionCuartel;
	private ComboBox<String> construccionesPlazaCentral;
	private Button confirmarConstruccionPlazaCentral;
	private Label labelAcciones;
	private Collection<Button> acciones;
	private ComboBox<String> construcciones;
	private Button confirmarConstruccion;
	private GridPane botonera;

	public ContenedorControles() {
		
    	labelNombreUnidad = new Label();
        labelNombreUnidad.setText("");
        getChildren().add(labelNombreUnidad);
        
        labelVida = new Label();
        labelVida.setText("");
        getChildren().add(labelVida);
        
        labelAccionesMovimiento = new Label();
        labelAccionesMovimiento.setText("");
        getChildren().add(labelAccionesMovimiento);

        
        setSpacing(10);
        setPadding(new Insets(15));
        setStyle("-fx-background-color: brown;");
        setPrefWidth(200);
        
        this.accionesMovimiento = new ArrayList<>();
        this.construccionesCuartel = new ComboBox<>();
        this.construccionesPlazaCentral = new ComboBox<>();
        this.acciones = new ArrayList<>();
        this.construcciones = new ComboBox<>();
        this.botonera = new GridPane();
	}

	public void setNombreUnidad(String nombreUnidad) {
		labelNombreUnidad.setText(nombreUnidad);
	}
	
	public void setVida(int vida) {
		labelVida.setText(String.valueOf(vida));
	}
	
	public void setAcciones(Collection<Button> acciones) {
		
		labelAccionesMovimiento.setText("Acciones");
		this.accionesMovimiento.addAll(acciones);
		getChildren().addAll(this.accionesMovimiento);
	}

	public void setAccionesCuartel(ComboBox<String> acciones, Button botonRealizarConstruccion){
		this.construccionesCuartel = acciones;
		getChildren().addAll(this.construccionesCuartel);
		this.confirmarConstruccionCuartel = botonRealizarConstruccion;
		getChildren().addAll(this.confirmarConstruccionCuartel);
	}
	
	public void setBotonera(GridPane botoneraMovimiento) {
		this.botonera = botoneraMovimiento;
	}

	public void setAccionesPlazaCentral(ComboBox<String> acciones, Button botonRealizarConstruccion){
		this.construccionesPlazaCentral = acciones;
		getChildren().addAll(this.construccionesPlazaCentral);
		this.confirmarConstruccionPlazaCentral = botonRealizarConstruccion;
		getChildren().addAll(this.confirmarConstruccionPlazaCentral);
	}

	public void clean() {
		
		labelNombreUnidad.setText("");
		labelVida.setText("");
		labelAccionesMovimiento.setText("");

		getChildren().removeIf(children -> !(children instanceof Label));
		/*
		if(this.accionesMovimiento != null) {
			getChildren().removeAll(this.accionesMovimiento);
		}

		if(this.construccionesCuartel != null) {
			getChildren().removeAll(this.construccionesCuartel);
		}

		if(this.construccionesPlazaCentral != null)
			getChildren().removeAll(this.construccionesCuartel);
		 */
		this.accionesMovimiento = new ArrayList<>();
		this.construccionesCuartel = new ComboBox<>();
		this.construccionesPlazaCentral = new ComboBox<>();
		
		/*
		if(this.confirmarConstruccion != null)
			getChildren().remove(this.confirmarConstruccion);
		
		getChildren().remove(botonera);
		*/
		this.acciones = new ArrayList<>();
		this.construcciones = new ComboBox<>();
	}
}
