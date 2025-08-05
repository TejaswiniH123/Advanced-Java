package javalab7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Calculator");

        JTextField num1 = new JTextField(5);
        JTextField num2 = new JTextField(5);
        JTextField result = new JTextField(10);
        result.setEditable(false);

        JButton add = new JButton("+");
        JButton sub = new JButton("-");
        JButton mul = new JButton("*");
        JButton div = new JButton("/");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Num1:"));
        panel.add(num1);
        panel.add(new JLabel("Num2:"));
        panel.add(num2);
        panel.add(add); panel.add(sub); panel.add(mul); panel.add(div);
        panel.add(new JLabel("Result:"));
        panel.add(result);

        ActionListener action = e -> {
            int a = Integer.parseInt(num1.getText());
            int b = Integer.parseInt(num2.getText());
            int res = 0;
            if (e.getSource() == add) res = a + b;
            if (e.getSource() == sub) res = a - b;
            if (e.getSource() == mul) res = a * b;
            if (e.getSource() == div) res = a / b;
            result.setText("" + res);
        };

        add.addActionListener(action);
        sub.addActionListener(action);
        mul.addActionListener(action);
        div.addActionListener(action);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

