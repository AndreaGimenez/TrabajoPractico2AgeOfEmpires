package fiuba.algo3.tp2.vista;

import javafx.scene.layout.Pane;

public class PaneMapa extends Pane {

	private VistaPosicionable vistaPosicionable;

	public VistaPosicionable obtenerVistaPosicionable() {
		return vistaPosicionable;
	}

	public void setVistaPosicionable(VistaPosicionable vistaPosicionable) {
		this.vistaPosicionable = vistaPosicionable;
	}
}
