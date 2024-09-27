package Aufagbe2.SingleResopnibility;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuLoader {
    private final Map<MenuItem, Double> inventoryDatabase = new HashMap<>();

    public void loadMenu() {
        System.out.println("loading menu.");
        for (MenuItem item : MenuItem.values()) {
            inventoryDatabase.put(item, item.getPrice());
        }
        System.out.println("menu loaded: " + inventoryDatabase.keySet());
    }

    public void displayMenu() {
        System.out.println("available items: " + inventoryDatabase.keySet());
    }
}
