package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioDestruidoException;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Unidad;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class NodoMapaOnMouseClickedAtacarStrategy implements NodoMapaOnMouseClickedStrategy {

	private Juego juego;
	private ContenedorMapa contenedorMapa;
	private VistaMapa vistaMapa;
	private VistaSeleccionador vistaSeleccionador;
	
	private Arquero arquero;

	public NodoMapaOnMouseClickedAtacarStrategy(Juego juego, VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador, ContenedorMapa contenedorMapa, Arquero arquero) {
		this.arquero = arquero;
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
				arquero.atacar((Atacable)posicionable);
				VistaPosicionableMultitone.getInstance(posicionable).dibujarPosicionable(posicionable, nodo);
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
