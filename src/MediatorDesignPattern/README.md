# Mediator Design Pattern

## Introduction
The **Mediator Design Pattern** is a behavioral design pattern that reduces direct dependencies between objects by introducing a mediator. It helps in **loose coupling** by centralizing communication between objects.

## When to Use Mediator Pattern?
- When a system has **multiple interacting objects**, leading to **complex dependencies**.
- When you want to **decouple objects** to improve maintainability.
- When **direct communication** between objects should be avoided.

---

## UML Diagram
```
          +---------------------+
          |     Mediator        |
          |---------------------|
          | + placeBid()        |
          | + registerBidder()  |
          +--------+------------+
                   |
      --------------------------------
      |                              |
+--------------+                +--------------+
|  Bidder A    |                |  Bidder B    |
|--------------|                |--------------|
| + bid()      |                | + bid()      |
| + update()   |                | + update()   |
+--------------+                +--------------+
```

---

## Java Implementation of Online Auction using Mediator Pattern

### Step 1: Define the Mediator Interface
```java
interface AuctionMediator {
    void placeBid(Bidder bidder, int amount);
    void registerBidder(Bidder bidder);
}
```

### Step 2: Implement Concrete Mediator (Auctioneer)
```java
import java.util.ArrayList;
import java.util.List;

class Auction implements AuctionMediator {
    private List<Bidder> bidders = new ArrayList<>();
    private int highestBid = 0;
    private Bidder highestBidder = null;

    @Override
    public void registerBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    @Override
    public void placeBid(Bidder bidder, int amount) {
        if (amount > highestBid) {
            highestBid = amount;
            highestBidder = bidder;
            notifyBidders();
        } else {
            System.out.println(bidder.getName() + "'s bid of $" + amount + " is too low.");
        }
    }

    private void notifyBidders() {
        for (Bidder bidder : bidders) {
            bidder.update(highestBidder, highestBid);
        }
    }
}
```

### Step 3: Create Bidder Class (Colleague)
```java
abstract class Bidder {
    protected AuctionMediator mediator;
    protected String name;

    public Bidder(String name, AuctionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.registerBidder(this);
    }

    abstract void bid(int amount);
    abstract void update(Bidder highestBidder, int highestBid);
    
    public String getName() {
        return name;
    }
}
```

### Step 4: Implement Concrete Bidder
```java
class ConcreteBidder extends Bidder {
    public ConcreteBidder(String name, AuctionMediator mediator) {
        super(name, mediator);
    }

    @Override
    void bid(int amount) {
        System.out.println(name + " places a bid of $" + amount);
        mediator.placeBid(this, amount);
    }

    @Override
    void update(Bidder highestBidder, int highestBid) {
        if (this != highestBidder) {
            System.out.println(name + " is notified: New highest bid is $" + highestBid + " by " + highestBidder.getName());
        } else {
            System.out.println(name + " has the highest bid of $" + highestBid);
        }
    }
}
```

### Step 5: Test the Online Auction System
```java
public class MediatorAuctionDemo {
    public static void main(String[] args) {
        Auction auction = new Auction();

        Bidder bidder1 = new ConcreteBidder("Alice", auction);
        Bidder bidder2 = new ConcreteBidder("Bob", auction);
        Bidder bidder3 = new ConcreteBidder("Charlie", auction);

        bidder1.bid(100);
        bidder2.bid(150);
        bidder3.bid(130);
        bidder1.bid(200);
    }
}
```

### Output
```
Alice places a bid of $100
Alice has the highest bid of $100
Bob places a bid of $150
Alice is notified: New highest bid is $150 by Bob
Charlie is notified: New highest bid is $150 by Bob
Bob has the highest bid of $150
Charlie places a bid of $130
Charlie’s bid of $130 is too low.
Alice places a bid of $200
Bob is notified: New highest bid is $200 by Alice
Charlie is notified: New highest bid is $200 by Alice
Alice has the highest bid of $200
```

---

## Key Takeaways
1. **AuctionMediator (Auctioneer)** manages bidding.
2. **Bidders interact only via the Mediator** (no direct communication).
3. **Loose coupling** is achieved, making the system more maintainable.

## Advantages of Using Mediator in Auction System
✅ **Decouples Bidders from Direct Interaction**  
✅ **Centralized Control Over Bidding**  
✅ **Easier to Extend (Add More Features Like Auto-Bidding)**

## Conclusion
The Mediator pattern is a useful design pattern when multiple objects need to interact but should not be directly coupled. This **reduces complexity** and makes the system more **maintainable and flexible**.
