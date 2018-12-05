package fiuba.algo3.tp2.vista;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class NodoMapaOnMouseClickedEventHandler implements EventHandler<MouseEvent>{
	
	private NodoMapaOnMouseClickedStrategy strategy;

	public NodoMapaOnMouseClickedEventHandler(NodoMapaOnMouseClickedStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public void handle(MouseEvent event) {
		
		strategy.handle(event);
	}

	public void setStrategy(NodoMapaOnMouseClickedStrategy strategy) {
		this.strategy = strategy;
	}
}
