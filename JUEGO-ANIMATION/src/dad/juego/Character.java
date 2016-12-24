package dad.juego;

import javafx.application.Platform;
import javafx.beans.binding.When;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Character extends Pane{
	
	Image sakuraQuieta = new Image(getClass().getResourceAsStream("/img/skura.png"));
	Image sakuraMove = new Image(getClass().getResourceAsStream("/img/skuraCaminando.png"));
	//Image sakuraSalto = new Image(getClass().getResourceAsStream("/img/spr_Sakura_Saltando.png"));
	private IntegerProperty estado;
    
    int count = 5;
    int columns = 5;
    int offsetX = 0;
    int offsetY = 0;
    int width = 33;
    int height = 55;
    public SpriteAnimation animation;
    public Point2D playerVelocity = new Point2D(0,0);
    private boolean canJump = true;

    
	public Character() {
		estado = new SimpleIntegerProperty(this,"estado",0);
		
		ImageView protagonistaImg = new ImageView();
		protagonistaImg.imageProperty().bind(new When(estado.isEqualTo(1)).then(sakuraMove).otherwise(sakuraQuieta));
		
        protagonistaImg.setViewport(new Rectangle2D(offsetX,offsetY,width,height));  //optenemos el sprite que queremos de la foto insertada
        animation = new SpriteAnimation(protagonistaImg,Duration.millis(600),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(protagonistaImg);
	}
	
	public void moveX(int value){ 
		
		boolean movingRight = value >0;
		for(int i=0; i<Math.abs(value); i++){  
			for (Node platform : GameApp.platformas) {
				if(this.getBoundsInParent().intersects(platform.getBoundsInParent())){
					if(movingRight){
						if (this.getTranslateX() + 33 == platform.getTranslateX()){
							this.setTranslateX(this.getTranslateX() - 1);
                            return;
                        }
					}
					else{
						this.setTranslateX(this.getTranslateX() + 1);
						return;
					}
				}
			}
			
			this.setTranslateX(this.getTranslateX() + (movingRight ? 1:-1));
		}
	}
	
	
	public void moveY(int value){
		
		boolean movingDown = value >0;
        for(int i = 0; i < Math.abs(value); i++){
            for(Block platform :GameApp.platformas){
                if(getBoundsInParent().intersects(platform.getBoundsInParent())){
                    if(movingDown){
                        if(this.getTranslateY()+ GameApp.SAKURA_SIZE == platform.getTranslateY()){
                            this.setTranslateY(this.getTranslateY()-1);
                            canJump = true;
                            return;
                        }
                    }
                    else{
                        if(this.getTranslateY() == platform.getTranslateY()+ GameApp.BLOCK_SIZE){
                            this.setTranslateY(this.getTranslateY()+1);
                            playerVelocity = new Point2D(0,10);
                            return;
                        }
                    }
                }
            }
            this.setTranslateY(this.getTranslateY() + (movingDown?1:-1));
            if(this.getTranslateY()>640){
                this.setTranslateX(0);
                this.setTranslateY(400);
                GameApp.gameRoot.setLayoutX(0);
            }
        }
	}
	
	
	public void jumpPlayer(){
        if(canJump){
            playerVelocity = playerVelocity.add(0,-25);
            canJump = false;
        }
    }

	public final IntegerProperty estadoProperty() {
		return this.estado;
	}
	

	public final int getEstado() {
		return this.estadoProperty().get();
	}
	

	public final void setEstado(final int estado) {
		this.estadoProperty().set(estado);
	}
	
	
	

}
