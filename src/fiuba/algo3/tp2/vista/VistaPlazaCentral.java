package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeAldeanosEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class VistaPlazaCentral implements VistaPosicionable {

	private ContenedorControles contenedorControles;
	private Mapa mapa;

	
	public VistaPlazaCentral(ContenedorControles contenedorControles, Mapa mapa) {
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
		
		PlazaCentral plazaCentral = (PlazaCentral) posicionable;
		contenedorControles.setNombreUnidad("Plaza Central");

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionCrearAldeano(plazaCentral));

		contenedorControles.setAcciones(acciones);
	}

	private Button crearAccionCrearAldeano(PlazaCentral plazaCentral) {
		Button crearAldeano = new Button("Crear Aldeano");
		crearAldeano.setOnAction(new BotonCreadorDeAldeanosEventHandler(crearAldeano, plazaCentral, mapa));
		return crearAldeano;
	}
}
