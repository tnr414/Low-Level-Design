# Visitor Design Pattern

The **Visitor Design Pattern** is a **behavioral pattern** that allows you to add new operations to existing object structures without modifying them. It helps separate algorithms from the objects they operate on, making it easier to extend functionality.

## **When to Use the Visitor Pattern?**
- When you need to add operations to a structure of objects without modifying their classes.
- When multiple unrelated operations need to be performed on objects in a structure.
- When objects in a structure rarely change, but you frequently need to add new behaviors.

---

## **UML Diagram**

```
          +---------------------+
          |      Visitor        |
          |---------------------|
          | + visit(ElementA)   |
          | + visit(ElementB)   |
          +---------------------+
                     ▲
                     │
      +----------------------------+
      |          ConcreteVisitor   |
      |----------------------------|
      | + visit(ElementA) override |
      | + visit(ElementB) override |
      +----------------------------+
                     ▲
                     │
   +--------------------------------+
   |          Element               |
   |--------------------------------|
   | + accept(Visitor visitor)      |
   +--------------------------------+
             ▲          ▲
             │          │
 +----------------+  +----------------+
 |  ElementA      |  |  ElementB      |
 |----------------|  |----------------|
 | + accept()     |  | + accept()     |
 | + operationA() |  | + operationB() |
 +----------------+  +----------------+
             ▲
             │
   +-------------------------+
   |      ObjectStructure    |
   |-------------------------|
   | + elements: List<Element> |
   | + addElement(Element)    |
   | + accept(Visitor)        |
   +-------------------------+
```

---

## **Java Implementation**

### **Step 1: Define the Visitor Interface**
```java
// Visitor Interface
interface Visitor {
    void visit(Book book);
    void visit(Fruit fruit);
}
```

### **Step 2: Implement a Concrete Visitor**
```java
// Concrete Visitor
class ShoppingCartVisitor implements Visitor {
    @Override
    public void visit(Book book) {
        int cost = book.getPrice();
        System.out.println("Book: " + book.getName() + ", Cost = " + cost);
    }

    @Override
    public void visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println("Fruit: " + fruit.getName() + ", Cost = " + cost);
    }
}
```

### **Step 3: Define the Element Interface**
```java
// Element Interface
interface ItemElement {
    void accept(Visitor visitor);
}
```

### **Step 4: Implement Concrete Elements**
```java
// Concrete Element: Book
class Book implements ItemElement {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Concrete Element: Fruit
class Fruit implements ItemElement {
    private String name;
    private int pricePerKg;
    private int weight;

    public Fruit(String name, int pricePerKg, int weight) {
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.weight = weight;
    }

    public String getName() { return name; }
    public int getPricePerKg() { return pricePerKg; }
    public int getWeight() { return weight; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
```

### **Step 5: Create the Object Structure**
```java
import java.util.ArrayList;
import java.util.List;

// Object Structure
class ShoppingCart {
    private List<ItemElement> items = new ArrayList<>();

    public void addItem(ItemElement item) {
        items.add(item);
    }

    public void checkout(Visitor visitor) {
        for (ItemElement item : items) {
            item.accept(visitor);
        }
    }
}
```

### **Step 6: Test the Visitor Pattern**
```java
public class VisitorPatternExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding items
        cart.addItem(new Book("Design Patterns", 500));
        cart.addItem(new Fruit("Apple", 100, 2));

        // Applying visitor
        Visitor visitor = new ShoppingCartVisitor();
        cart.checkout(visitor);
    }
}
```

---

## **Output**
```
Book: Design Patterns, Cost = 500
Fruit: Apple, Cost = 200
```

---

## **Advantages of the Visitor Pattern**
- **Separates concerns**: Business logic is separate from data structure.
- **Easy to extend**: New operations can be added without modifying element classes.
- **Encourages open/closed principle**: Existing structures remain untouched while adding new behaviors.

## **Disadvantages of the Visitor Pattern**
- **Difficult to maintain** if the element hierarchy changes frequently.
- **Complexity increases** due to extra classes and visitor logic.

---

## **Conclusion**
The Visitor pattern is useful when you need to perform operations on objects without modifying their structure. It follows the **open/closed principle** by allowing new functionality to be added easily. However, it should be used carefully if the object hierarchy is subject to frequent changes.
