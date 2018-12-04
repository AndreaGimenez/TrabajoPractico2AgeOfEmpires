package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeArqueroEventHandler;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeEspadachinEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class VistaCuartel implements VistaPosicionable {

	private ContenedorControles contenedorControles;
	private Mapa mapa;

	public VistaCuartel(ContenedorControles contenedorControles, Mapa mapa) {
		this.contenedorControles = contenedorControles;
		this.mapa = mapa;
	}
	
	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		pane.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
	}
	
	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		contenedorControles.clean();
		
		Cuartel cuartel = (Cuartel) posicionable;
		contenedorControles.setNombreUnidad("Cuartel");

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionCrearArquero(cuartel));
		acciones.add(crearAccionCrearEspadachin(cuartel));

		contenedorControles.setAcciones(acciones);
	}

	private Button crearAccionCrearEspadachin(Cuartel cuartel) {

		Button botonCrearEspadachin = new Button("Crear Espadachin");

		botonCrearEspadachin.setOnAction(new BotonCreadorDeEspadachinEventHandler(botonCrearEspadachin, cuartel, mapa));

		return botonCrearEspadachin;

	}

	private Button crearAccionCrearArquero(Cuartel cuartel) {

		Button botonCrearArquero = new Button("Crear Arquero");

		botonCrearArquero.setOnAction(new BotonCreadorDeArqueroEventHandler(botonCrearArquero, cuartel, mapa));

		return botonCrearArquero;
	}
}
