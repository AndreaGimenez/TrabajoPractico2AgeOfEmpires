package fiuba.algo3.tp2.vista.handlers;


import java.util.Collection;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
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
import fiuba.algo3.tp2.mapa.PosicionesIniciales;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.vista.MensajeDeError;
import fiuba.algo3.tp2.vista.VistaAldeano;
import fiuba.algo3.tp2.vista.VistaArmaAsedio;
import fiuba.algo3.tp2.vista.VistaArquero;
import fiuba.algo3.tp2.vista.VistaCastillo;
import fiuba.algo3.tp2.vista.VistaCuartel;
import fiuba.algo3.tp2.vista.VistaEspadachin;
import fiuba.algo3.tp2.vista.VistaPlazaCentral;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;
import fiuba.algo3.tp2.vista.musica.Musica;
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
	private ContenedorPartida contenedorJuego;
	
	public BotonAceptarIngresoJugadorHandler
	(Stage stage, Label labelAdvertencia, Label labelNombreJugador, TextField tfNombreJugador, 
			Collection<String> nombresJugadores, Musica musica) {
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
					this.contenedorJuego = new ContenedorPartida(stage);
					Juego juego = crearJuego(nombresJugadores);
					Scene escenaJuego = new Scene(contenedorJuego);
					AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorJuego.getBarraDeMenu());
			        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
			        
			        musica.detenerReproduccionMusica();

					stage.setScene(escenaJuego);
					stage.setFullScreen(true);
					
				} 
				catch(TamanioInvalidoException e) {		
					error.mostrarVentanaError("Tamanio Invalido", "");
				} 
				catch(CantidadDeJugadoresInvalidaException e) {
					error.mostrarVentanaError("Cantidad De Jugadores Invalida", "La cantidad de jugadores debe ser igual a 2");
				}
				catch(CeldaOcupadaException e) {
					error.mostrarVentanaError("Celda Ocupada", "Una celda no admite mas de un posicionable");
				}
				catch(CeldaInexistenteException e) {
					error.mostrarVentanaError("Celda Fuera Del Mapa", "Intente nuevamente con una celda dentro del mapa");
				}
				catch(PoblacionMaximaAlcanzadaException e) {
					error.mostrarVentanaError("Ya Alcanzaste La Poblacion Maxima", "Solo puede tener 50 de Poblacion");
				}
				catch(OroInsuficienteException e) {
					error.mostrarVentanaError("Oro Insuficiente", "Debe ganar mas oro para realizar la accion");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		}
	}
	
    private Juego crearJuego(Collection<String> nombresJugadores) throws CantidadDeJugadoresInvalidaException, 
																	    TamanioInvalidoException, 
																	    CeldaOcupadaException, 
																	    CeldaInexistenteException, 
																	    PoblacionMaximaAlcanzadaException, 
																	    OroInsuficienteException, AtaqueInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {
    	
    	Mapa mapa = new Mapa(35, 20);
        Juego juego = new Juego(mapa);
        juego.iniciar(nombresJugadores.toArray(new String[juego.CANTIDAD_DE_JUGADORES]));
        
        this.contenedorJuego.setControles(juego);
        this.contenedorJuego.setMapa(juego, stage);
        this.contenedorJuego.setEstadoJugador(juego);
        
        inicializarPosicionables(mapa, juego);
		
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
	 
	private void inicializarPosicionables(Mapa mapa, Juego juego) throws CeldaOcupadaException, CeldaInexistenteException, OroInsuficienteException, PoblacionMaximaAlcanzadaException, AtaqueInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {
		
		inicializarPosicionablesJugador1(mapa, juego);
		inicializarPosicionablesJugador2(mapa, juego);
		try {
			juego.avanzarJugador();
		} catch (EdificioNoAptoParaConstruccionException | EdificioConConstructorAsignadoException
				| YaSeReparoEnESteTurnoException | EdificioNoAptoParaReparacionException | EdificioConReparadorAsignadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			juego.avanzarJugador();
		} catch (EdificioNoAptoParaConstruccionException | EdificioConConstructorAsignadoException
				| YaSeReparoEnESteTurnoException | EdificioNoAptoParaReparacionException | EdificioConReparadorAsignadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void inicializarPosicionablesJugador1(Mapa mapa, Juego juego) throws OroInsuficienteException {
		
		//Asigno a cada celda del mapa que contiene un edificio/unidad inicial del jugador 1 su vista
        VistaCastillo vistaCastillo = new VistaCastillo(ContenedorPartida.contenedorMapa, ContenedorPartida.contenedorControles, ContenedorPartida.vistaMapa, ContenedorPartida.vistaSeleccionador, juego);
        Castillo castillo = (Castillo)mapa.obtenerPosicionable(PosicionesIniciales.POSICION_CASTILLO_1);
        castillo.addObserver(vistaCastillo);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaCastillo, castillo.obtenerPosicion());
        juego.obtenerJugadorActual().agregarEdificio(castillo, false);
        vistaCastillo.dibujarPosicionable(castillo);
        
        
        PlazaCentral plazaCentral = (PlazaCentral)mapa.obtenerPosicionable(PosicionesIniciales.POSICION_PLAZA_CENTRAL_1);
        VistaPlazaCentral vistaPlazaCentral = new VistaPlazaCentral(ContenedorPartida.contenedorMapa, ContenedorPartida.contenedorControles, ContenedorPartida.vistaMapa, ContenedorPartida.vistaSeleccionador, juego, plazaCentral);
        plazaCentral.addObserver(vistaPlazaCentral);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaPlazaCentral, plazaCentral.obtenerPosicion());
        juego.obtenerJugadorActual().agregarEdificio(plazaCentral, false);
        vistaPlazaCentral.dibujarPosicionable(plazaCentral);
		
        
        Aldeano aldeano = (Aldeano)mapa.obtenerPosicionable(PosicionesIniciales.POSICION_INICIAL_1);
        VistaAldeano vistaAldeano = new VistaAldeano(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego, aldeano);
        aldeano.addObserver(vistaAldeano);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaAldeano, aldeano.obtenerPosicion());
        vistaAldeano.dibujarPosicionable(aldeano);
        
        
        aldeano = (Aldeano)mapa.obtenerPosicionable(PosicionesIniciales.POSICION_INICIAL_2);
        vistaAldeano = new VistaAldeano(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego, aldeano);
        aldeano.addObserver(vistaAldeano);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaAldeano, aldeano.obtenerPosicion());
        vistaAldeano.dibujarPosicionable(aldeano);
        
        
        aldeano = (Aldeano)mapa.obtenerPosicionable(PosicionesIniciales.POSICION_INICIAL_3);
        vistaAldeano = new VistaAldeano(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego, aldeano);
        aldeano.addObserver(vistaAldeano);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaAldeano, aldeano.obtenerPosicion());
        vistaAldeano.dibujarPosicionable(aldeano);
	}

	private void inicializarPosicionablesJugador2(Mapa mapa, Juego juego) throws OroInsuficienteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException, AtaqueInvalidoException {
		
		//Asigno a cada celda del mapa que contiene un edificio/unidad inicial del jugador 1 su vista
        VistaCastillo vistaCastillo = new VistaCastillo(ContenedorPartida.contenedorMapa, ContenedorPartida.contenedorControles, ContenedorPartida.vistaMapa, ContenedorPartida.vistaSeleccionador, juego);
        Castillo castillo = (Castillo)mapa.obtenerPosicionable(new Posicion(mapa.getTamanioX()-1, mapa.getTamanioY()-1));
        castillo.addObserver(vistaCastillo);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaCastillo, castillo.obtenerPosicion());
        juego.avanzarJugador();
        juego.obtenerJugadorActual().agregarEdificio(castillo, false);
        vistaCastillo.dibujarPosicionable(castillo);
        
        PlazaCentral plazaCentral = (PlazaCentral)mapa.obtenerPosicionable(new Posicion(mapa.getTamanioX()-7, mapa.getTamanioY()-2));
        VistaPlazaCentral vistaPlazaCentral = new VistaPlazaCentral(ContenedorPartida.contenedorMapa, ContenedorPartida.contenedorControles, ContenedorPartida.vistaMapa, ContenedorPartida.vistaSeleccionador, juego, plazaCentral);
        plazaCentral.addObserver(vistaPlazaCentral);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaPlazaCentral, plazaCentral.obtenerPosicion());
        juego.obtenerJugadorActual().agregarEdificio(plazaCentral, false);
        vistaPlazaCentral.dibujarPosicionable(plazaCentral);
		
        
        Aldeano aldeano = (Aldeano)mapa.obtenerPosicionable(new Posicion(mapa.getTamanioX()-6, mapa.getTamanioY()-4));
        VistaAldeano vistaAldeano = new VistaAldeano(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego, aldeano);
        aldeano.addObserver(vistaAldeano);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaAldeano, aldeano.obtenerPosicion());
        vistaAldeano.dibujarPosicionable(aldeano);
        
        
        aldeano = (Aldeano)mapa.obtenerPosicionable(new Posicion(mapa.getTamanioX()-6, mapa.getTamanioY()-6));
        vistaAldeano = new VistaAldeano(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego, aldeano);
        aldeano.addObserver(vistaAldeano);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaAldeano, aldeano.obtenerPosicion());
        vistaAldeano.dibujarPosicionable(aldeano);
        
        
        aldeano = (Aldeano)mapa.obtenerPosicionable(new Posicion(mapa.getTamanioX()-4, mapa.getTamanioY()-6));
        vistaAldeano = new VistaAldeano(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego, aldeano);
        aldeano.addObserver(vistaAldeano);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaAldeano, aldeano.obtenerPosicion());
        vistaAldeano.dibujarPosicionable(aldeano);
	}
}
