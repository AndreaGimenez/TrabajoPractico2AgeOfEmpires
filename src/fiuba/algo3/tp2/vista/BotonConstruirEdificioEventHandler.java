package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.EdificioConstants;
import fiuba.algo3.tp2.edificio.PosicionarEdificio;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioNoSoportadoException;
import fiuba.algo3.tp2.mapa.Posicion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonConstruirEdificioEventHandler implements EventHandler<ActionEvent> {

    Button boton;
    PosicionarEdificio posicionador;
    

    public BotonConstruirEdificioEventHandler(Button accionConstruir, PosicionarEdificio posicionarEdificio) {

        this.boton = accionConstruir;

        this.posicionador = posicionarEdificio;
    }

    @Override
    public void handle(ActionEvent event) {

        try {
            posicionador.posicionarArribaPorLaDerecha(EdificioConstants.TipoEdificio.CUARTEL);
        } catch (EdificioNoSoportadoException e) {
            e.printStackTrace();
        } catch (CeldaInexistenteException e) {
            e.printStackTrace();
        } catch (CeldaOcupadaException e) {
            e.printStackTrace();
        }

    }
}
