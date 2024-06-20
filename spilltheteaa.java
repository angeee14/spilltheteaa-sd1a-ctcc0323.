import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpillTheTea {
    private static JFrame frame;
    private static JPanel loginPanel;
    private static JPanel orderPanel;

    public static void main(String[] args) {
        frame = new JFrame("Food and Milk Tea Ordering System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new CardLayout());

        createLoginPanel();
        createOrderPanel();

        frame.add(loginPanel, "login");
        frame.add(orderPanel, "order");

        showLoginPanel();

        frame.setVisible(true);
    }

    private static void createLoginPanel() {
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                
                // Basic authentication (replace with real authentication)
                if (username.equals("PonPon") && password.equals("Ponpon123")) {
                    showOrderPanel();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password");
                }
            }
        });

        loginPanel.add(userLabel);
        loginPanel.add(userField);
        loginPanel.add(passLabel);
        loginPanel.add(passField);
        loginPanel.add(loginButton);
    }

    private static void createOrderPanel() {
        orderPanel = new JPanel();
        orderPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Order your food and milk tea", JLabel.CENTER);
        orderPanel.add(label, BorderLayout.NORTH);

        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridLayout(5, 2));

        // Sample items (you can add more and make it dynamic)
        String[] foods = {"Burger", "Pizza", "Sandwich"};
        String[] drinks = {"Milk Tea", "Green Tea", "Black Tea"};

        for (String food : foods) {
            JCheckBox checkBox = new JCheckBox(food);
            itemsPanel.add(checkBox);
        }

        for (String drink : drinks) {
            JCheckBox checkBox = new JCheckBox(drink);
            itemsPanel.add(checkBox);
        }

        JButton orderButton = new JButton("Place Order");

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Order placed successfully!");
            }
        });

        orderPanel.add(itemsPanel, BorderLayout.CENTER);
        orderPanel.add(orderButton, BorderLayout.SOUTH);
    }

    private static void showLoginPanel() {
        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
        cl.show(frame.getContentPane(), "login");
    }

    private static void showOrderPanel() {
        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
        cl.show(frame.getContentPane(), "order");
    }
}
