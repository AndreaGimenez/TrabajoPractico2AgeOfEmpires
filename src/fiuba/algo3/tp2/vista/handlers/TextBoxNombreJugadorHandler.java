package fiuba.algo3.tp2.vista;



import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TextBoxNombreJugadorHandler implements EventHandler<KeyEvent>{

	private Button botonAceptarIngresoJugador;

	public TextBoxNombreJugadorHandler(Button botonAceptarIngresoJugador) {
		this.botonAceptarIngresoJugador = botonAceptarIngresoJugador;
	}

	@Override
	public void handle(KeyEvent event) {
		
		 if (event.getCode() == KeyCode.ENTER) {
			 Event.fireEvent(botonAceptarIngresoJugador, new ActionEvent()); 
		 }
	}
}
