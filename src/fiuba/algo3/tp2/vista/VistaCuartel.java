package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.Cuartel;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class VistaCuartel {

	private ContenedorControles contenedorControles;

	public void dibujar(Cuartel posicionable, Pane pane) {
		pane.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
	}
}
