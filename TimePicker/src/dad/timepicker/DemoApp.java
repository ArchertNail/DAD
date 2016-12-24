package dad.timepicker;

import java.time.LocalTime;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		TimePicker tp = new TimePicker();
		
		Button ponerTiempo = new Button("Poner tiempo");
		ponerTiempo.setOnAction(e -> tp.setTiempo(LocalTime.of(12, 23)));

		Button ponerHora = new Button("Poner hora");
		ponerHora.setOnAction(e -> tp.setHora(13));

		Button consultarHora = new Button("Consultar tiempo");
		consultarHora.setOnAction(e -> { 
			System.out.print(tp.getTiempo());
			System.out.print(" / " + tp.getHora());
			System.out.print(":" + tp.getMinutos());
			System.out.println(":" + tp.getSegundos());
		});
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(tp, ponerTiempo, ponerHora, consultarHora);
		
		primaryStage.setTitle("TimePicker Demo");
		primaryStage.setScene(new Scene(root, 320, 200));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
