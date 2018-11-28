package fiuba.algo3.tp2.vista;

import java.util.Collection;

import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class VistaMapa {
	
	 GraphicsContext gc;
	 Posicionable aldeano;
	 Juego juego;
	 Canvas canvasCentral;
	 
	public VistaMapa(Juego juego, Canvas canvasCentral) {
		 this.gc = canvasCentral.getGraphicsContext2D();
		 this.aldeano = (Posicionable)juego.mapa.obtenerCelda(new Posicion(5,3)).obtenerPosicionable();
		 this.juego = juego;
		 this.canvasCentral = canvasCentral;
	}

	public void dibujar() {
		
		Collection <Posicionable> posicionables = juego.obtenerJugadorActual().obtenerPosicionables();
		for(Posicionable posicionableActual : posicionables) {
			this.dibujarForma(gc, posicionableActual);
		}
		
	}

	private void dibujarForma(GraphicsContext gc, Posicionable posicionable) {

        gc.setFill(Color.RED);
        
        gc.fillRect(posicionable.obtenerPosicion().getX(), posicionable.obtenerPosicion().getY(), 2,2);
	}
}
