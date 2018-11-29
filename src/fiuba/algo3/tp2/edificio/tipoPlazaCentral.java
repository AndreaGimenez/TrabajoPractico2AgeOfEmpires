package fiuba.algo3.tp2.edificio;



public class tipoPlazaCentral extends TipoDeEdificio{
	
	private static final String TIPO = "PlazaCentral";

	private String tipo;
	 
	 public tipoPlazaCentral() {
		 
		 this.setTipo(TIPO); 
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	} 

}
