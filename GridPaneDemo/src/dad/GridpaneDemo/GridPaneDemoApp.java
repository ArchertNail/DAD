package dad.GridpaneDemo;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class GridPaneDemoApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		TextField nombreText = new TextField();
		TextField apellidosText = new TextField();
		TextField dniText = new TextField();
		dniText.setPrefColumnCount(8);
		DatePicker fechaNacDatePicker = new DatePicker();
		Label edadLabel = new Label("0 años");
		TextField iban[] = new TextField[6];
		for(int i=0; i<iban.length; i++){
			iban[i] = new TextField();
			iban[i].setPrefColumnCount(4);
		}
		ToggleGroup sexoGroup = new ToggleGroup();
		RadioButton hombreRadio = new RadioButton("Hombre");
		hombreRadio.setToggleGroup(sexoGroup);
		hombreRadio.setSelected(true);
		RadioButton mujerRadio = new RadioButton("Mujer");
		mujerRadio.setToggleGroup(sexoGroup);
		
		GridPane formPane = new GridPane();
		formPane.setPadding(new Insets(5));
		//formPane.setGridLinesVisible(true);
		formPane.setHgap(5);
		formPane.setVgap(5);
		formPane.addRow(0, new Label("Nombre"), nombreText);
		formPane.addRow(1, new Label("Apellidos"), apellidosText);
		formPane.addRow(2, new Label("DNI"), dniText);
		formPane.addRow(3, new Label("Fecha Nacimiento"), fechaNacDatePicker, edadLabel);
		formPane.addRow(4, new Label("IBAN"), new HBox(5, iban));
		formPane.addRow(5, new Label("Sexo"), new HBox(5, hombreRadio, mujerRadio));
		
		GridPane.setColumnSpan(nombreText, 2);
		GridPane.setColumnSpan(apellidosText, 2);
		//GridPane.setColumnSpan(dniText, 2);
		GridPane.setFillWidth(dniText, false);
		
		
		formPane.setAlignment(Pos.TOP_CENTER);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setHalignment(HPos.CENTER);
		col1.setHgrow(Priority.NEVER);
		
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setHgrow(Priority.ALWAYS);
		
		ColumnConstraints col3 = new ColumnConstraints();
		
		
		formPane.getColumnConstraints().setAll(col1,col2,col3);
		
		AnchorPane root = new AnchorPane(formPane);
		AnchorPane.setLeftAnchor(formPane, 0.0);
		AnchorPane.setRightAnchor(formPane, 0.0);
		AnchorPane.setTopAnchor(formPane, 0.0);
		primaryStage.setTitle("GridPane Demo");
		primaryStage.setScene(new Scene(root,640,480));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
