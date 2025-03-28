# Prototype Design Pattern

## Overview
The **Prototype Design Pattern** is a **creational pattern** used when object creation is expensive or complex. Instead of creating new instances from scratch, objects are cloned from a prototype instance.

## UML Diagram
```
       +----------------+
       |  Prototype     |<----------------+
       |---------------|                 |
       | +clone()      |                 |
       +----------------+                |
                 ▲                        |
                 |                        |
   +---------------------+      +---------------------+
   | ConcretePrototype1  |      | ConcretePrototype2  |
   |---------------------|      |---------------------|
   | +clone()           |      | +clone()           |
   +---------------------+      +---------------------+
```

### Components
- **Prototype**: Defines an interface (`clone()`) for cloning itself.
- **ConcretePrototype**: Implements the cloning method.
- **Client**: Uses the prototype to create a new object.

## Implementation in Java

### Step 1: Create the Prototype Interface
```java
interface Prototype extends Cloneable {
    Prototype clone();
}
```

### Step 2: Create a Concrete Prototype Class
```java
class Employee implements Prototype {
    private String name;
    private String designation;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    @Override
    public Prototype clone() {
        return new Employee(name, designation);
    }

    public void showDetails() {
        System.out.println("Employee: " + name + ", Designation: " + designation);
    }
}
```

### Step 3: Implement Client Code
```java
public class PrototypePatternDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee("John Doe", "Software Engineer");
        emp1.showDetails();

        // Cloning the object
        Employee emp2 = (Employee) emp1.clone();
        emp2.showDetails();
    }
}
```

## Benefits of Prototype Pattern
✅ **Reduces Object Creation Cost** – Useful when object creation is resource-intensive.  
✅ **Encapsulation of Object Creation** – The client doesn’t need to know how objects are created.  
✅ **Easy Object Duplication** – Simplifies object duplication while maintaining structure.

## When to Use?
- When creating objects is **expensive**.
- When **system performance is critical** and object creation needs to be optimized.
- When working with **complex object hierarchies** where instantiating new objects is tedious.

This pattern is commonly used in **game development, UI frameworks, and data processing**. 🚀

