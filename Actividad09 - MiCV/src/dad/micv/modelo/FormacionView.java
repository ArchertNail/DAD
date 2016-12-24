package dad.micv.modelo;

import java.time.LocalDate;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class FormacionView extends SplitPane{
	
	private Button anadirBtn,borrarBtn;
	private TableView<Titulo> formacionTable ;
	
	public FormacionView(){
		
		anadirBtn = new Button("Añadir");
		anadirBtn.setMaxWidth(Double.MAX_VALUE);
		borrarBtn = new Button("Eliminar");
		borrarBtn.setMaxWidth(Double.MAX_VALUE);	
		
		formacionTable = new TableView<>();
		TableColumn<Titulo, LocalDate> desdeColum = new TableColumn<>("Desde");
		desdeColum.setCellValueFactory(cellData -> cellData.getValue().desdeProperty());
		TableColumn<Titulo, LocalDate> hastaColum = new TableColumn<>("Hasta");
		hastaColum.setCellValueFactory(cellData -> cellData.getValue().hastaProperty());
		TableColumn<Titulo, String> denominacionColum = new TableColumn<>("Denominación");
		denominacionColum.setCellValueFactory(cellData -> cellData.getValue().denominacionProperty());
		TableColumn<Titulo, String> organizadorColum = new TableColumn<>("Organizador");
		organizadorColum.setCellValueFactory(cellData -> cellData.getValue().organizadorProperty());
		formacionTable.getColumns().addAll(desdeColum,hastaColum,denominacionColum,organizadorColum);
	
		VBox formacionBotones = new VBox(5,anadirBtn,borrarBtn);
		
		GridPane formacionPanel = new GridPane();
		formacionPanel.setPadding(new Insets(10));
		formacionPanel.setHgap(5);
		formacionPanel.setVgap(5);
		formacionPanel.addRow(0,formacionTable, formacionBotones);
		
		ColumnConstraints colfom1 = new ColumnConstraints();
		colfom1.setHgrow(Priority.ALWAYS);
		
		ColumnConstraints colfom2 = new ColumnConstraints();
		colfom2.setHgrow(Priority.NEVER);
		
		formacionPanel.getColumnConstraints().setAll(colfom1, colfom2);
		
		setOrientation(Orientation.VERTICAL);
		getItems().add(formacionPanel);
	}

	public Button getAnadirBtn() {
		return anadirBtn;
	}

	public void setAnadirBtn(Button anadirBtn) {
		this.anadirBtn = anadirBtn;
	}

	public Button getBorrarBtn() {
		return borrarBtn;
	}

	public void setBorrarBtn(Button borrarBtn) {
		this.borrarBtn = borrarBtn;
	}

	public TableView<Titulo> getFormacionTable() {
		return formacionTable;
	}

	public void setFormacionTable(TableView<Titulo> formacionTable) {
		this.formacionTable = formacionTable;
	}
	
	
}
