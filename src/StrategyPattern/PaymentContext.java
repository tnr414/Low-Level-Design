package StrategyPattern;

public class PaymentContext implements PaymentStrategy {
    PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public void pay(int amount) {
        paymentStrategy.pay(amount);
    }
}
