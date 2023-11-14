import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many items?");

        int itemQuantity = 0;
            itemQuantity = input.nextInt();


        System.out.println("\nWhat is price per item?");
        double pricePerItem = input.nextDouble();

        System.out.println("\nWhat state are you located in? (2-character code)");
        String stateCode = input.next();

        input.close();

        double totalPrice = itemQuantity * pricePerItem;
        System.out.println("\nTotal price: $" + totalPrice);

        double discountRate = 0;
        final int orderValue1 = 1000;
        final int orderValue2 = 5000;
        final int orderValue3 = 7000;
        final int orderValue4 = 10000;
        final int orderValue5 = 50000;

        if (totalPrice < orderValue2 && totalPrice > orderValue1) {
            discountRate = 0.03;
        } else if (totalPrice < orderValue3) {
            discountRate = 0.05;
        } else if (totalPrice < orderValue4) {
            discountRate = 0.07;
        } else if (totalPrice < orderValue5) {
            discountRate = 0.1;
        } else if (totalPrice > orderValue5) {
            discountRate = 0.15;
        }

        System.out.println("Your discount: " + discountRate * 100 + "%");

        double tax = 1;
        switch (stateCode) {
            case "UT" -> tax += 0.0685;
            case "NV" -> tax += 0.080;
            case "TX" -> tax += 0.0625;
            case "AL" -> tax += 0.040;
            case "CA" -> tax += 0.0825;
            default -> System.out.println("We dont support that state.");
        }

        System.out.printf("Your state tax is: %.2f%s\n", (tax - 1) * 100, "%");
        totalPrice *= (1 - discountRate);
        totalPrice *= tax;

        System.out.printf("Your final price: $%.2f", totalPrice);
    }
}
