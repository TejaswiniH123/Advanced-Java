package javalab7;
import java.awt.*;
import java.awt.event.*;

public class AWTCalculator {
    public static void main(String[] args) {
        Frame frame = new Frame("AWT Calculator");

        TextField num1 = new TextField(5);
        TextField num2 = new TextField(5);
        TextField result = new TextField(10);
        result.setEditable(false);

        Button add = new Button("+");
        Button sub = new Button("-");
        Button mul = new Button("*");
        Button div = new Button("/");

        Panel panel = new Panel();
        panel.add(new Label("Num1:"));
        panel.add(num1);
        panel.add(new Label("Num2:"));
        panel.add(num2);
        panel.add(add); panel.add(sub); panel.add(mul); panel.add(div);
        panel.add(new Label("Result:"));
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
    }
}
