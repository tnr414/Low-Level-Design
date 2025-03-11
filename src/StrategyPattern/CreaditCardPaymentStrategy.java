package StrategyPattern;

public class CreaditCardPaymentStrategy implements PaymentStrategy{
    private final String creditCardNumber;
    public CreaditCardPaymentStrategy(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
    @Override
    public void pay(int amount) {
        System.out.println("Paid Rs. "  +amount + " using credit card " + creditCardNumber);
    }
}
