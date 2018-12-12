package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.MontajeInvalidoException;
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
		if(armaAsedio.estaMontada()) {
			armaAsedio.desmontar();
			botonMontar.setText("Montar");
		}else {
			try {
				armaAsedio.montar();
			} catch (MontajeInvalidoException e) {
				error.mostrarVentanaError("Este Arma de Asedio No Se Puede Montar", "Necesita desmontarla primero");
			}
			botonMontar.setText("Desmontar");
		}
		
		try {
			VistaPosicionableMultitone.getInstance(armaAsedio).dibujarPosicionable(armaAsedio, ContenedorPartida.contenedorMapa.obtenerNodo(armaAsedio.obtenerPosicion()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
