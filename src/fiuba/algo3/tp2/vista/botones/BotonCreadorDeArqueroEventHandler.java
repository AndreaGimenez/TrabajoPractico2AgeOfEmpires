package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.unidad.UnidadConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class BotonCreadorDeArqueroEventHandler implements EventHandler<ActionEvent> {

    private Cuartel cuartel;

    private Button boton;

    public BotonCreadorDeArqueroEventHandler(Button botonCreadorDeArquero, Cuartel cuartel) {

        this.boton = botonCreadorDeArquero;

        this.cuartel = cuartel;

    }

    @Override
    public void handle(ActionEvent event) {

        try {
            this.cuartel.crear(UnidadConstants.TipoUnidad.ARQUERO, this.cuartel.obtenerPosicion().desplazarHorizontalmente(3));
        } catch (CeldaOcupadaException e) {
            e.printStackTrace();
        } catch (CeldaInexistenteException e) {
            e.printStackTrace();
        } catch (UnidadNoSoportadaException e) {
            e.printStackTrace();
        }

    }
}
