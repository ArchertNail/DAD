package Login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CrearLogin extends Application {
	
	private TextField textUser;
	private PasswordField textPass;
	private Stage primaryStage2;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage2 = primaryStage;
		// TODO Auto-generated method stub
		Label labelUsuario = new Label("Nombre: ");
		Label labelContrasenia = new Label("Contraseña: ");
		
		textUser = new TextField();
		textPass = new PasswordField();
		
		Button botonAcceder = new Button("Acceder");
		botonAcceder.setOnAction(e -> onAccderButtonAction(e));
		Button botonSalir = new Button("Salir");
		botonSalir.setOnAction(e -> onSalirButtonAction(e));
		
		HBox filaUsuario = new HBox();
		filaUsuario.setAlignment(Pos.CENTER);
		filaUsuario.setSpacing(5);
		filaUsuario.getChildren().addAll(labelUsuario, textUser);
		
		HBox filaContrasenia = new HBox();
		filaContrasenia.setAlignment(Pos.CENTER);
		filaContrasenia.setSpacing(5);
		filaContrasenia.getChildren().addAll(labelContrasenia, textPass);
		
		HBox filaBotones = new HBox();
		filaBotones.setAlignment(Pos.CENTER);
		filaBotones.setSpacing(5);
		filaBotones.getChildren().addAll(botonAcceder, botonSalir);
		
		VBox root = new VBox(); 
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		root.getChildren().addAll(filaUsuario,filaContrasenia,filaBotones);
		
		Scene scene = new Scene(root,320,200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
		primaryStage.show();
	}
	
	private void onAccderButtonAction(ActionEvent e) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Adivinar APP");
		alert.setHeaderText("Este es el encabezado");
		
		if(textUser.getText().equals("admin") && textPass.getText().equals("1234")){
			alert.setContentText("Login Correcto!");
			alert.showAndWait();
			primaryStage2.close();
		}
		else{
			alert.setContentText("INCORRECTO");
			alert.showAndWait();
		}
	}
	
	private void onSalirButtonAction(ActionEvent e) {
		primaryStage2.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
