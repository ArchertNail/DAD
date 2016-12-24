package dad.gesaula.ui.alumnos.edit;

import dad.gesaula.ui.model.Sexo;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class AlumnoEditView extends BorderPane {

	private TextField nombreText;
	private TextField apellidosText;
	private DatePicker fechaNacimientoDatePicker;
	private CheckBox repiteCheck;
	private ComboBox<Sexo> sexoCombo;

	public AlumnoEditView() {
		super();
		
		nombreText = new TextField();
		GridPane.setHgrow(nombreText, Priority.ALWAYS);
		
		apellidosText = new TextField();
		
		fechaNacimientoDatePicker = new DatePicker();
		
		sexoCombo = new ComboBox<Sexo>();
		
		repiteCheck = new CheckBox(); 

		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.addRow(0, new Label("Nombre"), nombreText);
		gridPane.addRow(1, new Label("Apellidos"), apellidosText);
		gridPane.addRow(2, new Label("Fecha de nacimiento"), fechaNacimientoDatePicker);
		gridPane.addRow(3, new Label("Sexo"), sexoCombo);
		gridPane.addRow(4, new Label("¿Repite?"), repiteCheck);
		
		setTop(gridPane);
		setPadding(new Insets(5));
	}

	public TextField getNombreText() {
		return nombreText;
	}

	public TextField getApellidosText() {
		return apellidosText;
	}

	public DatePicker getFechaNacimientoDatePicker() {
		return fechaNacimientoDatePicker;
	}

	public CheckBox getRepiteCheck() {
		return repiteCheck;
	}

	public ComboBox<Sexo> getSexoCombo() {
		return sexoCombo;
	}

}
