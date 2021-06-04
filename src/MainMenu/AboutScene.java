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

public class AboutScene{
	private Stage stage;
	private Scene primaryScene;
	private Pane aboutPane;
	private Scene scene;
	private BackgroundImage background;
	private ImageView arrowBack;
    public AboutScene(Stage stage, Scene scene){
    	//create about scene
    	
    	this.stage = stage;
    	this.primaryScene = scene;
    	this.aboutPane = new Pane();
    	this.scene = new Scene(this.aboutPane, 768, 460.8);
    	//set scene size, initialize pane

        this.background= new BackgroundImage(new Image("images/About.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(768, 460.8, true, true, true, true));
        this.aboutPane.setBackground(new Background(background));
        //set background to about.jpg
        

        this.arrowBack = new ImageView();
        this.arrowBack.setImage(new Image("images/exit2.png"));
        this.arrowBack.setFitHeight(90);
        this.arrowBack.setFitWidth(90);
        this.arrowBack.setX(0);
        this.arrowBack.setY(0);
        this.arrowBack.setPickOnBounds(false); // allows click to not on transparent areas
        this.arrowBack.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Clicked ArrowBack"); // change functionality
            this.stage.setScene(this.primaryScene);
        });
        //Create arrowback button, add to scene, set height width and coordinates
        //on the scene.
        this.aboutPane.getChildren().add(this.arrowBack);
  
    }
    public Scene getScene() {
        return this.scene;
    }
    

}
