package mini_project;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Course_Information extends JPanel {

    private CardLayout cardLayout;
    private JPanel parentPanel;
    private JButton button;
    private JButton backButton;
    private String selectedCourse;
    
    private static final Color PANEL_BG = new Color(230, 240, 255);

    public Course_Information(CardLayout cardLayout, JPanel parentPanel, String courseKey) {
        this.cardLayout = cardLayout;
        this.parentPanel = parentPanel;
        this.selectedCourse = courseKey;

        setLayout(null); // Absolute positioning
        setBackground(PANEL_BG);
        
                // Back button at top right
        backButton = new JButton("← Back");
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        backButton.setBounds(850, 20, 100, 30);
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> {
            // Change to the previous card or welcome page (adjust name as per your cards)
            cardLayout.show(parentPanel, "ApplicationPanel");
        });
        add(backButton);

        Course selected = CourseData.courseMap.get(courseKey);

        if (selected != null) {
            // Left: Course Image
            ImageIcon icon = new ImageIcon(selected.getImagePath());
            Image scaledImg = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
            imageLabel.setBorder(new LineBorder(Color.BLACK, 2, true));
            imageLabel.setBounds(50, 50, 250, 250);
            add(imageLabel);

            // Vertical Separator Line
            JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
            separator.setBounds(330, 20, 3, 400);
            separator.setForeground(Color.GRAY);
            add(separator);

            // Right: Text Labels and Button
            JLabel titleLabel = new JLabel("<html><b>" + selected.getTitle() + "</b></html>");
            titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
            titleLabel.setBounds(360, 50, 550, 40);
            add(titleLabel);

            JTextArea descriptionArea = new JTextArea(selected.getDescription());
            descriptionArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            descriptionArea.setLineWrap(true);
            descriptionArea.setWrapStyleWord(true);
            descriptionArea.setEditable(false);
            descriptionArea.setBackground(PANEL_BG);
            descriptionArea.setBounds(360, 100, 550, 150);
            add(descriptionArea);

            JLabel durationLabel = new JLabel("Duration: " + selected.getDuration());
            durationLabel.setFont(new Font("Segoe UI", Font.ITALIC, 13));
            durationLabel.setBounds(360, 260, 200, 25);
            add(durationLabel);

            button = new JButton("Apply Now");
            button.setFont(new Font("Segoe UI", Font.BOLD, 14));
            button.setBounds(360, 310, 150, 40);
            button.setFocusPainted(false);
            button.addActionListener(e -> {
                InformationPage infoPage = new InformationPage(cardLayout, parentPanel, selectedCourse);
                parentPanel.add(infoPage, "InformationPanel");
                cardLayout.show(parentPanel, "InformationPanel");
            });
            add(button);

        } else {
            JLabel errorLabel = new JLabel("Course data not found.", SwingConstants.CENTER);
            errorLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
            errorLabel.setBounds(50, 50, 800, 100);
            add(errorLabel);
        }
    }

    // Test main method
    public static void main(String[] args) {
        CourseData.courseMap.put("java", new Course(
            "Java Programming",
            "Learn object-oriented programming using Java.",
            "6 weeks",
            "logo_bmi.png"
        ));

        JFrame frame = new JFrame("Course Info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cl = new CardLayout();
        JPanel parentPanel = new JPanel(cl);
        Course_Information courseInfo = new Course_Information(cl, parentPanel, "java");

        parentPanel.add(courseInfo, "CoursePage");
        frame.add(parentPanel);

        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
