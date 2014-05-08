public class Ground extends GameObject
{
   public static final int SIZEX = Display.getWidth();
   public static final int SIZEY = 20;
   public Ground(float x, float y)
   {
      this.x = x;
      this.y = y;
      this.sx = SIZEX;
      this.sy = SIZEY;
   }
   public void update()
   {
   }
}
