package Geometriapp;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;

public class RectanguloPanel extends VBox {
	
	private ModeloRectangulo rectangulo;
	private Rectangle rectanguloShape;
	private Label anchoLabel, altoLabel, areaLabel;
	private TextField anchoText, altoText;
	public RectanguloPanel(){
		super();
		
		rectanguloShape = new Rectangle(60,30);
		rectanguloShape.setFill(Color.RED);
		rectanguloShape.setStroke(Color.BLUE);
		//rectanguloShape.setStroke(Color.BLUE);
		
		anchoLabel = new Label("Ancho");
		anchoText = new TextField();
		anchoText.setMaxWidth(100);
		
		altoLabel = new Label("Alto");
		altoText = new TextField();
		altoText.setMaxWidth(100);
		
		areaLabel = new Label("Area =xxxx");
		Label nomArea = new Label("Area=");
		
		HBox anchoBox=new HBox(5,anchoLabel, anchoText);
		anchoBox.setAlignment(Pos.BASELINE_CENTER);
		HBox altoBox = new HBox(5, altoLabel, altoText);
		altoBox.setAlignment(Pos.BASELINE_CENTER);
		
		setPadding(new Insets(5));
		setSpacing(5);
		setAlignment(Pos.TOP_CENTER);
		getChildren().addAll(rectanguloShape,anchoBox, altoBox, areaLabel);
				
		rectangulo = new ModeloRectangulo();
		
		Bindings.bindBidirectional(
				anchoText.textProperty(), 
				rectangulo.anchoProperty(),
				new NumberStringConverter()
		);
		Bindings.bindBidirectional(
				altoText.textProperty(), 
				rectangulo.altoProperty(),
				new NumberStringConverter()
		);
		
		
		rectanguloShape.widthProperty().bind(rectangulo.anchoProperty());
		rectanguloShape.heightProperty().bind(rectangulo.altoProperty());
		
		areaLabel.textProperty().bind(nomArea.textProperty().concat(rectangulo.areaProperty()));
		
		
	}
}
