package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.mapa.Posicionable;
import javafx.scene.layout.Pane;

public interface VistaPosicionable {

	void dibujarPosicionable(Posicionable posicionable, Pane pane);
	void dibujarControles(Posicionable posicionable);
}
