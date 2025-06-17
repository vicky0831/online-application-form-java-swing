/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package mini_project;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author Vicky
 */
public class Mini_Project extends JPanel {

    public static String Value1;
    
    public Mini_Project() {
        
    }
    
    

    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);

        CardLayout cardLayout = new CardLayout();
        JPanel cards = new JPanel(cardLayout);

        // Add both panels
        cards.add(new WelcomePage(cardLayout, cards), "WelcomePanel");
        cards.add(new ApplicationPage(cardLayout, cards, Value1), "ApplicationPanel");
        cards.add(new Course_Information(cardLayout, cards, Value1), "Course_Information");
        cards.add(new InformationPage(cardLayout, cards, Value1), "InformationPanel");
        
        frame.add(cards);
        frame.setVisible(true);
    }
}

// Use bCardLayout for page switching