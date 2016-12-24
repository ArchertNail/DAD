package dad.BuscaryReemplazar;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class BuscarReemplazarView extends GridPane {
	
	public BuscarReemplazarView(){
		
		
		//DECLARACION
		
		TextField buscarText = new TextField();
		TextField reemplazarConText= new TextField();
		
		Button aceptarButton = new Button("Buscar");		
		Button remplazarButton = new Button("Remplazar");
		Button remplazarTodoButton = new Button("Remplzar Todo");
		Button cerrarButton = new Button("Cerrar");
		Button ayudaButton = new Button("Ayuda");
		
		CheckBox mayMinCheck = new CheckBox("Mayusculas y minusculas");
		CheckBox busHacAtrCheck = new CheckBox("Buscar hacias atrás");
		CheckBox expRegCheck = new CheckBox("Expresion Regular");
		CheckBox resalResulCheck = new CheckBox("Resaltar Resultado");
		
		//PANELES
		
		VBox botonesVbox = new VBox();
		botonesVbox.getChildren().addAll(aceptarButton,remplazarButton,remplazarTodoButton,cerrarButton,ayudaButton);
		botonesVbox.setSpacing(5);
		
		ObservableList <Node> botoneslist =botonesVbox.getChildren();
		
		for (Node boton : botoneslist) {
			((Button) boton).setMaxWidth(Double.MAX_VALUE);
		}
		
		GridPane checksPane = new GridPane();
		checksPane.setPadding(new Insets(5));
		checksPane.setHgap(5);
		checksPane.setVgap(5);
		checksPane.addRow(0,mayMinCheck,busHacAtrCheck );
		checksPane.addRow(1,expRegCheck,resalResulCheck );
		
		
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setHalignment(HPos.LEFT);
		col1.setHgrow(Priority.NEVER);
			
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setHgrow(Priority.ALWAYS);
			
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setHgrow(Priority.NEVER);
		
		getColumnConstraints().setAll(col1, col2, col3);
		checksPane.getColumnConstraints().setAll(col2, col2);
		
		AnchorPane botonesAnchor = new AnchorPane(botonesVbox);
		AnchorPane.setTopAnchor(botonesVbox, 0.0);
		AnchorPane.setRightAnchor(botonesVbox, 0.0);
		
		
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		addRow(0, new Label("Buscar:"), buscarText);
		addRow(1, new Label("Remplazar con:"), reemplazarConText);
		add(checksPane,1,2);
		add(botonesAnchor,2,0);
		GridPane.setRowSpan(botonesAnchor, 3);
		//GridPane.setRowSpan(botonesVbox, 3);
	}
}
