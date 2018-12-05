package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.unidad.ArmaAsedio;
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
		
		if(armaAsedio.montada()) {
			armaAsedio.desmontar();
			botonMontar.setText("Montar");
		}else {
			armaAsedio.montar();
			botonMontar.setText("Desmontar");
		}
		
		try {
			VistaPosicionableMultitone.getInstance(armaAsedio).dibujarPosicionable(armaAsedio, contenedorMapa.obtenerNodo(armaAsedio.obtenerPosicion()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
