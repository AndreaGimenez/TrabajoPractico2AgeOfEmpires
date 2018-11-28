package fiuba.algo3.tp2.edificio;

import java.util.Collection;

import fiuba.algo3.tp2.formas.Forma;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.reparacion.Reparacion;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants;

/*Estado de construccion:
*
* 0/3 no construido
* 1/3 no construido
* 2/3 no construido
* 3/3 construido
*
* en el mismo turno que se quiere crear un edificio, esta en 0/3*/
public class GestionarConstruccion extends Edificio implements Posicionable {

    Edificio edificio;
    private int turnosDesdeSuPosicionamiento;
    private EdificioEnConstruccionException e;

    public GestionarConstruccion(Edificio edificio) {
        super();
        this.edificio = edificio;
        this.e = new EdificioEnConstruccionException();
        this.turnosDesdeSuPosicionamiento = 0;

    }

    public boolean estaEnConstruccion(){

        return this.turnosDesdeSuPosicionamiento < 3;

    }

    public Unidad crear(UnidadConstants.TipoUnidad espadachin, Posicion posicion) throws EdificioEnConstruccionException, CeldaOcupadaException, EdifioNoAptoParaContruirException, CeldaInexistenteException, UnidadNoSoportadaException {

        if(this.estaEnConstruccion()) throw this.e;

        return this.edificio.crear(espadachin, posicion);

    }

    @Override
    public int costo() {
        return this.edificio.costo();
    }

    @Override
    public boolean estaReparado() {
        return this.edificio.estaReparado();
    }

    @Override
    public void posicionar(Posicion coordenada) throws CeldaOcupadaException, CeldaInexistenteException {
        this.edificio.posicionar(coordenada);
    }

    @Override
    public Posicion obtenerPosicion() {
        return this.edificio.obtenerPosicion();
    }

    @Override
    public void iniciar() {

    }

    @Override
    public void actualizarEstadoParaNuevoTurno() {
        this.turnosDesdeSuPosicionamiento ++;
    }

	@Override
	public Collection<Posicion> obtenerPosicionesOcupadasEnMapa() {
		return this.edificio.obtenerPosicionesOcupadasEnMapa();
	}
}
