package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.EdificioEnConstruccionException;
import fiuba.algo3.tp2.edificio.GestionarConstruccion;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.unidad.UnidadConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonCreadorDeEspadachinEventHandler implements EventHandler<ActionEvent> {

    private Button boton;

    private Cuartel cuartel;

	private GestionarConstruccion gestorDeConstruccion;

	private Mapa mapa;

    public BotonCreadorDeEspadachinEventHandler(Button botonCreadorDeEspadachin, Cuartel cuartel, Mapa mapa) {

        this.boton = botonCreadorDeEspadachin;

        this.cuartel = cuartel;
        
        this.gestorDeConstruccion = new GestionarConstruccion(this.cuartel);
        
        this.mapa = mapa;

    }


    @Override
    public void handle(ActionEvent event) {

        try {
            this.gestorDeConstruccion.crearEspadachin(this.cuartel.obtenerPosicion().desplazarHorizontalmente(3), mapa);
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
