package fiuba.algo3.tp2.vista;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class VistaArmaAsedio implements VistaPosicionable, VistaMovible {

	private ContenedorControles contenedorControles;
	private ContenedorMapa contenedorMapa;
	private VistaSeleccionador vistaSeleccionador;

	public VistaArmaAsedio(ContenedorControles contenedorControles, ContenedorMapa contenedorMapa, VistaSeleccionador vistaSeleccionador) {
		this.contenedorControles = contenedorControles;
		this.contenedorMapa = contenedorMapa;
		this.vistaSeleccionador = vistaSeleccionador;
	}

	@Override
	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		pane.setBackground(obtenerFondoArmaAsedio((ArmaAsedio)posicionable));
	}

	@Override
	public void dibujarControles(Posicionable posicionable) {
		
		contenedorControles.clean();
		
		contenedorControles.setNombreUnidad("Arma de Asedio");

		Collection<Button> acciones = new ArrayList<Button>();
		acciones.add(crearAccionMontar((ArmaAsedio)posicionable));
		acciones.add(crearAccionAtacar());
		
		//Movimientos
		acciones.addAll(new CreadorBotonesMovimiento(this, vistaSeleccionador).crearBotones((Movible)posicionable));
		
		contenedorControles.setAcciones(acciones);
	}
	
	private Button crearAccionMontar(ArmaAsedio armaAsedio) {
		
		String textoBoton = (armaAsedio.montada()) ? "Desmontar" : "Montar";
		Button botonMontar = new Button(textoBoton);
		BotonMontarHandler botonMontarHandler = new BotonMontarHandler(botonMontar, armaAsedio, contenedorMapa);
		botonMontar.setOnAction(botonMontarHandler);
		
		
		return botonMontar;
	}

	private Button crearAccionAtacar() {
		Button botonAtacar = new Button("Atacar");
		//TODO agregar event handler.
		return botonAtacar;
	}
	
	@Override
	public void dibujarPosicionable(Movible movible, Posicion posicionAnterior) {
		contenedorMapa.setBackground(Background.EMPTY, posicionAnterior);
		contenedorMapa.setBackground(obtenerFondoArmaAsedio((ArmaAsedio)movible), movible.obtenerPosicion());
	}

	private Background obtenerFondoArmaAsedio(ArmaAsedio armaAsedio) {
		
		Image imagen = null;
		if(armaAsedio.montada()) {
			imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/arma-asedio-montada.jpg", 
					 50, 
					 50, 
					 false, 
					 true);
		}else {
			imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/arma-asedio-desmontada.png", 
					 50, 
					 50, 
					 false, 
					 true);
		}
		

       BackgroundImage fondoAldeano = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

       return new Background(fondoAldeano);
	}
}
