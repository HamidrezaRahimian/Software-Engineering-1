package Aufagbe2.SingleResopnibility;



public class FraudDetector {
    public void checkCartForFraud(Cart cart) {
        System.out.println("running fraud check on cart...");
        if (cart.getTotalAmount() > 100) {
            System.out.println("Fraud alert: Suspiciously high total amount.");
        }
    }
}

