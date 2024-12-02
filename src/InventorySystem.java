import java.util.ArrayList;
import java.util.Scanner;

// Abstract class representing a generic product
// Abstraction: Hides the complex details and only exposes essential properties and methods.
abstract class Product {
    private double price;      // Encapsulation: Restricting direct access to price.
    private int stock;         // Encapsulation: Restricting direct access to stock.
    private String material;   // Encapsulation: Restricting direct access to material.
    private String pattern;    // Encapsulation: Restricting direct access to pattern.
    private int sold;          // Encapsulation: Restricting direct access to sold count.

    // Constructor to initialize the product properties
    public Product(double price, int stock, String material, String pattern) {
        this.price = price;
        this.stock = stock;
        this.material = material;
        this.pattern = pattern;
        this.sold = 0;
    }

    // Getter and Setter methods (Encapsulation: controlling access to fields)
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public String getPattern() { return pattern; }
    public void setPattern(String pattern) { this.pattern = pattern; }
    public int getSold() { return sold; }
    public void increaseSold(int quantity) { this.sold += quantity; }

    // Abstract method to be implemented by subclasses (Polymorphism: allowing different behaviors in different subclasses)
    public abstract void displayDetails(int productNumber);
}

// Concrete subclass of Product, representing a Shawl (Inheritance: Shawl is a type of Product)
class Shawl extends Product {
    public Shawl(double price, int stock, String material, String pattern) {
        super(price, stock, material, pattern);
    }

    // Implementing the abstract method to display details specific to Shawl
    @Override
    public void displayDetails(int productNumber) {
        System.out.printf("| %-3d | %-16s | %-8.2f | %-8d | %-15s | %-15s | %-5d |\n",
            productNumber, "Shawl", getPrice(), getStock(), getMaterial(), getPattern(), getSold());
    }
}

// Concrete subclass of Product, representing a Bag (Inheritance: Bag is a type of Product)
class Bag extends Product {
    public Bag(double price, int stock, String material, String pattern) {
        super(price, stock, material, pattern);
    }

    // Implementing the abstract method to display details specific to Bag
    @Override
    public void displayDetails(int productNumber) {
        System.out.printf("| %-3d | %-16s | %-8.2f | %-8d | %-15s | %-15s | %-5d |\n",
            productNumber, "Bag", getPrice(), getStock(), getMaterial(), getPattern(), getSold());
    }
}

// Concrete subclass of Product, representing a Facemask (Inheritance: Facemask is a type of Product)
class Facemask extends Product {
    public Facemask(double price, int stock, String material, String pattern) {
        super(price, stock, material, pattern);
    }

    // Implementing the abstract method to display details specific to Facemask
    @Override
    public void displayDetails(int productNumber) {
        System.out.printf("| %-3d | %-16s | %-8.2f | %-8d | %-15s | %-15s | %-5d |\n",
            productNumber, "Facemask", getPrice(), getStock(), getMaterial(), getPattern(), getSold());
    }
}

// Concrete subclass of Product, representing a Hairband (Inheritance: Hairband is a type of Product)
class Hairband extends Product {
    public Hairband(double price, int stock, String material, String pattern) {
        super(price, stock, material, pattern);
    }

    // Implementing the abstract method to display details specific to Hairband
    @Override
    public void displayDetails(int productNumber) {
        System.out.printf("| %-3d | %-16s | %-8.2f | %-8d | %-15s | %-15s | %-5d |\n",
            productNumber, "Hairband", getPrice(), getStock(), getMaterial(), getPattern(), getSold());
    }
}

// Concrete subclass of Product, representing Pants (Inheritance: Pants is a type of Product)
class Pants extends Product {
    public Pants(double price, int stock, String material, String pattern) {
        super(price, stock, material, pattern);
    }

    // Implementing the abstract method to display details specific to Pants
    @Override
    public void displayDetails(int productNumber) {
        System.out.printf("| %-3d | %-16s | %-8.2f | %-8d | %-15s | %-15s | %-5d |\n",
            productNumber, "Pants", getPrice(), getStock(), getMaterial(), getPattern(), getSold());
    }
}

// Concrete subclass of Product, representing Skirt (Inheritance: Skirt is a type of Product)
class Skirt extends Product {
    public Skirt(double price, int stock, String material, String pattern) {
        super(price, stock, material, pattern);
    }

    // Implementing the abstract method to display details specific to Skirt
    @Override
    public void displayDetails(int productNumber) {
        System.out.printf("| %-3d | %-16s | %-8.2f | %-8d | %-15s | %-15s | %-5d |\n",
            productNumber, "Skirt", getPrice(), getStock(), getMaterial(), getPattern(), getSold());
    }
}

// Concrete subclass of Product, representing Shirt (Inheritance: Shirt is a type of Product)
class Shirt extends Product {
    public Shirt(double price, int stock, String material, String pattern) {
        super(price, stock, material, pattern);
    }

