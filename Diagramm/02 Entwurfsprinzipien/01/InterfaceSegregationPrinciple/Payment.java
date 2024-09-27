package Aufagbe2.InterfaceSegregationPrinciple;



import java.util.Random;

    public class Payment implements IPayment, IDiscountable {
        private final Random random = new Random();
        private double totalAmount = 0;

        public void processPayment(double amount) {
            if (totalAmount == 0) {
                System.out.println("No items ordered. Payment cannot be processed.");
                return;
            }
            try {
                if (amount < totalAmount) {
                    System.out.println("Error: payment too low. Please provide additional " + (totalAmount - amount));
                } else if (amount > totalAmount) {
                    throw new RuntimeException("Error: excessive payment amount. System cannot process extra funds.");
                } else {
                    System.out.println("Payment successful. Change: " + (amount - totalAmount));
                    totalAmount = 0;
                }
            } catch (RuntimeException e) {
                System.out.println("Payment processing error: " + e.getMessage());
            }
        }

        public void applyDiscount(double percentage) {
            if (percentage < 0 || percentage > 100) {
                throw new IllegalArgumentException("Invalid discount percentage.");
            }
            if (random.nextDouble() > 0.5) {
                throw new RuntimeException("System error: discount application failed.");
            }
            double discount = totalAmount * (percentage / 100);
            totalAmount -= discount;
            System.out.println("Applied discount of " + percentage + "%. New total: " + totalAmount);
        }
    }


