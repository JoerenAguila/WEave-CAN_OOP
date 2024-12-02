import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

// Swing-based Inventory System GUI
public class InventorySystemGUI {

    private static ArrayList<Product> inventory = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize sample products
        inventory.add(new Shawl(30.0, 10, "Cotton", "Bayawak"));
        inventory.add(new Bag(20.0, 20, "Abaca", "Binakul"));
        inventory.add(new Facemask(15.0, 30, "Fibres", "Binituwon"));
        inventory.add(new Hairband(10.0, 40, "Pineapple", "Bunga-sama"));
        inventory.add(new Pants(45.0, 12, "Cotton", "Palipattang"));
        inventory.add(new Skirt(35.0, 10, "Abaca", "Tinaggu"));
        inventory.add(new Shirt(25.0, 25, "Fibres", "Bayawak"));

        // Set up the main GUI frame
        JFrame frame = new JFrame("WEave CAN: Inventory and Order Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Create title
        JLabel title = new JLabel("WEave CAN: Inventory and Order Management System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(title, BorderLayout.NORTH);

        // Create buttons for actions
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));
        JButton viewInventoryButton = new JButton("View Inventory");
        JButton createOrderButton = new JButton("Create Order");
        JButton adminPanelButton = new JButton("Admin Panel");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(viewInventoryButton);
        buttonPanel.add(createOrderButton);
        buttonPanel.add(adminPanelButton);
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Add action listeners for buttons
        viewInventoryButton.addActionListener(e -> displayInventory());
        createOrderButton.addActionListener(e -> createOrder());
        adminPanelButton.addActionListener(e -> showAdminPanel());
        exitButton.addActionListener(e -> System.exit(0));

        // Show the frame
        frame.setVisible(true);
    }

    private static void displayInventory() {
        JFrame inventoryFrame = new JFrame("Inventory");
        inventoryFrame.setSize(600, 400);

        String[] columnNames = {"No", "Product", "Price", "Stock", "Material", "Pattern", "Sold"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        int productNumber = 1;
        for (Product product : inventory) {
            tableModel.addRow(new Object[]{
                    productNumber++,
                    product.getClass().getSimpleName(),
                    product.getPrice(),
                    product.getStock(),
                    product.getMaterial(),
                    product.getPattern(),
                    product.getSold()
            });
        }

        JTable table = new JTable(tableModel);
        inventoryFrame.add(new JScrollPane(table));
        inventoryFrame.setVisible(true);
    }

    private static void createOrder() {
        JFrame orderFrame = new JFrame("Create Order");
        orderFrame.setSize(400, 300);
        orderFrame.setLayout(new GridLayout(7, 2, 5, 5));

        JTextField customerNameField = new JTextField();
        JTextField contactNumberField = new JTextField();
        JComboBox<String> productComboBox = new JComboBox<>();
        JTextField quantityField = new JTextField();
        JLabel totalLabel = new JLabel();

        for (Product product : inventory) {
            productComboBox.addItem(product.getClass().getSimpleName());
        }

        JButton calculateButton = new JButton("Calculate Total");
        JButton placeOrderButton = new JButton("Place Order");

        orderFrame.add(new JLabel("Customer Name:"));
        orderFrame.add(customerNameField);
        orderFrame.add(new JLabel("Contact Number:"));
        orderFrame.add(contactNumberField);
        orderFrame.add(new JLabel("Select Product:"));
        orderFrame.add(productComboBox);
        orderFrame.add(new JLabel("Quantity:"));
        orderFrame.add(quantityField);
        orderFrame.add(new JLabel("Total:"));
        orderFrame.add(totalLabel);

        orderFrame.add(calculateButton);
        orderFrame.add(placeOrderButton);

        calculateButton.addActionListener(e -> {
            int selectedProductIndex = productComboBox.getSelectedIndex();
            int quantity = Integer.parseInt(quantityField.getText());
            Product selectedProduct = inventory.get(selectedProductIndex);

            if (quantity > selectedProduct.getStock()) {
                JOptionPane.showMessageDialog(orderFrame, "Not enough stock!");
            } else {
                double total = selectedProduct.getPrice() * quantity;
                totalLabel.setText(String.valueOf(total));
            }
        });

        placeOrderButton.addActionListener(e -> {
            int selectedProductIndex = productComboBox.getSelectedIndex();
            int quantity = Integer.parseInt(quantityField.getText());
            Product selectedProduct = inventory.get(selectedProductIndex);

            if (quantity > selectedProduct.getStock()) {
                JOptionPane.showMessageDialog(orderFrame, "Not enough stock!");
            } else {
                selectedProduct.setStock(selectedProduct.getStock() - quantity);
                selectedProduct.increaseSold(quantity);
                double total = selectedProduct.getPrice() * quantity;

                orders.add(new Order(selectedProduct, quantity, customerNameField.getText(), orders.size() + 1, total, contactNumberField.getText()));
                JOptionPane.showMessageDialog(orderFrame, "Order placed successfully!");
                orderFrame.dispose();
            }
        });

        orderFrame.setVisible(true);
    }

    private static void showAdminPanel() {
        JFrame adminFrame = new JFrame("Admin Panel");
        adminFrame.setSize(400, 200);
        adminFrame.setLayout(new GridLayout(2, 1, 10, 10));

        JButton restockButton = new JButton("Restock Product");
        JButton adjustPriceButton = new JButton("Adjust Product Price");

        restockButton.addActionListener(e -> restockProduct());
        adjustPriceButton.addActionListener(e -> adjustProductPrice());

        adminFrame.add(restockButton);
        adminFrame.add(adjustPriceButton);

        adminFrame.setVisible(true);
    }

    private static void restockProduct() {
        String[] productNames = inventory.stream().map(p -> p.getClass().getSimpleName()).toArray(String[]::new);

        String selectedProduct = (String) JOptionPane.showInputDialog(
                null, "Select Product to Restock:", "Restock Product",
                JOptionPane.QUESTION_MESSAGE, null, productNames, productNames[0]);

        if (selectedProduct != null) {
            Product product = inventory.stream()
                    .filter(p -> p.getClass().getSimpleName().equals(selectedProduct))
                    .findFirst()
                    .orElse(null);

            if (product != null) {
                String stockInput = JOptionPane.showInputDialog("Enter amount to restock:");
                try {
                    int additionalStock = Integer.parseInt(stockInput);
                    if (additionalStock > 0) {
                        product.setStock(product.getStock() + additionalStock);
                        JOptionPane.showMessageDialog(null, "Stock updated successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid stock amount!");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                }
            }
        }
    }

    private static void adjustProductPrice() {
        String[] productNames = inventory.stream().map(p -> p.getClass().getSimpleName()).toArray(String[]::new);

        String selectedProduct = (String) JOptionPane.showInputDialog(
                null, "Select Product to Adjust Price:", "Adjust Product Price",
                JOptionPane.QUESTION_MESSAGE, null, productNames, productNames[0]);

        if (selectedProduct != null) {
            Product product = inventory.stream()
                    .filter(p -> p.getClass().getSimpleName().equals(selectedProduct))
                    .findFirst()
                    .orElse(null);

            if (product != null) {
                String priceInput = JOptionPane.showInputDialog("Enter new price:");
                try {
                    double newPrice = Double.parseDouble(priceInput);
                    if (newPrice > 0) {
                        product.setPrice(newPrice);
                        JOptionPane.showMessageDialog(null, "Price updated successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid price!");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid price.");
                }
            }
        }
    }
}
