package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.vista.Musica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class OpcionMuteEventHandler implements EventHandler<ActionEvent>{
	
	private Musica musica;
	private MenuItem menuMute;

	public OpcionMuteEventHandler(Musica musica, MenuItem menuMute) {
		
		this.musica = musica;
		this.menuMute = menuMute;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		
		this.musica.cambiarEstado(menuMute);
	}

}
