import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends Frame implements MouseListener {

    public MouseEventDemo() {
        setSize(400, 300);
        setTitle("AWT Mouse Event Demo");

        addMouseListener(this);

        setVisible(true); // MUST be true, otherwise no events will work
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked at X: " + e.getX() + " Y: " + e.getY());
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered the Frame");
        setBackground(Color.GREEN); // visual effect instead of visibility
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exited the Frame");
        setBackground(Color.LIGHT_GRAY);
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    public static void main(String[] args) {
        new MouseEventDemo();
    }
}