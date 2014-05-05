import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel{
  JTextArea consoleField;
  public GamePanel( JTextArea consoleField ){
    this.consoleField = consoleField;
    addMouseListener( new MouseListener() {
      public void mouseEntered(MouseEvent e){
        appendConsole(e.toString());
      }
      public void mouseClicked(MouseEvent e){
        appendConsole(e.toString());
      }
      public void mouseExited(MouseEvent e){
        appendConsole(e.toString());
      }
      public void mouseReleased(MouseEvent e){
        appendConsole(e.toString());
      }
      public void mousePressed(MouseEvent e){
        appendConsole(e.toString());
      }
    }
    );
    
    adMouseMotionListener( new MouseMotionAdapter() {
       public void mouseDragged(MouseEvent e) {
          appendConsole(e.toString());
       }
       public void mouseMoved(MouseEvent e) {
         appendConsole(e.toString());
       }
    }
    );
    setBackground( Color.black );
  }
  
  public void appendConsole(String eventText) {
    GamePanel.this.consoleField.setText(eventText)
  }
}
