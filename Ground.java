import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;

public class Ground extends GameObject
{
	public float rColor;
	public float gColor;
	public float height;
	public static float blockNumber = 0;
	
    public Ground()
    {
       this.x += blockNumber * (Display.getWidth()/6);
       this.y = 0;
       this.sx = Display.getWidth()/6;
       
       //initialize pos.
       pos = new Vector2Float();
       pos.x = x + sx/2;
       pos.y = y + ((sy + 10)/2);

       //initialize size.
       size = new Vector2Float();
       size.x = sx/2;
       size.y = (sy + 10)/2;
		
       blockNumber += 1;   //increase the number of blocks created as to keep count and place
                           //blocks in the right place
       
       //setup random color for the ground block
	   float rColorF = (float)Math.random();
	   float gColorF = (float)Math.random();
	   float heightF = (float)Math.random() * 400;
	   rColor = (rColorF < 0.5 && rColorF > 0.3 ? rColorF : 0.4f);
	   gColor = (gColorF < 0.7 && gColorF > 0.4 ? gColorF : 0.55f);
	   this.sy = (heightF < 200 && heightF > 50  ? heightF : 150);
    }
   
    @Override
    public void render()
    {
	    initGroundObjects();
    }
    
    //applying color values and drawing the ground blocks
    public void initGroundObjects()
    {
	    //dirt
    	//glColor3f(0.7f,0.45f,0.3f);
    	glColor3f(rColor,0.3f,0.3f);
    	Draw.rect(x,0,sx,sy);
    	
    	//grass
    	//glColor3f(0.7f,1f,0.3f);
    	glColor3f(0.6f,gColor,0.3f);
		Draw.rect(x,sy,sx,10);
		
    	pos.x = x + sx/2;
    	pos.y = y + ((sy + 10)/2);
    	
    	size.x = sx/2;
    	size.y = (sy + 10)/2;
    	
		glColor3f(1,1,1);
		Draw.rect(pos.x, pos.y, 1, 1);
    }
    public void update()
    {
    }
}
