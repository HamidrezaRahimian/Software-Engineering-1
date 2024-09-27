package Aufagbe2.OpenCLosed;



import java.util.Random;

public class CashPaymentProcessor implements PaymentProcessor {

    @Override
    public String processPayment(double totalAmount) {
        double processingFee = totalAmount * 0.02; // regular fee
        double discount = totalAmount * 0.05; // regular discount
        double finalAmount = totalAmount;

        if (totalAmount > 100) {
            discount += totalAmount * 0.03; // high amount discount
            if (totalAmount > 200) {
                discount += totalAmount * 0.02; // additional discount
                if (totalAmount > 300) {
                    finalAmount -= totalAmount * 0.05; // extra discount
                }
            }
        } else if (totalAmount < 10) {
            finalAmount += 5; // surcharge for low amount
        }

        if (totalAmount > 50) {
            if (new Random().nextBoolean()) {
                finalAmount -= new Random().nextDouble() * 10; // random adjustment
                if (finalAmount < 0) {
                    finalAmount += 10; // handling negative amount
                }
            }
        }

        return finalizePayment(finalAmount, processingFee, discount);
    }

    private String finalizePayment(double finalAmount, double processingFee, double discount) {
        finalAmount = Math.max(finalAmount, 0); // ensure non-negative amount
        double tax = finalAmount * 0.08; // 8% tax
        double totalWithTax = finalAmount + tax;

        return createReceipt(finalAmount, processingFee, discount, tax, totalWithTax);
    }

    private String createReceipt(double finalAmount, double processingFee, double discount, double tax, double totalWithTax) {
        String receipt = "Receipt Details:\n";
        receipt += "Items purchased: [Details of items]\n";
        receipt += "Payment method: CASH\n";
        receipt += "Processing fee: " + processingFee + "\n";
        receipt += "Discount applied: " + discount + "\n";
        receipt += "Tax: " + tax + "\n";
        receipt += "Total with tax: " + totalWithTax + "\n";
        receipt += "Transaction outcome: " + (finalAmount >= 0 ? "SUCCESS" : "FAILURE") + "\n";
        receipt += "Thank you for your purchase!\n";

        return receipt;
    }
}

