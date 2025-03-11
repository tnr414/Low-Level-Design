package ObserverPattern;

abstract public class IObservee {
    abstract public void addStock(DummyProduct product);
    abstract public boolean addObserver(Observer observer);
    abstract public boolean removeObserver(Observer observer);
}
