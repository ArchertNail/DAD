package dad.juego2;

import javafx.beans.binding.When;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Protagonista extends Pane{

	Image sakuraQuieta = new Image(getClass().getResourceAsStream("/img/Protagonista.png"));
	Image sakuraMove = new Image(getClass().getResourceAsStream("/img/Protagonista2.png"));
	private IntegerProperty enMovimiento;
	
	private ImageView protagonistaImg;
	
	
	public Protagonista() {
		enMovimiento = new SimpleIntegerProperty(this,"enMovimiento",0);
		protagonistaImg = new ImageView();	
		protagonistaImg.imageProperty().bind(new When(enMovimiento.isEqualTo(1)).then(sakuraMove).otherwise(sakuraQuieta));
		
		
		
	}

	

	
	
}
