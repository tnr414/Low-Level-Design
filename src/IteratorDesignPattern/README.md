# Iterator Design Pattern

The **Iterator Pattern** is a behavioral design pattern that provides a way to access elements of a collection sequentially **without exposing its underlying representation**. It allows traversal through a collection **without needing to understand its internal structure**.

---

## 📌 **Key Components**

1. **Iterator Interface** – Defines methods for iterating over a collection (e.g., `hasNext()` and `next()`).
2. **Concrete Iterator** – Implements the iterator interface and keeps track of the current position.
3. **Aggregate (Collection) Interface** – Defines a method to create an iterator.
4. **Concrete Aggregate (Concrete Collection)** – Implements the aggregate interface and returns an iterator instance.

---

## 📊 **UML Diagram**

```
          +----------------------+
          |      Iterator        |
          |----------------------|
          | +hasNext(): boolean  |
          | +next(): Object      |
          +----------------------+
                   ▲
                   │
     +---------------------------+
     |   ConcreteIterator        |
     |---------------------------|
     | - collection: Collection  |
     | - index: int              |
     |---------------------------|
     | +hasNext(): boolean       |
     | +next(): Object           |
     +---------------------------+
                   
     +---------------------------+
     |       Aggregate           |
     |---------------------------|
     | +createIterator(): Iterator |
     +---------------------------+
                   ▲
                   │
     +---------------------------+
     |   ConcreteAggregate       |
     |---------------------------|
     | - items: List<Object>     |
     |---------------------------|
     | +createIterator(): Iterator |
     +---------------------------+
```

---

## 📝 **Java Implementation**

```java
import java.util.ArrayList;
import java.util.List;

// Step 1: Iterator Interface
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Step 2: Concrete Iterator Class
class ListIterator<T> implements Iterator<T> {
    private List<T> collection;
    private int index = 0;

    public ListIterator(List<T> collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return index < collection.size();
    }

    @Override
    public T next() {
        return hasNext() ? collection.get(index++) : null;
    }
}

// Step 3: Aggregate Interface
interface IterableCollection<T> {
    Iterator<T> createIterator();
}

// Step 4: Concrete Aggregate (Collection)
class CustomList<T> implements IterableCollection<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    @Override
    public Iterator<T> createIterator() {
        return new ListIterator<>(items);
    }
}

// Step 5: Client Code
public class IteratorPatternExample {
    public static void main(String[] args) {
        CustomList<String> namesList = new CustomList<>();
        namesList.addItem("Alice");
        namesList.addItem("Bob");
        namesList.addItem("Charlie");

        Iterator<String> iterator = namesList.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

---

## 🎯 **How It Works?**

1. **Iterator Interface (`Iterator<T>`)** – Defines `hasNext()` and `next()`.
2. **Concrete Iterator (`ListIterator<T>`)** – Implements `Iterator<T>` to traverse a list.
3. **Aggregate Interface (`IterableCollection<T>`)** – Defines `createIterator()`.
4. **Concrete Aggregate (`CustomList<T>`)** – Implements `IterableCollection<T>` and holds data.
5. **Client (`IteratorPatternExample`)** – Uses the iterator to access elements.

---

## ✅ **Advantages**

✔ **Encapsulation** – Hides internal data structure.
✔ **Uniform Access** – Provides a common way to iterate collections.
✔ **Extensibility** – Allows new iterators without modifying collections.

---

## 🔥 **When to Use?**

- When you need a **consistent way** to traverse collections.
- When you want to **decouple iteration logic** from collections.
- When different types of collections should have **a uniform interface for iteration**.

---

## 📌 **Conclusion**

The **Iterator Pattern** is an essential tool in designing flexible and maintainable code. It is widely used in Java collections (`Iterator`, `ListIterator`) and frameworks. Understanding this pattern helps in implementing robust traversal mechanisms in custom data structures.

---

💡 **Happy Coding! 🚀**

