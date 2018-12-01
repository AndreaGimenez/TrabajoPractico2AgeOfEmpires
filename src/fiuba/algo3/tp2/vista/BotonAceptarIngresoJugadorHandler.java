package fiuba.algo3.tp2.vista;


import java.util.Collection;

import fiuba.algo3.tp2.excepciones.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
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

	public BotonAceptarIngresoJugadorHandler(Stage stage, Label labelAdvertencia, Label labelNombreJugador, TextField tfNombreJugador, Collection<String> nombresJugadores) {
		this.nombresJugadores = nombresJugadores;
		this.tfNombreJugador = tfNombreJugador;
		this.labelAdvertencia = labelAdvertencia;
		this.labelNombreJugador = labelNombreJugador;
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
				
				try {
					
					Juego juego = crearJuego(nombresJugadores);
					ContenedorPartida contenedorJuego = new ContenedorPartida(stage, juego);
					Scene escenaJuego = new Scene(contenedorJuego);
					AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorJuego.getBarraDeMenu());
			        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
			        
					stage.setScene(escenaJuego);
					stage.setFullScreen(true);
					
				} catch (TamanioInvalidoException | CantidadDeJugadoresInvalidaException | CeldaOcupadaException
						| CeldaInexistenteException | PoblacionMaximaAlcanzadaException
						| OroInsuficienteException e) {
					
					//TODO manejar una excepcion que puede ser arrojada al iniciar el juego
					e.printStackTrace();
				}
			}
			
		}
	}
	
    private Juego crearJuego(Collection<String> nombresJugadores) 
    		throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
    	
    	Mapa mapa = new Mapa(50, 50);
    	new Arquero(new Posicion(10, 10), mapa);
    	new Espadachin(new Posicion(11, 10), mapa);
        Juego juego = new Juego(mapa);
        juego.iniciar(nombresJugadores.toArray(new String[juego.CANTIDAD_DE_JUGADORES]));
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
