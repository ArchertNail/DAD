package dad.BuscaryReemplazar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarReemplazarAPP extends Application {
	
	//private BuscarReemplazarController brController;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BuscarReemplazarController brControl = new BuscarReemplazarController();
		
		Scene scene = new Scene(brControl.getRoot(), 640,480);
		primaryStage.setTitle("Buscar y Remplazar");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
