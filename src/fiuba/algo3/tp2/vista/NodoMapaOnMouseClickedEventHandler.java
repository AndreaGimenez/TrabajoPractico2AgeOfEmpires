package fiuba.algo3.tp2.vista;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class NodoMapaOnMouseClickedEventHandler implements EventHandler<MouseEvent>{
	
	private VistaMapa vistaMapa;

	public NodoMapaOnMouseClickedEventHandler(VistaMapa vistaMapa) {
		this.vistaMapa = vistaMapa;
	}

	@Override
	public void handle(MouseEvent event) {
		
		vistaMapa.seleccionarNodo((Pane)event.getSource());
	}
}
