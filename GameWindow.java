import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JScrollPane;

public class GameWindow extends JFrame {
  private Container container;
  private GamePanel gamePanel;
  private JTextArea consoleField;
  public static int windowX = 600, windowY = 400;
  
  public GameWindow(){
    super("GameWindow");
    container = getContentPane();
    setUpGUI();
    gamePanel = new GamePanel( consoleField );
    gamePanel.setFocusable(true);
    container.add(gamePanel);
    setPreferredSize(new Dimension(windowX, windowY));
    setResizable(false);
    pack();
    setVisible(true);
  }
  
  public void setUpGUI(){
    consoleField = new JTextArea(3, 1);
    consoleField.setLineWrap(true);
    consoleField.setText("GameWindow console");
    container.add((new JScrollPane(consoleField)),
      BorderLayout.SOUTH);
  }
}
