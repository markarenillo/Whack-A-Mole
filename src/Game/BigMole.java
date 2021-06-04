package Game;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BigMole extends Mole{
	public final static Image BIGMOLE_IMAGE = new Image("images/mole2.png",Mole.MOLE_WIDTH,Mole.MOLE_LENGTH,false,false);
	public final static int BIGMOLE_HITS = 3;
	public final static Image SCOREPOP = new Image("images/plusfive.png",100,50,false,false);
	BigMole(Hole hole,int xcor, int ycor, Group root){
		super(hole,xcor,ycor,root);
		this.score = 5;
		this.hit = BIGMOLE_HITS;
		this.loadImage(BIGMOLE_IMAGE);
	}
	
	public void scorePop(GraphicsContext gc,double posx, double posy) {
		gc.drawImage(SCOREPOP, posx, posy);
	}
}