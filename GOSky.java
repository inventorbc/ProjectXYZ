import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.glColor3f;

public class GOSky extends GameObject {
	
	public GOSky()
	{
		this.x = 0;
		this.y = 0;
		this.sx = Display.getWidth();
		this.sy = Display.getHeight();
	}
	
	public void update()
	{
	}
	
	public void render()
	{
		glColor3f(0f,0.5f,1f);
		super.render();
	}
}
