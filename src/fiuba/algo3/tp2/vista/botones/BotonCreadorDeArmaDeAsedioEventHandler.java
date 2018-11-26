package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.unidad.UnidadConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonCreadorDeArmaDeAsedioEventHandler implements EventHandler<ActionEvent> {

    private Button boton;

    private Castillo castillo;

    public BotonCreadorDeArmaDeAsedioEventHandler(Button botonCreadorDeArmaDeAsedio, Castillo castillo) {

        this.boton = botonCreadorDeArmaDeAsedio;

        this.castillo = castillo;

    }

    @Override
    public void handle(ActionEvent event) {

        try {
            this.castillo.crear(UnidadConstants.TipoUnidad.ARMA_ASEDIO, this.castillo.obtenerPosicion().desplazarHorizontalmente(5));
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
