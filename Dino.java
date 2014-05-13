import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Dino {
   private ArrayList<GameObject> objects;
   private ArrayList<Ground> groundObjects;
   private GOPlayer player;
   private GONPC npc1;
   private GONPC npc2;
   private GONPC npc3;
   
   public int groundArraySize = 25;
   
   public Dino()
   {
	  Display.setTitle("Dino v1.0");
	  
      objects = new ArrayList<GameObject>();
      groundObjects = new ArrayList<Ground>(groundArraySize);
      groundObjects.ensureCapacity(25);
      //npc2 = new GONPC(250, 240, ground);
      //npc3 = new GONPC(350, 240, ground);
      
      for(int i = 0; i < groundArraySize; i++)
      {
    	Ground ground = new Ground();
    	groundObjects.add(i, ground);
    	objects.add(ground);
      }
      player = new GOPlayer(Display.getWidth()/2 - GOPlayer.SIZEX/2,
    		  300-GOPlayer.SIZEY/2, groundObjects);
      //npc1 = new GONPC(300, 400, groundObjects);
      //objects.add(npc1);
      //objects.add(npc2);
      //objects.add(npc3);
      objects.add(player);
   }
   
   public void update()
   {
      for( GameObject gO : objects )
         gO.update();
   }
   
   public void getInput()
   {
	   if(Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
		   player.moveRight(2);
	   if(Keyboard.isKeyDown(Keyboard.KEY_A) || Keyboard.isKeyDown(Keyboard.KEY_LEFT))
		   player.moveLeft(2);
	   if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
	   {
		   if(player.canJump)
		   {
			   player.isJumping = true;
 			   player.jump();
		   }
	   }
   }
   
   public void render()
   {
      for( GameObject gO : objects )
         gO.render();
   }
}
