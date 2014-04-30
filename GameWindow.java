import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends JFrame {
  private Container container;
  private GamePanel gamePanel;
  private JTextField consoleField;
  public static int windowX = 500, windowY = 400;
  
  public GameWindow(){
    super("GameWindow");
    container = getContentPane();
    gamePanel = new GamePanel();
    gamePanel.setFocusable(true);
    container.add(gamePanel);
    setUpGUI();
    addMouseListener( new MouseAdapter() {
        public void mouseMoved(MouseEvent e){
          String event = e.toString();
          consoleField.setText(event);
        }
      }
    );
    setSize(windowX, windowY);
    setVisible(true);
  }
  
  public void setUpGUI(){
    consoleField = new JTextField();
    consoleField.setText("GameWindow console");
    container.add(consoleField, BorderLayout.SOUTH);
  }
}

class GamePanel extends JPanel{
  public GamePanel(){
    setBackground( Color.white );
  }
}

class GameTest {
  public static void main(String args[]){
    GameWindow application = new GameWindow();
    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
