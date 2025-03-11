package StrategyPattern;

public class Main {
    public static void main(String[] args) {
        PaymentContext creditCardContext = new PaymentContext(new CreaditCardPaymentStrategy("123456789"));
        creditCardContext.pay(100);

        PaymentContext paypalContext = new PaymentContext(new PayPalPaymentStrategy("abc@email.com"));
        paypalContext.pay(120);
    }
}
