import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/* <applet code="KeyStatusApplet" width=400 height=300></applet> */

public class KeyStatusApplet extends Applet implements KeyListener {

    String msg = "Click here and press any key...";
    int x = 50, y = 150;

    public void init() {
        addKeyListener(this);
        setBackground(Color.lightGray);

        setFocusable(true);   // allow focus
        requestFocus();       // request focus automatically
    }

    public void keyPressed(KeyEvent ke) {
        msg = "Key Down: " + ke.getKeyChar();
        repaint();
    }

    public void keyReleased(KeyEvent ke) {
        msg = "Key Released: " + ke.getKeyChar();
        repaint();
    }

    public void keyTyped(KeyEvent ke) {
        msg = "Key Typed: " + ke.getKeyChar();
        repaint();
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(msg, x, y);
    }
}