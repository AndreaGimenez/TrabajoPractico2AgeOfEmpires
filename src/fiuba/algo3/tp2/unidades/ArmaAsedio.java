package fiuba.algo3.tp2.unidades;

import fiuba.algo3.tp2.edificios.Cuartel;

public class ArmaAsedio {

	public void atacar(Aldeano aldeano) throws Exception {
		throw new Exception("No se puede atacar un aldeano");
	}

	public void atacar(Cuartel cuartel) {
		
		cuartel.reducirVida(75);
	}
}
