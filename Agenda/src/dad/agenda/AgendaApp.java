package dad.agenda;

import java.time.LocalDate;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AgendaApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Contacto c1 = new Contacto();
		c1.setNombre("Perico");
		c1.setFechaNacimiento(LocalDate.of(1960, 6, 26));
		c1.setMovil("665606177");
		c1.setFijo("92222222");
		
		Contacto c2 = new Contacto();
		c2.setNombre("Juancho");
		c2.setFechaNacimiento(LocalDate.of(1970, 9, 16));
		c2.setMovil("635996147");
		c2.setFijo("93333333");
		
		Agenda agenda = new Agenda();
		agenda.getContactos().addAll(c1,c2);
		
		TableView<Contacto> contactosTable = new TableView<>();
		contactosTable.setTableMenuButtonVisible(true);
		contactosTable.setEditable(true);
		
		TableColumn<Contacto, String> nombreColumn = new TableColumn<>("Nombre");
		nombreColumn.setEditable(true);
		nombreColumn.setCellValueFactory(value -> value.getValue().nombreProperty());
		nombreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		//nombreColumn.setCellFactory(ComboBoxTableCell.forTableColumn("A","B","C"));
		
		TableColumn<Contacto, LocalDate> fechaNacimientoColum = new TableColumn<>("Fecha");
		fechaNacimientoColum.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
		
		TableColumn<Contacto, String> movilColum = new TableColumn<>("Movil");
		movilColum.setCellValueFactory(new PropertyValueFactory<>("movil"));
		TableColumn<Contacto, String> fijoColum = new TableColumn<>("Fijo");
		fijoColum.setCellValueFactory(new PropertyValueFactory<>("fijo"));
		//fijoColum.setCellValueFactory(value -> value.getValue().fijoProperty()); --> esta es mejor

		contactosTable.getColumns().add(nombreColumn);
		contactosTable.getColumns().add(fechaNacimientoColum);
		contactosTable.getColumns().add(movilColum);
		contactosTable.getColumns().add(fijoColum);
		contactosTable.itemsProperty().bind(agenda.contactosProperty());
		
		ListView<Contacto> contactoList = new ListView<Contacto>();
		contactoList.itemsProperty().bind(agenda.contactosProperty());
		
		SplitPane root = new SplitPane();
		root.setOrientation(Orientation.VERTICAL);
		root.setDividerPositions(0.5);
		//root.setDividerPositions(0.25, 0.8);
		root.getItems().addAll(contactosTable, contactoList);
		
		primaryStage.setScene(new Scene(root,640,480));
		primaryStage.setTitle("Contactos");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
