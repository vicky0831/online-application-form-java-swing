/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
 * @author Vicky
 */
public class WelcomePage extends JPanel {

    private JLabel Label1, Label2, Label3, Label4;
    private ImageIcon Icon1;
    private JTextArea infoArea;
    private JButton startButton;

    public WelcomePage(CardLayout cardLayout, JPanel parentPanel) {

        Icon1 = new ImageIcon("Logo_BMI.png");
        super.setLayout(null);
        setBackground(new Color(230, 240, 255));  // Set background color here
        Image img = Icon1.getImage();
        Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Set width and height to fit your desired size
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        Label1 = new JLabel(scaledIcon);
        Label1.setLocation(100,50);
        Label1.setSize(200, 200);
        Label1.setBorder(new LineBorder(Color.BLACK,2,true));       
        add(Label1);
        
        Label2 = new JLabel("<html><div style='text-align: center;'>Welcome to<br>Bangi Malaysian Institute, where we empower youth with industry-relevant skills.</div></html>");
        Label2.setFont(new Font("Segoe UI", Font.ITALIC, 22));
        Label2.setForeground(new Color(30, 30, 60)); // Dark navy ton
        Label2.setLocation(40,240);
        Label2.setSize(300, 200);
        add(Label2);
        
        
        JSeparator line = new JSeparator(SwingConstants.VERTICAL);
        line.setBounds(400, 0, 800, 1000); // x, y, width, height (height is thickness)
        line.setForeground(Color.BLACK); // line color
        add(line);
        
                // Center content with vision, mission, benefits
        infoArea = new JTextArea();
        infoArea.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
        infoArea.setEditable(false);
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);
        infoArea.setLocation(420,20);
        infoArea.setSize(540, 330);
        infoArea.setOpaque(true);
        infoArea.setBackground(new Color(245, 250, 255)); // slightly different for contrast
        infoArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));       
        infoArea.setMargin(new Insets(55, 25, 10, 15)); // top, left, bottom, right
        
        String content = """
                  🎯 VISION:
                    "To be a leading institute in empowering youth with industry-relevant technical \n     and vocational skills that drive innovation and national development."

                  🛠️ MISSION:
                    • Provide high-quality short-term TVET courses tailored to industry needs.
                    • Equip school leavers with practical, job-ready skills.
                    • Promote lifelong learning and career advancement opportunities.
                    • Collaborate with industry partners for real-world training.
                    • Nurture creativity, discipline, and work ethics among future professionals.

                  🌟 BENEFITS:
                    1. Industry-Relevant Skills - Hands-on training based on industry needs.
                    2. Fast-Track Learning - Complete programs in 2–6 weeks.
                    3. Career-Ready Certification - Boost your employment value.
                    4. Affordable Education - Low-cost with high returns.
                    5. Flexible Learning - Weekend and evening classes available.
                    6. Pathway to Employment - Connect with potential employers.
                    7. Supportive Environment - Experienced, industry-based instructors.
                """;

        infoArea.setText(content);
        add(infoArea);

        
        startButton = new JButton("Start Application ▶");
        startButton.setFont(new Font("Arial Unicode MS", Font.BOLD, 14));
        startButton.setLocation(600,385);
        startButton.setSize(170,40);
        //startButton.setActionCommand("Next");
        startButton.addActionListener(e -> {
            // Switch to next card
            cardLayout.show(parentPanel, "ApplicationPanel");
        });
        add(startButton);
    }
    
    

    public static void main(String[] args) {
        JFrame MyWindow = new JFrame("BMI");
        MyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyWindow.add(new Mini_Project());
        MyWindow.setSize(1000, 500);
        MyWindow.setVisible(true);
    }
}

// Use bCardLayout for page switching