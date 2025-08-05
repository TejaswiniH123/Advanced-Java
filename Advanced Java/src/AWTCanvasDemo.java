package javalab7;
import java.awt.*;
import java.awt.event.*;

class MyCanvas extends Canvas implements MouseMotionListener {
    int mouseX = 0, mouseY = 0;
    Color shapeColor = Color.RED;

    MyCanvas() {
        addMouseMotionListener(this);
        setSize(400, 400);
    }

    public void paint(Graphics g) {
        g.setColor(shapeColor);
        g.fillRect(50, 50, 100, 60);
        g.fillOval(200, 50, 100, 60);
        g.drawLine(50, 150, 250, 150);

        g.setColor(Color.BLACK);
        g.drawString("Mouse: (" + mouseX + ", " + mouseY + ")", 20, 20);
    }

    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent e) {}
}

public class AWTCanvasDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("AWT Canvas Demo");
        MyCanvas canvas = new MyCanvas();

        Button btnColor = new Button("Change Color");
        btnColor.addActionListener(e -> {
            canvas.shapeColor = Color.BLUE;
            canvas.repaint();
        });

        frame.add(canvas, BorderLayout.CENTER);
        frame.add(btnColor, BorderLayout.SOUTH);
        frame.setSize(500, 500);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    }
}
