package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.edificio.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.unidad.UnidadConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class BotonCreadorDeAldeanosEventHandler implements EventHandler<ActionEvent> {

    private Button boton;
    private PlazaCentral plazaCentral;

    public BotonCreadorDeAldeanosEventHandler(Button botonCreadorDeAldeanos, PlazaCentral plazaCentral) {

        this.boton = botonCreadorDeAldeanos;
        this.plazaCentral = plazaCentral;

    }

    @Override
    public void handle(ActionEvent event) {

        try {
            this.plazaCentral.crear(UnidadConstants.TipoUnidad.ALDEANO, this.plazaCentral.obtenerPosicion().desplazarHorizontalmente(3));
        } catch (CeldaOcupadaException e) {
            e.printStackTrace();
        } catch (CeldaInexistenteException e) {
            e.printStackTrace();
        } catch (UnidadNoSoportadaException e) {
            e.printStackTrace();
        } catch (EdifioNoAptoParaContruirException e) {
            e.printStackTrace();
        }

    }
}
