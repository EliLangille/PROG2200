package SingleResponsibility.Assignment.OrderProcessingSystem;

public class Main {
    public static void main(String[] args) {

        /*
        n this code, the OrderProcessor class represents a system managing customer
        orders. It includes methods for adding items to an order, calculating the
        total cost, applying discounts, processing payments, and sending confirmation
        emails. The Main class demonstrates its use by creating an order, adding items,
        applying a discount, processing payment, and handling the order confirmation.
        This setup illustrates a multi-functional class handling various aspects of
        order processing, ideal for teaching refactoring according to the Single
        Responsibility Principle.   Students should refactor this class to align
        with the Single Responsibility Principle, creating separate classes to handle
        these individual responsibilities.
         */

        // Create an instance of the processor classes
        DiscountProcessor discountProcessor = new DiscountProcessor();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        EmailProcessor emailProcessor = new EmailProcessor();

        // Creating items and a discount
        Item item1 = new Item("Laptop", 999.99);
        Item item2 = new Item("Mouse", 19.99);
        Discount discount = new Discount(10); // 10% discount

        // Creating an order and adding items
        Order order = new Order();
        order.addItem(item1);
        order.addItem(item2);

        // Calculating total cost
        double totalCost = order.getTotalCost();
        System.out.println("Total Cost: " + totalCost);

        // Applying discount
        if (discountProcessor.applyDiscount(order, discount)) {
            System.out.println("Discount applied. New Total: " + order.getTotalCost());
        }

        // Processing payment
        Payment payment = new Payment("Credit Card", order.getTotalCost());
        if (paymentProcessor.processPayment(order, payment)) {
            System.out.println("Payment processed successfully.");
        }

        // Send order confirmation email
        emailProcessor.sendOrderConfirmationEmail(order);
    }
}
