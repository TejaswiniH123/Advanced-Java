package javalab7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StudentFinder {
    private static HashMap<Integer, String> studentDB = new HashMap<>();
    private static JTextArea displayArea = new JTextArea(10, 30);

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Finder");
        frame.setLayout(new FlowLayout());

        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JButton addBtn = new JButton("Add");
        JButton findBtn = new JButton("Find");
        JButton removeBtn = new JButton("Remove");
        JButton showAllBtn = new JButton("Show All");

        frame.add(new JLabel("ID:"));
        frame.add(idField);
        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(addBtn);
        frame.add(findBtn);
        frame.add(removeBtn);
        frame.add(showAllBtn);

        displayArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(displayArea);
        frame.add(scroll);

        addBtn.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            studentDB.put(id, name);
            JOptionPane.showMessageDialog(frame, "Student Added");
        });

        findBtn.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String name = studentDB.get(id);
            if (name != null)
                JOptionPane.showMessageDialog(frame, "Name: " + name);
            else
                JOptionPane.showMessageDialog(frame, "Student not found");
        });

        removeBtn.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            studentDB.remove(id);
            JOptionPane.showMessageDialog(frame, "Student Removed");
        });

        showAllBtn.addActionListener(e -> {
            displayArea.setText("");
            for (Map.Entry<Integer, String> entry : studentDB.entrySet())
                displayArea.append("ID: " + entry.getKey() + ", Name: " + entry.getValue() + "\n");
        });

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
