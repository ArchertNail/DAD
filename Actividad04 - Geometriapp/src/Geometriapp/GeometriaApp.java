package Geometriapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class GeometriaApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Tab rectanguloTab = new Tab("Rectangulo");
		rectanguloTab.setClosable(false);
		rectanguloTab.setContent(new RectanguloPanel());
		
		
		Tab trianguloTab = new Tab("triangulo");
		trianguloTab.setClosable(false);
		trianguloTab.setContent(new TrianguloPanel());
		
		Tab circuloTab = new Tab("circulo");
		circuloTab.setClosable(false);
		circuloTab.setContent(new CirculoPanel());
		
		TabPane root = new TabPane();
		root.getTabs().addAll(rectanguloTab,trianguloTab,circuloTab);
		
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
