package fiuba.algo3.tp2.vista.musica;

import java.io.File;

import javafx.scene.control.MenuItem;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Musica {
	MediaPlayer mediaPlayer;
	Media cancion;
	
	public Musica(String cancionInicioJuego) {
		String cancionInicioJuego1 = "src/fiuba/algo3/tp2/vista/musica/musicaJuego.mp3";
		this.cancion = new Media(new File(cancionInicioJuego1).toURI().toString());
		this.mediaPlayer = new MediaPlayer(cancion);
	}
	
	public MediaPlayer iniciarReproduccionMusica() {
        mediaPlayer.play();
        return mediaPlayer;
	}
	
	public void detenerReproduccionMusica() {
		mediaPlayer.stop();
	}

	public void cambiarEstado(MenuItem menuMute) {
		
		if(this.mediaPlayer.isMute()) {
			
			this.mediaPlayer.setMute(false);
			menuMute.setText("Apagar");
		}
		else {
			
			this.mediaPlayer.setMute(true);
			menuMute.setText("Encender");
		}
	}
}
