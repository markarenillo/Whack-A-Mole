package Game;

import java.util.ArrayList;


import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameOverStage {
	private Pane root;
	private Stage stage;
	private Scene scene;
	private Scene mainscene;
	private GraphicsContext gc;
	private Canvas canvas;
	private Integer score;
	private Text text;
	private ArrayList<Integer> highscores;
	private ImageView menu;
	private BackgroundImage background;
	GameOverStage(Integer score,ArrayList<String> highscores,  Stage stage, Scene scene){
		this.stage = stage;
		this.mainscene = scene;
		this.highscores = new ArrayList <Integer>(3);
		this.root = new Pane();
		this.scene = new Scene(root, GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);
		this.canvas = new Canvas(GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT);
		this.background = new BackgroundImage(new Image("images/gameover.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(768, 460.8, true, true, true, true));
		
		this.gc = canvas.getGraphicsContext2D();
		this.root.setBackground(new Background(this.background));
		this.score = score;
		for(String i:highscores) {
			this.highscores.add(Integer.valueOf(i));
		}
		for(int i = 0;i<3;i++) {
			if(score>this.highscores.get(i)){
				this.highscores.remove(i);
				this.highscores.add(i,score);
				break;
			}
		}
		this.setProperties();
		
		
		
	}
	
	private void setProperties(){

		System.out.println("WIIN");
		
		
//		Font theFont = Font.font("Times New Roman",FontWeight.BOLD,30);//set font type, style and size
		
//		String score = " "+ this.score;
//		text = new Text(160 ,55 , score);
//		text.setFont(Font.loadFont(getClass()
//                .getResourceAsStream("/images/boston caps.ttf"), 60));
//		
//		text.setFill(Color.WHITE);
		
		
		  this.menu = new ImageView();
	        this.menu.setImage(new Image("images/menu.png"));
	        this.menu.setFitHeight(70);
	        this.menu.setFitWidth(90);
	        this.menu.setX(155);
	        this.menu.setY(1);
	        this.menu.setPickOnBounds(false); // allows click on transparent areas
	        this.menu.setOnMouseClicked((MouseEvent e) -> {
	            System.out.println("Clicked Menu");
	            this.stage.setScene(this.mainscene);     
	        });
	        this.root.getChildren().add(this.menu);
	}
	
	Scene getScene(){
		return this.scene;
	}
}