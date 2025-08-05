package javalab7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Student {
    String name, usn, branch;

    Student(String name, String usn, String branch) {
        this.name = name;
        this.usn = usn;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", USN: " + usn + ", Branch: " + branch;
    }
}

public class StudentForm extends JFrame implements ActionListener {
    JTextField nameField, usnField, branchField;
    JButton addBtn, clearBtn, viewAllBtn;
    JLabel displayLabel;

    ArrayList<Student> studentList = new ArrayList<>();

    StudentForm() {
        setTitle("Student Information Form");
        setLayout(new GridLayout(6, 2, 5, 5));
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("Enter Student Details"));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("USN:"));
        usnField = new JTextField();
        add(usnField);

        add(new JLabel("Branch:"));
        branchField = new JTextField();
        add(branchField);

        addBtn = new JButton("Add");
        clearBtn = new JButton("Clear");
        viewAllBtn = new JButton("View All");

        add(addBtn);
        add(clearBtn);
        add(viewAllBtn);

        displayLabel = new JLabel("");
        add(displayLabel);

        addBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        viewAllBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            String name = nameField.getText().trim();
            String usn = usnField.getText().trim();
            String branch = branchField.getText().trim();

            if (name.isEmpty() || usn.isEmpty() || branch.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Student student = new Student(name, usn, branch);
            studentList.add(student);

            JOptionPane.showMessageDialog(this, "Student added successfully!");
            clearFields();

        } else if (e.getSource() == clearBtn) {
            clearFields();

        } else if (e.getSource() == viewAllBtn) {
            if (studentList.isEmpty()) {
                displayLabel.setText("No students to display.");
            } else {
                StringBuilder sb = new StringBuilder("<html>");
                for (Student s : studentList) {
                    sb.append(s.toString()).append("<br>");
                }
                sb.append("</html>");
                displayLabel.setText(sb.toString());
            }
        }
    }

    private void clearFields() {
        nameField.setText("");
        usnField.setText("");
        branchField.setText("");
        displayLabel.setText("");
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}
