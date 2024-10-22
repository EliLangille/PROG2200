package SingleResponsibility.Assignment.OrderProcessingSystem;

public class PaymentProcessor {
    public boolean processPayment(Order order, Payment payment) {
        // Simulating payment processing
        double totalCost = order.getTotalCost();

        // Return payment success/fail
        return payment.getAmount() >= totalCost;
    }
}
