package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.excepciones.EdificioEnConstruccionException;
import fiuba.algo3.tp2.edificio.GestionarConstruccion;
import fiuba.algo3.tp2.excepciones.UnidadNoSoportadaException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonCreadorDeArmaDeAsedioEventHandler implements EventHandler<ActionEvent> {

    private Button boton;

    private Castillo castillo;

	private GestionarConstruccion gestorDeConstruccion;

	private Mapa mapa;

    public BotonCreadorDeArmaDeAsedioEventHandler(Button botonCreadorDeArmaDeAsedio, Castillo castillo, Mapa mapa) {

        this.boton = botonCreadorDeArmaDeAsedio;

        this.castillo = castillo;
        
        this.gestorDeConstruccion = new GestionarConstruccion(castillo);
        
        this.mapa = mapa;

    }

    @Override
    public void handle(ActionEvent event) {

        try {
            this.gestorDeConstruccion.crearArmaAsedio(this.castillo.obtenerPosicion().desplazarHorizontalmente(5), mapa);
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
