# Adapter Design Pattern

## Overview
The **Adapter Pattern** is a **structural design pattern** that allows objects with incompatible interfaces to work together. It acts as a bridge between the two interfaces by wrapping an existing class and providing a new interface.

## When to Use Adapter Pattern?
- When an existing class's interface does not match the required interface.
- When you want to use a third-party or legacy class but cannot modify it.
- When you need to create a reusable class that works with unrelated classes having different interfaces.

---

## UML Diagram
Below is a UML representation of the Adapter Design Pattern:

```
+-----------------+        +-------------------+
| Target         |        | Adaptee           |
| (Expected API) |        | (Existing API)    |
+-----------------+        +-------------------+
         ▲                         ▲
         |                         |
         |                         |
         |         +-----------------------+
         |-------->| Adapter               |
                   | (Bridges the Gap)     |
                   +-----------------------+
```

---

## Example Scenario
Imagine we have an existing **Voltage220V** class that provides 220V power, but a **Mobile Charger** requires only 5V. The Adapter will convert 220V to 5V.

### **1. Define the Target Interface**
```java
// Target Interface (What the client expects)
interface MobileCharger {
    int get5Volt();
}
```

### **2. Create the Adaptee Class**
```java
// Adaptee (Existing class that provides 220V)
class Voltage220V {
    public int getVoltage() {
        return 220;
    }
}
```

### **3. Create the Adapter Class**
```java
// Adapter Class (Bridging Voltage220V to MobileCharger)
class VoltageAdapter implements MobileCharger {
    private Voltage220V voltage220V; // Using Composition

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int get5Volt() {
        return convertVoltage(voltage220V.getVoltage());
    }

    private int convertVoltage(int voltage) {
        return voltage / 44; // Converts 220V to 5V
    }
}
```

### **4. Client Code**
```java
public class AdapterPatternDemo {
    public static void main(String[] args) {
        Voltage220V voltage220V = new Voltage220V();
        MobileCharger charger = new VoltageAdapter(voltage220V); // Using Adapter

        System.out.println("Mobile Charger Output: " + charger.get5Volt() + "V");
    }
}
```

### **Output**
```
Mobile Charger Output: 5V
```

---

## **Advantages of Adapter Pattern**
✅ **Reusability** – You can use an existing class without modifying it.
✅ **Flexibility** – Allows objects with incompatible interfaces to interact.
✅ **Improved Maintainability** – Code changes are localized within the adapter class.

---

## **Real-World Examples**
- **USB to HDMI adapters** (Old interface to new display devices)
- **Power socket adapters** (220V to 110V conversion)
- **Java API Wrappers** (Wrapping legacy API calls with modern interfaces)

---

## Conclusion
The **Adapter Design Pattern** is widely used in software development to **bridge incompatible interfaces**. It is useful in **legacy system integration**, **third-party library usage**, and **code reusability**.

Would you like to explore another design pattern? 🚀

