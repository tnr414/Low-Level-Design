package ObserverPattern;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        IObservee observee = new Observee();
        Observer emailObserver = new EmailObserver(observee);
        Observer smsObserver = new SmsObserver(observee);

        DummyProduct product = new DummyProduct();
        observee.addObserver(emailObserver);
        observee.addObserver(smsObserver);
        observee.addStock(product);
    }
}
