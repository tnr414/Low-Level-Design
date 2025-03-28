# Flyweight Design Pattern

## Overview
The **Flyweight Pattern** is a **structural design pattern** used to minimize memory usage or computational cost by sharing as much data as possible between similar objects. This pattern is particularly useful when working with a **large number of objects** that share common properties.

---

## UML Diagram
```
                     +----------------+
                     |    Flyweight    |
                     |----------------|
                     | + render(x, y)  |
                     +----------------+
                              ▲
                              │
                     +---------------------+
                     |  ConcreteFlyweight   |
                     |---------------------|
                     | - type              |
                     | - color             |
                     | - texture           |
                     | + render(x, y)      |
                     +---------------------+
                              ▲
                              │
                  +----------------------+
                  |   FlyweightFactory    |
                  |----------------------|
                  | + getTreeType(type)   |
                  +----------------------+
                              ▲
                              │
              +--------------------------------+
              |            Client             |
              |--------------------------------|
              | - treeList (x, y, TreeType)   |
              | + renderForest()              |
              +--------------------------------+
```

---

## Example: Tree Rendering System (Game Development Use Case)

### 1. **Flyweight Interface**
```java
// Flyweight Interface
interface Tree {
    void render(int x, int y);
}
```

### 2. **Concrete Flyweight (Shared Tree Type)**
```java
// Concrete Flyweight (shared tree properties)
class TreeType implements Tree {
    private final String type;
    private final String color;
    private final String texture;

    public TreeType(String type, String color, String texture) {
        this.type = type;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void render(int x, int y) {
        System.out.println("Rendering " + type + " tree at (" + x + ", " + y + ") with color " + color + " and texture " + texture);
    }
}
```

### 3. **Flyweight Factory (Manages Shared Objects)**
```java
import java.util.HashMap;
import java.util.Map;

// Flyweight Factory
class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String type, String color, String texture) {
        String key = type + "-" + color + "-" + texture;
        if (!treeTypes.containsKey(key)) {
            treeTypes.put(key, new TreeType(type, color, texture));
            System.out.println("Creating new TreeType: " + key);
        }
        return treeTypes.get(key);
    }
}
```

### 4. **Client (Forest with Many Trees)**
```java
import java.util.ArrayList;
import java.util.List;

// Client
class Forest {
    private final List<TreeData> trees = new ArrayList<>();

    public void plantTree(int x, int y, String type, String color, String texture) {
        TreeType treeType = TreeFactory.getTreeType(type, color, texture);
        trees.add(new TreeData(x, y, treeType));
    }

    public void renderForest() {
        for (TreeData tree : trees) {
            tree.treeType.render(tree.x, tree.y);
        }
    }

    private static class TreeData {
        int x, y;
        TreeType treeType;

        public TreeData(int x, int y, TreeType treeType) {
            this.x = x;
            this.y = y;
            this.treeType = treeType;
        }
    }
}
```

### 5. **Main Class (Running the Example)**
```java
public class FlyweightExample {
    public static void main(String[] args) {
        Forest forest = new Forest();

        // Planting trees in the forest
        forest.plantTree(1, 2, "Oak", "Green", "Rough");
        forest.plantTree(3, 5, "Pine", "Dark Green", "Smooth");
        forest.plantTree(5, 8, "Oak", "Green", "Rough");  // Uses shared Oak object
        forest.plantTree(7, 10, "Pine", "Dark Green", "Smooth");  // Uses shared Pine object
        forest.plantTree(9, 12, "Oak", "Green", "Rough");  // Uses shared Oak object

        // Render the forest
        forest.renderForest();
    }
}
```

---

## Expected Output
```
Creating new TreeType: Oak-Green-Rough
Creating new TreeType: Pine-Dark Green-Smooth
Rendering Oak tree at (1, 2) with color Green and texture Rough
Rendering Pine tree at (3, 5) with color Dark Green and texture Smooth
Rendering Oak tree at (5, 8) with color Green and texture Rough
Rendering Pine tree at (7, 10) with color Dark Green and texture Smooth
Rendering Oak tree at (9, 12) with color Green and texture Rough
```

---

## Benefits of the Flyweight Pattern
✅ **Memory Efficiency:** Reduces memory usage by sharing object instances.  
✅ **Performance Optimization:** Reduces object creation overhead.  
✅ **Ideal for Large Object Pools:** Suitable for games, text editors, and caching mechanisms.

### **Use Cases**
- **Game Development:** Reusing game assets (e.g., trees, enemy units, bullets).
- **GUI Design:** Sharing fonts, icons, and UI elements.
- **Text Editors:** Storing shared character glyphs efficiently.
- **Database Connection Pooling:** Managing reusable database connections.

---

## Conclusion
The **Flyweight Pattern** is useful when working with **a large number of similar objects** that can share intrinsic state. By applying this pattern, we **reduce memory usage and improve performance** efficiently.
