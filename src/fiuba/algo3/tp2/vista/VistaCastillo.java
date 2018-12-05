package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.vista.botones.BotonCreadorDeArmaDeAsedioEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class VistaCastillo implements VistaPosicionable {
	
	private Mapa mapa;
	private ContenedorControles contenedorControles;

	
	public VistaCastillo(ContenedorControles contenedorControles, Mapa mapa) {
		this.mapa = mapa;
		this.contenedorControles = contenedorControles;
	}
	
	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		pane.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
	}

	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		contenedorControles.clean();
		
		Castillo castillo = (Castillo) posicionable;
		
		contenedorControles.setNombreUnidad("Castillo");

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionConstruirArmaAsedio(castillo));

		contenedorControles.setAcciones(acciones);
	}

	private Button crearAccionConstruirArmaAsedio(Castillo castillo) {

		Button crearArmaAsedio = new Button("Crear Arma de Asedio");
		crearArmaAsedio.setOnAction(new BotonCreadorDeArmaDeAsedioEventHandler(crearArmaAsedio, castillo, mapa));
		return crearArmaAsedio;
	}
}
