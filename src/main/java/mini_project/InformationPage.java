package mini_project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformationPage extends JPanel {

    private CardLayout cardLayout;
    private JPanel parentPanel;
    private String selectedCourse;

    // Form fields
    private JTextField nameField, icField, emailField;
    private JTextArea addressArea;

    public InformationPage(CardLayout cardLayout, JPanel parentPanel, String course) {
        this.cardLayout = cardLayout;
        this.parentPanel = parentPanel;
        this.selectedCourse = course;

        setLayout(null);
        setBackground(new Color(230, 240, 255));

        // Title
        JLabel titleLabel = new JLabel("User Information Form");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setBounds(370, 20, 400, 40);
        add(titleLabel);

        Font labelFont = new Font("Arial", Font.PLAIN, 20);
        Font fieldFont = new Font("Arial", Font.PLAIN, 18);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        nameLabel.setBounds(200, 100, 150, 30);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setFont(fieldFont);
        nameField.setBounds(350, 100, 350, 30);
        add(nameField);

        // IC
        JLabel icLabel = new JLabel("IC:");
        icLabel.setFont(labelFont);
        icLabel.setBounds(200, 150, 150, 30);
        add(icLabel);
        icField = new JTextField();
        icField.setFont(fieldFont);
        icField.setBounds(350, 150, 350, 30);
        add(icField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        emailLabel.setBounds(200, 200, 150, 30);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setFont(fieldFont);
        emailField.setBounds(350, 200, 350, 30);
        add(emailField);

        // Address
        JLabel addressLabel = new JLabel("Home Address:");
        addressLabel.setFont(labelFont);
        addressLabel.setBounds(200, 250, 150, 30);
        add(addressLabel);
        addressArea = new JTextArea();
        addressArea.setFont(fieldFont);
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(addressArea);
        scrollPane.setBounds(350, 250, 350, 80);
        add(scrollPane);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setBounds(350, 350, 150, 40);
        add(submitButton);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBounds(520, 350, 150, 40);
        add(backButton);

        // Submit Action
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = String.format("Name: %s\nIC: %s\nEmail: %s\nAddress: %s\nCourse: %s",
                        nameField.getText(),
                        icField.getText(),
                        emailField.getText(),
                        addressArea.getText(),
                        selectedCourse);

                String subject = "New User Information Submission";
                String instituteEmail = "bangimalaysianinstitute79@gmail.com"; // Replace with real email

                EmailSender.sendUserDetails(instituteEmail, subject, info);

                JOptionPane.showMessageDialog(null, "Thank you for submitting your information.\nWe will contact you soon via email.");
            }
        });

        // Back Action
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(parentPanel, "Course_Information");
            }
        });
    }

    public static void main(String[] args) {
        JFrame MyWindow = new JFrame("BMI");
        MyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout layout = new CardLayout();
        JPanel panel = new JPanel(layout);

        InformationPage infoPage = new InformationPage(layout, panel, "Sample Course");
        panel.add(infoPage, "Info");

        layout.show(panel, "Info");

        MyWindow.add(panel);
        MyWindow.setSize(1000, 500);
        MyWindow.setVisible(true);
    }
}