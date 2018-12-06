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


public class BotonCreadorDeArqueroEventHandler implements EventHandler<ActionEvent> {

    private Cuartel cuartel;

    private Button boton;

	private GestionarConstruccion gestorDeConstruccion;

	private Mapa mapa;

    public BotonCreadorDeArqueroEventHandler(Button botonCreadorDeArquero, Cuartel cuartel, Mapa mapa) {

        this.boton = botonCreadorDeArquero;

        this.cuartel = cuartel;
        
        this.gestorDeConstruccion = new GestionarConstruccion(cuartel);
        
        this.mapa = mapa;

    }

    @Override
    public void handle(ActionEvent event) {
    	
    	MensajeDeError error = new MensajeDeError();
    	
        try {
            this.gestorDeConstruccion.crearArquero(this.cuartel.obtenerPosicion().desplazarHorizontalmente(3), mapa);
        } catch (CeldaOcupadaException e) {
            error.mostrarVentanaError("Celda Ocupada");
         } catch (CeldaInexistenteException e) {
         	 error.mostrarVentanaError("Celda Fuera De Mapa");
         } catch (UnidadNoSoportadaException e) {
         	 error.mostrarVentanaError("Unidad No Soportada");
         } catch (EdificioEnConstruccionException e) {
         	 error.mostrarVentanaError("Edificio En Construcción");
 		}

    }
}
