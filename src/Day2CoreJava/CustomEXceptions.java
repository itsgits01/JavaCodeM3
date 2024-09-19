package Day2CoreJava;



import java.util.*;

// Custom checked exception
class OutOfStockException extends Exception {
    private String itemName;

    public OutOfStockException(String itemName) {
        super("Item out of stock: " + itemName);
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}

// Custom unchecked exception
class InvalidItemException extends RuntimeException {
    private String itemName;

    public InvalidItemException(String itemName) {
        super("Invalid item: " + itemName);
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}

// Main class demonstrating exception handling in a shopping cart
public class CustomEXceptions {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 5);
        cart.addItem("Phone", 0); // Out of stock

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                // Taking item and quantity input from user
                System.out.print("Enter item name: ");
                String itemName = scanner.nextLine();
                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                // Attempt to purchase item (may throw exceptions)
                cart.purchaseItem(itemName, quantity);

                System.out.println("Item purchased successfully.");
                break;

            } catch (OutOfStockException e) {
                // Handle the custom checked exception
                System.out.println("Error: " + e.getMessage());
                System.out.println("Would you like to select another item? (y/n)");
                if (!scanner.nextLine().equalsIgnoreCase("y")) {
                    break;
                }

            } catch (InvalidItemException e) {
                // Handle the custom unchecked exception
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again with a valid item.");

            } catch (NumberFormatException e) {
                // Handle invalid input for quantity
                System.out.println("Error: Invalid quantity entered. Please enter a valid number.");

            } catch (Exception e) {
                // Generic exception handler for any unexpected exceptions
                System.out.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
                break;

            } finally {
                // This block always executes, regardless of whether an exception occurred
                System.out.println("Transaction attempt completed.");
            }
        }

        scanner.close();
    }
}

// ShoppingCart class demonstrating methods that can throw exceptions
class ShoppingCart {
    private Map<String, Integer> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    // Add items to the cart
    public void addItem(String itemName, int quantity) {
        items.put(itemName, quantity);
    }

    // Method that demonstrates throwing both custom checked and unchecked exceptions
    public void purchaseItem(String itemName, int quantity) throws OutOfStockException {
        // Check if the item exists in the cart (may throw unchecked exception)
        if (!items.containsKey(itemName)) {
            throw new InvalidItemException(itemName);
        }

        // Check for stock availability (may throw checked exception)
        int availableStock = items.get(itemName);
        if (quantity > availableStock) {
            throw new OutOfStockException(itemName);
        }

        // Process the purchase
        items.put(itemName, availableStock - quantity);
    }
}
