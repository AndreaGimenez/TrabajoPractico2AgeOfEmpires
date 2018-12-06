package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.EdificioConstants;
import fiuba.algo3.tp2.edificio.PosicionarEdificio;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioNoSoportadoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonConstruirCuartelALaIzquierdaPorEncimaEventHandler implements EventHandler<ActionEvent> {

    private PosicionarEdificio posicionador;

    public BotonConstruirCuartelALaIzquierdaPorEncimaEventHandler(Aldeano aldeano) {
        this.posicionador = new PosicionarEdificio(aldeano);
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            this.posicionador.posicionarALaIzquierdaPorEncima(EdificioConstants.TipoEdificio.CUARTEL);
        } catch (EdificioNoSoportadoException e) {
            e.printStackTrace();
        } catch (CeldaInexistenteException e) {
            e.printStackTrace();
        } catch (CeldaOcupadaException e) {
            e.printStackTrace();
        }
    }
}
