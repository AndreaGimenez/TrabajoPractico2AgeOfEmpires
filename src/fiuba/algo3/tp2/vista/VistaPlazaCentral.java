package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.PlazaCentral;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class VistaPlazaCentral {

	private ContenedorControles contenedorControles;

	public void dibujar(PlazaCentral posicionable, Pane pane) {
		pane.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
	}
}
