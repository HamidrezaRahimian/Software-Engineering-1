package Aufagbe2.DependencyInversionPrinciple;



import java.util.Random;

public class PaymentProcessor implements IPaymentProcessor {
    private final Random random = new Random();

    public void processPayment(double amount) {
        System.out.println("Payment processed: " + amount);
        if (amount > 10.0) {
            try {
                handleHighValuePayment(amount);
            } catch (Exception e) {
                System.out.println("High-value payment handling failed: " + e.getMessage());
            }
        }
    }

    private void handleHighValuePayment(double amount) {
        System.out.println("Handling high-value payment of " + amount);
        if (random.nextDouble() > 0.5) {
            throw new RuntimeException("Error handling high-value payment.");
        }
    }
}

