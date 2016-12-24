package dad.AnchoPaneDemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AnchorPaneDemoApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Pane pane1 = new Pane();
		pane1.setStyle("-fx-background-color: red");
		pane1.setPrefSize(150, 100);
		
		Pane pane2 = new Pane();
		pane2.setStyle("-fx-background-color: green");
		pane2.setPrefSize(150, 100);
		
		AnchorPane root = new AnchorPane(pane1,pane2);
		AnchorPane.setTopAnchor(pane2, 0.0);
		AnchorPane.setBottomAnchor(pane1, 0.0);
		AnchorPane.setRightAnchor(pane2, 0.0);
		AnchorPane.setRightAnchor(pane1, 0.0);
		
		primaryStage.setTitle("AnchorPane Demo");
		primaryStage.setScene(new Scene(root, 320, 200));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
