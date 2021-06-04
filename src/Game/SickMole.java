package Game;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class SickMole extends Mole{
	public final static Image SICKMOLE_IMAGE = new Image("images/mole4.png",Mole.MOLE_WIDTH,Mole.MOLE_LENGTH,false,false);
	public final static Image SCOREPOP = new Image("images/minustwo.png",100,50,false,false);
	
	SickMole(Hole hole,int xcor, int ycor, Group root){
		super(hole,xcor,ycor,root);
		this.score = -2;
		this.loadImage(SICKMOLE_IMAGE);
	}
	
	public void scorePop(GraphicsContext gc,double posx, double posy) {
		gc.drawImage(SCOREPOP, posx, posy);
	}
}
