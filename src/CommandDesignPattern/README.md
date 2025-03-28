# Command Design Pattern

The **Command Pattern** is a behavioral design pattern that encapsulates a request as an object, allowing parameterization of clients with operations, queuing of requests, and logging of operations. It also supports undoable operations.

---

## **1. Intent**
- Encapsulates a request as an object.
- Decouples the sender and receiver.
- Supports undo/redo operations.

---

## **2. UML Diagram**

```
+----------------+       +-----------------+       +----------------+
|    Client     | -----> |    Invoker      | -----> |   Command     |
+----------------+       +-----------------+       +----------------+
                                             |                   |
                                             v                   v
                                      +--------------+    +----------------+
                                      | ConcreteCmd1 |    |  ConcreteCmd2  |
                                      +--------------+    +----------------+
                                             |                   |
                                             v                   v
                                     +----------------+    +----------------+
                                     |   Receiver1   |    |   Receiver2   |
                                     +----------------+    +----------------+
```

---

## **3. Components of Command Pattern**
1. **Command Interface**: Defines the execute method.
2. **Concrete Command**: Implements the Command interface and defines execution logic.
3. **Receiver**: The actual business logic implementation.
4. **Invoker**: Calls the command and executes it.
5. **Client**: Creates and assigns commands.

---

## **4. Java Implementation**

### **Step 1: Create a Command Interface**
```java
interface Command {
    void execute();
}
```

### **Step 2: Create Concrete Command Classes**
```java
// Receiver
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Concrete Command: Turn ON the Light
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command: Turn OFF the Light
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
```

### **Step 3: Create an Invoker Class**
```java
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

### **Step 4: Client Code**
```java
public class CommandPatternDemo {
    public static void main(String[] args) {
        Light light = new Light();
        
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();
        
        // Turn on the light
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn off the light
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
```

### **Output**
```
Light is ON
Light is OFF
```

---

## **5. Use Cases of Command Pattern**
- GUI buttons and menu items (e.g., Undo/Redo in text editors).
- Macro recording systems (e.g., recording sequences of operations).
- Queueing tasks for background execution.
- Remote controls or home automation systems.

This pattern is useful for implementing **Undo/Redo, Task Scheduling, and Transactional Operations**.


---

## **6. Conclusion**
The **Command Pattern** is widely used in software design for decoupling the sender and receiver. It enables flexible, maintainable, and scalable code by encapsulating requests into objects.

