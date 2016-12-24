package dad.CalculadoraMVC;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class CalculadoraView extends GridPane {
	
	private Button ceBoton,cBoton,sumBoton,restBoton,multBoton,divBoton,puntoBoton,igualBoton;
	private Button[] numerosBotones;
	TextField resultText;
	
	public CalculadoraView() {
		
		resultText = new TextField();
		resultText.setMaxHeight(Double.MAX_VALUE);
		resultText.setAlignment(Pos.BASELINE_RIGHT);
		
		numerosBotones = new Button[10];
		
		for(int i=0; i<numerosBotones.length;i++){
			numerosBotones[i] = new Button(""+i);
			numerosBotones[i].setMaxWidth(Double.MAX_VALUE);
			numerosBotones[i].setMaxHeight(Double.MAX_VALUE);
		}
		
		
		ceBoton = new Button("CE");
		ceBoton.setMaxWidth(Double.MAX_VALUE);
		ceBoton.setMaxHeight(Double.MAX_VALUE);
		cBoton = new Button("C");
		cBoton.setMaxWidth(Double.MAX_VALUE);
		cBoton.setMaxHeight(Double.MAX_VALUE);
		sumBoton = new Button("+");
		sumBoton.setMaxHeight(Double.MAX_VALUE);
		sumBoton.setMaxWidth(Double.MAX_VALUE);
		restBoton = new Button("-");
		restBoton.setMaxHeight(Double.MAX_VALUE);
		restBoton.setMaxWidth(Double.MAX_VALUE);
		multBoton = new Button("*");
		multBoton.setMaxHeight(Double.MAX_VALUE);
		multBoton.setMaxWidth(Double.MAX_VALUE);
		divBoton = new Button("/");
		divBoton.setMaxHeight(Double.MAX_VALUE);
		divBoton.setMaxWidth(Double.MAX_VALUE);
		puntoBoton = new Button(".");
		puntoBoton.setMaxWidth(Double.MAX_VALUE);
		puntoBoton.setMaxHeight(Double.MAX_VALUE);
		igualBoton = new Button("=");
		igualBoton.setMaxWidth(Double.MAX_VALUE);
		igualBoton.setMaxHeight(Double.MAX_VALUE);
		
		//GridPane formPane = new GridPane();
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		addRow(0, resultText);
		addRow(1, numerosBotones[7],numerosBotones[8],numerosBotones[9], ceBoton,cBoton);
		addRow(2, numerosBotones[4],numerosBotones[5],numerosBotones[6], multBoton,divBoton);
		addRow(3, numerosBotones[1],numerosBotones[2],numerosBotones[3], restBoton,igualBoton);
		addRow(4, numerosBotones[0]);
		add(puntoBoton,2,4);
		add(sumBoton,3,4);
		
		
		RowConstraints row1 = new RowConstraints();
		row1.setVgrow(Priority.NEVER);
		
		RowConstraints row2 = new RowConstraints();
		row2.setVgrow(Priority.ALWAYS);

		RowConstraints row3 = new RowConstraints();
		row3.setVgrow(Priority.ALWAYS);

		RowConstraints row4 = new RowConstraints();
		row4.setVgrow(Priority.ALWAYS);
		
		RowConstraints row5 = new RowConstraints();
		row5.setVgrow(Priority.ALWAYS);
		
		getRowConstraints().setAll(row1, row2, row3,row4,row5);
		
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setHalignment(HPos.LEFT);
		col1.setHgrow(Priority.ALWAYS);
		
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setHgrow(Priority.ALWAYS);
			
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setHgrow(Priority.ALWAYS);
		
		ColumnConstraints col4 = new ColumnConstraints();
		col4.setHgrow(Priority.ALWAYS);
		
		ColumnConstraints col5 = new ColumnConstraints();
		col5.setHgrow(Priority.ALWAYS);
		
		getColumnConstraints().setAll(col1, col2, col3,col4,col5);
		
		GridPane.setColumnSpan(resultText,5);
		GridPane.setColumnSpan(numerosBotones[0],2);
		GridPane.setRowSpan(igualBoton, 2);
	}

	public Button getCeBoton() {
		return ceBoton;
	}

	public Button getcBoton() {
		return cBoton;
	}

	public Button getSumBoton() {
		return sumBoton;
	}

	public Button getRestBoton() {
		return restBoton;
	}

	public Button getMultBoton() {
		return multBoton;
	}

	public Button getDivBoton() {
		return divBoton;
	}

	public Button getPuntoBoton() {
		return puntoBoton;
	}

	public Button getIgualBoton() {
		return igualBoton;
	}

	public Button[] getNumerosBotones() {
		return numerosBotones;
	}

	public TextField getResultText() {
		return resultText;
	}

	public void setResultText(TextField resultText) {
		this.resultText = resultText;
	}
	
	
	
	
}
