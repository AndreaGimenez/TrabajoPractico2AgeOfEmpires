package fiuba.algo3.tp2.mapa;

import java.util.Iterator;
import java.util.LinkedList;

public class PosicionesInicialesAldeanos extends LinkedList{

	private static final Posicion POSICION_INICIAL_1 = new Posicion(6, 4);
	private static final Posicion POSICION_INICIAL_2 = new Posicion(6, 6);
	private static final Posicion POSICION_INICIAL_3 = new Posicion(4, 6);
	
	private Mapa mapa;
	private LinkedList<Posicion> posiciones;

	public PosicionesInicialesAldeanos(Mapa mapa) {

		this.mapa = mapa;
		this.posiciones = iniciarPosiciones();
	}

	private LinkedList<Posicion> iniciarPosiciones() {
		
		LinkedList<Posicion> posiciones = new LinkedList<>();
		
		posiciones.add(POSICION_INICIAL_1);
		posiciones.add(POSICION_INICIAL_2);
		posiciones.add(POSICION_INICIAL_3);
		posiciones.add(new Posicion(this.mapa.getTamanioX()-4, this.mapa.getTamanioY()-6));
		posiciones.add(new Posicion(this.mapa.getTamanioX()-6, this.mapa.getTamanioY()-6));
		posiciones.add(new Posicion(this.mapa.getTamanioX()-6, this.mapa.getTamanioY()-4));
		
		return posiciones;
	}

	public Posicion buscarPosicion() {
		
		Iterator<Posicion> iterador = posiciones.iterator();
		Posicion posicion = null;
		
		while (iterador.hasNext() && posicion==null) {
			
			Posicion posicionAEvaluar = iterador.next();
			Celda celda = this.mapa.obtenerCelda(posicionAEvaluar);
			
			if(!celda.estaOcupada()) {
				posicion = posicionAEvaluar;
			}
		}
		
		return posicion;
	}
	
	
}