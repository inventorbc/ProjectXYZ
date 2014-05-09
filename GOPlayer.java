import static org.lwjgl.opengl.GL11.*;

public class GOPlayer extends GameObject{
	public static final float SIZEX = 30;
	public static final float SIZEY = 45;
	private static final int JUMPMAXSPEED = 10;
	public static float x;
	public static float y;
	public float gravityLimit;
	public float groundLevel;
	
	public static boolean isJumping;
	private boolean climax = false;
	
	public Ground ground;
	private float jumpSpeed;
	
	public GOPlayer(float x, float y, Ground ground)
	{
		this.x = x;
		this.y = y;
		gravityLimit = 250;
		groundLevel = 240;
		jumpSpeed = JUMPMAXSPEED;
		this.ground = ground;
	}
	
	public void update()
	{
		if(Physics.checkCollision(this, ground))
		{
			//some stuff
		}
		
		if( isJumping )
			jump();
	}
	
	public void move(float mag)
	{
		x += mag;
	}
	
	public void jump()
	{
		if (isJumping )
		{
			
			y += jumpSpeed;
			System.out.println("jumpSpeed = " + jumpSpeed);
			jumpSpeed -= 1;
			if (jumpSpeed < -JUMPMAXSPEED)
			{
				jumpSpeed = JUMPMAXSPEED;
				isJumping = false;
			}
		}
		
		/*  Code to be deleted unless needed.
		 * 
		 *  For now, we'll keep it.
		 * 
		if (y > gravityLimit && climax == false)
		{
			climax = true;
			System.out.println("y > 250, reached climax");
		}
		if (y == groundLevel && isJumping) {
			isJumping = false;
			climax = false;
			System.out.println("isJumping = " + isJumping + "climax = " + climax);
		}
		else if (climax) {
			y -= 1;
			System.out.println("descending");
		}
		else if (!climax){
			y += 1;
			isJumping = true;
			System.out.println("still jumping, isJumping = true climax:" + climax);
		}
		*/
	}
	
	public void setGravityLimit(float gravity)
	{
		gravityLimit = gravity;
	}
	
	public void render()
	{
		glColor3f(1f,1f,1f);
		Draw.rect(x, y, SIZEX, SIZEY);
	}
	

}
