package Adivinar;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JuegoAdivinar extends Application {

	private TextField textNumero;
	private Button botonComprobar;

	private int contador = 0;
	private int numeroAleatorio = (int)Math.round(Math.random()*100);
	@Override
	public void start(Stage primaryStage) throws Exception {

		Label enunciado = new Label("Introduce un número del 1 al 100");
		
		
		textNumero = new TextField();
		textNumero.setMaxWidth(150);
		textNumero.setPromptText("numero");
		
		botonComprobar = new Button("Comprobar");
		botonComprobar.setOnAction(e -> onComprobarButtonAction(e));
		botonComprobar.setDefaultButton(true);
		
		VBox root = new VBox(); 
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		root.getChildren().addAll(enunciado,textNumero,botonComprobar);
		
		Scene scene = new Scene(root,320,200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Advinar Numero");
		primaryStage.show();
	}
	
	private void onComprobarButtonAction(ActionEvent e) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Adivinar APP");
		alert.setHeaderText("Este es el encabezado");
		contador++;
		int numero =0;
		try{
			if(textNumero.getText().isEmpty()){
				alert.setContentText("Introduzca un numero porfavor");
				alert.showAndWait();
			}
			else{
				numero = Integer.parseInt(textNumero.getText());
		
				if(numero<numeroAleatorio){
					alert.setContentText("EL Numero es Mayor a " + numero);
					alert.showAndWait();
					textNumero.setText("");
				}
				else if(numero>numeroAleatorio){
					alert.setContentText("EL Numero es Menor a " + numero);
					alert.showAndWait();
					textNumero.setText("");
				}
				else{
					alert.setContentText("FELICIDADES HAS ACERTADO! INTENTOS: " + contador);
					alert.showAndWait();
					numeroAleatorio = (int)Math.round(Math.random()*100);
					contador=0;
					textNumero.setText("");
				}
			}
		}
		catch (NumberFormatException ex) { 	
			alert.setContentText("No introduzca caracteres");
			alert.showAndWait();
		}
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
