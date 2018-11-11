package fiuba.algo3.tp2.mapa;

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

	private void verificarCelda(Posicion coordenada) throws CeldaInexistenteException {
		if(coordenada.getX() < 0 || coordenada.getX() >= tamanioX
		   || coordenada.getY() < 0 || coordenada.getY() >= tamanioY) {
			throw new CeldaInexistenteException();
		}
	}

	private Celda obtenerCelda(Posicion coordenada) {
		return celdas[coordenada.getX()][coordenada.getY()];
	}

	public void desplazar(Posicion coordenadaOrigen, Posicion coordenadaDestino) throws CeldaOcupadaException {
		
		Celda origen = celdas[coordenadaOrigen.getX()][coordenadaOrigen.getY()];
		Celda destino = celdas[coordenadaDestino.getX()][coordenadaDestino.getY()];
		
		destino.ocupar(origen);
		origen.liberar();
	}
}