    // Implementing the abstract method to display details specific to Shirt
    @Override
    public void displayDetails(int productNumber) {
        System.out.printf("| %-3d | %-16s | %-8.2f | %-8d | %-15s | %-15s | %-5d |\n",
            productNumber, "Shirt", getPrice(), getStock(), getMaterial(), getPattern(), getSold());
    }
}

// Class representing an Order (Encapsulation: Protects order details and exposes controlled access)
class Order {
    private Product product;  // Encapsulation: Protects direct access to the product.
    private int quantity;
    private String customerName;
    private int customerId;
    private double amount;
    private String contactNumber;
    private String status;

    public Order(Product product, int quantity, String customerName, int customerId, double amount, String contactNumber) {
        this.product = product;
        this.quantity = quantity;
        this.customerName = customerName;
        this.customerId = customerId;
        this.amount = amount;
        this.contactNumber = contactNumber;
        this.status = "Pending";
    }

    // Getter methods for accessing the details of the order
    public Product getProduct() { return product; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Display the order details
    public void displayOrder(int orderNumber) {
        System.out.printf("| %-5d | %-14s | %-9s | %-8d | %-7.2f | %-15s | %-8d | %-8s |\n",
            orderNumber, customerName, product.getClass().getSimpleName(), quantity, amount, contactNumber, customerId, status);
    }
}

// Main InventorySystem class
public class InventorySystem {
    private static ArrayList<Product> inventory = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    private static int customerIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------------------------------------------------------");
        System.out.println("WEave CAN: Inventory and Order Management System for Filipino Weavers");
        System.out.println("I CAN, YOU CAN, WEave CAN!");
        System.out.println("---------------------------------------------------------------------");

        // Initialize inventory with some products
        inventory.add(new Shawl(30.0, 10, "Cotton", "Bayawak"));
        inventory.add(new Bag(20.0, 20, "Abaca", "Binakul"));
        inventory.add(new Facemask(15.0, 30, "Fibres", "Binituwon"));
        inventory.add(new Hairband(10.0, 40, "Pineapple", "Bunga-sama"));
        inventory.add(new Pants(45.0, 12, "Cotton", "Palipattang"));
        inventory.add(new Skirt(35.0, 10, "Abaca", "Tinaggu"));
        inventory.add(new Shirt(25.0, 25, "Fibres", "Bayawak"));

        boolean running = true;
        while (running) {
            System.out.println("\n-------------------------------------------------");
            System.out.printf("| %-5s | %-20s |%n", "Choice", "Action");
            System.out.println("-------------------------------------------------");
            System.out.printf("| %-5s | %-20s |%n", "1", "View Inventory");
            System.out.printf("| %-5s | %-20s |%n", "2", "View Orders");
            System.out.printf("| %-5s | %-20s |%n", "3", "Place an Order");
            System.out.printf("| %-5s | %-20s |%n", "4", "Admin Panel");
            System.out.printf("| %-5s | %-20s |%n", "5", "Exit");
            System.out.println("-------------------------------------------------");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewInventory();
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    placeOrder(scanner);
                    break;
                case 4:
                    adminPanel(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display all products in inventory
    private static void viewInventory() {
        System.out.println("\n-----------------------------------------------------------------------------------");
        System.out.println("| No  | Product Name     | Price    | Stock   | Material     | Pattern    | Sold   |");
        System.out.println("-------------------------------------------------------------------------------------");
        int productNumber = 1;
        for (Product product : inventory) {
            product.displayDetails(productNumber++);
        }
        System.out.println("--------------------------------------------------------");
    }

    // View all orders placed
    private static void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders have been placed yet.");
            return;
        }

        System.out.println("\n---------------------------------------------------------------------------------------");
        System.out.println("| No  | Customer Name  | Product   | Qty  | Amount  | Contact Number | ID    | Status   |");
        System.out.println("-----------------------------------------------------------------------------------------");

        int orderNumber = 1;
        for (Order order : orders) {
            order.displayOrder(orderNumber++);
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    // Place a new order
    private static void placeOrder(Scanner scanner) {
        viewInventory();

        System.out.print("Enter product number to place an order: ");
        int productChoice = scanner.nextInt();

        if (productChoice < 1 || productChoice > inventory.size()) {
            System.out.println("Invalid product number.");
            return;
        }

        Product chosenProduct = inventory.get(productChoice - 1);
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        if (quantity > chosenProduct.getStock()) {
            System.out.println("Insufficient stock.");
            return;
        }

        System.out.print("Enter customer name: ");
        scanner.nextLine();  // Consume newline character
        String customerName = scanner.nextLine();

        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();

        double totalAmount = quantity * chosenProduct.getPrice();
        Order newOrder = new Order(chosenProduct, quantity, customerName, customerIdCounter++, totalAmount, contactNumber);
        orders.add(newOrder);
        chosenProduct.setStock(chosenProduct.getStock() - quantity);
        System.out.println("Order placed successfully!");
    }

    // Admin Panel to manage orders
    private static void adminPanel(Scanner scanner) {
        System.out.println("Admin Panel: Coming soon...");
    }
}
