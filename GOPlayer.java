import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

public class GOPlayer extends GOCharacter{
	public float gravityLimit;
	
	public static float cameraDeltaXP;
	public static float cameraDeltaYP;

	
	public GOPlayer(float x, float y, ArrayList<Ground> groundObjects)
	{
		super(x,y, groundObjects);
	}
	
	@Override
	public void update()
	{
		//update pos.
		pos.x = x + SIZEX/2;
		pos.y = y + SIZEY/2;
		
		//update size.
		size.x = SIZEX/2;
		size.y = SIZEY/2;
		
		if(!checkCollisionGround()){
			canJump = false;
			
			//if jumping at the moment wait
			if(!isJumping)
			{
				//reset falling attributes
				isFalling = true;
				fall();
			}
			
			Main.scrollCameraY(cameraDeltaYP -= 2);
		}
		else if(checkCollisionGround())
		{
		}
		
		if(checkCollisionGroundRight())
		{
			canMoveRight = false;
			System.out.println("can right " + canMoveRight + ", can left " + canMoveLeft);
		}
		else if(checkCollisionGroundLeft())
		{
			canMoveLeft = false;
			System.out.println("can right " + canMoveRight + ", can left " + canMoveLeft);
		}
		else
		{
			canMoveRight = true;
			canMoveLeft = true;
		}
		
		if(isJumping)
			jump();
	}
	
	public void render()
	{
		glColor3f(0f,1f,0f);
		Draw.rect(x, y, SIZEX, SIZEY);
		glColor3f(0,0,0);
		Draw.rect(pos.x, pos.y, 1, 1);
	}
	
	public void moveRight(float mag)
	{
		if(canMoveRight)
		{
			x += mag; 
			Main.scrollCameraX(cameraDeltaXP += mag);
		}
		
	}
	
	public void moveLeft(float mag)
	{
		if(canMoveLeft)
		{
			x -= mag;
			Main.scrollCameraX(cameraDeltaXP -= mag);
		}
		
	}
	
	public void setGravityLimit(float gravity)
	{
		gravityLimit = gravity;
	}
	
	public String toString()
	{
		return "y=" + y;
	}
}
