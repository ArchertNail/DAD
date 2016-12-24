package Geometriapp;

import com.sun.javafx.binding.BidirectionalBinding;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.converter.NumberStringConverter;

public class TrianguloPanel extends VBox {
	
	private ModeloTriangulo triangulo;
	private Label baseLabel, alturaLabel, areaLabel;
	private TextField baseText, alturaText;
	private TrianguloShape triangleShape;
	
	
	public TrianguloPanel(){
		
		baseLabel = new Label("Base");
		baseText = new TextField();
		baseText.setMaxWidth(100);
		
		alturaLabel = new Label("Altura");
		alturaText = new TextField();
		alturaText.setMaxWidth(100);
		
		areaLabel = new Label("Area = xxxx");
		
		triangleShape = new TrianguloShape(50.0, 50.0);
	
		triangleShape.setFill(Color.RED);
		triangleShape.setStroke(Color.BLUE);
		
		HBox baseBox=new HBox(5,baseLabel, baseText);
		baseBox.setAlignment(Pos.BASELINE_CENTER);
		HBox alturaBox = new HBox(5, alturaLabel, alturaText);
		alturaBox.setAlignment(Pos.BASELINE_CENTER);
		
		setPadding(new Insets(5));
		setSpacing(5);
		setAlignment(Pos.TOP_CENTER);
		getChildren().addAll(triangleShape, baseBox, alturaBox, areaLabel);
		
		triangulo = new ModeloTriangulo();
		
		triangulo.setBase(50.0);
		triangulo.setAltura(50.0);
		Bindings.bindBidirectional(
				baseText.textProperty(), 
				triangulo.baseProperty(),
				new NumberStringConverter()
		);
		Bindings.bindBidirectional(
				alturaText.textProperty(), 
				triangulo.alturaProperty(),
				new NumberStringConverter()
		);
		
		triangleShape.baseProperty().bind(triangulo.baseProperty());
		triangleShape.alturaProperty().bind(triangulo.alturaProperty());
		/*triangulo.baseProperty().addListener(
				(observable,oldValue,newValue) -> onChangeSizeTriangle(newValue)
		);
		
		
		triangleShape.getPoints().addAll(new Double[]{0.0, 0.0,
				-40.0, 40.0,
				40.0, 40.0 });*/
		
		
		areaLabel.textProperty().bind(triangulo.areaProperty().asString());
	}
	
}
