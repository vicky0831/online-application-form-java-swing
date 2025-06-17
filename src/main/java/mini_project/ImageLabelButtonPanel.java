package mini_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class ImageLabelButtonPanel extends JPanel {

    private static final Color PANEL_BG = new Color(220, 235, 250);  // Light blue background
    private JButton button; // Declare at class level
    
    public ImageLabelButtonPanel(String imagePath, String labelText, String buttonText) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        setBackground(PANEL_BG);  // Set background for main panel

        // Image with top margin
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImg = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(PANEL_BG);  // Apply same background
        imagePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); // Top margin
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        add(imagePanel, BorderLayout.NORTH);
        
        // Text Label
        JLabel textLabel = new JLabel(labelText, SwingConstants.CENTER);
        textLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        textLabel.setOpaque(true);
        textLabel.setBackground(PANEL_BG);  // Apply background to label too
        add(textLabel, BorderLayout.CENTER);

        // Button
         button = new JButton(buttonText);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setFocusPainted(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(PANEL_BG);  // Apply background
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); // Bottom margin: 20px
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void addButtonActionListener(ActionListener listener) {
        button.addActionListener(listener);
    }
}
