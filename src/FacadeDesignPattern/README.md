# Facade Design Pattern

## Overview
The **Facade Design Pattern** is a structural pattern that provides a simplified, unified interface to a set of interfaces in a subsystem. It acts as a front-facing interface that hides the complexities of the underlying system, making it easier for clients to interact with it.

## When to Use?
- When you want to provide a **simplified interface** to a complex subsystem.
- When you need to **decouple** clients from subsystem dependencies.
- When you want to **improve readability and maintainability** of the system.

---

## UML Diagram
Below is a UML representation of the **Facade Pattern**:

```
        +------------------+
        |   Client         |
        +------------------+
                 |
                 v
        +------------------+
        |   Facade         |
        +------------------+
        | + operation()    |
        +------------------+
                 |
      -----------------------------
      |             |             |
      v             v             v
+------------+ +------------+ +------------+
| Subsystem1 | | Subsystem2 | | Subsystem3 |
+------------+ +------------+ +------------+
| + methodA()| | + methodB()| | + methodC()|
+------------+ +------------+ +------------+
```

---

## Example: Home Theater System
Consider a **Home Theater System** where multiple components like **Amplifier, DVD Player, Projector, and Lights** work together. Instead of controlling each component separately, we create a **Facade** class to simplify user interaction.

### **Implementation in Java**

```java
// Subsystem 1: Amplifier
class Amplifier {
    void on() { System.out.println("Amplifier is ON"); }
    void setVolume(int level) { System.out.println("Amplifier volume set to " + level); }
    void off() { System.out.println("Amplifier is OFF"); }
}

// Subsystem 2: DVD Player
class DVDPlayer {
    void on() { System.out.println("DVD Player is ON"); }
    void play(String movie) { System.out.println("Playing movie: " + movie); }
    void off() { System.out.println("DVD Player is OFF"); }
}

// Subsystem 3: Projector
class Projector {
    void on() { System.out.println("Projector is ON"); }
    void setInput(DVDPlayer dvd) { System.out.println("Projector input set to DVD Player"); }
    void off() { System.out.println("Projector is OFF"); }
}

// Subsystem 4: Lights
class Lights {
    void dim(int level) { System.out.println("Lights dimmed to " + level + "%"); }
}

// Facade: HomeTheaterFacade
class HomeTheaterFacade {
    private Amplifier amplifier;
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private Lights lights;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector proj, Lights light) {
        this.amplifier = amp;
        this.dvdPlayer = dvd;
        this.projector = proj;
        this.lights = light;
    }

    public void watchMovie(String movie) {
        System.out.println("\nStarting Movie Mode...");
        lights.dim(30);
        amplifier.on();
        amplifier.setVolume(5);
        projector.on();
        projector.setInput(dvdPlayer);
        dvdPlayer.on();
        dvdPlayer.play(movie);
        System.out.println("Enjoy your movie!\n");
    }

    public void endMovie() {
        System.out.println("\nShutting Down Home Theater...");
        dvdPlayer.off();
        projector.off();
        amplifier.off();
        lights.dim(100);
        System.out.println("Movie mode off.\n");
    }
}

// Client
public class FacadePatternDemo {
    public static void main(String[] args) {
        // Create subsystem components
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector proj = new Projector();
        Lights lights = new Lights();

        // Create Facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, proj, lights);

        // Use the Facade
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}
```

---

## Output
```
Starting Movie Mode...
Lights dimmed to 30%
Amplifier is ON
Amplifier volume set to 5
Projector is ON
Projector input set to DVD Player
DVD Player is ON
Playing movie: Inception
Enjoy your movie!

Shutting Down Home Theater...
DVD Player is OFF
Projector is OFF
Amplifier is OFF
Lights dimmed to 100%
Movie mode off.
```

---

## Key Benefits of Facade Pattern
✅ **Simplifies the Interface** - Provides a single, unified interface to interact with multiple subsystems.  
✅ **Decouples Client from Subsystems** - Clients don’t need to know the complexities of subsystem components.  
✅ **Improves Maintainability** - If subsystems change, the facade can shield clients from those changes.  
✅ **Reduces Dependencies** - The client depends only on the facade, not on multiple subsystem classes.

---

## Conclusion
The **Facade Pattern** helps simplify interactions with complex systems by providing a single access point. It is widely used in frameworks like Java’s `javax.faces.context.FacesContext` in JSF and `java.net.URL` in networking.
