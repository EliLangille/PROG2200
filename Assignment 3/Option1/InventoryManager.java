package Option1;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager implements InventoryOperations {

    private Map<String, Integer> inventory;

    public InventoryManager() { inventory = new HashMap<>(); }

    @Override
    public void addItem(String item, int quantity) {
        if (inventory.containsKey(item)) {
            inventory.put(item, inventory.get(item) + quantity);
        } else {
            inventory.put(item, quantity);
        }
    }

    @Override
    public void removeItem(String item, int quantity) throws Exception {
        if (!inventory.containsKey(item) || inventory.get(item) < quantity) {
            throw new Exception("Item not available or insufficient quantity");
        }
        inventory.put(item, inventory.get(item) - quantity);
    }

    @Override
    public void displayInventory() {
        System.out.println("Inventory:");
        for (String item : inventory.keySet()) {
            System.out.println(item + ": " + inventory.get(item));
        }
    }
}