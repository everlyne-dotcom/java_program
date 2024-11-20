import java.awt.*;
import javax.swing.*;

public class PracticeGUI {
    public static void main(String[] args) {
        while (true) {
            // Display menu using JOptionPane
            String[] options = {"Rectangle", "Circle", "Triangle", "Exit"};
            String choice = (String) JOptionPane.showInputDialog(
                    null,
                    "Select a shape to display:",
                    "Shape Selector",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == null || choice.equals("Exit")) {
                JOptionPane.showMessageDialog(null, "Exiting...");
                break; // Exit the program
            }

            switch (choice) {
                case "Rectangle" -> displayRectangle();
                case "Circle" -> displayCircle();
                case "Triangle" -> displayTriangle();
                default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }

    private static void displayRectangle() {
        int length = getValidatedInput("Enter the length of the rectangle (1-20):", 1, 20);
        int width = getValidatedInput("Enter the width of the rectangle (1-20):", 1, 20);

        // Create and show the rectangle in a JPanel
        JFrame frame = new JFrame("Rectangle");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);

        frame.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < width; j++) {
                        g.fillRect(50 + j * 20, 50 + i * 20, 18, 18);
                    }
                }
            }
        });

        frame.setVisible(true);
    }

    private static void displayCircle() {
        int radius = getValidatedInput("Enter the radius of the circle (1-10):", 1, 10);

        // Create and show the circle in a JPanel
        JFrame frame = new JFrame("Circle");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);

        frame.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int centerX = 200, centerY = 200;
                g.drawOval(centerX - radius * 20, centerY - radius * 20, radius * 40, radius * 40);
            }
        });

        frame.setVisible(true);
    }

    private static void displayTriangle() {
        int height = getValidatedInput("Enter the height of the triangle (1-10):", 1, 10);

        // Create and show the triangle in a JPanel
        JFrame frame = new JFrame("Triangle");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);

        frame.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int startX = 200, startY = 50;
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j <= i; j++) {
                        g.fillOval(startX - i * 10 + j * 20, startY + i * 20, 18, 18);
                    }
                }
            }
        });

        frame.setVisible(true);
    }

    private static int getValidatedInput(String message, int min, int max) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(message);
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Operation canceled.");
                    System.exit(0);
                }
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a value between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            }
        }
    }
}