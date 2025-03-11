package ObserverPattern;

public class EmailObserver extends Observer{
    public EmailObserver(IObservee observee) {
        super(observee);
    }

    @Override
    public void receiveNotification() {
        System.out.println("received notification, sending email");
    }

}
