package dad.AsistenteAlumnos;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;

public class ContactoView extends BorderPane {
	private TextField movilText, fijoText, emailText;
	private Button siguienteBtn,atrasBtn;
	
	public ContactoView() {
		movilText = new TextField();
		movilText.setMaxWidth(100);
		fijoText = new TextField();
		fijoText.setMaxWidth(100);
		emailText = new TextField();
		siguienteBtn = new Button("Siguiente");
		siguienteBtn.setStyle("-fx-background-color: #58ACFA");
		atrasBtn = new Button("Atras");
		
		GridPane contactoGridPane = new GridPane();
		//contactoGridPane.setAlignment(Pos.CENTER);
		contactoGridPane.setPadding(new Insets(5,5,5,85));
		contactoGridPane.setHgap(5);
		contactoGridPane.setVgap(5);
		contactoGridPane.addRow(0, new Label("Móvil:"), movilText);
		contactoGridPane.addRow(1, new Label("Fijo:"), fijoText);
		contactoGridPane.addRow(2, new Label("E-mail:"), emailText);
		/*ColumnConstraints col1 = new ColumnConstraints();
		col1.setHalignment(HPos.RIGHT);
		col1.setHgrow(Priority.NEVER);
		
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setHgrow(Priority.ALWAYS);
		
		contactoGridPane.getColumnConstraints().setAll(col1,col2);*/
		
		Line linea002 = new Line(0,0,0,0);
        linea002.setStroke(Color.STEELBLUE);
        linea002.setStrokeWidth(1);
        linea002.setStrokeLineCap(StrokeLineCap.ROUND);
        
        HBox botones = new HBox(5,atrasBtn,siguienteBtn);
        
		AnchorPane nextPrevius = new AnchorPane(botones,linea002);
		AnchorPane.setBottomAnchor(botones, 5.0);
		AnchorPane.setRightAnchor(botones, 5.0);
		AnchorPane.setTopAnchor(linea002, 0.0);  	
	        
		TitledPane tp = new TitledPane("Contacto",contactoGridPane);
		tp.setCollapsible(false);
		tp.setPadding(new Insets(5));
		setTop(tp);
		setBottom(nextPrevius);
		
	}

	public TextField getMovilText() {
		return movilText;
	}

	public void setMovilText(TextField movilText) {
		this.movilText = movilText;
	}

	public TextField getFijoText() {
		return fijoText;
	}

	public void setFijoText(TextField fijoText) {
		this.fijoText = fijoText;
	}

	public TextField getEmailText() {
		return emailText;
	}

	public void setEmailText(TextField emailText) {
		this.emailText = emailText;
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
	
}
