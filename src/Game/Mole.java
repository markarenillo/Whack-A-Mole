package Game;


import javafx.scene.image.Image;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Mole extends Sprite implements Runnable{

	private boolean hidden;
	private int time;//amount of time the mole is alive
	private Hole hole;
	protected final static int MOLE_WIDTH = 170;
	protected final static int MOLE_LENGTH = 180;
	public final static Image MOLE_IMAGE = new Image("images/mole1.png",Mole.MOLE_WIDTH,Mole.MOLE_LENGTH,false,false);
	private static final Image IMAGE1 = new Image("images/Picture7.png");
	public final static int NORMALMOLE_HITS = 1;
	protected static final int WIDTH    = 84;
	protected static final int HEIGHT   = 115;
	protected int score;
	protected int hit;
	public final static Image SCOREPOP = new Image("images/plustwo.png",100,50,false,false);
	private static final int COLUMNS  =   11;
    private static final int COUNT    =  32;
    private static final int OFFSET_X =  0;
    private static final int OFFSET_Y =  0;
    public Animation animation;
    private ImageView imageview;
    public int rendered;
   
    
	//Constructor
	public Mole(Hole hole,int xcor, int ycor, Group root){
		
		super((xcor+5),(ycor-130));
		
		this.hidden = true;
		this.time = 0;
		this.hole = hole;
		this.score = 2;
		this.hit = NORMALMOLE_HITS;
		this.loadImage(MOLE_IMAGE);
		this.imageview = new ImageView(IMAGE1);
		this.imageview.setX(this.x+40);
    	this.imageview.setY(this.y+50);
        this.imageview.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        this.rendered = 0;
		this.animation = new MoleAnimation(this,
				this.imageview,
                 Duration.millis(500),
                 COUNT, COLUMNS,
                 OFFSET_X, OFFSET_Y,
                 WIDTH, HEIGHT, root
         );
	
		
		
		
	}
	
	//render image
	public void render1(GraphicsContext gc){
		gc.drawImage(this.img, this.x, this.y);
    }
	


	protected void trytohit(){
		if(!hidden){this.hidden = false;}
	}
	protected Hole getHole() {return this.hole;}
	protected void reduceHits(){this.hit-=1;}
	public int getHits(){return this.hit;}
	protected void unhide(){this.hidden = false;}
	protected void setTime(int time){this.time = time;}
	protected void hide(){}
	protected void adjustSpeed(){}
	protected void getHit(){}
	protected boolean getHiddenStatus(){return this.hidden;}
	protected int addScore() {return this.score;}
	//Once mole is started decrement time by 1 every second
	//hide once time runs out
	public void run(){
		while(this.time>0){
			
			this.time = this.time-1;
			System.out.println(time);
			try{Thread.sleep(1000);}catch(InterruptedException e){}
		}
		System.out.println("HIDEEE");
		this.hidden = true;
		this.hole.hideMole();
		//animate the disappearing mole
		this.animation.setRate(-1);
		this.animation.play();

		
	}
	
	public void scorePop(GraphicsContext gc,double posx, double posy) {
		System.out.println(x);
		gc.drawImage(SCOREPOP, posx, posy);
	}
	

}