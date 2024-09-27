package Aufagbe2.SingleResopnibility;



public enum MenuItem {
    BURGER(5.99),
    FRIES(2.99),
    SHAKE(3.99);

    private final double price;

    MenuItem(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

