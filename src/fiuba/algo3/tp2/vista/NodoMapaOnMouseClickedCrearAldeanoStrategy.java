package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.generacionDeUnidades.YaSeGeneraronUnidadesEnEsteTurnoException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Aldeano;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class NodoMapaOnMouseClickedCrearAldeanoStrategy implements NodoMapaOnMouseClickedStrategy {
	
	private ContenedorMapa contenedorMapa;
	private PlazaCentral plazaCentral;
	private Juego juego;
	private VistaMapa vistaMapa;
	private VistaSeleccionador vistaSeleccionador;
	
	public NodoMapaOnMouseClickedCrearAldeanoStrategy(ContenedorMapa contenedorMapa, PlazaCentral plazaCentral, Juego juego, VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador) {
		this.contenedorMapa = contenedorMapa;
		this.plazaCentral = plazaCentral;
		this.juego = juego;
		this.vistaMapa = vistaMapa;
		this.vistaSeleccionador = vistaSeleccionador;
	}
	@Override
	public void handle(MouseEvent event) {
		Pane nodo = (Pane) event.getSource();
		int colIndex = ContenedorPartida.contenedorMapa.obtenerColumnIndex(nodo);
		int rowIndex = ContenedorPartida.contenedorMapa.obtenerRowIndex(nodo);
		
		MensajeDeError error = new MensajeDeError();

		try {
			Mapa mapa = juego.obtenerMapa();
			Aldeano aldeano = new Aldeano(new Posicion(colIndex, rowIndex), mapa);
			plazaCentral.crear(aldeano);
			juego.obtenerJugadorActual().agregarUnidad(aldeano, mapa);
		} 
		catch(YaSeGeneraronUnidadesEnEsteTurnoException e) {
			error.mostrarVentanaError("No es Posible Generar el aldeano porque ya fue generada una en este turno","");
		}
		catch(CeldaOcupadaException e) {
			error.mostrarVentanaError("La Celda en la que deseas posicionar el aldeano esta ocupada","");
		}
		catch(CeldaInexistenteException e) {
			error.mostrarVentanaError("La Celda en la que deseas posicionar el aldeano no existe","");
		}
		catch(PoblacionMaximaAlcanzadaException e) {
			error.mostrarVentanaError("No puede crear un nuevo aldeano porque ya ha alcanzado la poblacion máxima","");
		}
		catch(OroInsuficienteException e) {
			error.mostrarVentanaError("No puede crear un nuevo aldeano porque no tiene suficiente oro","");
		}
		finally {
			vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedSeleccionarStrategy(juego, ContenedorPartida.contenedorMapa, vistaSeleccionador));
			ContenedorPartida.contenedorMapa.setCursor(Cursor.DEFAULT);
		}
	}
}
