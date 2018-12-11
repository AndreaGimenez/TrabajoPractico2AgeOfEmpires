package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.AldeanoConConstruccionAsignadaException;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class NodoMapaOnMouseClickedConstruirCuartelStrategy implements NodoMapaOnMouseClickedStrategy {
	
	private ContenedorMapa contenedorMapa;
	private Juego juego;
	private Aldeano aldeano;
	private VistaMapa vistaMapa;
	private VistaSeleccionador vistaSeleccionador;
	
	public NodoMapaOnMouseClickedConstruirCuartelStrategy(ContenedorMapa contenedorMapa, Juego juego, Aldeano aldeano,
			VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador) {
		this.contenedorMapa = contenedorMapa;
		this.juego = juego;
		this.aldeano = aldeano;
		this.vistaMapa = vistaMapa;
		this.vistaSeleccionador = vistaSeleccionador;
	}

	@Override
	public void handle(MouseEvent event) {
		
		Pane nodo = (Pane) event.getSource();
		
		int colIndex = contenedorMapa.obtenerColumnIndex(nodo);
		int rowIndex = contenedorMapa.obtenerRowIndex(nodo);
		
		MensajeDeError error = new MensajeDeError();
		try {
			Mapa mapa = juego.obtenerMapa();
			Cuartel cuartel = new Cuartel(new Posicion(colIndex, rowIndex), mapa);
			aldeano.construirConstruible(cuartel);
			juego.obtenerJugadorActual().agregarEdificio(cuartel);
			} 
		catch(CeldaOcupadaException e) {
			error.mostrarVentanaError("La celda en la que intentas contruir esta ocupada", "Intente nuevamente con otra celda libre");
		}
		catch(CeldaInexistenteException e) {
			error.mostrarVentanaError("La celda en la que intentas contruir no existe", "Intente nuevamente con una celda dentro del mapa");
		}
		catch(EdificioNoAptoParaConstruccionException e) {
			error.mostrarVentanaError("No es posible construir este Edificio", "No tiene recursos para contruir este edificio");
		}
		catch(EdificioConConstructorAsignadoException e) {
			error.mostrarVentanaError("Aldeno constructor Error", "Este aldeano no puede construir este edificio porque siendo construido por otro");
		}
		catch(AldeanoConConstruccionAsignadaException e) {
			error.mostrarVentanaError("Este aldeano se encuentra construyendo otro edificio","");
		} catch (OroInsuficienteException e) {
			error.mostrarVentanaError("No puede crear un nuevo cuartel porque no tiene suficiente oro","");
		}
		finally {
			vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedSeleccionarStrategy(juego, contenedorMapa, vistaSeleccionador));
			contenedorMapa.setCursor(Cursor.DEFAULT);
		}
	}
}
