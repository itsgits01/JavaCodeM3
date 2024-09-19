package Day1;

import java.util.*;
import java.util.function.BiFunction;

class User {
    private int numberOfVisits;

    public User(int numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public void incrementVisits() {
        this.numberOfVisits++;
    }
}

public class RestActivity {

    public static void main(String[] args) {

        User user = new User(1);

        System.out.println("Welcome to the Restaurant!!");

        System.out.println("Number of previous visits: " + user.getNumberOfVisits());

        Scanner sc = new Scanner(System.in);

        System.out.println("Here is our menu: Pizza, Burger, Pancakes, Fries, Drinks");
        System.out.print("Enter the item: ");
        String item = sc.nextLine();

        System.out.print("Enter the quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        double pricePerItem = 0;
        switch (item) {
            case "Pizza":
                pricePerItem = 500.0;
                break;
            case "Burger":
                pricePerItem = 200.0;
                break;
            case "Pancakes":
                pricePerItem = 150.0;
                break;
            case "Fries":
                pricePerItem = 100.0;
                break;
            case "Drinks":
                pricePerItem = 50.0;
                break;
            default:
                System.out.println("Invalid item.");
                return;
        }

        double discount = (user.getNumberOfVisits() >= 2) ? (user.getNumberOfVisits() - 1) * 10 : 0;

        if (discount > 50) {
            discount = 50;
        }

        BiFunction<Double, Double, Double> calculateFinalPrice = (totalPrice, discountPercent) ->
                totalPrice - (totalPrice * discountPercent / 100);

        double totalPrice = pricePerItem * quantity;

        double serviceCharge = totalPrice * 0.10;
        double tax = totalPrice * 0.18;
        double finalPrice = calculateFinalPrice.apply(totalPrice, discount) + serviceCharge + tax;

        System.out.println("Item: " + item);
        System.out.println("Quantity: " + quantity);
        System.out.println("Original Price for one: " + pricePerItem);
        System.out.println("Total Original Price: " + totalPrice);
        System.out.println("Service Charge (10%): " + serviceCharge);
        System.out.println("Tax (18%): " + tax);

        if (user.getNumberOfVisits() > 1) {
            System.out.println("Discount on total price: " + discount + "%");
        }

        System.out.println("Final Price after discount and charges: " + finalPrice);

        user.incrementVisits();

        System.out.println("Thank you for your order! Your total number of visits is now: " + user.getNumberOfVisits());
    }
}
