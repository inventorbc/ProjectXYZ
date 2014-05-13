import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glTranslatef;

/**
 * 
 * @author inven_000
 *
 */

public class Main {
	
	private static Dino game;
	
	public static long lastFrame;

	private static float cameraX;

	private static float cameraY;
	
	public static void main(String args[])
	{
		//Initialize program
		initDisplay();
		initGL();
		
		lastFrame = getTime();
		getDelta();
		
		initGame();
		
		gameLoop();
		cleanUp();
	}
	
	private static void initGame()
	{
		game = new Dino();
	}
	
	private static void getInput()
	{
		game.getInput();
	}
	
	private static void update()
	{
		game.update();
	}
	
	private static void render()
	{
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();

		game.render();

		Display.update();
		Display.sync(60);
	}
	
	private static void gameLoop()
	{
		while(!Display.isCloseRequested())
		{
			getInput();
			update();
			initGL();
			render();
		}
	}
	
	private static void initGL()
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,Display.getWidth(),0,Display.getHeight(),-1,1);
		glTranslatef(-cameraX,0f,0f);
		glMatrixMode(GL_MODELVIEW);
		glClearColor(0.6f,1,1,1);
		
		glDisable(GL_DEPTH_TEST);
	}
	
	private static void cleanUp()
	{
		Display.destroy();
		Keyboard.destroy();
	}
	
	private static void initDisplay()
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
			Display.setVSyncEnabled(true);
			Keyboard.create();
		}
		catch(LWJGLException ex)
		{
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static long getTime() 
	{
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public static int  getDelta()
	{
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		
		return delta;
	}
	
	public static void scrollCameraX(float x)
	{
		cameraX = x;
	}
	
	public static void scrollCameraY(float y)
	{
		cameraY = y;
	}
}
