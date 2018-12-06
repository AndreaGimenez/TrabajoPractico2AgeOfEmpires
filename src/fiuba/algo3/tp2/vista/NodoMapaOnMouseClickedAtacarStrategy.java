package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioDestruidoException;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.Atacador;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class NodoMapaOnMouseClickedAtacarStrategy implements NodoMapaOnMouseClickedStrategy {

	private Juego juego;
	private ContenedorMapa contenedorMapa;
	private VistaMapa vistaMapa;
	private VistaSeleccionador vistaSeleccionador;
	
	private Atacador atacador;

	public NodoMapaOnMouseClickedAtacarStrategy(Juego juego, VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador, ContenedorMapa contenedorMapa, Atacador atacador) {
		this.atacador = atacador;
		this.contenedorMapa = contenedorMapa;
		this.juego = juego;
		this.vistaMapa = vistaMapa;
		this.vistaSeleccionador = vistaSeleccionador;
	}

	@Override
	public void handle(MouseEvent event) {
		
		Pane nodo = (Pane)event.getSource();
	      
		int colIndex = contenedorMapa.obtenerColumnIndex(nodo);
		int rowIndex = contenedorMapa.obtenerRowIndex(nodo);
		Posicionable posicionable = juego.obtenerMapa().obtenerPosicionable(new Posicion(colIndex, rowIndex));
		
		if(!juego.obtenerJugadorActual().posicionablePerteneceAJugador(posicionable)
				&& posicionable instanceof Atacable) {
			
			try {
				atacador.atacar((Atacable)posicionable);
				VistaPosicionableMultitone.getInstance(posicionable).dibujarPosicionable(posicionable, nodo);
				
				Shape nodoShape = new Rectangle(nodo.getWidth(), nodo.getHeight());
				nodo.getChildren().add(nodoShape);
				
		        final Animation animation = new Transition() {

		            {
		                setCycleDuration(Duration.millis(750));
		                setInterpolator(Interpolator.EASE_OUT);
		            }

		            @Override
		            protected void interpolate(double frac) {
		            	
		            	double valorInicialOpacity = 0;
		            	double valorActualOpacity = 0;
		            	
		            	if(frac <= 0.5) {
		            		valorActualOpacity = valorInicialOpacity + (frac * 2);
		            	}else {
		            		valorActualOpacity = 1 - (frac - 0.5) * 2;
		            	}
		            	
		                Color vColor = new Color(1, 0, 0, valorActualOpacity);
		                nodoShape.setFill(vColor);
		            }
		        };
		        animation.play();
				
			} catch (UnidadMuertaException | EdificioDestruidoException | AtaqueFueraDeRangoException
					| AtaqueInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedSeleccionarStrategy(juego, contenedorMapa, vistaSeleccionador));
				contenedorMapa.setCursor(Cursor.DEFAULT);
			}
			
		}
	}
}
