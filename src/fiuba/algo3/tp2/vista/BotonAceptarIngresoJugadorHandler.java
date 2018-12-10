package fiuba.algo3.tp2.vista;


import java.util.Collection;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.excepciones.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.vista.eventos.AplicacionOnKeyPressEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonAceptarIngresoJugadorHandler implements EventHandler<ActionEvent>{

	private Collection<String> nombresJugadores;
	private TextField tfNombreJugador;
	private Stage stage;
	private Label labelAdvertencia;
	private Label labelNombreJugador;
	private Musica musica;
	
	public BotonAceptarIngresoJugadorHandler(Stage stage, Label labelAdvertencia, Label labelNombreJugador, TextField tfNombreJugador, Collection<String> nombresJugadores, Musica musica) {
		this.nombresJugadores = nombresJugadores;
		this.tfNombreJugador = tfNombreJugador;
		this.labelAdvertencia = labelAdvertencia;
		this.labelNombreJugador = labelNombreJugador;
		this.musica = musica;
		this.stage = stage;
	}

	@Override
	public void handle(ActionEvent event) {
		
		if(checkNombreJugador(tfNombreJugador.getText())) {
			
			nombresJugadores.add(tfNombreJugador.getText());
			if(nombresJugadores.size() < Juego.CANTIDAD_DE_JUGADORES) {
				
				labelNombreJugador.setText("Ingrese nombre del jugador " + String.valueOf(nombresJugadores.size() + 1));
				tfNombreJugador.setText("");
				tfNombreJugador.requestFocus();
			}else {
				 MensajeDeError error = new MensajeDeError();
				try {
					
					Juego juego = crearJuego(nombresJugadores);
					ContenedorPartida contenedorJuego = new ContenedorPartida(stage, juego);
					Scene escenaJuego = new Scene(contenedorJuego);
					AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorJuego.getBarraDeMenu());
			        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
			        
			        musica.detenerReproduccionMusica();

					stage.setScene(escenaJuego);
					stage.setFullScreen(true);
					
				} 
				catch(TamanioInvalidoException e) {		
					error.mostrarVentanaError("Tamanio Invalido");
				}
				catch(CantidadDeJugadoresInvalidaException e) {
					error.mostrarVentanaError("Cantidad De Jugadores Invalida");
				}
				catch(CeldaOcupadaException e) {
					error.mostrarVentanaError("Celda Ocupada");
				}
				catch(CeldaInexistenteException e) {
					error.mostrarVentanaError("Celda Fuera Del Mapa");
				}
				catch(PoblacionMaximaAlcanzadaException e) {
					error.mostrarVentanaError("Ya Alcanzaste La Poblaci�n M�xima");
				}
				catch(OroInsuficienteException e) {
					error.mostrarVentanaError("Oro Insuficiente");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		}
	}
	
    private Juego crearJuego(Collection<String> nombresJugadores) 
    		throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
    	
    	Mapa mapa = new Mapa(20, 20);
        Juego juego = new Juego(mapa);
        juego.iniciar(nombresJugadores.toArray(new String[juego.CANTIDAD_DE_JUGADORES]));
        
        juego.obtenerJugadorActual().agregarEdificio(new Cuartel(new Posicion(8, 0), mapa), false);
        juego.obtenerJugadorActual().agregarUnidad(new Arquero(new Posicion(10, 10), mapa), mapa, false);
        juego.obtenerJugadorActual().agregarUnidad(new Espadachin(new Posicion(11, 10), mapa), mapa, false);
        juego.obtenerJugadorActual().agregarUnidad(new ArmaAsedio(new Posicion(12, 10), mapa), mapa, false);
        
			try {
				juego.avanzarJugador();
			} catch (EdificioNoAptoParaConstruccionException | EdificioConConstructorAsignadoException
					| YaSeReparoEnESteTurnoException | EdificioNoAptoParaReparacionException | EdificioConReparadorAsignadoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        juego.obtenerJugadorActual().agregarUnidad(new Aldeano(new Posicion(13, 10), mapa), mapa, false);
        try {
			juego.avanzarJugador();
		} catch (EdificioNoAptoParaConstruccionException | EdificioConConstructorAsignadoException
				| YaSeReparoEnESteTurnoException | EdificioNoAptoParaReparacionException | EdificioConReparadorAsignadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return juego;
	}

	private boolean checkNombreJugador(String nombreJugador) {
		
		boolean resultado;
		if (nombreJugador.trim().equals("")) {
			labelAdvertencia.setText("Debe ingresar un nombre de jugador");
			resultado = false;
		}else {
			labelAdvertencia.setText("");
			resultado = true;
		}
		
		return resultado;
	}
}
