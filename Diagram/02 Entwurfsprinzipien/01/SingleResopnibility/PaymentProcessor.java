package Aufagbe2.SingleResopnibility;



public class PaymentProcessor {
    private final Cart cart;

    public PaymentProcessor(Cart cart) {
        this.cart = cart;
    }

    public void processPayment(PaymentMethod method) {
        System.out.println("processing payment using " + method);
        switch (method) {
            case CASH:
                handleCashPayment();
                break;
            case CARD:
            case APPLE_PAY:
            case GOOGLE_PAY:
                handleDigitalPayment(method);
                break;
        }
    }

    private void handleCashPayment() {
        System.out.println("handling cash payment.");
        if (cart.getTotalAmount() > 100) {
            System.out.println("Suspicious cash amount. Possible fraud.");
        }
    }

    private void handleDigitalPayment(PaymentMethod method) {
        System.out.println("processing " + method + " payment.");
        if (cart.getTotalAmount() > 50) {
            System.out.println("Applying discount for digital payment.");
            cart.reset();
        }
    }
}

