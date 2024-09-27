package Aufagbe2.DependencyInversionPrinciple;




import java.util.Random;

public class ItemSelector implements IItemSelector {
    private final Random random = new Random();

    public void selectItem(String item) {
        System.out.println("Item selected: " + item);
        if (item.equalsIgnoreCase("shake")) {
            try {
                selectShake();
            } catch (Exception e) {
                System.out.println("Shake selection failed: " + e.getMessage());
            }
        }
    }

    private void selectShake() {
        System.out.println("Selecting shake.");
        if (random.nextDouble() > 0.5) {
            throw new RuntimeException("Failed to select shake due to system error.");
        }
    }
}

