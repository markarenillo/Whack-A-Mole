package Game;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MoleAnimation extends Transition {
	    private final ImageView imageView;
	    private final int count;
	    private final int columns;
	    private final int offsetX;
	    private final int offsetY;
	    private final int width;
	    private final int height;
	    private int lastIndex;
	    private Group root;
	    private Mole mole;
	    private int movingX;
	    private int movingY;
	    public Rectangle2D bounds;

	public MoleAnimation(Mole mole,ImageView imageView,Duration duration, int count,   int columns,int offsetX, int offsetY, int width, int height,Group root) {
        this.mole = mole;
		this.imageView = imageView;
        this.count     = count;
        this.columns   = columns;
        this.offsetX   = offsetX;
        this.offsetY   = offsetY;
        this.width     = width;
        this.height    = height;
        this.movingX = 0;
        this.movingY = 0;
        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
        this.root = root;
        
    }
	
	protected void interpolate(double k) {
    	
        final int index = Math.min((int) Math.floor(k * count), count - 1);
        
        if (index != lastIndex) {
            final int x = (index % columns) * width  + offsetX;
            final int y = (index / columns) * height + offsetY;
            this.movingX = x;
            this.movingY = y;
            System.out.println("lolol");
            System.out.println(x);
            System.out.println(y);
            imageView.setViewport(new Rectangle2D(x, y, width, height));
            this.bounds = new Rectangle2D(x, y, width, height);
            
            lastIndex = index;
        }
        
        if(this.mole.rendered ==0){
        	root.getChildren().add(this.imageView);
        	this.mole.rendered = 1;
        }
        if(index ==0) {
        	root.getChildren().remove(this.imageView);
        	this.mole.rendered = 0;
        }
    }
	public Rectangle2D getBoundsMole(){
		return new Rectangle2D(this.movingX, this.movingY, this.width, this.height);
	}
	
}
