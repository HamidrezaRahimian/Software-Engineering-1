package Aufagbe2.SingleResopnibility;




public class ReceiptPrinter {
    public void printReceipt(Cart cart, PaymentMethod paymentMethod) {
        System.out.println("--- receipt ---");
        System.out.println("items: " + cart.getItems());
        System.out.println("total amount: " + cart.getTotalAmount());
        System.out.println("paid using: " + paymentMethod);
    }
}
