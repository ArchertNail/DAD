package dad.PatronMVC;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class VerView extends VBox {
	
	private ProgressBar progresoBar;
	private Label valorLabel;
	
	public VerView(){
		super();
		progresoBar = new ProgressBar();
		valorLabel = new Label();
		setAlignment(Pos.CENTER);
		getChildren().addAll(progresoBar,valorLabel);
	}

	public ProgressBar getProgresoBar() {
		return progresoBar;
	}

	public Label getValorLabel() {
		return valorLabel;
	}
	
}
