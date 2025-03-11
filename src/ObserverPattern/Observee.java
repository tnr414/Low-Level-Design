package ObserverPattern;

import java.util.*;

public class Observee extends IObservee {
    private Set<Observer> observers = new HashSet<>();
    List<DummyProduct> stocks = new ArrayList<>();
    public boolean addObserver(Observer observer) {
        return observers.add(observer);
    }

    public boolean removeObserver(Observer observer) {
        return observers.remove(observer);
    }

    public void addStock(DummyProduct product) {
        if (stocks.isEmpty()) {
            notifyObservers();
        }
        stocks.add(product);
    }

    private void notifyObservers() {
        for (Observer observer: observers) {
            observer.receiveNotification();
        }
    }


}
