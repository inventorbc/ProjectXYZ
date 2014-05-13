import static org.lwjgl.opengl.GL11.glColor3f;

import java.util.ArrayList;


public abstract class GOCharacter extends GameObjectPhysical {
	public static final float SIZEX = 30;
	public static final float SIZEY = 45;
	protected static final float TERMINALVELOCITY = 100;
	protected static final float MAXJUMPSPEED = 15;
	
	public float x;
	public float y;
	
	protected float jumpSpeed;
	protected float fallSpeed;
	protected float groundLevel;
	
	public boolean isJumping;
	public boolean isFalling;
	protected boolean canJump;
	protected boolean canMoveRight;
	protected boolean canMoveLeft;
	
	
	public ArrayList<Ground> groundObjects;
	
	public GOCharacter(float x, float y, ArrayList<Ground> groundObjects2)
	{
		this.x = x;
		this.y = y;
		
		groundLevel = y;
		fallSpeed = 0;
		jumpSpeed = MAXJUMPSPEED;
		
		pos = new Vector2Float();
		pos.x = x + SIZEX/2;
		pos.y = y + SIZEY/2;
		
		size = new Vector2Float();
		size.x = SIZEX/2;
		size.y = SIZEY/2;
		
		this.groundObjects = groundObjects2;
	}
	
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
		}
		else if(checkCollisionGround())
		{
		}
		
		if(checkCollisionGroundRight())
		{
			canMoveRight = false;
		}
		else if(checkCollisionGroundLeft())
		{
			canMoveLeft = false;
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
	
	public float checkInObjects()
	{
		for(int i = 0; i < groundObjects.size(); i++)
		{
			if(inside(this, groundObjects.get(i)))
			{
				isFalling = false;
				System.out.println("Inside another object");
				return groundObjects.get(i).y + groundObjects.get(i).sy + 15;
			}
		}
		return 0;
	}
	
	public boolean checkCollisionGround()
	{
		for(int i = 0; i < groundObjects.size(); i++)
		{
			if(predictCollides(this, groundObjects.get(i)))
			{
				fallSpeed = 0;
				isFalling = false;
				return true;
			}		
		}
		return false;
	}
	
	public boolean checkCollisionGroundRight()
	{
		for(int i = 0; i < groundObjects.size(); i++)
		{
			if(collidesSide(this, groundObjects.get(i)) == 1)
				return true;
		}
		return false;
	}
	
	public boolean checkCollisionGroundLeft()
	{
		for(int i = 0; i < groundObjects.size(); i++)
		{
			if(collidesSide(this, groundObjects.get(i)) == -1)
				return true;
		}
		return false;
	}
	
	public void moveRight(float mag)
	{
		if(canMoveRight)
		{
			x += mag;
		}
		
	}
	
	public void moveLeft(float mag)
	{
		if(canMoveLeft)
		{
			x -= mag;
		}
		
	}
	
	public void fall()
	{
		if (isFalling)
		{
			y -= fallSpeed;
			System.out.println("fallSpeed = " + fallSpeed);
			
			if(fallSpeed >= TERMINALVELOCITY)
			{
				return;
			} else {
				fallSpeed += 1;
			}
		}
	}
	
	public void jump()
	{
		if (isJumping )
		{
			y += jumpSpeed;
			System.out.println("jumpSpeed = " + jumpSpeed);
			jumpSpeed -= 1;
			if (jumpSpeed <= 0)
			{
				jumpSpeed = MAXJUMPSPEED;
				isJumping = false;
			}
		}
	}
}
