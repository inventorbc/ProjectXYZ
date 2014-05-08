import static org.lwjgl.opengl.GL11.glColor3f;


public class GONPC extends GameObject {
	
	public static final float SIZEX = 30;
	public static final float SIZEY = 45;
	private float x;
	private float y;
	
	private boolean willMove;
	private boolean isRight;
	
	public Ground ground;
	
	public GONPC(float x, float y, Ground ground)
	{
		this.x = x;
		this.y = y;
		
		willMove = false;
		isRight = true;
		
		this.ground = ground;
	}
	
	public void update()
	{
		System.out.println("In update");
		if(Physics.checkCollision(this, ground))
		{
			//some stuff
		}
		
		move(1);
		
		int decision = (int) (Math.random() * 100);
		
		//see if decision will equal to 2 (1:100 chance)
		if( decision == 2 )
		{
			setWillMove(true, true);
			
		//see if decision will equal to 3 (1:100 chance)
		} else if( decision == 3 ){
			
			setWillMove(true, false);
		} else if( decision == 4 ) {
			
			setWillMove(false);
		}
	}
	
	public void setWillMove(boolean willMove, boolean isRight)
	{
		this.willMove = willMove;
		this.isRight = isRight;
	}
	
	public void setWillMove(boolean willMove)
	{
		this.willMove = willMove;
	}
	
	public void move(float mag)
	{
		if(willMove && isRight)
			x += mag;
		else if(willMove && !isRight)
			x -= mag;
		else
			return;
	}
	
	public void render()
	{
		glColor3f(1f,1f,1f);
		Draw.rect(x, y, SIZEX, SIZEY);
	}
}
