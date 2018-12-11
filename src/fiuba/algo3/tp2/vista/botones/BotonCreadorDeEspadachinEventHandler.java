package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.excepciones.EdificioEnConstruccionException;
import fiuba.algo3.tp2.edificio.GestionarConstruccion;
import fiuba.algo3.tp2.excepciones.UnidadNoSoportadaException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.vista.MensajeDeError;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonCreadorDeEspadachinEventHandler implements EventHandler<ActionEvent> {

    private Button boton;

    private Cuartel cuartel;

	private GestionarConstruccion gestorDeConstruccion;

	private Mapa mapa;

    public BotonCreadorDeEspadachinEventHandler(Button botonCreadorDeEspadachin, Cuartel cuartel, Mapa mapa) {

        this.boton = botonCreadorDeEspadachin;

        this.cuartel = cuartel;
        
        this.gestorDeConstruccion = new GestionarConstruccion(this.cuartel);
        
        this.mapa = mapa;

    }


    @Override
    public void handle(ActionEvent event) {
    	
    	MensajeDeError error = new MensajeDeError();
    	
        try {
            this.gestorDeConstruccion.crearEspadachin(this.cuartel.obtenerPosicion().desplazarHorizontalmente(3), mapa);
        } catch (CeldaOcupadaException e) {
        	 error.mostrarVentanaError("Celda Ocupada", "Una celda soporta solo un posicionable");
        } catch (CeldaInexistenteException e) {
        	 error.mostrarVentanaError("Celda Fuera De Mapa", "Intente con una celda dentro del mapa");
        } catch (UnidadNoSoportadaException e) {
        	 error.mostrarVentanaError("Unidad No Soportada", "Elija otra unidad");
        } catch (EdificioEnConstruccionException e) {
        	 error.mostrarVentanaError("Edificio En Construccion", "Debe esperar a que el edifico termine de construirse");
		}
    }
}
