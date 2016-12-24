package dad.AsistenteAlumnos;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class ResumenView extends AnchorPane {
	private Button siguienteBtn,atrasBtn;
	private TextArea resumenArea;
	
	public ResumenView() {
		resumenArea = new TextArea();
		resumenArea.setPadding(new Insets(5));
		siguienteBtn = new Button("Finalizar");
		siguienteBtn.setStyle("-fx-background-color: #58ACFA");
		atrasBtn = new Button("Atras");
	        
		TitledPane tp = new TitledPane("Resumen",resumenArea);
		tp.setCollapsible(false);
		tp.setPadding(new Insets(5));
		
		HBox botones = new HBox(5,atrasBtn,siguienteBtn);
		
		getChildren().addAll(tp,botones);
		setBottomAnchor(botones, 5.0);
		setRightAnchor(botones, 5.0);
		setTopAnchor(tp, 0.0); 
		setRightAnchor(tp, 0.0); 
		setLeftAnchor(tp, 0.0); 
		setBottomAnchor(tp,35.0); 
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

	public TextArea getResumenArea() {
		return resumenArea;
	}

	public void setResumenArea(TextArea resumenArea) {
		this.resumenArea = resumenArea;
	}
	
}
