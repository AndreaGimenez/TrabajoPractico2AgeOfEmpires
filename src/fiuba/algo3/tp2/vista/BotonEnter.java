package fiuba.algo3.tp2.vista;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

public class BotonEnter {

	public void disparar(Button boton) {
		
        boton.setOnKeyPressed(evento -> {if(evento.getCode() == KeyCode.ENTER) {
        	boton.fire();
	    	evento.consume();
	    	}
	    });
	}
}
