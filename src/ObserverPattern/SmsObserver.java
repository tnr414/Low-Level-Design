package ObserverPattern;

public class SmsObserver extends Observer{
    public SmsObserver(IObservee observee) {
        super(observee);
    }

    @Override
    public void receiveNotification() {
        System.out.println("Notification received, sending sms");
    }
}
