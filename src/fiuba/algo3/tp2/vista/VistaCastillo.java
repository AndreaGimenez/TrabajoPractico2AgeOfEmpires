package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeArmaDeAsedioEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collection;

public class VistaCastillo {

	private Castillo castillo;

	private Mapa mapa;

	private ContenedorControles contenedorControles;

	public void dibujar(Castillo posicionable, Pane pane) {
		pane.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
	}

    public void dibujarControles(Castillo posicionable, Mapa mapa) {

		castillo = posicionable;

		this.mapa = mapa;

		contenedorControles.setNombreUnidad("Castillo");

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionConstruirArmaAsedio());

		contenedorControles.setAcciones(acciones);

    }

	private Button crearAccionConstruirArmaAsedio() {

		Button crearArmaAsedio = new Button("Crear Arma de Asedio");
		crearArmaAsedio.setOnAction(new BotonCreadorDeArmaDeAsedioEventHandler(crearArmaAsedio,castillo, mapa));
		return crearArmaAsedio;
	}

	public void setContenedorControles(ContenedorControles contenedorControles) {
		this.contenedorControles = contenedorControles;
	}
}
