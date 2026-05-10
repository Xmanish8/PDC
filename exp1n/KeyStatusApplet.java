import java.awt.*;
import java.awt.event.*;

public class KeyStatusApplet extends Frame implements KeyListener {

    String msg = "Press any key...";
    int x = 50, y = 150;

    public KeyStatusApplet() {

        addKeyListener(this);

        setBackground(Color.lightGray);

        setSize(400, 300);

        setVisible(true);

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {

                System.exit(0);
            }
        });
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

    public static void main(String args[]) {

        new KeyStatusApplet();
    }
}