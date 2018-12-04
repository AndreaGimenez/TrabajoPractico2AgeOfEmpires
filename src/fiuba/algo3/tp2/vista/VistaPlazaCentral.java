package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeAldeanosEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collection;

public class VistaPlazaCentral {

	private ContenedorControles contenedorControles;

	private PlazaCentral plazaCentral;

	private Mapa mapa;

	public void dibujar(PlazaCentral posicionable, Pane pane) {
		pane.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
	}

    public void dibujarControles(PlazaCentral posicionable, Mapa mapa) {

		this.plazaCentral = posicionable;

		this.mapa = mapa;

		contenedorControles.setNombreUnidad("Plaza Central");

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionCrearAldeano());

		contenedorControles.setAcciones(acciones);
    }

	private Button crearAccionCrearAldeano() {
		Button crearAldeano = new Button("Crear Aldeano");
		crearAldeano.setOnAction(new BotonCreadorDeAldeanosEventHandler(crearAldeano, plazaCentral, mapa));
		return crearAldeano;
	}

	public void setContenedorControles(ContenedorControles contenedorControles) {

		this.contenedorControles = contenedorControles;

	}
}
