package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.EdificioConstants;
import fiuba.algo3.tp2.edificio.PosicionarEdificio;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioNoSoportadoException;
import fiuba.algo3.tp2.unidad.Aldeano;

public class ConstruirPlazaCentralALaDerechaPorEncima implements AccionPosicionarEdificio {

    private PosicionarEdificio posicionador;
    private String identificador;

    public ConstruirPlazaCentralALaDerechaPorEncima(Aldeano aldeano) {
        this.posicionador = new PosicionarEdificio(aldeano);
        this.identificador = "Construir a la derecha por encima";
    }

    @Override
    public void realizarConstruccion() {
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

    @Override
    public AccionPosicionarEdificio coincideAccion(String accion) {
        if(this.identificador.equals(accion))
            return this;
        else
            return null;
    }
}
