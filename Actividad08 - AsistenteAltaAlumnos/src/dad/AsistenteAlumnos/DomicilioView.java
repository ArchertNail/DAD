package dad.AsistenteAlumnos;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;

public class DomicilioView extends BorderPane {
	
	private TextField codPostalText, ciudadText;
	private Button siguienteBtn,atrasBtn;
	private TextArea direccionArea;
	
	public DomicilioView() {
		direccionArea = new TextArea();
		direccionArea.setMaxHeight(70);
		codPostalText = new TextField("0");
		ciudadText = new TextField();
		siguienteBtn = new Button("Siguiente");
		siguienteBtn.setStyle("-fx-background-color: #58ACFA");
		atrasBtn = new Button("Atras");
		
		GridPane domicilioGridPane = new GridPane();
		domicilioGridPane.setPadding(new Insets(5));
		domicilioGridPane.setHgap(5);
		domicilioGridPane.setVgap(5);
		domicilioGridPane.addRow(0, new Label("Direccion:"), direccionArea);
		domicilioGridPane.addRow(1, new Label("Código Postal:"), codPostalText);
		domicilioGridPane.addRow(2, new Label("Ciudad:"), ciudadText);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setHalignment(HPos.RIGHT);
		col1.setPercentWidth(15);
		col1.setHgrow(Priority.NEVER);
		
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setHgrow(Priority.ALWAYS);
		col2.setPercentWidth(85);
		domicilioGridPane.getColumnConstraints().setAll(col1,col2);
		
		Line linea002 = new Line(0,0,0,0);
        linea002.setStroke(Color.STEELBLUE);
        linea002.setStrokeWidth(1);
        linea002.setStrokeLineCap(StrokeLineCap.ROUND);
        
        HBox botones = new HBox(5,atrasBtn,siguienteBtn);
        
		AnchorPane nextPrevius = new AnchorPane(botones,linea002);
		AnchorPane.setBottomAnchor(botones, 5.0);
		AnchorPane.setRightAnchor(botones, 5.0);
		AnchorPane.setTopAnchor(linea002, 0.0);  	
	        
		TitledPane tp = new TitledPane("Domicilio",domicilioGridPane);
		tp.setCollapsible(false);
		tp.setPadding(new Insets(5));
		setTop(tp);
		setBottom(nextPrevius);
		
	}

	public TextField getCodPostalText() {
		return codPostalText;
	}

	public void setCodPostalText(TextField codPostalText) {
		this.codPostalText = codPostalText;
	}

	public TextField getCiudadText() {
		return ciudadText;
	}

	public void setCiudadText(TextField ciudadText) {
		this.ciudadText = ciudadText;
	}

	public Button getSiguienteBtn() {
		return siguienteBtn;
	}

	public void setSiguienteBtn(Button siguienteBtn) {
		this.siguienteBtn = siguienteBtn;
	}

	public Button getAtrasBtn() {
		return atrasBtn;
	}

	public void setAtrasBtn(Button atrasBtn) {
		this.atrasBtn = atrasBtn;
	}

	public TextArea getDireccionArea() {
		return direccionArea;
	}

	public void setDireccionArea(TextArea direccionArea) {
		this.direccionArea = direccionArea;
	}
	
	
}
