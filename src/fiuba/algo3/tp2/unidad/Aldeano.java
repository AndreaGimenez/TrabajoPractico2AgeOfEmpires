package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioConstants.TipoEdificio;
import fiuba.algo3.tp2.edificio.EspacioDeConstruccionOcupadoError;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.DireccionArriba;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;

public class Aldeano extends Unidad {
	
	public Aldeano(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, new CreadorEdificioAldeano(mapa), mapa, new MovimientoBasico());
	}

	public void construirCuartel() 
			throws CeldaOcupadaException, CeldaInexistenteException, EspacioDeConstruccionOcupadoError {

	    try {

           /* Posicion derecha = new Posicion(1, 0);*/
	    	Direccion derecha = new DireccionDerecha();
	    	
            Cuartel cuartel = new Cuartel(super.obtenerPosicion().sumar(derecha), super.obtenerMapa());
            
        } catch (Exception e) {
        	
        	try {
        	/* Posicion arriba = new Posicion(0, -1);*/
        	Direccion arriba = new DireccionArriba();
        	
            Cuartel cuartel = new Cuartel(super.obtenerPosicion().sumar(arriba), super.obtenerMapa());
        	}
        	catch (Exception ex) {
        		throw new EspacioDeConstruccionOcupadoError();
        	}
        }

	}

    public void reparar(Edificio cuartel) {
	    cuartel.reparar();
    }

    @Override
    public void recibirDanio(int danio) {
        
    }
}
