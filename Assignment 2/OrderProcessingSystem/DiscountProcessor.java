package SingleResponsibility.Assignment.OrderProcessingSystem;

public class DiscountProcessor {
    public boolean applyDiscount(Order order, Discount discount) {
        // Verify discount and update order cost
        if (discount != null && order.getTotalCost() > 0) {
            double totalCost = order.getTotalCost();
            totalCost -= totalCost * (discount.getPercentage() / 100.0);
            order.setTotalCost(totalCost);
            return true;
        }
        return false;
    }
}
