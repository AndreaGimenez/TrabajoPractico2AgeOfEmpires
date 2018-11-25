package fiuba.algo3.tp2.vistas;

import fiuba.algo3.tp2.construccion.EdificioNoSoportadoException;
import fiuba.algo3.tp2.edificio.EdificioConstants;
import fiuba.algo3.tp2.edificio.PosicionarEdificio;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.unidad.Aldeano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonCreadorDeCuartelEventHandler implements EventHandler<ActionEvent> {

    private PosicionarEdificio posicionador;

    private Button boton;


    public BotonCreadorDeCuartelEventHandler(Button botonCreadorDeCuartel, PosicionarEdificio aldeano) {

        this.boton = botonCreadorDeCuartel;

        this.posicionador = aldeano;

    }

    @Override
    public void handle(ActionEvent event) {

        try {
            this.posicionador.posicionarALaDerechaPorEncima(EdificioConstants.TipoEdificio.CUARTEL);
        } catch (EdificioNoSoportadoException e) {
            e.printStackTrace();
        } catch (CeldaInexistenteException e) {
            e.printStackTrace();
        } catch (CeldaOcupadaException e) {
            e.printStackTrace();
        }

    }
}
