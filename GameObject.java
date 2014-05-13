
public abstract class GameObject {
	
	protected float x;
	protected float y;
	protected float sx;
	protected float sy;
	protected Vector2Float pos;
	protected Vector2Float size;
	
	abstract void update();
	public void render()
	{
		Draw.rect(x,y,sx,sy);
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public float getSX()
	{
		return sx;
	}
	
	public float getSY()
	{
		return sy;
	}
	
	public float getCenterY()
	{
		return y + sy / 2;
	}
}
