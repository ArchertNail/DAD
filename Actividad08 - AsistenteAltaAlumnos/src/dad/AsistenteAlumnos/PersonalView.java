package dad.AsistenteAlumnos;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;

public class PersonalView extends BorderPane {
	TextField nombreText,primerApellidoText,segundoApellidoText;
	DatePicker fechaDatePicker;
	Label edad;
	Button siguienteBtn;
	public PersonalView(){
		
		nombreText= new TextField();
		primerApellidoText = new TextField();
		segundoApellidoText = new TextField();
		fechaDatePicker = new DatePicker();
		edad = new Label("0 años");
		edad.setAlignment(Pos.BASELINE_LEFT);
		siguienteBtn = new Button("Siguiente");
		siguienteBtn.setStyle("-fx-background-color: #58ACFA");
		siguienteBtn.setAlignment(Pos.BASELINE_RIGHT);
		
		GridPane personalGridPane = new GridPane();
		personalGridPane.setPadding(new Insets(5));
		personalGridPane.setHgap(5);
		personalGridPane.setVgap(5);
		personalGridPane.addRow(0, new Label("Nombre"), nombreText);
		personalGridPane.addRow(1, new Label("Primer Apellido"), primerApellidoText);
		personalGridPane.addRow(2, new Label("Segundo Apellido"), segundoApellidoText);
		personalGridPane.addRow(3, new Label("Fecha de nacimiento"), fechaDatePicker,edad);
		
		GridPane.setColumnSpan(nombreText,3);
		GridPane.setColumnSpan(primerApellidoText,3);
		GridPane.setColumnSpan(segundoApellidoText,3);
		//GridPane.setColumnSpan(edad,1);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setHalignment(HPos.RIGHT);
		col1.setHgrow(Priority.NEVER);
		
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setHgrow(Priority.NEVER);
		
		ColumnConstraints col4 = new ColumnConstraints();
		col4.setHgrow(Priority.ALWAYS);
		
		personalGridPane.getColumnConstraints().setAll(col1,col2,col2, col4);
		
		Line linea001 = new Line(0,0,0,0);
        linea001.setStroke(Color.STEELBLUE);
        linea001.setStrokeWidth(1);
        linea001.setStrokeLineCap(StrokeLineCap.ROUND);
		
		AnchorPane nextPrevius = new AnchorPane(siguienteBtn,linea001);
		AnchorPane.setBottomAnchor(siguienteBtn, 5.0);
		AnchorPane.setRightAnchor(siguienteBtn, 5.0);
		AnchorPane.setTopAnchor(linea001, 0.0);  	
	        
		TitledPane tp = new TitledPane("Personal",personalGridPane);
		tp.setCollapsible(false);
		tp.setPadding(new Insets(5));
		setTop(tp);
		setBottom(nextPrevius);
	}
	
	
	public TextField getNombreText() {
		return nombreText;
	}
	public void setNombreText(TextField nombreText) {
		this.nombreText = nombreText;
	}
	public TextField getPrimerApellidoText() {
		return primerApellidoText;
	}
	public void setPrimerApellidoText(TextField primerApellidoText) {
		this.primerApellidoText = primerApellidoText;
	}
	public TextField getSegundoApellidoText() {
		return segundoApellidoText;
	}
	public void setSegundoApellidoText(TextField segundoApellidoText) {
		this.segundoApellidoText = segundoApellidoText;
	}
	public DatePicker getFechaDatePicker() {
		return fechaDatePicker;
	}
	public void setFechaDatePicker(DatePicker fechaDatePicker) {
		this.fechaDatePicker = fechaDatePicker;
	}
	public Label getEdad() {
		return edad;
	}
	public void setEdad(Label edad) {
		this.edad = edad;
	}
	public Button getSiguienteBtn() {
		return siguienteBtn;
	}
	public void setSiguienteBtn(Button siguienteBtn) {
		this.siguienteBtn = siguienteBtn;
	}
	
	
}
