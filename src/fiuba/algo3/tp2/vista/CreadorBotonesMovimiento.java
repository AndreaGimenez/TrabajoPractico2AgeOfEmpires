package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.DireccionAbajoDerecha;
import fiuba.algo3.tp2.movimiento.DireccionAbajoIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionArriba;
import fiuba.algo3.tp2.movimiento.DireccionArribaDerecha;
import fiuba.algo3.tp2.movimiento.DireccionArribaIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;
import fiuba.algo3.tp2.movimiento.DireccionIzquierda;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.unidad.DireccionAbajo;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class CreadorBotonesMovimiento {

	private static final int TAMANIO_BOTON = 50;
	
	private VistaSeleccionador vistaSeleccionador;
	private VistaPosicionable vistaPosicionable;


	public CreadorBotonesMovimiento(VistaPosicionable vistaPosicionable, VistaSeleccionador vistaSeleccionador) {
		this.vistaSeleccionador = vistaSeleccionador;
		this.vistaPosicionable = vistaPosicionable;
	}
	
	public GridPane crearBotones(Movible movible) {
		
		GridPane contenedorBotones = new GridPane();
		for (int i = 0; i < 3; i++) {
            RowConstraints row = new RowConstraints(TAMANIO_BOTON);
            contenedorBotones.getRowConstraints().add(row);
        }
        for (int i = 0; i < 3; i++) {
            ColumnConstraints col = new ColumnConstraints(TAMANIO_BOTON);
            contenedorBotones.getColumnConstraints().add(col);
        }
        
        contenedorBotones.add(crearAccionMover(movible, "arriba", new DireccionArriba()), 1, 0);
        contenedorBotones.add(crearAccionMover(movible, "arribaderecha", new DireccionArribaDerecha()), 2, 0);
        contenedorBotones.add(crearAccionMover(movible, "derecha", new DireccionDerecha()), 2, 1);
        contenedorBotones.add(crearAccionMover(movible, "abajoderecha", new DireccionAbajoDerecha()), 2, 2);
        contenedorBotones.add(crearAccionMover(movible, "abajo", new DireccionAbajo()), 1, 2);
        contenedorBotones.add(crearAccionMover(movible, "abajoizquierda", new DireccionAbajoIzquierda()), 0, 2);
        contenedorBotones.add(crearAccionMover(movible, "izquierda", new DireccionIzquierda()), 0, 1);
        contenedorBotones.add(crearAccionMover(movible, "arribaizquierda", new DireccionArribaIzquierda()), 0, 0);
        
        contenedorBotones.add(crearCentroContenedorBotones(), 1, 1);
        
		return contenedorBotones;
	}
	
	private Node crearCentroContenedorBotones() {
		
		Pane centro = new Pane();

		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/movimiento.jpg", 
								TAMANIO_BOTON, 
								TAMANIO_BOTON, 
								false, 
								true);
		

		BackgroundImage fondoCentro = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		centro.setPrefHeight(TAMANIO_BOTON);
		centro.setPrefWidth(TAMANIO_BOTON);
		centro.setBackground(new Background(fondoCentro));
		
		return centro;
	}

	private Button crearAccionMover(Movible movible, String nombre, Direccion direccion) {

		Button botonMovimiento = new Button();

		Image imagen = new Image("file:src/fiuba/algo3/tp2/vista/imagenes/flechas/" + nombre + ".gif", 
								TAMANIO_BOTON, 
								TAMANIO_BOTON, 
								false, 
								true);
		

		BackgroundImage fondoBoton = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		botonMovimiento.setPrefHeight(TAMANIO_BOTON);
		botonMovimiento.setPrefWidth(TAMANIO_BOTON);
		botonMovimiento.setBackground(new Background(fondoBoton));
		
		BotonMovimientoHandler botonMovimientoHandler = new BotonMovimientoHandler(movible, direccion, vistaPosicionable, vistaSeleccionador);
		botonMovimiento.setOnAction(botonMovimientoHandler);
		
		return botonMovimiento;
	}
}
