package dad.juego2;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Bloques extends Pane{

	Image bloquesImg = new Image(getClass().getResourceAsStream("/img/escenario.png"));
	ImageView bloque;
	
	public enum tipoBloque{
		SUELO,PLATAFORMA,MURO;
	}
	
	public  Bloques(tipoBloque tipoBloque, int x, int y) {
		bloque = new ImageView(bloquesImg);
		bloque.setFitWidth(JuegoApp.TAMANIO_BLOQUE);
		bloque.setFitHeight(JuegoApp.TAMANIO_BLOQUE);
		/*bloque.setFitWidth(JuegoApp.TAMANIO_BLOQUE);
		bloque.setFitHeight(y);*/
		setTranslateX(x);
		setTranslateY(y);
		
		switch(tipoBloque){
		
		case SUELO:
			bloque.setViewport(new Rectangle2D(0, 16, 32, 40));
			break;
			
		case PLATAFORMA:
			bloque.setViewport(new Rectangle2D(80, 84, 64, 14));
			break;
		
		case MURO:
			bloque.setViewport(new Rectangle2D(0, 340, 48, 97));
			bloque.setFitWidth(JuegoApp.TAMANIO_BLOQUE);
			bloque.setFitHeight(JuegoApp.TAMANIO_BLOQUE*2);
		}
		
		getChildren().add(bloque);
		
		/*getChildren().add(bloque);
		JuegoApp.juegoRoot.getChildren().add(this);*/
		
	}
		
	
}
