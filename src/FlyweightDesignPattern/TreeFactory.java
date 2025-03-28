package FlyweightDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    public  static  final Map<String, TreeType> treeTypeMap = new HashMap<>();

    public static TreeType getTreeType(String type, String color, String texture) {
        String key = type + "-" + color + "-" + texture;

        if (!treeTypeMap.containsKey(key)) {
            treeTypeMap.put(key, new TreeType(type, color, texture));
            System.out.println("Creating new TreeType: " + key);
        }

        return treeTypeMap.get(key);
    }
}
