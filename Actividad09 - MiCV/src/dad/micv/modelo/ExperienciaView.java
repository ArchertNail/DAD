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
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ExperienciaView extends SplitPane{
	
	private Button anadirBtn,borrarBtn;
	private TableView<Experiencia> experienciaTable;
	public ExperienciaView(){
		anadirBtn = new Button("Añadir");
		anadirBtn.setMaxWidth(Double.MAX_VALUE);
		borrarBtn = new Button("Eliminar");
		borrarBtn.setMaxWidth(Double.MAX_VALUE);	
		
		experienciaTable = new TableView<>();
		TableColumn<Experiencia, LocalDate> desdeColum = new TableColumn<>("Desde");
		desdeColum.setCellValueFactory(cellData -> cellData.getValue().desdeProperty());
		TableColumn<Experiencia, LocalDate> hastaColum = new TableColumn<>("Hasta");
		hastaColum.setCellValueFactory(cellData -> cellData.getValue().hastaProperty());
		TableColumn<Experiencia, String> denominacionColum = new TableColumn<>("Denominación");
		denominacionColum.setCellValueFactory(cellData -> cellData.getValue().denominacionProperty());
		TableColumn<Experiencia, String> empleadorColum = new TableColumn<>("Empleador");
		empleadorColum.setCellValueFactory(cellData -> cellData.getValue().empleadorProperty());
		experienciaTable.getColumns().addAll(desdeColum,hastaColum,denominacionColum,empleadorColum);
	
		VBox experienciaBotones = new VBox(5,anadirBtn,borrarBtn);
		
		GridPane experienciaPanel = new GridPane();
		experienciaPanel.setPadding(new Insets(10));
		experienciaPanel.setHgap(5);
		experienciaPanel.setVgap(5);
		experienciaPanel.addRow(0,experienciaTable, experienciaBotones);
		
		ColumnConstraints colfom1 = new ColumnConstraints();
		colfom1.setHgrow(Priority.ALWAYS);
		
		ColumnConstraints colfom2 = new ColumnConstraints();
		colfom2.setHgrow(Priority.NEVER);
		
		experienciaPanel.getColumnConstraints().setAll(colfom1, colfom2);
		
		setOrientation(Orientation.VERTICAL);
		getItems().add(experienciaPanel);
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
	public TableView<Experiencia> getExperienciaTable() {
		return experienciaTable;
	}
	public void setExperienciaTable(TableView<Experiencia> experienciaTable) {
		this.experienciaTable = experienciaTable;
	}
	
	
}
