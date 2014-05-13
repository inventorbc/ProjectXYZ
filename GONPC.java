import static org.lwjgl.opengl.GL11.glColor3f;

import java.util.ArrayList;


public class GONPC extends GOCharacter {
	
	public GONPC(float x, float y, ArrayList<Ground> groundObjects)
	{
		super(x,y,groundObjects);
	}
	
	public void update()
	{
		super.update();
	}
	
	public void render()
	{
		glColor3f(0f,0f,0f);
		Draw.rect(x, y, SIZEX, SIZEY);
		glColor3f(0,0,0);
		Draw.rect(pos.x, pos.y, 1, 1);
	}
}
