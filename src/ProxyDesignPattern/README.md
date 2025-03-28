# Proxy Design Pattern

## Overview
The **Proxy Design Pattern** is a structural pattern that provides a surrogate or placeholder for another object to control access to it. It is used when direct access to an object is expensive, restricted, or requires additional functionalities like logging, access control, or lazy initialization.

---

## UML Diagram
```
+----------------+          +----------------+          +--------------------+
|   Client       |          |  Proxy         |          |  RealSubject       |
| (Uses Subject) | -------> | (Implements)   | -------> | (Implements Subject) |
+----------------+          +----------------+          +--------------------+
```
- **Client**: Uses the subject (interface).
- **Proxy**: Acts as an intermediary for `RealSubject`.
- **RealSubject**: Actual object that performs operations.

---

## Types of Proxies
1. **Virtual Proxy** – Used for lazy initialization.
2. **Protection Proxy** – Controls access, often used for security.
3. **Remote Proxy** – Represents an object in a different address space.
4. **Smart Proxy** – Adds functionalities like logging and reference counting.

---

## Example: Protection Proxy in Java
### **Step 1: Define Subject Interface**
```java
// Subject Interface
interface Internet {
    void connectTo(String serverHost) throws Exception;
}
```

### **Step 2: Create RealSubject**
```java
// Real Object that performs actual operations
class RealInternet implements Internet {
    @Override
    public void connectTo(String serverHost) {
        System.out.println("Connecting to " + serverHost);
    }
}
```

### **Step 3: Create Proxy Class**
```java
import java.util.ArrayList;
import java.util.List;

// Proxy Class that controls access
class ProxyInternet implements Internet {
    private Internet internet = new RealInternet();
    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<>();
        bannedSites.add("banned.com");
        bannedSites.add("malware.com");
    }

    @Override
    public void connectTo(String serverHost) throws Exception {
        if (bannedSites.contains(serverHost.toLowerCase())) {
            throw new Exception("Access Denied: " + serverHost);
        }
        internet.connectTo(serverHost);
    }
}
```

### **Step 4: Client Code**
```java
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        try {
            internet.connectTo("example.com");
            internet.connectTo("banned.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
```

---

## Output
```
Connecting to example.com
Access Denied: banned.com
```

---

## When to Use Proxy Pattern?
- **Security**: Protect access to sensitive objects.
- **Lazy Loading**: Load heavy objects on demand.
- **Logging/Monitoring**: Track object usage.
- **Remote Access**: Communicate with remote objects (e.g., RMI).

---
### Happy Coding! 🚀

