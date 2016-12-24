package dad.juego;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Block extends Pane{
	
	Image blocksImg = new Image(getClass().getResourceAsStream("/img/Escenario.png"));
	ImageView block;
	
	public enum BlockType {
        FLOOR,PLATFORM
    }
	
	public Block(BlockType blockType, int x, int y){
		
		block = new ImageView(blocksImg);
		block.setFitWidth(GameApp.BLOCK_SIZE);
		block.setFitHeight(GameApp.BLOCK_SIZE);
		setTranslateX(x);
        setTranslateY(y);
        
        switch (blockType) {
        
        case FLOOR:
	        block.setViewport(new Rectangle2D(50, 310, 16, 16));
	        //block.setFitWidth(GameApp.BLOCK_SIZE * 2);
	        break;
        
        
        case PLATFORM:
            block.setViewport(new Rectangle2D(0, 211, 70, 16));
            block.setFitWidth(GameApp.BLOCK_SIZE * 3);
            break;
       
    }
      
        getChildren().add(block);
        GameApp.platformas.add(this);
        GameApp.gameRoot.getChildren().add(this);
	}
}
