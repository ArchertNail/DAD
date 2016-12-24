package Geometriapp;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;

public class CirculoPanel extends VBox {
	
	private modeloCirculo circulo;
	private Circle circuloShape;
	private Label radioLabel, areaLabel;
	private TextField raidoText;
	public CirculoPanel(){
		super();
		
		circuloShape = new Circle();
		circuloShape.setFill(Color.RED);
		circuloShape.setStroke(Color.BLUE);
		//rectanguloShape.setStroke(Color.BLUE);
		
		radioLabel = new Label("radio");
		raidoText = new TextField();
		raidoText.setMaxWidth(100);
		
		areaLabel = new Label("Area =xxxx");
		Label nomArea = new Label("Area=");
		
		HBox radioBox=new HBox(5,radioLabel, raidoText);
		radioBox.setAlignment(Pos.BASELINE_CENTER);
		
		setPadding(new Insets(5));
		setSpacing(5);
		setAlignment(Pos.TOP_CENTER);
		getChildren().addAll(circuloShape,radioBox, areaLabel);
				
		circulo = new modeloCirculo();
		
		Bindings.bindBidirectional(
				raidoText.textProperty(), 
				circulo.radioProperty(),
				new NumberStringConverter()
		);
		
		circuloShape.radiusProperty().bind(circulo.radioProperty());
		
		areaLabel.textProperty().bind(nomArea.textProperty().concat(circulo.areaProperty()));
		
		
	}
}
