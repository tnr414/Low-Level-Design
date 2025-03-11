package ObserverPattern;

import java.util.SortedMap;

abstract public class Observer {
    IObservee observee;

    public Observer(IObservee observee) {
        this.observee = observee;
    }

    abstract void receiveNotification();
}
