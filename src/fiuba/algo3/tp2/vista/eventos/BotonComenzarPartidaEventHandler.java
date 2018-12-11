package fiuba.algo3.tp2.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonComenzarPartidaEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;

    public BotonComenzarPartidaEventHandler(Stage stage, Scene proximaEscena) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
    
}
