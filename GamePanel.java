import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel{
  JTextArea consoleField;
  public GamePanel( JTextArea consoleField ){
    this.consoleField = consoleField;
    addMouseListener( new MouseAdapter() {
      public void mouseEntered(MouseEvent e){
        String event = e.toString();
        GamePanel.this.consoleField.setText(event);
      }
      public void mouseClicked(MouseEvent e){
        String event = e.toString();
        GamePanel.this.consoleField.setText(event);
      }
      public void mouseExited(MouseEvent e){
        String event = e.toString();
        GamePanel.this.consoleField.setText(event);
      }
      public void mouseReleased(MouseEvent e){
        String event = e.toString();
        GamePanel.this.consoleField.setText(event);
      }
      public void mousePressed(MouseEvent e){
        String event = e.toString();
        GamePanel.this.consoleField.setText(event);
      }
    }
    );
    setBackground( Color.black );
  }
}
