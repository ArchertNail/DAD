package dad.calendario;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class CalendarioController implements Initializable{
	
	private CalendarioApp app;
	
	// modelo
	private Calendario calendario;
	
	// vista
	private List<MesController> meses;
	
	private BorderPane view;
	
	@FXML
	private GridPane mesesPane;
	
	@FXML
	private Label anyoLabel;
	
	@FXML
	private Button anteriorButton;
	
	@FXML
	private Button siguienteButton;
	
	public static int contador=0;
	
	private FadeTransition transicion;
	
	public CalendarioController(CalendarioApp app) {
		this.app = app;
		
		this.meses = new ArrayList<>();
	
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CalendarioView.fxml"));
			loader.setController(this);
			this.view = loader.load();
			view.getStylesheets().add(getClass().getResource("CalendarioCss.css").toExternalForm());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		int mesActual= LocalDate.now().getMonthValue();
		int diaActual = LocalDate.now().getDayOfMonth();
		
		int contador =1;
		for(int i=0; i<4; i++){
			for(int j=0;j<3;j++){
				MesController mesController = new MesController();
				mesController.setMonth(contador);
				meses.add(mesController);
				mesesPane.add(mesController, j, i);
			
				contador++;
			}
		}
	
		siguienteButton.setOnAction(e->onSiguienteAnyo());
		anteriorButton.setOnAction(e->onAnteriorAnio());
		
		
		
	}

	public void onSiguienteAnyo(){
	
		
		
		transicion = new FadeTransition();
		
		transicion.setCycleCount(1);
		transicion.setDuration(Duration.seconds(1));
		transicion.setFromValue(1.0);
		transicion.setToValue(0.0);
		transicion.setNode(mesesPane);
		transicion.setOnFinished(e->{
				calendario.siguiente();
		
			FadeTransition transicion2 = new FadeTransition();
			transicion2.setCycleCount(1);
			transicion2.setDuration(Duration.seconds(1));
			transicion2.setFromValue(0.0);
			transicion2.setToValue(1.0);
			transicion2.setNode(mesesPane);
			transicion2.play();
		});
		transicion.setInterpolator(Interpolator.LINEAR);
		transicion.play();
	}
	
	public void onAnteriorAnio(){
		calendario.anterior();
	}

	public BorderPane getView() {
		return view;
	}

	public void bind(Calendario calendario) {
		
		this.calendario = calendario;
		for (MesController mes : meses) {
			mes.yearProperty().bind(calendario.anyoProperty());
		}
		anyoLabel.textProperty().bind(calendario.anyoProperty().asString());

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
	}

}
