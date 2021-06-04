package MainMenu;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Game.GameStage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
//import java.util.Scanner;


public class Menu {
	private Stage stage;
	private Pane root;
	private Scene scene;
	private BackgroundImage background;
	private ImageView play;
	private ImageView instructions;
	private ImageView about;
	private ImageView scores;
	private ImageView exit;
	private ArrayList<String> highscores;
	
	
	public Menu(Stage primaryStage) {
		//Main Menu
		this.highscores = new ArrayList<String>();
		this.stage = primaryStage;
		this.root = new Pane();
		this.scene = new Scene(this.root, 768, 460.8);
		//set scene size
		this.background = new BackgroundImage(new Image("images/WHACKMENU.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(768, 460.8, true, true, true, true));
		//set background and background size
		

	}
	public void setMenu() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("HighScores.txt"));
			//Scanner scan = new Scanner(System.in);
			String line;
			while((line=reader.readLine()) != null) {
				highscores.add(line);
			}
			reader.close();
		} catch(FileNotFoundException e) {
			try{
						System.out.println("File HighScores.txt not found");
						BufferedWriter writer = new BufferedWriter(new FileWriter("HighScores.txt"));
						writer.write(0+"\n");
						writer.write(0+"\n");
						writer.write(0+"\n");
						highscores.add("0");
						highscores.add("0");
						highscores.add("0");
						writer.close();}catch(Exception f){}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		//System.out.println(highscores);
		
		this.stage.setTitle("Whack-A-Mole");
        this.root.setBackground(new Background(this.background));
        this.stage.getIcons().add(new Image("images/mole1.png"));
        //set background and title
        
        this.play = new ImageView();
        this.play.setImage(new Image("images/play.png"));
        this.play.setFitHeight(80);
        this.play.setFitWidth(250);
        //fix height and width
        this.play.setX(266);
        this.play.setY(350);
        //set coordinates on scene
        this.play.setPickOnBounds(false); // allows click on transparent areas
        this.play.setOnMouseClicked((MouseEvent e) -> {
        	//go to gametest scene if object is clicked
            System.out.println("Clicked Play");
    		GameStage theGameStage = new GameStage(this.stage, this.scene,this.highscores);
    		theGameStage.setStage();
        });
        //above creates the play button
        
        this.instructions = new ImageView();
        this.instructions.setImage(new Image("images/i.png"));
        this.instructions.setFitHeight(70);
        this.instructions.setFitWidth(55);
        this.instructions.setX(700);
        this.instructions.setY(275);
        this.instructions.setPickOnBounds(false); // allows click on transparent areas
        this.instructions.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Clicked Instructions");
            InstructionsScene instructions = new InstructionsScene(this.stage, this.scene);
            this.stage.setScene(instructions.getScene());     
        });
        //above creates the instructions button, similar to play button
        
        this.about = new ImageView();
        this.about.setImage(new Image("images/about.png"));
        this.about.setFitHeight(99);
        this.about.setFitWidth(85);
        this.about.setX(688);
        this.about.setY(318);
        this.about.setPickOnBounds(false); // allows to not click on transparent areas
        this.about.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Clicked About"); // change functionality
            AboutScene about = new AboutScene(this.stage, this.scene);
            this.stage.setScene(about.getScene());
        });
        
        this.scores = new ImageView();
        this.scores.setImage(new Image("images/scores.png"));
        this.scores.setFitHeight(55);
        this.scores.setFitWidth(73);
        this.scores.setX(697);
        this.scores.setY(215);
        this.scores.setPickOnBounds(false); // allows to not click on transparent areas
        this.scores.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Clicked Scores"); // change functionality
            Scores score = new Scores(this.stage, this.scene);
            this.stage.setScene(score.getScene());
        });
        
        this.exit = new ImageView();
        this.exit.setImage(new Image("images/exit3.png"));
        this.exit.setFitHeight(50);
        this.exit.setFitWidth(110);
        this.exit.setX(700);
        this.exit.setY(400);
        this.exit.setPickOnBounds(false); // allows to not click on transparent areas
        this.exit.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Bye!"); // change functionality
            System.exit(0);
        });
      //above creates the about button, similar to play button
         
        this.root.getChildren().add(this.play);
        this.root.getChildren().add(this.instructions);
        this.root.getChildren().add(this.about);
        this.root.getChildren().add(this.scores);
        this.root.getChildren().add(this.exit);
        //add buttons to scene
        this.stage.setResizable(false);
        //not allow to be resized
        this.stage.setScene(this.scene);
        this.stage.show();
        //show
	}
}