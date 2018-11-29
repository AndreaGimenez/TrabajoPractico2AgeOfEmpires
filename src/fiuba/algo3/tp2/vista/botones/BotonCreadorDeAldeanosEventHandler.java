package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.edificio.EdificioEnConstruccionException;
import fiuba.algo3.tp2.edificio.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.edificio.GestionarConstruccion;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.unidad.UnidadConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class BotonCreadorDeAldeanosEventHandler implements EventHandler<ActionEvent> {

    private Button boton;
    private PlazaCentral plazaCentral;
	private GestionarConstruccion gestorDeConstruccion;
	private Mapa mapa;

    public BotonCreadorDeAldeanosEventHandler(Button botonCreadorDeAldeanos, PlazaCentral plazaCentral, Mapa mapa) {

        this.boton = botonCreadorDeAldeanos;
        this.plazaCentral = plazaCentral;
        this.gestorDeConstruccion = new GestionarConstruccion(this.plazaCentral);
        this.mapa = mapa;

    }

    @Override
    public void handle(ActionEvent event) {

        try {
            this.gestorDeConstruccion.crearAldeano(this.plazaCentral.obtenerPosicion().desplazarHorizontalmente(3), this.mapa);
        } catch (CeldaOcupadaException e) {
            e.printStackTrace();
        } catch (CeldaInexistenteException e) {
            e.printStackTrace();
        } catch (UnidadNoSoportadaException e) {
            e.printStackTrace();
        } catch (EdificioEnConstruccionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
