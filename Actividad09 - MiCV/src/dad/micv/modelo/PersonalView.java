package dad.micv.modelo;


import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PersonalView extends GridPane{
	
	private TextField dniText,nombreText,apellidosText,cpText,localidadText;
	private TextArea direccionArea;
	private ListView<Nacionalidad> nacionalidadList;
	private DatePicker fechaDatePicker;
	private ComboBox<String> paisesCombo;
	private Button masBtn, menosBtn;
	
	public PersonalView(){
		
		dniText = new TextField();
		nombreText = new TextField();
		apellidosText = new TextField();
		cpText = new TextField();
		cpText.setMaxWidth(100);
		localidadText = new TextField();
		direccionArea = new TextArea();
		direccionArea.setPrefRowCount(7);
		nacionalidadList = new ListView<Nacionalidad>();
		fechaDatePicker = new DatePicker();
		paisesCombo = new ComboBox<>();
		
		masBtn = new Button("+");
		masBtn.setMaxWidth(Double.MAX_VALUE);
		menosBtn = new Button("-");
		menosBtn.setMaxWidth(Double.MAX_VALUE);
		VBox botones = new VBox(5,masBtn,menosBtn);
		
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		addRow(0, new Label("DNI/NIE/Pasaporte"), dniText);
		addRow(1, new Label("Nombre"),nombreText);
		addRow(2, new Label("Apellidos"), apellidosText);
		addRow(3, new Label("Fecha de nacimiento"), fechaDatePicker);
		addRow(4, new Label("Dirección"), direccionArea);
		addRow(5, new Label("Código Postal"), cpText);
		addRow(6, new Label("Localidad"), localidadText);
		addRow(7, new Label("País"), paisesCombo);
		addRow(8, new Label("Nacionalidad"), nacionalidadList,botones);
		setColumnSpan(dniText, 2);
		setColumnSpan(nombreText, 2);
		setColumnSpan(apellidosText, 2);
		setColumnSpan(direccionArea, 2);
		setColumnSpan(localidadText, 2);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setHalignment(HPos.RIGHT);
		col1.setHgrow(Priority.NEVER);
		
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setHgrow(Priority.ALWAYS);
		
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setHgrow(Priority.NEVER);
		
		getColumnConstraints().setAll(col1, col2, col3);
	}

	public TextField getDniText() {
		return dniText;
	}

	public TextField getNombreText() {
		return nombreText;
	}

	public TextField getApellidosText() {
		return apellidosText;
	}

	public TextField getCpText() {
		return cpText;
	}

	public TextField getLocalidadText() {
		return localidadText;
	}

	public TextArea getDireccionArea() {
		return direccionArea;
	}

	public ListView<Nacionalidad> getNacionalidadList() {
		return nacionalidadList;
	}

	public DatePicker getFechaDatePicker() {
		return fechaDatePicker;
	}

	public ComboBox<String> getPaisesCombo() {
		return paisesCombo;
	}

	public Button getMasBtn() {
		return masBtn;
	}

	public Button getMenosBtn() {
		return menosBtn;
	}

	public void setPaisesCombo(ComboBox<String> paisesCombo) {
		this.paisesCombo = paisesCombo;
	}
	
	
}
