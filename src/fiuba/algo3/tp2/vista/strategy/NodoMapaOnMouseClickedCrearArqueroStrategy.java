package fiuba.algo3.tp2.vista.strategy;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.generacionDeUnidades.YaSeGeneraronUnidadesEnEsteTurnoException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.vista.MensajeDeError;
import fiuba.algo3.tp2.vista.VistaArquero;
import fiuba.algo3.tp2.vista.VistaMapa;
import fiuba.algo3.tp2.vista.VistaSeleccionador;
import fiuba.algo3.tp2.vista.contenedores.ContenedorControles;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class NodoMapaOnMouseClickedCrearArqueroStrategy implements NodoMapaOnMouseClickedStrategy {
	
	private Cuartel cuartel;
	private Juego juego;
	private VistaMapa vistaMapa;
	private VistaSeleccionador vistaSeleccionador;
	
	public NodoMapaOnMouseClickedCrearArqueroStrategy(ContenedorMapa contenedorMapa, Cuartel cuartel, Juego juego, VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador) {
		
		this.cuartel = cuartel;
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
			Arquero arquero= new Arquero(new Posicion(colIndex, rowIndex), mapa);
			VistaArquero vistaArquero = new VistaArquero(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, vistaSeleccionador, vistaMapa, juego, arquero);
			arquero.addObserver(vistaArquero);
			ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaArquero, arquero.obtenerPosicion());
			cuartel.crear(arquero);
			arquero.addObserver(vistaArquero);
			juego.obtenerJugadorActual().agregarUnidad(arquero, mapa);
			vistaArquero.dibujarPosicionable(arquero);
		} 
		catch(YaSeGeneraronUnidadesEnEsteTurnoException e) {
			error.mostrarVentanaError("No es Posible Generar El Arquero porque ya fue generada una en este turno","");
		}
		catch(CeldaOcupadaException e) {
			error.mostrarVentanaError("La Celda en la que deseas posicionar el Arquero esta ocupada","");
		}
		catch(CeldaInexistenteException e) {
			error.mostrarVentanaError("La Celda en la que deseas posicionar el Arquero no existe","");
		}
		catch(PoblacionMaximaAlcanzadaException e) {
			error.mostrarVentanaError("No puede crear un nuevo arquero porque ya ha alcanzado la poblacion máxima","");
		}
		catch(OroInsuficienteException e) {
			error.mostrarVentanaError("No puede crear un nuevo arquero porque no tiene suficiente oro","");
		}
		finally {
			vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedSeleccionarStrategy(juego, ContenedorPartida.contenedorMapa, vistaSeleccionador));
			ContenedorPartida.contenedorMapa.setCursor(Cursor.DEFAULT);
		}
	}
}
