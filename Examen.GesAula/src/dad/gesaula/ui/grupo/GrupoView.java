package dad.gesaula.ui.grupo;

import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class GrupoView extends BorderPane {

	private TextField denominacionText;
	private DatePicker inicioCursoDatePicker;
	private DatePicker finCursoDatePicker;
	private Slider examenesSlider;
	private Slider practicasSlider;
	private Slider actitudSlider;

	public GrupoView() {
		super();
		setPadding(new Insets(5));

		denominacionText = new TextField();
		GridPane.setHgrow(denominacionText, Priority.ALWAYS);
		GridPane.setColumnSpan(denominacionText, 2);

		inicioCursoDatePicker = new DatePicker();
		GridPane.setHgrow(inicioCursoDatePicker, Priority.ALWAYS);

		finCursoDatePicker = new DatePicker();

		examenesSlider = new Slider();
		examenesSlider.setMinorTickCount(9);
		examenesSlider.setMajorTickUnit(10);
		examenesSlider.setBlockIncrement(5);
		examenesSlider.setShowTickMarks(true);
		examenesSlider.setSnapToTicks(true);

		practicasSlider = new Slider();
		practicasSlider.setMinorTickCount(9);
		practicasSlider.setMajorTickUnit(10);
		practicasSlider.setBlockIncrement(5);
		practicasSlider.setShowTickMarks(true);
		practicasSlider.setSnapToTicks(true);

		actitudSlider = new Slider();
		actitudSlider.setMinorTickCount(9);
		actitudSlider.setMajorTickUnit(10);
		actitudSlider.setBlockIncrement(5);
		actitudSlider.setShowTickMarks(true);
		actitudSlider.setSnapToTicks(true);

		Label examenesLabel = new Label("0%");
		examenesLabel.textProperty().bind(examenesSlider.valueProperty().asString("%.0f").concat("%"));

		Label practicasLabel = new Label("0%");
		practicasLabel.textProperty().bind(practicasSlider.valueProperty().asString("%.0f").concat("%"));

		Label actitudLabel = new Label("0%");
		actitudLabel.textProperty().bind(actitudSlider.valueProperty().asString("%.0f").concat("%"));

		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.addRow(0, new Label("Denominación"), denominacionText);
		gridPane.addRow(1, new Label("Inicio del curso"), inicioCursoDatePicker);
		gridPane.addRow(2, new Label("Fin del curso"), finCursoDatePicker);
		gridPane.addRow(3, new Label("Exámenes"), examenesSlider, examenesLabel);
		gridPane.addRow(4, new Label("Prácticas"), practicasSlider, practicasLabel);
		gridPane.addRow(5, new Label("Actitud"), actitudSlider, actitudLabel);

		setTop(gridPane);
	}

	public TextField getDenominacionText() {
		return denominacionText;
	}

	public DatePicker getInicioCursoDatePicker() {
		return inicioCursoDatePicker;
	}

	public DatePicker getFinCursoDatePicker() {
		return finCursoDatePicker;
	}

	public Slider getExamenesSlider() {
		return examenesSlider;
	}

	public Slider getPracticasSlider() {
		return practicasSlider;
	}

	public Slider getActitudSlider() {
		return actitudSlider;
	}

}
