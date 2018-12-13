package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.MontajeInvalidoException;
import fiuba.algo3.tp2.vista.MensajeDeError;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonMontarHandler implements EventHandler<ActionEvent>{

	private ArmaAsedio armaAsedio;
	private ContenedorMapa contenedorMapa;
	private Button botonMontar;

	public BotonMontarHandler(Button botonMontar, ArmaAsedio armaAsedio, ContenedorMapa contenedorMapa) {
		this.armaAsedio = armaAsedio;
		this.contenedorMapa = contenedorMapa;
		this.botonMontar = botonMontar;
	}

	@Override
	public void handle(ActionEvent event) {
		
		MensajeDeError error = new MensajeDeError();
		try {
			armaAsedio.montar();
		} catch (MontajeInvalidoException e) {
			error.mostrarVentanaError("Este Arma de Asedio No Se Puede Montar", "Necesita desmontarla primero");
		}
	}
}
