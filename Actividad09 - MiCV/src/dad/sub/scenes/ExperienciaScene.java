package dad.sub.scenes;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ExperienciaScene extends GridPane{

	private DatePicker desdeDate,hastaDate;
	private TextField denominacionText,empleadorText;
	private Button anadirBtn, cerrarBtn;
	
	public ExperienciaScene(){
		desdeDate = new DatePicker();
		hastaDate = new DatePicker();
		denominacionText  = new TextField();
		empleadorText = new TextField();
		anadirBtn = new Button("A�adir");
		cerrarBtn = new Button("Cerrar");
		
		HBox botones= new HBox(5,anadirBtn,cerrarBtn);
		
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		addRow(0, new Label("Desde:"), desdeDate);
		addRow(1, new Label("Hasta:"), hastaDate);
		addRow(2, new Label("Denominaci�n:"), denominacionText);
		addRow(3, new Label("Empleador:"), empleadorText);
		addRow(4, botones);
	}

	public DatePicker getDesdeDate() {
		return desdeDate;
	}

	public void setDesdeDate(DatePicker desdeDate) {
		this.desdeDate = desdeDate;
	}

	public DatePicker getHastaDate() {
		return hastaDate;
	}

	public void setHastaDate(DatePicker hastaDate) {
		this.hastaDate = hastaDate;
	}

	public TextField getDenominacionText() {
		return denominacionText;
	}

	public void setDenominacionText(TextField denominacionText) {
		this.denominacionText = denominacionText;
	}

	public TextField getEmpleadorText() {
		return empleadorText;
	}

	public void setEmpleadorText(TextField empleadorText) {
		this.empleadorText = empleadorText;
	}

	public Button getAnadirBtn() {
		return anadirBtn;
	}

	public void setAnadirBtn(Button anadirBtn) {
		this.anadirBtn = anadirBtn;
	}

	public Button getCerrarBtn() {
		return cerrarBtn;
	}

	public void setCerrarBtn(Button cerrarBtn) {
		this.cerrarBtn = cerrarBtn;
	}
	
	
}
