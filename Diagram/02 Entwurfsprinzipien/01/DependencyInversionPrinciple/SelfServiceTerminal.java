package Aufagbe2.DependencyInversionPrinciple;


public class SelfServiceTerminal {
    private final IItemSelector itemSelector;
    private final IOrderProcessor orderProcessor;
    private final IPaymentProcessor paymentProcessor;
    private double totalAmount = 0;

    // Constructor Injection
    public SelfServiceTerminal(IItemSelector itemSelector, IOrderProcessor orderProcessor, IPaymentProcessor paymentProcessor) {
        this.itemSelector = itemSelector;
        this.orderProcessor = orderProcessor;
        this.paymentProcessor = paymentProcessor;
    }

    public void selectItem(String item) {
        try {
            itemSelector.selectItem(item);
        } catch (Exception e) {
            System.out.println("Failed to select item: " + e.getMessage());
        }
    }

    public void orderItem(String item) {
        double itemPrice = getItemPrice(item);
        try {
            orderProcessor.processOrder(item, itemPrice);
            totalAmount += itemPrice;
        } catch (Exception e) {
            System.out.println("Failed to process order: " + e.getMessage());
        }
    }

    public void processPayment(double amount) {
        if (amount < totalAmount) {
            System.out.println("Insufficient payment. Please pay " + (totalAmount - amount));
        } else if (amount > totalAmount) {
            System.out.println("Error: excessive payment amount.");
        } else {
            try {
                paymentProcessor.processPayment(amount);
                totalAmount = 0;
            } catch (Exception e) {
                System.out.println("Payment processing error: " + e.getMessage());
            }
        }
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

