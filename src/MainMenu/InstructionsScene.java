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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InstructionsScene {
	private Stage stage;
	private Scene primaryScene;
	private Pane instPane;
	private Scene scene;
	private BackgroundImage background;
	private ImageView arrowBack;
	public InstructionsScene(Stage primaryStage, Scene scene){
			//create instructions scene
	    	
	    	this.stage = primaryStage;
	    	this.primaryScene = scene;
	    	this.instPane = new Pane();
	    	this.scene = new Scene(this.instPane, 768, 460.8);
	    	//Scene size

	    	
	        this.background= new BackgroundImage(new Image("images/Instructions.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(768, 460.8, true, true, true, true));
	        this.instPane.setBackground(new Background(background));
	        //set background to instructions.jpg
	        
	        this.arrowBack = new ImageView();
	        this.arrowBack.setImage(new Image("images/exit2.png"));
	        this.arrowBack.setFitHeight(90);
	        this.arrowBack.setFitWidth(90);
	        this.arrowBack.setX(0);
	        this.arrowBack.setY(0);
	        //set height, width, set the coordinates, set image
	        this.arrowBack.setPickOnBounds(false); // allows click on transparent areas
	        this.arrowBack.setOnMouseClicked((MouseEvent e) -> {
	            System.out.println("Clicked ArrowBack"); // change functionality
	            this.stage.setScene(this.primaryScene);
	        });
	        //create arrowback button and add functionality that will bring it back
	        //to main
	        this.instPane.getChildren().add(this.arrowBack);
	        //add arrowback to scene
	        
      
	    }
	    public Scene getScene() {
	        return this.scene;
	    }

}
