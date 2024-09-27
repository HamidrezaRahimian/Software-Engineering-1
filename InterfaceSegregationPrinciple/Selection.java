package Aufagbe2.InterfaceSegregationPrinciple;



import java.util.Random;

public class Selection implements ISelectionOperations {
    private final Random random = new Random();
    private boolean isShakeOrdered = false;

    public void selectItem(String item) {
        System.out.println("Item selected: " + item);
        if (random.nextDouble() > 0.7) {
            throw new RuntimeException("System error: unexpected issue during selection.");
        }
        if (item.equalsIgnoreCase("shake")) {
            isShakeOrdered = true;
        }
    }

    public void cancelSelection(String item) {
        if (isShakeOrdered) {
            System.out.println("Cannot cancel shake selection due to system instability.");
        } else {
            System.out.println("Selection canceled: " + item);
        }
    }
}
