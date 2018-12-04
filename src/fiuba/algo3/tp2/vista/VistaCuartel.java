package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeArqueroEventHandler;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeEspadachinEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collection;

public class VistaCuartel {

	private ContenedorControles contenedorControles;

	private Cuartel cuartel;

	private Mapa mapa;

	public void dibujar(Cuartel posicionable, Pane pane) {
		pane.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
	}

    public void dibujarControles(Cuartel posicionable, Mapa mapa) {

		contenedorControles.setNombreUnidad("Cuartel");

		cuartel = posicionable;

		this.mapa = mapa;

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionCrearArquero());
		acciones.add(crearAccionCrearEspadachin());

		contenedorControles.setAcciones(acciones);

    }

	private Button crearAccionCrearEspadachin() {

		Button botonCrearEspadachin = new Button("Crear Espadachin");

		botonCrearEspadachin.setOnAction(new BotonCreadorDeEspadachinEventHandler(botonCrearEspadachin, cuartel, mapa));

		return botonCrearEspadachin;

	}

	private Button crearAccionCrearArquero() {

		Button botonCrearArquero = new Button("Crear Arquero");

		botonCrearArquero.setOnAction(new BotonCreadorDeArqueroEventHandler(botonCrearArquero, cuartel, mapa));

		return botonCrearArquero;
	}

	public void setContenedorControles(ContenedorControles contenedorControles) {

		this.contenedorControles = contenedorControles;
	}

	public void dibujar(Cuartel posicionable, Posicion posicionAnterior) {
		// TODO Auto-generated method stub
		
	}
}
