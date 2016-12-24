package dad.PatronMVC;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ModificarView extends VBox {
	private TextField valorText;
	private Button establecerButton, incButton, decButton;
	
	public ModificarView(){
		Label nuevoLabel = new Label("Nuevo valor:");
		valorText = new TextField();
		valorText.setAlignment(Pos.BASELINE_CENTER);
		valorText.setMaxWidth(100);
		
		establecerButton = new Button("Establecer");
		incButton = new Button(">>");
		decButton = new Button("<<");
		
		HBox valorBox = new HBox(5, nuevoLabel,valorText);
		HBox incDecBox = new HBox(5, decButton,incButton);
		
		
		setAlignment(Pos.CENTER);
		setSpacing(5);
		getChildren().addAll(valorBox,establecerButton,incDecBox);
	}

	public TextField getValorText() {
		return valorText;
	}

	public Button getEstablecerButton() {
		return establecerButton;
	}

	public Button getIncButton() {
		return incButton;
	}

	public Button getDecButton() {
		return decButton;
	}
	
	
}
