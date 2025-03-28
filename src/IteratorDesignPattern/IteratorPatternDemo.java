package IteratorDesignPattern;

public class IteratorPatternDemo {
    public static void main(String[] args) {
        CustomList<String> names = new CustomList<>();
        names.addItem("Alice");
        names.addItem("Bob");
        names.addItem("Charlie");

        Iterator<String> iterator = names.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
