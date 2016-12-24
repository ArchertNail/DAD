package dad.gesaula.ui.alumnos;

import java.time.LocalDate;

import dad.gesaula.ui.alumnos.edit.AlumnoEditController;
import dad.gesaula.ui.model.Alumno;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class AlumnosView extends SplitPane {
	
	private TableView<Alumno> alumnosTable;
	private TitledPane fichaPane;
	private Button nuevoButton;
	private Button eliminarButton;
	private HBox infoPane;
	private AlumnoEditController editController;
	
	public AlumnosView() {
		super();
		
		TableColumn<Alumno, String> nombreColumn = new TableColumn<>("Nombre");
		nombreColumn.setCellValueFactory(data -> data.getValue().nombreProperty());

		TableColumn<Alumno, String> apellidosColumn = new TableColumn<>("Apellidos");
		apellidosColumn.setCellValueFactory(data -> data.getValue().apellidosProperty());

		TableColumn<Alumno, LocalDate> fechaNacimientoColumn = new TableColumn<>("Fecha de nacimiento");
		fechaNacimientoColumn.setCellValueFactory(data -> data.getValue().fechaNacimientoProperty());
		
		alumnosTable = new TableView<>();
		alumnosTable.getColumns().add(nombreColumn);
		alumnosTable.getColumns().add(apellidosColumn);
		alumnosTable.getColumns().add(fechaNacimientoColumn);
		
		nuevoButton = new Button("Nuevo");
		nuevoButton.setGraphic(new ImageView(getClass().getResource("../resources/add-32x32.png").toExternalForm()));

		eliminarButton = new Button("Eliminar");
		eliminarButton.setGraphic(new ImageView(getClass().getResource("../resources/del-32x32.png").toExternalForm()));

		HBox botonesPane = new HBox(5);
		botonesPane.setPadding(new Insets(5, 0, 0, 0));
		botonesPane.setAlignment(Pos.BASELINE_RIGHT);
		botonesPane.getChildren().addAll(nuevoButton, eliminarButton);
		
		BorderPane izquierdaPane = new BorderPane();
		izquierdaPane.setPadding(new Insets(5));
		izquierdaPane.setCenter(alumnosTable);
		izquierdaPane.setBottom(botonesPane);
		
		fichaPane = new TitledPane();
		fichaPane.setFocusTraversable(false);
		fichaPane.setCollapsible(false);
		fichaPane.setText("Alumno");
		AnchorPane.setBottomAnchor(fichaPane, 5.0);
		AnchorPane.setTopAnchor(fichaPane, 5.0);
		AnchorPane.setLeftAnchor(fichaPane, 5.0);
		AnchorPane.setRightAnchor(fichaPane, 5.0);
		
		AnchorPane derechaPane = new AnchorPane();
		derechaPane.getChildren().add(fichaPane);
				
		infoPane = new HBox(new Label("No hay ningún alumno seleccionado."));
		infoPane.setAlignment(Pos.CENTER);

		editController = new AlumnoEditController();
		
		setDividerPositions(0.5);
		getItems().addAll(izquierdaPane, derechaPane);

		showInfoPane();
	}
	
	public void showInfoPane() {
		fichaPane.setContent(infoPane);		
	}
	
	public void showEditPane() {
		fichaPane.setContent(editController.getView());				
	}

	public TableView<Alumno> getAlumnosTable() {
		return alumnosTable;
	}

	public Button getNuevoButton() {
		return nuevoButton;
	}

	public Button getEliminarButton() {
		return eliminarButton;
	}
	
	public AlumnoEditController getEditPane() {
		return editController;
	}

}
