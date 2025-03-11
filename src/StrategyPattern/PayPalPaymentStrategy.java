package StrategyPattern;

public class PayPalPaymentStrategy implements PaymentStrategy {
    String email;

    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid Rs. "  +amount + "  using paypal account " + email);
    }
}
