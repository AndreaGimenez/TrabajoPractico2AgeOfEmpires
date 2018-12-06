package fiuba.algo3.tp2.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MensajeDeError {
	public void mostrarVentanaError(String mensajeDeError){
		Stage ventanaError = new Stage();
		ventanaError.setTitle("Error");
		
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		Label etiqueta = new Label();
	    etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));

	    etiqueta.setText(mensajeDeError);
	    etiqueta.setTextFill(Color.web("#2E2EFE"));
	    box.getChildren().add(etiqueta);
	    Scene nuevaEscena = new Scene(box, 300,200);
		ventanaError.setScene(nuevaEscena);
		ventanaError.setFullScreen(false);
		ventanaError.show();
	}
}
