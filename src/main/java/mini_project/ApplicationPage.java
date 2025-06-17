/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_project;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.AbstractButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 *
 * @author USER
 */
public class ApplicationPage extends JPanel {
    private JLabel Label, Label2, Label3, Label4;
    private ImageIcon Icon1;
    private CardLayout cardLayout;
    private JPanel parentPanel;
    
    public static String selectedCourse = "T1"; //Global Variable
    
    public ApplicationPage(CardLayout cardLayout, JPanel parentPanel, String Course){
        this.cardLayout = cardLayout;
        this.parentPanel = parentPanel;
        this.selectedCourse = Course;
        
        setLayout(new BorderLayout()); // For scroll pane to occupy full area
        setBackground(new Color(230, 240, 255));
        
        
        // Step 1: Create inner content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null); // Using absolute positioning for demonstration
        contentPanel.setPreferredSize(new Dimension(1000, 1000)); // Set preferred size to enable scrolling Scroll size
        contentPanel.setBackground(new Color(230, 240, 255));
        
        
        Icon1 = new ImageIcon("Logo_BMI_Rounded.png");
        Image img = Icon1.getImage();
        Image scaledImg = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH); // Set width and height to fit your desired size
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        JButton Label1 = new JButton(scaledIcon);
        Label1.setBounds(10,15,75,75);
        Label1.setBorderPainted(false);
        Label1.setContentAreaFilled(false); // Make it look like an image, not a button

        Label1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(parentPanel, "WelcomePanel"); // Go back to WelcomePage
            }
        });
        contentPanel.add(Label1);
        
        
        
        Label2 = new JLabel("Bangi-Malaysian Institute");
        Label2.setFont(new Font("Segoe UI", Font.ITALIC, 28));
        Label2.setBounds(346,25,400,40);
        contentPanel.add(Label2);
        
        
        // Step 2: Add ImageLabelButtonPanels to contentPanel
        ImageLabelButtonPanel panel1 = new ImageLabelButtonPanel("hydraulic.jpg", "Hydraulics Technology", "Apply Now");
        panel1.setBounds(75, 100, 250, 300);
        panel1.addButtonActionListener(e -> {
            
        selectedCourse = "Hydraulics Technology";           
        Course_Information coursePage = new Course_Information(cardLayout, parentPanel, selectedCourse);
        parentPanel.add(coursePage, "Course_Information");
        cardLayout.show(parentPanel, "Course_Information");
        
        });
        contentPanel.add(panel1);

        ImageLabelButtonPanel panel2 = new ImageLabelButtonPanel("Industrial_Robotics.jpg", "<html><div style='text-align: center;'>Fundamental Of Industrial<br>Robotics</div></html>", "Apply Now");
        panel2.setBounds(375, 100, 250, 300);
        
        panel2.addButtonActionListener(e -> {          
            selectedCourse = "Fundamental Of Industrial Robotics";           
            Course_Information coursePage = new Course_Information(cardLayout, parentPanel, selectedCourse);
            parentPanel.add(coursePage, "Course_Information");
            cardLayout.show(parentPanel, "Course_Information");
        });
        contentPanel.add(panel2);

        ImageLabelButtonPanel panel3 = new ImageLabelButtonPanel("PLC.jpg", "<html><div style='text-align: center;'>Programmable Logic Controlller<br>Advanced Programming</div></html>", "Apply Now");
        panel3.setBounds(675, 100, 250, 300);
        panel3.addButtonActionListener(e -> {          
            selectedCourse = "Programmable Logic Controller";           
            Course_Information coursePage = new Course_Information(cardLayout, parentPanel, selectedCourse);
            parentPanel.add(coursePage, "Course_Information");
            cardLayout.show(parentPanel, "Course_Information");
        });
        contentPanel.add(panel3);

        ImageLabelButtonPanel panel4 = new ImageLabelButtonPanel("Electrical_installation.jpg", "<html><div style='text-align: center;'>Electrical Installation</div></html>", "Apply Now");
        panel4.setBounds(75, 450, 250, 300);
        panel4.addButtonActionListener(e -> {          
            selectedCourse = "Electrical Installation";           
            Course_Information coursePage = new Course_Information(cardLayout, parentPanel, selectedCourse);
            parentPanel.add(coursePage, "Course_Information");
            cardLayout.show(parentPanel, "Course_Information");
        });
        contentPanel.add(panel4);
        
        
        // Step 3: Wrap contentPanel in JScrollPane
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // smoother scroll

        // Step 4: Add scrollPane to this main panel
        add(scrollPane, BorderLayout.CENTER);
    }
    
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        
    

    }
}
