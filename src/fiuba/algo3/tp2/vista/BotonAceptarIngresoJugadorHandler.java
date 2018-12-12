package fiuba.algo3.tp2.vista;


import java.util.Collection;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.PlazaCentral;
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
					//this.contenedorJuego = new ContenedorPartida(stage, juego);
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
																	    OroInsuficienteException {
    	
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
	
	private void inicializarPosicionables(Mapa mapa, Juego juego) throws CeldaOcupadaException, CeldaInexistenteException, OroInsuficienteException, PoblacionMaximaAlcanzadaException {
		
		inicializarPosicionablesJugador1(mapa, juego);
		inicializarPosicionablesJugador2(mapa, juego);
		
        
        //agrego unidades y edificios EXTRA para probar funcionalidad
        Cuartel cuartel = new Cuartel(new Posicion(8, 0), mapa);
        VistaCuartel vistaCuartel = new VistaCuartel(ContenedorPartida.contenedorMapa, ContenedorPartida.contenedorControles, ContenedorPartida.vistaMapa, ContenedorPartida.vistaSeleccionador, juego);
        cuartel.addObserver(vistaCuartel);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaCuartel, cuartel.obtenerPosicion());
        juego.obtenerJugadorActual().agregarEdificio(cuartel, false);
        vistaCuartel.dibujarPosicionable(cuartel);
        
        
        Arquero arquero = new Arquero(new Posicion(10, 10), mapa);
        VistaArquero vistaArquero = new VistaArquero(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego);
        arquero.addObserver(vistaArquero);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaArquero, arquero.obtenerPosicion());
        juego.obtenerJugadorActual().agregarUnidad(arquero, mapa, false);
        vistaArquero.dibujarPosicionable(arquero);
        
        Espadachin espadachin = new Espadachin(new Posicion(11, 10), mapa);
        VistaEspadachin vistaEspadachin = new VistaEspadachin(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego);
        espadachin.addObserver(vistaEspadachin);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaEspadachin, espadachin.obtenerPosicion());
        juego.obtenerJugadorActual().agregarUnidad(espadachin, mapa, false);
        vistaEspadachin.dibujarPosicionable(espadachin);
        
        ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(12, 10), mapa);
        VistaArmaAsedio vistaArmaAsedio = new VistaArmaAsedio(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego);
        armaAsedio.addObserver(vistaArmaAsedio);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaArmaAsedio, armaAsedio.obtenerPosicion());
        juego.obtenerJugadorActual().agregarUnidad(armaAsedio, mapa, false);
        vistaArmaAsedio.dibujarPosicionable(armaAsedio);
        
        
		try {
			juego.avanzarJugador();
		} catch (EdificioNoAptoParaConstruccionException | EdificioConConstructorAsignadoException
				| YaSeReparoEnESteTurnoException | EdificioNoAptoParaReparacionException | EdificioConReparadorAsignadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        VistaAldeano vistaAldeano = new VistaAldeano(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego);
        Aldeano aldeano = new Aldeano(new Posicion(13, 10), mapa);
        aldeano.addObserver(vistaAldeano);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaAldeano, aldeano.obtenerPosicion());
        vistaAldeano.dibujarPosicionable(aldeano);
        juego.obtenerJugadorActual().agregarUnidad(aldeano, mapa, false);
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
        
        VistaPlazaCentral vistaPlazaCentral = new VistaPlazaCentral(ContenedorPartida.contenedorMapa, ContenedorPartida.contenedorControles, ContenedorPartida.vistaMapa, ContenedorPartida.vistaSeleccionador, juego);
        PlazaCentral plazaCentral = (PlazaCentral)mapa.obtenerPosicionable(PosicionesIniciales.POSICION_PLAZA_CENTRAL_1);
        plazaCentral.addObserver(vistaPlazaCentral);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaPlazaCentral, plazaCentral.obtenerPosicion());
        juego.obtenerJugadorActual().agregarEdificio(plazaCentral, false);
        vistaPlazaCentral.dibujarPosicionable(plazaCentral);
		
        VistaAldeano vistaAldeano = new VistaAldeano(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego);
        Aldeano aldeano = (Aldeano)mapa.obtenerPosicionable(PosicionesIniciales.POSICION_INICIAL_1);
        aldeano.addObserver(vistaAldeano);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaAldeano, aldeano.obtenerPosicion());
        vistaAldeano.dibujarPosicionable(aldeano);
        
        
        vistaAldeano = new VistaAldeano(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego);
        aldeano = (Aldeano)mapa.obtenerPosicionable(PosicionesIniciales.POSICION_INICIAL_2);
        aldeano.addObserver(vistaAldeano);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaAldeano, aldeano.obtenerPosicion());
        vistaAldeano.dibujarPosicionable(aldeano);
        
        
        vistaAldeano = new VistaAldeano(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego);
        aldeano = (Aldeano)mapa.obtenerPosicionable(PosicionesIniciales.POSICION_INICIAL_3);
        aldeano.addObserver(vistaAldeano);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaAldeano, aldeano.obtenerPosicion());
        vistaAldeano.dibujarPosicionable(aldeano);
	}

	private void inicializarPosicionablesJugador2(Mapa mapa, Juego juego) throws OroInsuficienteException {
		
		//Asigno a cada celda del mapa que contiene un edificio/unidad inicial del jugador 1 su vista
        VistaCastillo vistaCastillo = new VistaCastillo(ContenedorPartida.contenedorMapa, ContenedorPartida.contenedorControles, ContenedorPartida.vistaMapa, ContenedorPartida.vistaSeleccionador, juego);
        Castillo castillo = (Castillo)mapa.obtenerPosicionable(new Posicion(mapa.getTamanioX()-1, mapa.getTamanioY()-1));
        castillo.addObserver(vistaCastillo);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaCastillo, castillo.obtenerPosicion());
        juego.obtenerJugadorActual().agregarEdificio(castillo, false);
        vistaCastillo.dibujarPosicionable(castillo);
        
        VistaPlazaCentral vistaPlazaCentral = new VistaPlazaCentral(ContenedorPartida.contenedorMapa, ContenedorPartida.contenedorControles, ContenedorPartida.vistaMapa, ContenedorPartida.vistaSeleccionador, juego);
        PlazaCentral plazaCentral = (PlazaCentral)mapa.obtenerPosicionable(new Posicion(mapa.getTamanioX()-7, mapa.getTamanioY()-2));
        plazaCentral.addObserver(vistaPlazaCentral);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaPlazaCentral, plazaCentral.obtenerPosicion());
        juego.obtenerJugadorActual().agregarEdificio(plazaCentral, false);
        vistaPlazaCentral.dibujarPosicionable(plazaCentral);
		
        VistaAldeano vistaAldeano = new VistaAldeano(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego);
        Aldeano aldeano = (Aldeano)mapa.obtenerPosicionable(new Posicion(mapa.getTamanioX()-6, mapa.getTamanioY()-4));
        aldeano.addObserver(vistaAldeano);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaAldeano, aldeano.obtenerPosicion());
        vistaAldeano.dibujarPosicionable(aldeano);
        
        
        vistaAldeano = new VistaAldeano(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego);
        aldeano = (Aldeano)mapa.obtenerPosicionable(new Posicion(mapa.getTamanioX()-6, mapa.getTamanioY()-6));
        aldeano.addObserver(vistaAldeano);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaAldeano, aldeano.obtenerPosicion());
        vistaAldeano.dibujarPosicionable(aldeano);
        
        
        vistaAldeano = new VistaAldeano(ContenedorPartida.contenedorControles, ContenedorPartida.contenedorMapa, ContenedorPartida.vistaSeleccionador, ContenedorPartida.vistaMapa, juego);
        aldeano = (Aldeano)mapa.obtenerPosicionable(new Posicion(mapa.getTamanioX()-4, mapa.getTamanioY()-6));
        aldeano.addObserver(vistaAldeano);
        ContenedorPartida.contenedorMapa.agregarVistaPosicionable(vistaAldeano, aldeano.obtenerPosicion());
        vistaAldeano.dibujarPosicionable(aldeano);
	}
}
