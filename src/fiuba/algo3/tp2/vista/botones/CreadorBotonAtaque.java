package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.unidad.Atacador;
import fiuba.algo3.tp2.vista.VistaMapa;
import fiuba.algo3.tp2.vista.VistaSeleccionador;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;
import fiuba.algo3.tp2.vista.handlers.BotonAtacarHandler;
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
		BotonAtacarHandler botonAtacarHandler = new BotonAtacarHandler(juego, vistaMapa, vistaSeleccionador, ContenedorPartida.contenedorMapa, atacador);
		botonAtacar.setOnAction(botonAtacarHandler);
		return botonAtacar;
	}

}
