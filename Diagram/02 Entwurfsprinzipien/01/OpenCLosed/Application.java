package Aufagbe2.OpenCLosed;





public class Application {
    public static void main(String... args) {
        // Beispiel für Zahlung mit einer Karte
        PaymentProcessor cardProcessor = new CardPaymentProcessor();
        SelfServiceTerminal terminal1 = new SelfServiceTerminal(350.00, cardProcessor);
        System.out.println(terminal1.processPayment());

        // Beispiel für Zahlung mit Apple Pay
        PaymentProcessor applePayProcessor = new ApplePayPaymentProcessor();
        SelfServiceTerminal terminal2 = new SelfServiceTerminal(450.00, applePayProcessor);
        System.out.println(terminal2.processPayment());

        // Beispiel für Zahlung mit Google Pay
        PaymentProcessor googlePayProcessor = new GooglePayPaymentProcessor();
        SelfServiceTerminal terminal3 = new SelfServiceTerminal(300.00, googlePayProcessor);
        System.out.println(terminal3.processPayment());

        // Beispiel für Zahlung mit PayPal
        PaymentProcessor paypalProcessor = new PayPalPaymentProcessor();
        SelfServiceTerminal terminal4 = new SelfServiceTerminal(700.00, paypalProcessor);
        System.out.println(terminal4.processPayment());
    }
}

