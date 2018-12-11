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
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

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
		
		MensajeDeError error = new MensajeDeError();
		
		if(!juego.obtenerJugadorActual().posicionablePerteneceAJugador(posicionable)
				&& posicionable instanceof Atacable) {
			
			try {
				atacador.atacar((Atacable)posicionable);
				VistaPosicionableMultitone.getInstance(posicionable).dibujarPosicionable(posicionable, nodo);
				
				Shape nodoShape = new Rectangle(nodo.getWidth(), nodo.getHeight());
				nodo.getChildren().add(nodoShape);
				
		        final Animation animation = new ColorTransition(Color.RED, nodoShape);
		        animation.play();
				
			} 
			catch(UnidadMuertaException e) {
				error.mostrarVentanaError("Esta Unidad Ya Fue Destruida", "");
			}
			catch(EdificioDestruidoException e) {
				error.mostrarVentanaError("Este Edificio Ya Fue Destruido", "");
			}
			catch(AtaqueFueraDeRangoException e) {
				error.mostrarVentanaError("Ataque Fuera De Rango", "");
			}
			catch(AtaqueInvalidoException e) {
				error.mostrarVentanaError("Ataque Invalido", "");
			}
			finally {
				vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedSeleccionarStrategy(juego, contenedorMapa, vistaSeleccionador));
				contenedorMapa.setCursor(Cursor.DEFAULT);
			}
			
		}
	}
}
