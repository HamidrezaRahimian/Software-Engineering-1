package Aufagbe2.InterfaceSegregationPrinciple;



import java.util.Random;

public class Ordering implements IOrdering, IReviewOrder {
    private final Random random = new Random();
    private double totalAmount = 0;

    public void orderItem(String item) {
        try {
            double itemPrice = getItemPrice(item);
            totalAmount += itemPrice;
            System.out.println("Ordered: " + item + " for " + itemPrice);
            if (random.nextDouble() > 0.5) {
                throw new RuntimeException("Order failure due to system overload.");
            }
        } catch (Exception e) {
            System.out.println("Error while ordering: " + e.getMessage());
        }
    }

    public void reviewOrder() {
        System.out.println("Reviewing order.");
        if (random.nextDouble() > 0.5) {
            throw new RuntimeException("Error: unable to review order due to system malfunction.");
        }
        System.out.println("Total amount: " + totalAmount);
    }

    private double getItemPrice(String item) {
        return switch (item.toLowerCase()) {
            case "burger" -> 5.0;
            case "fries" -> 2.0;
            case "shake" -> 3.0;
            default -> throw new IllegalArgumentException("Invalid item.");
        };
    }
}
