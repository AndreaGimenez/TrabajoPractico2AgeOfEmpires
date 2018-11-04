package fiuba.algo3.tp2.edificios;

public class Cuartel {

	private static final Integer VIDA_CUARTEL_INICIAL = 250;
	
	private Integer vida;
	
	
	public Cuartel() {
		vida = VIDA_CUARTEL_INICIAL;
	}
	
	public Integer obtenerVida() {
		return vida;
	}

	public void reducirVida(Integer vidaAReducir) {
		vida -= vidaAReducir;
	}
}
