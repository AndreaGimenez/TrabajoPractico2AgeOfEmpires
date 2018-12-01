package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;
import javafx.scene.layout.Pane;

public class VistaPosicionable {

	private VistaAldeano vistaAldeano;
	private VistaEspadachin vistaEspadachin;
	private VistaArquero vistaArquero;
	private VistaArmaAsedio vistaArmaAsedio;
	private VistaCuartel vistaCuartel;
	private VistaPlazaCentral vistaPlazaCentral;
	private VistaCastillo vistaCastillo;
	
	
	public VistaPosicionable() {
		
		super();
		this.vistaAldeano = new VistaAldeano();
		this.vistaEspadachin = new VistaEspadachin();
		this.vistaArquero = new VistaArquero();
		this.vistaArmaAsedio = new VistaArmaAsedio();
		this.vistaCuartel = new VistaCuartel();
		this.vistaPlazaCentral = new VistaPlazaCentral();
		this.vistaCastillo = new VistaCastillo();
	}

	public void dibujarPosicionable(Posicionable posicionable, Pane pane) {
		
		if(posicionable != null) {
			
    		if(posicionable instanceof Aldeano) {
    			
    			vistaAldeano.dibujar((Aldeano)posicionable, pane);
    	        
    		} else if(posicionable instanceof Espadachin) {
    			
    			vistaEspadachin.dibujar((Espadachin)posicionable, pane);
    			
    		} else if(posicionable instanceof Arquero) {
    			
    			vistaArquero.dibujar((Arquero)posicionable, pane);
    			
    		} else if(posicionable instanceof ArmaAsedio) {
    			
    			vistaArmaAsedio.dibujar((ArmaAsedio)posicionable, pane);
    			
    		} else if(posicionable instanceof Cuartel) {
    			
    			vistaCuartel.dibujar((Cuartel)posicionable, pane);
    			
    		} else if(posicionable instanceof PlazaCentral) {
    			
    			vistaPlazaCentral.dibujar((PlazaCentral)posicionable, pane);
    			
    		} else if(posicionable instanceof Castillo) {
    			
    			vistaCastillo.dibujar((Castillo)posicionable, pane);
    			
    		}
		}
	}
}
