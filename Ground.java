import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;

public class Ground extends GameObject
{
   public static final int SIZEX = Display.getWidth();
   public static final int SIZEY = 200;//(int)(Math.random() * 200);
   public Ground(float x, float y)
   {
      this.x = x;
      this.y = y;
      this.sx = SIZEX;
      this.sy = SIZEY;

   }
   
   @Override
   public void render()
   {
	   //dirt
	   glColor3f(0.7f,0.45f,0.3f);
	   Draw.rect(0,0,sx,sy);
	   //grass
	   glColor3f(0.7f,1f,0.3f);
	   Draw.rect(0,sy,sx,sy/5);
   }
   public void update()
   {
   }
}
