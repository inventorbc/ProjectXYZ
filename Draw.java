import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;


public class Draw {
	
	public static void rect(float x, float y, float width, float height)
	{
		glPushMatrix();
		{
			glTranslatef(x,y,0);
		
			glBegin(GL_QUADS);
			{
				glVertex2f(0,0);
				glVertex2f(0,height);
				glVertex2f(width,height);
				glVertex2f(width,0);
			}
			glEnd();
		} 	
		glPopMatrix();
	}
}
