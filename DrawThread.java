import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JTextField;

public class DrawThread extends Thread {
   Graphics g;
   GamePanel gamePanel;
   JTextField consoleField;
   private final Color DAY = new Color(0, 250, 250);
   private final Color NIGHT = new Color(0, 0, 0);
   Color skyColor;
   public DrawThread(Graphics g, GamePanel gamePanel, JTextField consoleField) {
      this.g = g;
      this.gamePanel = gamePanel;
      this.consoleField = consoleField;
   }
   public void run() {
      for (int i = 0; i <= 250; i++) {
         for (int j = 0; i <= 250; i++)
         {
            gamePanel.setBackground(new Color(0, i, i));
         }
      }
      
   }

}
