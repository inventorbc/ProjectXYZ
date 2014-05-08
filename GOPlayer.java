import static org.lwjgl.opengl.GL11.*;

public class GOPlayer extends GameObject{
	public static final float SIZEX = 30;
	public static final float SIZEY = 45;
	public static float x;
	public static float y;
	
	public Ground ground;
	
	public GOPlayer(float x, float y, Ground ground)
	{
		this.x = x;
		this.y = y;
		this.ground = ground;
	}
	
	public void update()
	{
		if(Physics.checkCollision(this, ground))
		{
			//some stuff
		}
	}
	
	public void move(float mag)
	{
		x += mag;
	}
	
	public void render()
	{
		glColor3f(1f,1f,1f);
		Draw.rect(x, y, SIZEX, SIZEY);
	}
}
