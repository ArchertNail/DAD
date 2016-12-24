package dad.recetario;

import dad.recetario.model.Recetario;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RecetarioApp extends Application {

	private MainController main;
	
	private ObjectProperty<Recetario> recetario;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		recetario = new SimpleObjectProperty<>(this, "recetario", new Recetario());
		
		main = new MainController();
		main.bind(recetario.get());
		
		primaryStage.setTitle("Recetario");
		primaryStage.setScene(new Scene(main.getView(),640,420));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
