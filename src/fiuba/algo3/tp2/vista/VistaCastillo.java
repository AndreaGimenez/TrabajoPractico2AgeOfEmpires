package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.Castillo;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class VistaCastillo {

	private ContenedorControles contenedorControles;

	public void dibujar(Castillo posicionable, Pane pane) {
		pane.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
	}
}
