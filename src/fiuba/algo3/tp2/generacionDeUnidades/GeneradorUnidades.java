package fiuba.algo3.tp2.generacionDeUnidades;

public interface GeneradorUnidades {
	
	public void crear(Generable generable) throws YaSeGeneraronUnidadesEnEsteTurnoException;
}
