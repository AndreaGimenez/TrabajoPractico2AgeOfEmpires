package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.construccion.EdificioNoSoportadoException;
import fiuba.algo3.tp2.edificio.EdificioConstants;
import fiuba.algo3.tp2.edificio.PosicionarEdificio;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonCreadorDePlazaCentralEventHandler implements EventHandler<ActionEvent> {

    private Button boton;

    private PosicionarEdificio posicionador;

    public BotonCreadorDePlazaCentralEventHandler(Button botonCreadorDePlazaCentral, PosicionarEdificio posicionador) {

        this.boton = botonCreadorDePlazaCentral;

        this.posicionador = posicionador;

    }

    @Override
    public void handle(ActionEvent event) {

        try {
            this.posicionador.posicionarALaDerechaPorEncima(EdificioConstants.TipoEdificio.PLAZA_CENTRAL);
        } catch (EdificioNoSoportadoException e) {
            e.printStackTrace();
        } catch (CeldaInexistenteException e) {
            e.printStackTrace();
        } catch (CeldaOcupadaException e) {
            e.printStackTrace();
        }

    }
}
