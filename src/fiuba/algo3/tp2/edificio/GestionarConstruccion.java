package fiuba.algo3.tp2.edificio;

import java.util.Collection;

import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioEnConstruccionException;
import fiuba.algo3.tp2.excepciones.UnidadNoSoportadaException;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;

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
    public void actualizarEstadoParaSiguienteTurno() {
        this.turnosDesdeSuPosicionamiento ++;
    }

	@Override
	public Collection<Posicion> obtenerPosicionesOcupadasEnMapa() {
		return this.edificio.obtenerPosicionesOcupadasEnMapa();
	}

	public Aldeano crearAldeano(Posicion posicion, Mapa mapa) 
			throws EdificioEnConstruccionException, UnidadNoSoportadaException, CeldaOcupadaException, CeldaInexistenteException {
		
		if(this.estaEnConstruccion()) throw this.e;
		
		if(!this.edificio.getClass().equals(PlazaCentral.class)) throw new UnidadNoSoportadaException();

        return new Aldeano(posicion, mapa);
	}

	public Espadachin crearEspadachin(Posicion posicion, Mapa mapa) throws EdificioEnConstruccionException, UnidadNoSoportadaException, CeldaOcupadaException, CeldaInexistenteException {
		
		if(this.estaEnConstruccion()) throw this.e;
		
		if(!this.edificio.getClass().equals(Cuartel.class)) throw new UnidadNoSoportadaException();

        return new Espadachin(posicion, mapa);
	}

	public Arquero crearArquero(Posicion posicion, Mapa mapa) throws EdificioEnConstruccionException, UnidadNoSoportadaException, CeldaOcupadaException, CeldaInexistenteException {
		
		if(this.estaEnConstruccion()) throw this.e;
		
		if(!this.edificio.getClass().equals(Cuartel.class)) throw new UnidadNoSoportadaException();

        return new Arquero(posicion, mapa);
	}

	public ArmaAsedio crearArmaAsedio(Posicion posicion, Mapa mapa) throws EdificioEnConstruccionException, UnidadNoSoportadaException, CeldaOcupadaException, CeldaInexistenteException {
		
		if(this.estaEnConstruccion()) throw this.e;
		
		if(!this.edificio.getClass().equals(Castillo.class)) throw new UnidadNoSoportadaException();

        return new ArmaAsedio(posicion, mapa);
	}
}
