package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.unidad.Atacador;
import javafx.scene.control.Button;

public class CreadorBotonAtaque {

	private Juego juego;
	private VistaMapa vistaMapa;
	private VistaSeleccionador vistaSeleccionador;
	private ContenedorMapa contenedorMapa;

	public CreadorBotonAtaque(Juego juego, VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador,
			ContenedorMapa contenedorMapa) {
		super();
		this.juego = juego;
		this.vistaMapa = vistaMapa;
		this.vistaSeleccionador = vistaSeleccionador;
		this.contenedorMapa = contenedorMapa;
	}

	public Button crearBoton(Atacador atacador) {
		
		Button botonAtacar = new Button("Atacar");
		BotonAtacarHandler botonAtacarHandler = new BotonAtacarHandler(juego, vistaMapa, vistaSeleccionador, contenedorMapa, atacador);
		botonAtacar.setOnAction(botonAtacarHandler);
		return botonAtacar;
	}

}
