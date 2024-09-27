package Aufagbe2.SingleResopnibility;

import java.util.HashMap;
import java.util.Map;


import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<MenuItem> items = new ArrayList<>();
    private double totalAmount = 0.0;

    public void addItem(MenuItem item) {
        items.add(item);
        totalAmount += item.getPrice();
        if (items.size() > 5) {
            System.out.println("Applying discount for bulk order.");
            totalAmount -= 5;
        }
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void reset() {
        items.clear();
        totalAmount = 0.0;
    }
}
