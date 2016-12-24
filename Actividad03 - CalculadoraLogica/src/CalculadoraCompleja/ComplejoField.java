package CalculadoraCompleja;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ComplejoField extends HBox {
	
	private TextField realText, imaginarioText;
	private Label masLabel, iLabel;
	
	
	public ComplejoField(){
		super();
		realText = new TextField();
		realText.setAlignment(Pos.BASELINE_CENTER);
		realText.setPrefColumnCount(4);
		
		imaginarioText = new TextField();
		imaginarioText.setAlignment(Pos.BASELINE_CENTER);
		imaginarioText.setPrefColumnCount(4);
		
		masLabel = new Label("+");
		iLabel = new Label("i");
		
		setAlignment(Pos.BASELINE_CENTER);
		getChildren().addAll(realText, masLabel, imaginarioText,iLabel);
		setSpacing(5);
	}
	
	public TextField getRealText(){
		return realText;
	}
	public TextField getImaginarioText(){
		return imaginarioText;
	}
}
