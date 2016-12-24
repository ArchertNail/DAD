package dad.juego;

import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Character extends Pane{
	
	Image sakuraImg = new Image(getClass().getResourceAsStream("/img/skura.png"));
    ImageView imageView = new ImageView(sakuraImg);
    
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
		
        imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));  //optenemos el sprite que queremos de la foto insertada
        animation = new SpriteAnimation(this.imageView,Duration.millis(600),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(this.imageView);
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

}
