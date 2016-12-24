package dad.micv.modelo;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class cvApp extends Application {

	private mainController mainControl;
	private ObjectProperty<CV> cv;
	private Stage primaryStage2;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage2 = primaryStage;
		
		cv = new SimpleObjectProperty<>(this, "cv", new CV());
		cv.addListener((observable, viejoGrupo, nuevoGrupo) -> onNuevoCV(viejoGrupo, nuevoGrupo));
		
		mainControl = new mainController();
		mainControl.bind(cv);
		mainControl.setApp(this);
		Scene scene = new Scene(mainControl.getRoot(),640,420);
		primaryStage.setTitle("Curriculum");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void onNuevoCV(CV viejo, CV nuevo) {
		mainControl.unbind(viejo);
		mainControl.bind(cv);
	}

	public static void main(String[] args) {
		launch(args);
	}

	public Stage getPrimaryStage2() {
		return primaryStage2;
	}

	public void setPrimaryStage2(Stage primaryStage2) {
		this.primaryStage2 = primaryStage2;
	}
	
	

}
