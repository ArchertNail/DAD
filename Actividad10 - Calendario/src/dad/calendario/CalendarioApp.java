package dad.calendario;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalendarioApp extends Application {

	private CalendarioController calendarioController;
	private Calendario calendario;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		calendario = new Calendario();
		
		calendarioController = new CalendarioController(this);
		calendarioController.bind(calendario);
		
		primaryStage.setTitle("Calendario");
		primaryStage.setScene(new Scene(calendarioController.getView(), 580, 540));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
