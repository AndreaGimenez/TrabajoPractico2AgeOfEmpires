package fiuba.algo3.tp2.vista;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class ColorTransition extends Transition {
	
	private Shape nodoShape;
	private Color color;
	
	public ColorTransition(Color color, Shape nodoShape) {
		
		this.nodoShape = nodoShape;
		this.color = color;
		
		setCycleDuration(Duration.millis(750));
        setInterpolator(Interpolator.EASE_OUT);
	}
	
	
	@Override
	protected void interpolate(double frac) {
		
		double valorInicialOpacity = 0;
    	double valorActualOpacity = 0;
    	
    	if(frac <= 0.5) {
    		valorActualOpacity = valorInicialOpacity + (frac * 2);
    	}else {
    		valorActualOpacity = 1 - (frac - 0.5) * 2;
    	}
    	
    	Color vColor = this.color.deriveColor(0, 1, 1, valorActualOpacity);
        //Color vColor = new Color(1, 0, 0, valorActualOpacity);
        nodoShape.setFill(vColor);
	}
	
}
