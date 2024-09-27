package Aufagbe2.SingleResopnibility;



import java.util.List;

public class SelfServiceTerminal {
    private final Cart cart = new Cart();
    private final MenuLoader menuLoader = new MenuLoader();
    private final PaymentProcessor paymentProcessor = new PaymentProcessor(cart);
    private final FraudDetector fraudDetector = new FraudDetector();
    private final NetworkManager networkManager = new NetworkManager();
    private final ReceiptPrinter receiptPrinter = new ReceiptPrinter();

    public SelfServiceTerminal() {
        System.out.println("initializing terminal.");
        menuLoader.loadMenu();
        networkManager.initializeNetworkConnection();
        renderUI();
    }

    public void selectItem(MenuItem item) {
        System.out.println("selecting item: " + item);
        cart.addItem(item);
        fraudDetector.checkCartForFraud(cart);
    }

    public void processPayment(PaymentMethod method) {
        if (networkManager.checkNetworkConnection()) {
            paymentProcessor.processPayment(method);
            receiptPrinter.printReceipt(cart, method);
            cart.reset();
        } else {
            System.out.println("Network error. Payment failed.");
        }
    }

    public void displayCart() {
        System.out.println("your cart contains: " + cart.getItems());
    }

    private void renderUI() {
        System.out.println("rendering user interface.");
        menuLoader.displayMenu();
        displayCart();
    }
}

