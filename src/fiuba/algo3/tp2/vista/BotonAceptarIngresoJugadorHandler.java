package fiuba.algo3.tp2.vista;


import java.util.Collection;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonAceptarIngresoJugadorHandler implements EventHandler<ActionEvent>{

	private Collection<String> nombresJugadores;
	private TextField tfNombreJugador;
	private Stage stage;
	private Label labelAdvertencia;
	private Label labelNombreJugador;
	private Scene proximaEscena;

	public BotonAceptarIngresoJugadorHandler(Stage stage, Label labelAdvertencia, Label labelNombreJugador, TextField tfNombreJugador, Collection<String> nombresJugadores, Scene proximaEscena) {
		this.nombresJugadores = nombresJugadores;
		this.tfNombreJugador = tfNombreJugador;
		this.labelAdvertencia = labelAdvertencia;
		this.labelNombreJugador = labelNombreJugador;
		this.stage = stage;
		this.proximaEscena = proximaEscena;
	}

	@Override
	public void handle(ActionEvent event) {
		
		if(checkNombreJugador(tfNombreJugador.getText())) {
			if(nombresJugadores.isEmpty()) {
				labelNombreJugador.setText("Ingrese nombre del jugador 2");
				tfNombreJugador.setText("");
				tfNombreJugador.requestFocus();
			}else {
				stage.setScene(proximaEscena);
				stage.setFullScreen(true);
			}
			nombresJugadores.add(tfNombreJugador.getText());
		}
	}

	private boolean checkNombreJugador(String nombreJugador) {
		
		boolean resultado;
		if (nombreJugador.trim().equals("")) {
			labelAdvertencia.setText("Debe ingresar un nombre de jugador");
			resultado = false;
		}else {
			labelAdvertencia.setText("");
			resultado = true;
		}
		
		return resultado;
	}
}
