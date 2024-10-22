package SingleResponsibility.Assignment.OrderProcessingSystem;

public class Payment {
    private String method;
    private double amount;

    public Payment(String method, double amount) {
        this.method = method;
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public double getAmount() {
        return amount;
    }
}
