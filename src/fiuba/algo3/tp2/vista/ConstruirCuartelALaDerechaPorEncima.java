package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.EdificioConstants;
import fiuba.algo3.tp2.edificio.PosicionarEdificio;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioNoSoportadoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ConstruirCuartelALaDerechaPorEncima implements AccionPosicionarEdificio {

    private PosicionarEdificio posicionardor;
    private String identificador;

    public ConstruirCuartelALaDerechaPorEncima(Aldeano aldeano) {
        this.posicionardor = new PosicionarEdificio(aldeano);
        this.identificador = "Construir a la derecha por encima";
    }

    @Override
    public void realizarConstruccion() {
        try {
            this.posicionardor.posicionarALaDerechaPorEncima(EdificioConstants.TipoEdificio.CUARTEL);
        } catch (EdificioNoSoportadoException e) {
            e.printStackTrace();
        } catch (CeldaInexistenteException e) {
            e.printStackTrace();
        } catch (CeldaOcupadaException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AccionPosicionarEdificio coincideAccion(String accion) {
        if(this.identificador.equals(accion))
            return this;
        else
            return null;
    }
}
