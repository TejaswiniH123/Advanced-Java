package javalab8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationGUI {
    private static JTextField nameField, usnField, emailField;
    private static JRadioButton maleButton, femaleButton, otherButton;
    private static JCheckBox codingCheckBox, musicCheckBox, sportsCheckBox;
    private static JLabel outputLabel, welcomeLabel;
    private static JTextArea additionalInfoArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Profile Picture", createProfileTab());
        tabbedPane.addTab("Registration Form", createFormTab());
        tabbedPane.addTab("Additional Info", createInfoTab());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    private static JPanel createProfileTab() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(230, 240, 250));

        ImageIcon profilePic = new ImageIcon("profile.png");
        JLabel picLabel = new JLabel(profilePic);
        picLabel.setHorizontalAlignment(JLabel.CENTER);

        welcomeLabel = new JLabel("Welcome, Student!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(picLabel, BorderLayout.CENTER);
        panel.add(welcomeLabel, BorderLayout.SOUTH);

        return panel;
    }

    private static JPanel createFormTab() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new JLabel("Name:"));
        nameField = new JTextField(20);
        namePanel.add(nameField);

        JPanel usnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        usnPanel.add(new JLabel("USN:"));
        usnField = new JTextField(20);
        usnPanel.add(usnField);

        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        emailPanel.add(new JLabel("Email:"));
        emailField = new JTextField(20);
        emailPanel.add(emailField);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(new JLabel("Gender:"));
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        otherButton = new JRadioButton("Other");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        genderPanel.add(otherButton);

        JPanel interestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        interestPanel.add(new JLabel("Interests:"));
        codingCheckBox = new JCheckBox("Coding");
        musicCheckBox = new JCheckBox("Music");
        sportsCheckBox = new JCheckBox("Sports");
        interestPanel.add(codingCheckBox);
        interestPanel.add(musicCheckBox);
        interestPanel.add(sportsCheckBox);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        outputLabel = new JLabel();
        outputLabel.setVerticalAlignment(JLabel.TOP);

        panel.add(namePanel);
        panel.add(usnPanel);
        panel.add(emailPanel);
        panel.add(genderPanel);
        panel.add(interestPanel);
        panel.add(buttonPanel);
        panel.add(outputLabel);

        return panel;
    }

    private static JPanel createInfoTab() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel infoLabel = new JLabel("Additional Information:");
        infoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(infoLabel, BorderLayout.NORTH);

        additionalInfoArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(additionalInfoArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private static void submitForm() {
        String name = nameField.getText().trim();
        String usn = usnField.getText().trim();
        String email = emailField.getText().trim();

        if (name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name and Email fields cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String gender = "";
        if (maleButton.isSelected()) gender = "Male";
        else if (femaleButton.isSelected()) gender = "Female";
        else if (otherButton.isSelected()) gender = "Other";

        String interests = "";
        if (codingCheckBox.isSelected()) interests += "Coding ";
        if (musicCheckBox.isSelected()) interests += "Music ";
        if (sportsCheckBox.isSelected()) interests += "Sports ";

        String additionalInfo = additionalInfoArea.getText().trim();

        outputLabel.setText("<html><b>Name:</b> " + name + "<br>"
                + "<b>USN:</b> " + usn + "<br>"
                + "<b>Email:</b> " + email + "<br>"
                + "<b>Gender:</b> " + gender + "<br>"
                + "<b>Interests:</b> " + interests + "<br>"
                + "<b>Additional Info:</b> " + additionalInfo.replaceAll("\n", "<br>") + "</html>");

        welcomeLabel.setText("Welcome, " + name + "!");
    }

    private static void clearForm() {
        nameField.setText("");
        usnField.setText("");
        emailField.setText("");
        maleButton.setSelected(false);
        femaleButton.setSelected(false);
        otherButton.setSelected(false);
        codingCheckBox.setSelected(false);
        musicCheckBox.setSelected(false);
        sportsCheckBox.setSelected(false);
        outputLabel.setText("");
        additionalInfoArea.setText("");

        welcomeLabel.setText("Welcome, Student!");
    }
}
