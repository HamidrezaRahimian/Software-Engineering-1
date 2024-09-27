package Aufagbe2.OpenCLosed;


public class SelfServiceTerminal {
    private double totalAmount;
    private PaymentProcessor paymentProcessor;

    public SelfServiceTerminal(double totalAmount, PaymentProcessor paymentProcessor) {
        this.totalAmount = totalAmount;
        this.paymentProcessor = paymentProcessor;
    }

    public String processPayment() {
        return paymentProcessor.processPayment(totalAmount);
    }
}

