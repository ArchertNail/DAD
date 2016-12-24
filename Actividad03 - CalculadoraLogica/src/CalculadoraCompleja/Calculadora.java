package CalculadoraCompleja;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Calculadora extends Application {

	private ComplejoField oper1Field, oper2Field, resultField;
	private ComboBox<String> operacionCombo;
	private Complejo oper1, oper2, result;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		oper1Field = new ComplejoField();
		oper2Field = new ComplejoField();
		resultField = new ComplejoField();
		resultField.setDisable(true);
		
		//oper1.getRealText();
		operacionCombo = new ComboBox();
		operacionCombo.getItems().addAll("+","-","*","/");
		operacionCombo.valueProperty().addListener(
				(observable,oldValue,newValue) -> onOperacionComboValueChanged(newValue)
		);
		VBox operacionesPanel1 = new VBox();
		operacionesPanel1.setAlignment(Pos.CENTER);
		operacionesPanel1.getChildren().addAll(operacionCombo);
		
		VBox centroPanel = new VBox(5);
		centroPanel.setAlignment(Pos.CENTER);
		centroPanel.getChildren().addAll(oper1Field,oper2Field,new Separator(),resultField);
		
		HBox root = new HBox(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(operacionesPanel1,centroPanel);
		
		Scene scene = new Scene(root,320,200);
		
		oper1 = new Complejo();
		oper2 = new Complejo();
		result = new Complejo();
		
		Bindings.bindBidirectional(
				oper1Field.getRealText().textProperty(), 
				oper1.realProperty(),
				new NumberStringConverter()
		);
		Bindings.bindBidirectional(
				oper1Field.getImaginarioText().textProperty(), 
				oper1.imaginarioProperty(),
				new NumberStringConverter()
		);
		
		Bindings.bindBidirectional(
				oper2Field.getRealText().textProperty(), 
				oper2.realProperty(),
				new NumberStringConverter()
		);
		Bindings.bindBidirectional(
				oper2Field.getImaginarioText().textProperty(), 
				oper2.imaginarioProperty(),
				new NumberStringConverter()
		);
		
		resultField.getRealText().textProperty().bind(
				result.realProperty().asString()
			);
		
		resultField.getImaginarioText().textProperty().bind(
				result.imaginarioProperty().asString()
			);
		
		operacionCombo.setValue("+");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void onOperacionComboValueChanged(String newValue) {
		// TODO Auto-generated method stub
		DoubleExpression rExp = null;
		DoubleExpression iExp = null;
		
		DoubleProperty a = oper1.realProperty();
		DoubleProperty b = oper1.imaginarioProperty();
		DoubleProperty c = oper2.realProperty();
		DoubleProperty d = oper2.imaginarioProperty();
		
		switch(newValue){
		case "+":
			rExp= a.add(c); //a+c
			iExp = b.add(d); //b+d
			break;
			
		case "-":
			rExp = a.subtract(c); //a-c
			iExp = b.subtract(d); //b-d
			break;
		case "*":
			rExp = (a.multiply(c)).subtract(b.multiply(d)); //ac - bd 4
			iExp = (a.multiply(d)).add(b.multiply(c));     //ad+bc
			break;
		case "/":
			DoubleExpression divisor = (c.multiply(c)).add(d.multiply(d));  //(c^2+d^2)
			rExp = (a.multiply(c)).add(b.multiply(d)).divide(divisor);  //(ac+bd)
			iExp =(b.multiply(c)).subtract(a.multiply(d)).divide(divisor);   // (bc-ad)
			break;
		}
		
		result.realProperty().bind(rExp);
		result.imaginarioProperty().bind(iExp);
		System.out.println("se ha seleccionado " + newValue);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
