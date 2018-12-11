package fiuba.algo3.tp2.vista;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class MensajeDeError {
	
	public void mostrarVentanaError(String mensajeDeError){
		
		Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Accion Invalida");
        alert.setHeaderText("Error al accionar");
        String mensaje = mensajeDeError;
        alert.setContentText(mensaje);
        alert.show();
	}
}
