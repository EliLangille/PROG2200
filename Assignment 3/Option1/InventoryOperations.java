package Option1;

public interface InventoryOperations {
    void addItem(String item, int quantity);
    void removeItem(String item, int quantity) throws Exception;
    void displayInventory();
}
