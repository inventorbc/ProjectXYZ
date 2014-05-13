
public abstract class GameObjectPhysical extends GameObject {

	@Override
	void update() {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean predictCollides(GOCharacter a, GameObject b)
	{
		float distance = Math.abs(a.y - (b.pos.y + (b.size.y)));
		float timeHit = distance/a.fallSpeed;
		if(timeHit >= 0 && timeHit <= 1 && Math.abs(a.pos.x - b.pos.x) < (a.size.x + b.size.x))
		{
			a.y = b.y + (2*b.size.y);
			a.groundLevel = a.y;
			a.isFalling = false;
			a.canJump = true;
			System.out.println("collided" + distance);
			return true;
		}
		return false;
	}
	
	public static boolean collides(GameObject a, GameObject b)
	{
		if(Math.abs(a.pos.x - b.pos.x) < a.size.x + b.size.x )
		{
			if(Math.abs(a.pos.y - b.pos.y) <= a.size.y + b.size.y + 0.5)
			{
				return true;
			}
			
		}
		return false;
	}
	
	public static int collidesSide(GameObject a, GameObject b)
	{
		//right
		if(a.pos.x - b.pos.x <= 0)
		{
			if(Math.abs(a.pos.x - b.pos.x) <= a.size.x + b.size.x + 1)
			{
				if(((a.pos.y - a.size.y) < b.pos.y + b.size.y) && ((a.pos.y - a.size.y) >=  b.pos.y  - b.size.y))
					return 1;
			}
		}
		
		//left
		if(a.pos.x - b.pos.x >= 0)
		{
			if(Math.abs(a.pos.x - b.pos.x) <= a.size.x + b.size.x + 1)
			{
				if(((a.pos.y - a.size.y)< b.pos.y + b.size.y) && ((a.pos.y - a.size.y) >=  b.pos.y  - b.size.y))
					return -1;
			}
		}
		return 0;
	}
	
	public static boolean inside(GameObject a, Vector2Float b)
	{
		if(Math.abs(a.pos.x - b.x) < a.size.x)
		{
			if(Math.abs(a.pos.y - b.y) < a.size.y)
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean inside(GameObject a, GameObject b)
	{
		if(Math.abs(a.pos.x - b.pos.x) < a.size.x + b.size.x)
		{
			if(Math.abs(a.pos.y - b.pos.y) < a.size.y + b.size.y)
			{
				return true;
			}
		}
		return false;
	}
}
