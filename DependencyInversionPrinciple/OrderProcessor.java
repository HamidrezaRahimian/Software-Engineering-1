package Aufagbe2.DependencyInversionPrinciple;



import java.util.Random;

public class OrderProcessor implements IOrderProcessor {
    private final Random random = new Random();

    public void processOrder(String item, double price) {
        System.out.println("Order processed: " + item + " for " + price);
        if (price > 2.0) {
            try {
                processSpecialOrder(item, price);
            } catch (Exception e) {
                System.out.println("Special order processing failed: " + e.getMessage());
            }
        }
    }

    private void processSpecialOrder(String item, double price) {
        System.out.println("Processing special order for " + item);
        if (random.nextDouble() > 0.5) {
            throw new RuntimeException("Error processing special order.");
        }
    }
}

