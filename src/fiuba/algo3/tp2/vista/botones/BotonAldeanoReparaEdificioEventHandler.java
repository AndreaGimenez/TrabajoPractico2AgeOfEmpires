package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.unidad.Aldeano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAldeanoReparaEdificioEventHandler implements EventHandler<ActionEvent> {

    private Aldeano aldeano;

    private Edificio edificio;

    public BotonAldeanoReparaEdificioEventHandler(Edificio edificio){

        this.edificio = edificio;

    }

    @Override
    public void handle(ActionEvent event) {

        try {
            this.aldeano.repararEdificio(this.edificio);
        } catch (EdificioFueraDeRangoException e) {
            e.printStackTrace();
        } catch (EdificioNoAptoParaReparacionException e) {
            e.printStackTrace();
        } catch (EdificioConReparadorAsignadoException e) {
            e.printStackTrace();
        }

    }

    public void seleccionarAldeano(Aldeano aldeano) {

        this.aldeano = aldeano;

    }
}
