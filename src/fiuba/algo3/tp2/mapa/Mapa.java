package fiuba.algo3.tp2.mapa;

import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;

import java.util.ArrayList;
import java.util.Collection;

public class Mapa {
	
	private int tamanioX;
	private int tamanioY;
	private Celda[][] celdas;

	
	public Mapa(int tamanioX, int tamanioY) throws TamanioInvalidoException {
		
		if(tamanioX < 1 || tamanioY < 1) {
			throw new TamanioInvalidoException();
		}
		
		this.tamanioX = tamanioX;
		this.tamanioY = tamanioY;
		this.celdas = new Celda[tamanioX][tamanioY];
		
		for(int i = 0; i < tamanioX; i++) {
			for(int j = 0; j < tamanioY; j++) {
				celdas[i][j] = new Celda();
			}
		}
	}
	
	public void posicionar(Posicionable posicionable, Posicion coordenada) throws CeldaOcupadaException, CeldaInexistenteException{
		verificarCelda(coordenada);
		
		Celda celda = obtenerCelda(coordenada);		
		celda.ocupar(posicionable);
	}

	public void verificarCelda(Posicion coordenada) throws CeldaInexistenteException {
		if(coordenada.getX() < 0 || coordenada.getX() >= tamanioX
		   || coordenada.getY() < 0 || coordenada.getY() >= tamanioY) {
			throw new CeldaInexistenteException();
		}
	}

	public Celda obtenerCelda(Posicion coordenada) {
		return celdas[coordenada.getX()][coordenada.getY()];
	}

	public void desplazar(Posicion posicionOrigen, Posicion posicionDestino) throws CeldaOcupadaException, CeldaInexistenteException {
		
		verificarCelda(posicionDestino);
		
		Celda origen = obtenerCelda(posicionOrigen);
		Celda destino = obtenerCelda(posicionDestino);
		
		destino.ocupar(origen);
		origen.liberar();
	}

	public Integer getTamanioX() {
		
		return this.tamanioX;
	}

	public Integer getTamanioY() {
		
		return this.tamanioY;
	}

	public Posicionable obtenerPosicionable(Posicion posicion) {

		return obtenerCelda(posicion).obtenerPosicionable();
	}

	public Collection<Posicionable> obtenerPosicionables(Collection<Posicion> posiciones) {
		
		Collection<Posicionable> posicionables = new ArrayList<Posicionable>();
		for(Posicion posicion : posiciones) {
			Celda celda = obtenerCelda(posicion);
			if(!posicionables.contains(celda.obtenerPosicionable())) {
				posicionables.add(celda.obtenerPosicionable());
			}
		}
		return posicionables;
	}
}
