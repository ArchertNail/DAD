package dad.calendario;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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
		//calendario.anterior();
		
		TranslateTransition transicion = new TranslateTransition();
		transicion.setCycleCount(1);
		transicion.setDuration(Duration.seconds(0.70));
		transicion.setFromX(0.0);
		transicion.setToX(580);
		transicion.setNode(view);
		transicion.setOnFinished(e->{
			calendario.anterior();
	
		TranslateTransition transicion2 = new TranslateTransition();
		transicion2.setCycleCount(1);
		transicion2.setDuration(Duration.seconds(0.7));
		transicion2.setFromX(-580);
		transicion2.setToX(0);
		transicion2.setNode(view);
		transicion2.play();
	});
		transicion.setInterpolator(Interpolator.LINEAR);
		transicion.play();
		
		/*
		// Sacamos una captura de pantalla a las scenas
		WritableImage wi = new WritableImage(580, 540);
		Image img1 = mesesPane.snapshot(new SnapshotParameters(),wi);
		ImageView imgView1= new ImageView(img1);
		wi = new WritableImage(580, 540);
		Image img2 = mesesPane.snapshot(new SnapshotParameters(),wi);
		ImageView imgView2= new ImageView(img2);
		
		// Creamos una nueva escena para cada una de las escenas
		imgView1.setTranslateX(0);
        imgView2.setTranslateX(300);
        StackPane pane= new StackPane(imgView1,imgView2);
        pane.setPrefSize(580,540);
        
        //Reemplazamos el panel1 por el nuevo panel
        mesesPane.getChildren().setAll(pane);
        
        //Creamos la Transicion
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(imgView2.translateXProperty(), 0, Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t->{
            // remove pane and restore scene 1
            //root1.getChildren().setAll(rectangle1);
            // set scene 2
            //primaryStage.setScene(scene2);
        });
        timeline.play();*/
        
		
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
