package SingleResponsibility.Assignment.OrderProcessingSystem;

import java.util.ArrayList;
import java.util.List;

public class Order {
    // An order has a list of items and a total cost (splitting them into two classes would overcomplicate things)
    private List<Item> items = new ArrayList<>();
    private double totalCost = 0.0;

    public void addItem(Item item) {
        items.add(item);
        totalCost += item.getPrice();
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalCost() { return totalCost; }

    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
}