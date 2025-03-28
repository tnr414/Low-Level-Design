# Bridge Design Pattern

## Overview
The **Bridge Pattern** is a **structural design pattern** that decouples an abstraction from its implementation, allowing both to evolve independently. It helps in reducing the complexity of class hierarchies by dividing the responsibilities between abstraction and implementation.

## UML Diagram

```
        +------------------+        +-------------------+
        |    Abstraction   |        |  Implementor      |
        |------------------|        |-------------------|
        | implementor: Impl|<>----->| +operation()      |
        | +operation()     |        |                   |
        +------------------+        +-------------------+
                 |
        +------------------+
        | RefinedAbstraction |
        +------------------+
                 |
        +------------------+       +--------------------+
        |  ConcreteImplementorA |   | ConcreteImplementorB |
        |------------------|       |--------------------|
        | +operation()     |       | +operation()      |
        +------------------+       +--------------------+
```

## Implementation in Java

### Step 1: Implementor Interface
```java
// Implementor interface
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int percent);
}
```

### Step 2: Concrete Implementations
```java
// Concrete Implementor - TV
class TV implements Device {
    private int volume = 30;
    
    @Override
    public void turnOn() {
        System.out.println("TV is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is turned OFF");
    }

    @Override
    public void setVolume(int percent) {
        this.volume = percent;
        System.out.println("TV volume set to " + percent + "%");
    }
}

// Concrete Implementor - Radio
class Radio implements Device {
    private int volume = 50;
    
    @Override
    public void turnOn() {
        System.out.println("Radio is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio is turned OFF");
    }

    @Override
    public void setVolume(int percent) {
        this.volume = percent;
        System.out.println("Radio volume set to " + percent + "%");
    }
}
```

### Step 3: Abstraction
```java
// Abstraction
abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }

    public void setVolume(int percent) {
        device.setVolume(percent);
    }
}
```

### Step 4: Refined Abstractions
```java
// Refined Abstraction - Basic Remote
class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Muting device...");
        device.setVolume(0);
    }
}
```

### Step 5: Testing the Bridge Pattern
```java
public class BridgePatternDemo {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl remote = new BasicRemote(tv);

        remote.turnOn();
        remote.setVolume(70);
        ((BasicRemote) remote).mute();
        remote.turnOff();

        System.out.println();

        Device radio = new Radio();
        remote = new BasicRemote(radio);

        remote.turnOn();
        remote.setVolume(40);
        ((BasicRemote) remote).mute();
        remote.turnOff();
    }
}
```

### Output
```
TV is turned ON
TV volume set to 70%
Muting device...
TV volume set to 0%
TV is turned OFF

Radio is turned ON
Radio volume set to 40%
Muting device...
Radio volume set to 0%
Radio is turned OFF
```

## Advantages of Bridge Pattern
✅ **Decouples Abstraction from Implementation** → Enables independent changes.  
✅ **Improves Maintainability** → Avoids large hierarchies due to different variations.  
✅ **Enhances Flexibility** → New abstraction or implementation can be added without affecting existing code.

## Use Cases
- **Graphics rendering engines** (e.g., OpenGL, DirectX abstraction).
- **Cross-platform UI components** (Windows vs. Mac implementations).
- **Database drivers** (JDBC with different databases like MySQL, PostgreSQL).

## Conclusion
The **Bridge Pattern** helps manage complexity by **separating abstraction from implementation**, making it easier to maintain and scale. It avoids **class explosion** and ensures **better code reusability**.
