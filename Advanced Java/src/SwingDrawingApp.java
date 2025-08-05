package javalab7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DrawingPanel extends JPanel implements MouseMotionListener {
    int mouseX = 0, mouseY = 0;
    Color shapeColor = Color.RED;
    JLabel label;

    DrawingPanel(JLabel label) {
        this.label = label;
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(400, 400));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(shapeColor);
        g.fillRect(50, 50, 100, 60);
        g.fillOval(200, 50, 100, 60);
        g.drawLine(50, 150, 250, 150);
    }

    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        label.setText("Mouse: (" + mouseX + ", " + mouseY + ")");
        repaint();
    }

    public void mouseDragged(MouseEvent e) {}
}

public class SwingDrawingApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Drawing");
        JLabel label = new JLabel("Mouse: (0, 0)");

        DrawingPanel panel = new DrawingPanel(label);
        JButton btnColor = new JButton("Change Color");
        btnColor.addActionListener(e -> {
            panel.shapeColor = Color.BLUE;
            panel.repaint();
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(btnColor, BorderLayout.SOUTH);
        frame.add(label, BorderLayout.NORTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
