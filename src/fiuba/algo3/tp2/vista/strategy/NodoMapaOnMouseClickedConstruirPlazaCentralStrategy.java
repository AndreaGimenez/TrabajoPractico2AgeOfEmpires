package fiuba.algo3.tp2.vista.strategy;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.AldeanoConConstruccionAsignadaException;
import fiuba.algo3.tp2.vista.MensajeDeError;
import fiuba.algo3.tp2.vista.VistaMapa;
import fiuba.algo3.tp2.vista.VistaPlazaCentral;
import fiuba.algo3.tp2.vista.VistaSeleccionador;
import fiuba.algo3.tp2.vista.contenedores.ContenedorMapa;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class NodoMapaOnMouseClickedConstruirPlazaCentralStrategy implements NodoMapaOnMouseClickedStrategy {
	
	private Juego juego;
	private Aldeano aldeano;
	private VistaMapa vistaMapa;
	private VistaSeleccionador vistaSeleccionador;
	
	public NodoMapaOnMouseClickedConstruirPlazaCentralStrategy(ContenedorMapa contenedorMapa, Juego juego, Aldeano aldeano, VistaMapa vistaMapa, VistaSeleccionador vistaSeleccionador) {
		
		this.juego = juego;
		this.aldeano = aldeano;
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
			PlazaCentral plazaCentral= new PlazaCentral(new Posicion(colIndex, rowIndex), mapa);
			VistaPlazaCentral vistaPlazaCentral = new VistaPlazaCentral(ContenedorPartida.contenedorMapa, ContenedorPartida.contenedorControles, ContenedorPartida.vistaMapa, ContenedorPartida.vistaSeleccionador, juego, plazaCentral);
			plazaCentral.addObserver(vistaPlazaCentral);
			aldeano.construirConstruible(plazaCentral);
			juego.obtenerJugadorActual().agregarEdificio(plazaCentral);
			vistaPlazaCentral.dibujarPosicionable(plazaCentral);
			}
		
		catch(EdificioNoAptoParaConstruccionException e) {
			error.mostrarVentanaError("No es posible construir este Edificio", "No tiene recursos suficientes");
		}
		catch(EdificioConConstructorAsignadoException e) {
			error.mostrarVentanaError("Error de aldeano constructor", "Este aldeano no puede construir este edificio porque siendo construido por otro");
		}
		catch(AldeanoConConstruccionAsignadaException e) {
			error.mostrarVentanaError("Error de aldeano constructor","Este aldeano se encuentra construyendo otro edificio");
		}
		catch(CeldaOcupadaException e) {
			error.mostrarVentanaError("La celda en la que intentas contruir esta ocupada", "Intente con una celda libre");
		}
		catch(CeldaInexistenteException e) {
			error.mostrarVentanaError("La celda en la que intentas contruir no existe", "Intente con una celda del mapa");
		} catch (OroInsuficienteException e) {
			error.mostrarVentanaError("No puede crear una nueva plazaCentral porque no tiene suficiente oro","");
		}			
		finally {
			vistaMapa.setNodoMapaOnMouseClickedStrategy(new NodoMapaOnMouseClickedSeleccionarStrategy(juego, ContenedorPartida.contenedorMapa, vistaSeleccionador));
			ContenedorPartida.contenedorMapa.setCursorDefault();
		}
	}

}
