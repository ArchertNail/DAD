package dad.juego;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox.KeySelectionManager;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameApp extends Application {

	public static ArrayList<Block> platformas = new ArrayList<>(); 
	private HashMap<KeyCode,Boolean> keys = new HashMap<>();
	
	
	Image backgroundImg = new Image(getClass().getResourceAsStream("/img/background.png"));
	public static final int BLOCK_SIZE = 35;
	public static final int SAKURA_SIZE = 55;
	
	public static Pane appRoot = new Pane();
	public static Pane gameRoot = new Pane();
	
	public Character player;
	
	int levelNumber = 0;
	private int levelWidth;
	
	
	private void initContent() {
		
		ImageView backgroundIV = new ImageView(backgroundImg);
		backgroundIV.setFitHeight(12*BLOCK_SIZE);  //CANTIDAD DE FILA X TAMAÑO BLOQUES
        backgroundIV.setFitWidth(30*BLOCK_SIZE);   //Columnas * Bloques
       
        levelWidth = LevelData.LEVEL1[0].length()*BLOCK_SIZE;
        
        
        for(int i=0; i<LevelData.LEVEL1.length; i++){

        	String line = LevelData.LEVEL1[i]; 

        	for(int j=0; j<line.length();j++){
        		
        		switch(line.charAt(j)){
				case '0':
					break;
				case '1':
					Block Floor = new Block(Block.BlockType.FLOOR, j * BLOCK_SIZE, i * BLOCK_SIZE);
                    break;
                    
				case '2':
					Block platform = new Block(Block.BlockType.PLATFORM, j * BLOCK_SIZE, i * BLOCK_SIZE);
                    break;
                   
        		}
        		
        	}
        	
        }
        
        player =new Character();
        player.setTranslateX(10);
        player.setTranslateY(280);
        /*player.translateXProperty().addListener((obs,old,newValue)->{
        	int offset = newValue.intValue();
        	if(offset>640 && offset<levelWidth-640){
        		gameRoot.setLayoutX(-(offset-640));
        		backgroundIV.setLayoutX(-(offset-640));
        	}
        });*/
        
        
        gameRoot.getChildren().add(player);
        appRoot.getChildren().addAll(backgroundIV,gameRoot);
        
        
        player.animation.play();
	}
	
	private void update(){
		
	
	    if(isPressed(KeyCode.LEFT) && player.getTranslateX()>=5){
	    	player.setScaleX(-1);
	        player.animation.play();
	        player.moveX(-5);
	    }
	    if(isPressed(KeyCode.RIGHT) && player.getTranslateX()+40 <=levelWidth-5){
	        player.setScaleX(1);	
	        player.animation.play();
	        player.moveX(5);
	    }
		
		
		if(player.playerVelocity.getY()<10){                          //ãðàâèòàöèÿ
			player.playerVelocity = player.playerVelocity.add(0,1);
	     }
		
		 if(isPressed(KeyCode.UP) && player.getTranslateY()>=5){
			 player.jumpPlayer();
	     }
		
		 player.moveY((int)player.playerVelocity.getY());
	}
	
	
	//devuelve la tecla pulsada
	private boolean isPressed(KeyCode key){
		return keys.getOrDefault(key,false);
		
	}
	
	public void start(Stage primaryStage) throws Exception {
		initContent();
		
		Scene scene = new Scene(appRoot);
		
		scene.setOnKeyPressed(event-> keys.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> {
            keys.put(event.getCode(), false);
            this.player.animation.play();
        }); 
        
		primaryStage.setTitle("Prueba Juego");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
	}

	

	public static void main(String[] args) {
		launch(args);
	}
}
