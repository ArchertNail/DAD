package dad.sub.scenes;

import java.util.ArrayList;

import dad.micv.modelo.Nivel;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class IdiomaScene extends GridPane{
	private TextField certificacionText, denominacionText;
	private Button anadirBtn, cerrarBtn;
	
	private ComboBox<Nivel> nivelCombo;
	
	public IdiomaScene(){
		certificacionText = new TextField();
		denominacionText = new TextField();
		nivelCombo = new ComboBox<>();
		nivelCombo.setValue(Nivel.BASICO);
		nivelCombo.getItems().addAll(Nivel.values());
		anadirBtn = new Button("Añadir");
		cerrarBtn = new Button("Cerrar");
		
		HBox botones = new HBox(5,anadirBtn,cerrarBtn);
		
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		addRow(0, new Label("Certificación:"), certificacionText);
		addRow(1, new Label("Idioma:"), denominacionText);
		addRow(2, new Label("Nivel:"), nivelCombo);
		addRow(3, botones);
	}

	public TextField getCertificacionText() {
		return certificacionText;
	}

	public void setCertificacionText(TextField certificacionText) {
		this.certificacionText = certificacionText;
	}

	public TextField getDenominacionText() {
		return denominacionText;
	}

	public void setDenominacionText(TextField denominacionText) {
		this.denominacionText = denominacionText;
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

	public ComboBox<Nivel> getNivelCombo() {
		return nivelCombo;
	}

	public void setNivelCombo(ComboBox<Nivel> nivelCombo) {
		this.nivelCombo = nivelCombo;
	}
	
	
}
