package Aufagbe2.OpenCLosed;


import java.util.Random;

public class ApplePayPaymentProcessor implements PaymentProcessor {

    @Override
    public String processPayment(double totalAmount) {
        double processingFee = totalAmount * 0.02; // regular fee
        double discount = totalAmount * 0.1; // high amount discount
        double finalAmount = totalAmount;

        if (totalAmount > 200) {
            finalAmount -= 20; // Apple Pay high amount discount
            if (totalAmount > 400) {
                finalAmount += 10; // additional Apple Pay charge
            }
        }

        if (new Random().nextBoolean()) {
            if (totalAmount > 150) {
                finalAmount += 15; // Apple Pay special handling
                if (finalAmount > 250) {
                    finalAmount -= 10; // Apple Pay high amount adjustment
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
        receipt += "Payment method: APPLE_PAY\n";
        receipt += "Processing fee: " + processingFee + "\n";
        receipt += "Discount applied: " + discount + "\n";
        receipt += "Tax: " + tax + "\n";
        receipt += "Total with tax: " + totalWithTax + "\n";
        receipt += "Transaction outcome: " + (finalAmount >= 0 ? "SUCCESS" : "FAILURE") + "\n";
        receipt += "Thank you for your purchase!\n";

        return receipt;
    }
}

