import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Dino {
   private ArrayList<GameObject> objects;
   private GOPlayer player;
   private GONPC npc;
   
   public Dino()
   {
      objects = new ArrayList<GameObject>();
      GOSky sky = new GOSky();
      Ground ground = new Ground(0f, 0f);
      npc = new GONPC(50, 240, ground);
      player = new GOPlayer(100,240,ground);
      
      objects.add(sky);
      objects.add(ground);
      objects.add(npc);
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
		   player.move(2);
	   if(Keyboard.isKeyDown(Keyboard.KEY_A) || Keyboard.isKeyDown(Keyboard.KEY_LEFT))
		   player.move(-2);
   }
   
   public void render()
   {
      for( GameObject gO : objects )
         gO.render();
   }
}
