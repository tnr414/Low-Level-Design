# Builder Design Pattern

The **Builder Pattern** is a **creational design pattern** used to construct complex objects step by step. It helps create different representations of an object using the same construction process.

## **When to Use?**
- When an object has **many optional attributes**.
- When we want to avoid **constructors with too many parameters**.
- When the object creation process is **complex** and involves multiple steps.

---

## **UML Diagram**
Below is the UML representation of the **Builder Pattern**:

```plaintext
+----------------------+
|     Computer        | <--------+------------------+
+----------------------+          |    ComputerBuilder |
| - cpu: String       |          +------------------+
| - ram: String       |          | + setGraphicsCard()|
| - storage: String   |          | + setCoolingSystem()|
| - graphicsCard: String |       | + build()          |
| - coolingSystem: String |       +------------------+
| - os: String        |
+----------------------+
        ^
        |
 +----------------+
 |    Director    |
 +----------------+
 | + buildGamingPC() |
 | + buildOfficePC() |
 +----------------+
```

---

## **Implementation in Java**

### **Step 1: Create the Immutable Product Class**
```java
class Computer {
    private final String cpu;            // Required
    private final String ram;            // Required
    private final String storage;        // Optional
    private final String graphicsCard;   // Optional
    private final String coolingSystem;  // Optional
    private final String os;             // Optional

    public Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.coolingSystem = builder.coolingSystem;
        this.os = builder.os;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + cpu + '\'' +
                ", RAM='" + ram + '\'' +
                ", Storage='" + storage + '\'' +
                ", GraphicsCard='" + graphicsCard + '\'' +
                ", CoolingSystem='" + coolingSystem + '\'' +
                ", OS='" + os + '\'' +
                '}';
    }
}
```

### **Step 2: Create the Builder Class**
```java
class ComputerBuilder {
    protected String cpu;
    protected String ram;
    protected String storage;
    protected String graphicsCard;
    protected String coolingSystem;
    protected String os;

    public ComputerBuilder(String cpu, String ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    public ComputerBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    public ComputerBuilder setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    public ComputerBuilder setCoolingSystem(String coolingSystem) {
        this.coolingSystem = coolingSystem;
        return this;
    }

    public ComputerBuilder setOS(String os) {
        this.os = os;
        return this;
    }

    public Computer build() {
        return new Computer(this);
    }
}
```

### **Step 3: Create a Director Class**
```java
class ComputerDirector {
    public static Computer buildGamingPC() {
        return new ComputerBuilder("Intel i9", "32GB")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setStorage("2TB SSD")
                .setCoolingSystem("Liquid Cooling")
                .setOS("Windows 11")
                .build();
    }

    public static Computer buildOfficePC() {
        return new ComputerBuilder("Intel i5", "16GB")
                .setStorage("512GB SSD")
                .setOS("Windows 10")
                .build();
    }

    public static Computer buildServerPC() {
        return new ComputerBuilder("AMD EPYC", "64GB")
                .setStorage("4TB NVMe SSD")
                .setCoolingSystem("Advanced Air Cooling")
                .setOS("Linux")
                .build();
    }
}
```

### **Step 4: Using the Builder Pattern**
```java
public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer gamingPC = ComputerDirector.buildGamingPC();
        Computer officePC = ComputerDirector.buildOfficePC();
        Computer serverPC = ComputerDirector.buildServerPC();

        System.out.println("Gaming PC Config: \n" + gamingPC);
        System.out.println("\nOffice PC Config: \n" + officePC);
        System.out.println("\nServer PC Config: \n" + serverPC);
    }
}
```

---

## **Output**
```plaintext
Gaming PC Config:
Computer{CPU='Intel i9', RAM='32GB', Storage='2TB SSD', GraphicsCard='NVIDIA RTX 4090', CoolingSystem='Liquid Cooling', OS='Windows 11'}

Office PC Config:
Computer{CPU='Intel i5', RAM='16GB', Storage='512GB SSD', GraphicsCard='null', CoolingSystem='null', OS='Windows 10'}

Server PC Config:
Computer{CPU='AMD EPYC', RAM='64GB', Storage='4TB NVMe SSD', GraphicsCard='null', CoolingSystem='Advanced Air Cooling', OS='Linux'}
```

---

## **Advantages of Builder Pattern**
✔ **Improves Readability**: No need for long constructors with multiple parameters.  
✔ **Immutable Objects**: We can make fields `final` since values are set in a step-by-step manner.  
✔ **Flexible Object Creation**: You can create different variations of an object using the same builder.  
✔ **Encapsulates Object Creation Logic**: Separates complex object creation from the main logic.

---

## **Real-World Applications of Builder Pattern**
📌 **StringBuilder** - Used to construct strings efficiently.  
📌 **Lombok's @Builder Annotation** - Helps in auto-generating builders for Java classes.  
📌 **Spring Boot Configuration** - Uses builders for complex object creation.

---

## **Conclusion**
The **Builder Pattern** is perfect for building objects with **many optional parameters** in a clean and maintainable way. 🚀

